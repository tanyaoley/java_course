package it.sevenbits.courses.sm.manager.sm.command;

import it.sevenbits.courses.sm.network.NetworkPackage;

import java.util.ArrayList;

public class AddToBufferCommand implements INetworkManagerCommand{
private StringBuilder buffer;
//private NetworkPackage p;
private ArrayList<NetworkPackage> container;
    public AddToBufferCommand(StringBuilder buffer, ArrayList<NetworkPackage> container){
        this.buffer = buffer;
        this.container = container;
    }
    @Override
    public void execute(){
        buffer.append(container.get(0).getMessage());
        container.remove(0);
    }
}
