package edu.arhs.team1100.aerialassist;

import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.PushOutPuncherCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.FireShooterCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.ToggleClampCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.MoveArmCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.SetArmMiddleCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.ResetEncoderCommand;
import edu.arhs.team1100.aerialassist.commands.drive.ToggleMecModeCommand;
import edu.arhs.team1100.aerialassist.commands.drive.ToggleDriveModeCommand;
import edu.arhs.team1100.aerialassist.input.AttackThree;
import edu.arhs.team1100.aerialassist.input.XboxController;
import edu.arhs.team1100.aerialassist.commands.drive.ToggleReverseDirectionCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.ClampInCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.ClampOutCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.FireShooterCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.RollInCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.RollOutCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.ToggleHolderCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.TogglePuncherPosCommand;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    /**
     * SETTINGS
     */
    //Right STICK BUTTON SETTINGS
    private static final int TOGGLE_MEC = 2;
    private static final int TOGGLE_DRIVE = 5;
    private static final int REVERSE_DIRECTION = 4; //trigger
    private static final int TOGGLE_ENCODER = 3;
    //left STICK BUTTON SETTINGS
    private static final int CALIBRATE_GYRO = 3;
    private static final int LEG = 1;//trigger
    private static final int STOP_DRIVE = 12;
    //Recording
    private static OI instance;
    private AttackThree rightStick;
    private AttackThree leftStick;
    private XboxController xbox;

    /**
     * Creates an OI if not already created
     *
     * @return instance
     */
    public static OI getInstance() throws DriverStationEnhancedIO.EnhancedIOException {
        if (instance == null) {
            instance = new OI();
        }
        return instance;
    }

    /**
     * Constructs an OI Initializes control scheme
     */
    public OI() throws DriverStationEnhancedIO.EnhancedIOException {
        //Initialize controllers
        rightStick = new AttackThree(RobotMap.C_RIGHT_JOYSTICK, 0.1);
        leftStick = new AttackThree(RobotMap.C_LEFT_JOYSTICK, 0.1);
        xbox = new XboxController(RobotMap.C_XBOX_CONTROLLER, 0.1);

        //CONTROL ASSIGNMENTS       
        xbox.getButtonRightBumper().whenPressed(new ToggleClampCommand());
        xbox.getButtonA().whileHeld(new RollInCommand());
        xbox.getButtonB().whileHeld(new RollOutCommand());   
        xbox.getButtonX().whenPressed(new FireShooterCommand());
        xbox.getButtonLeftBumper().whenPressed(new TogglePuncherPosCommand());
        xbox.getButtonY().whenPressed(new ToggleHolderCommand());
        rightStick.getButton(TOGGLE_MEC).whenPressed(new ToggleMecModeCommand());
        rightStick.getButton(TOGGLE_DRIVE).whenPressed(new ToggleDriveModeCommand());
//      rightStick.getButton(CALIBRATE_GYRO).whenPressed(new CalibrateGyroCommand());
//      rightStick.getButton(TOGGLE_ENCODER).whenPressed(new ToggleEncoderCommand());
        rightStick.getButton(REVERSE_DIRECTION).whenPressed(new ToggleReverseDirectionCommand());        
 //       leftStick.getButton(3).whenPressed(new PushOutPuncherCommand());
//        
//      leftStick.getButton(STOP_DRIVE).whenPressed(new StopDriveCommand(0.1));
    }

    /**
     * Get the left joystick
     *
     * @return left AttackThree object
     */
    public AttackThree getRightJoystick() {
        return rightStick;
    }

    /**
     * Get right joystick
     *
     * @return right AttackThree
     */
    public AttackThree getLeftJoystick() {
        return leftStick;
    }

    /**
     * Get Xbox controller
     *
     * @return XboxController object
     */
    public XboxController getXboxController() {
        return xbox;
    }
}
