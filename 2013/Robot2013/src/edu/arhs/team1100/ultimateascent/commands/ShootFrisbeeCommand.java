package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterPistonSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;

/**
 *
 * @author Team 1100
 */
public class ShootFrisbeeCommand extends CommandBase {

    public ShootFrisbeeCommand() {
        requires(ShooterPistonSubsystem.getInstance());
    }

    protected void initialize() {
        ShooterPistonSubsystem.getInstance();
    }

    protected void execute() {
        ShooterPistonSubsystem.getInstance().shoot(1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        DriveSubsystem.getInstance().disable();
    }

    protected void interrupted() {
        end();
    }
}
