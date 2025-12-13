package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import java.util.ArrayList;
import java.util.List;

public class CommandFactory {

    public static DriverCommand getRectangle() {
        List<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(0, 0));
        commands.add(new OperateToCommand(100, 0));
        commands.add(new OperateToCommand(100, 100));
        commands.add(new OperateToCommand(0, 100));
        commands.add(new OperateToCommand(0, 0));
        return new ComplexCommand(commands);
    }

    public static DriverCommand getTriangle() {
        List<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(0, 0));
        commands.add(new OperateToCommand(50, -100));
        commands.add(new OperateToCommand(100, 0));
        commands.add(new OperateToCommand(0, 0));
        return new ComplexCommand(commands);
    }
}

