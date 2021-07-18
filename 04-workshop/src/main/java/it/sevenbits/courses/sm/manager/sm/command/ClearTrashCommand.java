package it.sevenbits.courses.sm.manager.sm.command;

public class ClearTrashCommand implements INetworkManagerCommand
{
    StringBuilder buffer;

    public  ClearTrashCommand(StringBuilder buffer){
        this.buffer = buffer;
    }
    @Override
    public void execute() {
        buffer.setLength(0);
    }
}
