package edu.arhs.team1100.aerialassist.commands.manipulatorcommands;

import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.ManipulatorSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.ShooterSubsystem;

/**
 *
 * @author Team 1100
 */
public class SetArmMiddleCommand extends CommandBase {

    /**
     * Constructs a DriveSubsystem object
     */
    public SetArmMiddleCommand() {
        requires(ManipulatorSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        ManipulatorSubsystem.getInstance().disable();
        ManipulatorSubsystem.getInstance().setSetpoint(0);
        ManipulatorSubsystem.getInstance().goingToMiddle = true;
        ManipulatorSubsystem.getInstance().enable();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return false
     */
    protected boolean isFinished() {
        return ManipulatorSubsystem.getInstance().onTarget();
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        ManipulatorSubsystem.getInstance().goingToMiddle = false;
       // ManipulatorSubsystem.getInstance().disable();
       // ManipulatorSubsystem.getInstance().stopArm();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}