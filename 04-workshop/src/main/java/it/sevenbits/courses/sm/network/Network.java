package it.sevenbits.courses.sm.network;

import it.sevenbits.courses.sm.manager.sm.StateMachineNetworkManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Network implements INetwork {
    private final int maxSize;
    private ConcurrentLinkedDeque<NetworkPackage> packages = new ConcurrentLinkedDeque<NetworkPackage>();
    private final static Logger logger = LoggerFactory.getLogger(StateMachineNetworkManager.class);
    public Network(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean hasPackage() {
       return packages.size() > 0;
    }

    @Override
    public NetworkPackage getPackage(){

        logger.debug("The first element was removed from the package and returned");
        return packages.removeFirst();
    }

    @Override
    public void addPackage(String message, String type) {
        if(packages.size() < maxSize) {
            logger.debug("The package was added at the end of the packages");

            packages.addLast(new NetworkPackage(type, message));
        }
        logger.error("Can't add a new package to the packages, packages size greater than maxSize");
    }
}
