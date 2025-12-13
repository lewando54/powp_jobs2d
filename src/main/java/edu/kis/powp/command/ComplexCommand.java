package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import java.util.List;

/**
 * ComplexCommand class for executing a sequence of commands.
 */
public class ComplexCommand implements DriverCommand {

    private final List<DriverCommand> commands;

    public ComplexCommand(List<DriverCommand> commands) {
        if (commands == null) {
            throw new IllegalArgumentException("Commands list cannot be null");
        }
        this.commands = commands;
    }

    @Override
    public void execute(Job2dDriver driver) {
        for (DriverCommand command : commands) {
            command.execute(driver);
        }
    }
}
