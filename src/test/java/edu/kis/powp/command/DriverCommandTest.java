package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import java.util.ArrayList;
import java.util.List;

/**
 * DriverCommand test.
 */
public class DriverCommandTest {

    private static class StubDriver implements Job2dDriver {
        @Override
        public void operateTo(int x, int y) {
            System.out.println("StubDriver operateTo: " + x + ", " + y);
        }

        @Override
        public void setPosition(int x, int y) {
            System.out.println("StubDriver setPosition: " + x + ", " + y);
        }
    };
    
    private static class AlternativeDriver implements Job2dDriver {
        @Override
        public void operateTo(int x, int y) {
            System.out.println("AlternativeDriver operates to (" + x + ", " + y + ")");
        }

        @Override
        public void setPosition(int x, int y) {
            System.out.println("AlternativeDriver sets position at (" + x + ", " + y + ")");
        }
    };

    /**
     * DriverCommand test.
     */
    public static void main(String[] args) {
        Job2dDriver stubDriver = new StubDriver();
        Job2dDriver altDriver = new AlternativeDriver();

        System.out.println("Testing basic commands on StubDriver:");
        DriverCommand command = new SetPositionCommand(10, 20);
        command.execute(stubDriver);

        command = new OperateToCommand(50, 60);
        command.execute(stubDriver);
        
        System.out.println("\nTesting basic commands on AlternativeDriver (reusing same command objects):");
        // Reuse the same command object to show loose coupling
        command.execute(altDriver);

        System.out.println("\nTesting ComplexCommand on StubDriver:");
        List<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(-10, -20));
        commands.add(new OperateToCommand(-50, -60));
        commands.add(new OperateToCommand(-10, -20));
        
        ComplexCommand complexCommand = new ComplexCommand(commands);
        complexCommand.execute(stubDriver);
        
        System.out.println("\nTesting ComplexCommand on AlternativeDriver:");
        complexCommand.execute(altDriver);
    }
}
