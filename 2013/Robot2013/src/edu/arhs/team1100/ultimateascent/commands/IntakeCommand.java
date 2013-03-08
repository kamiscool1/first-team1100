/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.IntakeSubsystem;
import edu.arhs.team1100.ultimateascent.OI;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author akshay
 */
public class IntakeCommand extends CommandBase {
    
    /**
     * Initializes IntakeSubsystem
     */
    public IntakeCommand() {
        requires(IntakeSubsystem.getInstance());
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        IntakeSubsystem.getInstance().roll();
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     * @return false
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        IntakeSubsystem.getInstance().stop();
    }
  
    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}