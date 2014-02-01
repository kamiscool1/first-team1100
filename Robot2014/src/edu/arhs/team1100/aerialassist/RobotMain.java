/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.arhs.team1100.aerialassist;

import com.sun.squawk.util.MathUtils;
import edu.arhs.team1100.aerialassist.commands.drive.CalibrateGyroCommand;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.commands.drive.GyroTestCommand;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.ManipulatorSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.ShooterSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.CompressorSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.SensorTestSubsystem;
import edu.arhs.team1100.aerialassist.util.DSLog;
import edu.arhs.team1100.aerialassist.util.Log;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot {

    private CommandGroup autoCommand;
    private long lastTime = 0;
    private long totalTime = 0;
    private long cycles = 0;
    private long rate = 0;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        //Initialize the Log utility
        Log.init();
        Log.setMinLevel(Log.LEVEL_DEBUG);

        //Add all logging classes
        //Log.addClass(RobotMain.class, Log.LEVEL_DEBUG);
        //Log.addClass(DriveSubsystem.class, Log.LEVEL_DEBUG);
        //Log.addClass(ManipulatorSubsystem.class, Log.LEVEL_DEBUG);
        //Log.addClass(ShooterSubsystem.class, Log.LEVEL_DEBUG);
        //Log.addClass(CompressorSubsystem.class, Log.LEVEL_DEBUG);
        Log.addClass(SensorTestSubsystem.class, Log.LEVEL_DEBUG);
        //Log.addClass(CalibrateGyroCommand.class, Log.LEVEL_OFF);
      

        // Instantiate the command used for the autonomous period
        // Initialize all subsystems
        CommandBase.init();
        //autoCommand = new AutoShootAndReloadCommandGroup();


    }

    /**
     * Initializes Autonomous
     */
    public void autonomousInit() {
        //Schedule the autonomous command (example)
        //autonomous.start();
        autoCommand.start();

        Scheduler.getInstance().enable();
        //DSLog.log(5, "auto init");
        //autonomous.start();
    }

    /**
     * Called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //autonomous.execute();
        Scheduler.getInstance().run();
    }

    /*
     * Initializes teleop mode
     */
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        lastTime = System.currentTimeMillis();
        Scheduler.getInstance().enable();
    }

    /**
     * Called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //trackRate();
        updateDriverStationLog();


    }

    private void updateDriverStationLog() {
        if (DriveSubsystem.getInstance().getDriveMode() == DriveSubsystem.MODE_POLAR){
            DSLog.log(1, "Drive Mode: POLAR");
        }
        else if (DriveSubsystem.getInstance().getDriveMode() == DriveSubsystem.MODE_TANK){
            DSLog.log(1, "Drive Mode: TANK");
        }
        else if (DriveSubsystem.getInstance().getDriveMode() == DriveSubsystem.MODE_CARTESIAN){
            DSLog.log(1, "Drive Mode: CARTESIAN");
        }
      
        DSLog.log(2, "Gyro Angle: " + Log.round(DriveSubsystem.getInstance().getGyroAngle(), 2));
    
    }

    /**
     * Prints out the refresh rate of program
     */
    private void trackRate() {

        long curTime = System.currentTimeMillis();
        long d = curTime - lastTime;
        totalTime += d;
        cycles++;

        if (totalTime >= 1000) {
            rate = cycles / (totalTime / 1000);
            cycles = 0;
            totalTime = 0;
        }

        lastTime = curTime;

    }

    /**
     * Called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    /**
     * Removes all instances declared
     */
    public void disabledInit() {
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().disable();
    }
}
