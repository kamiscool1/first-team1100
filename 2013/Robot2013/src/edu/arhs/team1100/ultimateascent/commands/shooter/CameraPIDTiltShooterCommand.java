package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;
import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.arhs.team1100.ultimateascent.util.DSPID;

/**
 *
 * @author akshay
 */
public class CameraPIDTiltShooterCommand extends CommandBase {

    public CameraPIDTiltShooterCommand() {
        requires(ShooterTiltSubsystem.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ShooterTiltSubsystem.getInstance().setCameraMode(true);
        //ShooterTiltSubsystem.getInstance().setInputRange(-1.0, 1.0);
        //ShooterTiltSubsystem.getInstance().setPercentTolerance(5.0);//10 %
        DSPID.setPIDFromDS(ShooterTiltSubsystem.getInstance().getPIDController());
        //ShooterTiltSubsystem.getInstance().setSetpoint(0.1);
        ShooterTiltSubsystem.getInstance().enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        DSLog.log(5, "");
        Log.log(this, "PID", Log.LEVEL_DEBUG);
      //  DSPID.setPIDFromDS(ShooterTiltSubsystem.getInstance().getPIDController());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        ShooterTiltSubsystem.getInstance().stop();
        ShooterTiltSubsystem.getInstance().disable();
        ShooterTiltSubsystem.getInstance().setCameraMode(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
