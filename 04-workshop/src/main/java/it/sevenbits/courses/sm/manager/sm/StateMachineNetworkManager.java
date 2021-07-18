package it.sevenbits.courses.sm.manager.sm;

import it.sevenbits.courses.sm.log.MessageFormatter;
import it.sevenbits.courses.sm.manager.INetworkManager;
import it.sevenbits.courses.sm.manager.NetworkManagerException;
import it.sevenbits.courses.sm.manager.sm.command.*;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.NetworkPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateMachineNetworkManager implements INetworkManager {

    private boolean isInterrupted = false;
    private final long TIMEOUT = 500;
    private final StateTransition stateTransition;
    private Map<Pair<State, String>, INetworkManagerCommand>  cmd;
    private final static Logger logger = LoggerFactory.getLogger(StateMachineNetworkManager.class);
    MessageFormatter messageFormatter;

    public StateMachineNetworkManager() {

        this.stateTransition = new StateTransition();
        messageFormatter = new MessageFormatter();
        cmd = new HashMap<>();
    }

private void cmdMap(StringBuilder buffer, ArrayList<NetworkPackage> container){
        cmd.clear();
        State defaultState = new State("IGNORE");
        State listenState = new State("LISTEN");
        State stubSuspicion = new State("TRASH_SUSPICION");

        cmd.put(new Pair<>(defaultState, "MESSAGE"), new IgnoreCommand());
        cmd.put(new Pair<>(defaultState, "TRASH"), new IgnoreCommand());
        cmd.put(new Pair<>(defaultState, "MESSAGE_START"), new IgnoreCommand());
        cmd.put(new Pair<>(defaultState, "MESSAGE_FINISH"), new IgnoreCommand());

        cmd.put(new Pair<>(listenState, "MESSAGE"), new AddToBufferCommand(buffer, container));
        cmd.put(new Pair<>(listenState, "TRASH"), new IgnoreCommand());
        cmd.put(new Pair<>(listenState, "MESSAGE_START"), new IgnoreCommand());
        cmd.put(new Pair<>(listenState, "MESSAGE_FINISH"), new WriteClearCommand(buffer));

        cmd.put(new Pair<>(stubSuspicion, "MESSAGE"), new AddToBufferCommand(buffer, container));
        cmd.put(new Pair<>(stubSuspicion, "TRASH"), new ClearTrashCommand(buffer));
        cmd.put(new Pair<>(stubSuspicion, "MESSAGE_START"), new IgnoreCommand());
        cmd.put(new Pair<>(stubSuspicion, "MESSAGE_FINISH"), new WriteClearCommand(buffer));
    }

    @Override
    public void listen(INetwork network) throws NetworkManagerException {
        State currentState = stateTransition.getStartState();

        StringBuilder buffer = new StringBuilder("");
//        Container container = new Container();
        ArrayList<NetworkPackage> container = new ArrayList<NetworkPackage>();
        cmdMap(buffer, container);

        try {
            while(!isInterrupted){
                    while (network.hasPackage()) {
                        NetworkPackage p = network.getPackage();
                        container.add(0,p);

                        cmd.get(new Pair<>(currentState, p.getType())).execute();

                        logger.info(String.format(messageFormatter.getStringFormatByType(p.getType()), p.getMessage()));
                        currentState = stateTransition.nextState(currentState, p);
//                        System.out.println(String.format("%1$s: %2$s", p.getType(), currentState.toString()));
                }
                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e){
            logger.error("Error: netkwork manager was interrupted");
            throw new NetworkManagerException("Network manager was interrupted unexpectedly", e);
        }
    }

    @Override
    public void stop() {
        logger.info("Network manager stopped working");
        isInterrupted = true;
    }
}
