package me.jiyun233.command;

public abstract class AbstractCommand {

    private final String command;

    abstract public void execute(String[] args);

    public AbstractCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
