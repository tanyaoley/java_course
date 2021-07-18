package it.sevenbits.courses.sm.manager.sm.command;

public class WriteClearCommand implements INetworkManagerCommand{
    StringBuilder buffer;

    public  WriteClearCommand(StringBuilder buffer){
        this.buffer = buffer;
    }
    @Override
    public void execute() {
    System.out.println(buffer);
    buffer.setLength(0);
    }
}
