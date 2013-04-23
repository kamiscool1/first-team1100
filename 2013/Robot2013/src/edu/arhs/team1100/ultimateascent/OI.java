package edu.arhs.team1100.ultimateascent;

import edu.arhs.team1100.ultimateascent.commands.IntakeLiftCommand;
import edu.arhs.team1100.ultimateascent.commands.IntakeRollerCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.ChangeShooterSpeedCommand;
import edu.arhs.team1100.ultimateascent.commands.drive.ToggleDriveModeCommand;
import edu.arhs.team1100.ultimateascent.commands.drive.CalibrateGyroCommand;
import edu.arhs.team1100.ultimateascent.commands.drive.JoystickPIDMecanumCommand;
import edu.arhs.team1100.ultimateascent.recording.RecordCommand;
import edu.arhs.team1100.ultimateascent.recording.PlayRecordingCommand;
import edu.arhs.team1100.ultimateascent.commands.drive.StopDriveCommand;
import edu.arhs.team1100.ultimateascent.input.AttackThree;
import edu.arhs.team1100.ultimateascent.input.XboxController;
import edu.arhs.team1100.ultimateascent.recording.PrintRecordingCodeCommand;
import edu.arhs.team1100.ultimateascent.commands.drive.CameraPIDMecanumCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.CameraPIDTiltShooterCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.RapidFireCommandGroup;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    /**
     * SETTINGS
     */
    //LEFT STICK BUTTON SETTINGS
    private static final int TOGGLE_DRIVE = 2;
    private static final int CAMERA_PID = 1; //Trigger
    //RIGHT STICK BUTTON SETTINGS
    private static final int CALIBRATE_GYRO = 3;
    private static final int JOYSTICK_PID = 1; //Trigger
    private static final int STOP_DRIVE = 4;
    //Recording
    private static final int RECORD = 5;
    private static final int PLAY_RECORDING = 2;
    private static final int PRINT_RECORDING = 7;
    private static OI instance;
    private AttackThree leftStick;
    private AttackThree rightStick;
    private XboxController xbox;
    RecordCommand recorder;

    /**
     * Creates an OI if not already created
     *
     * @return instance
     */
    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        return instance;
    }

    /**
     * Constructs an OI Initializes control scheme
     */
    public OI() {
        //Initialize controllers
        leftStick = new AttackThree(RobotMap.C_LEFT_JOYSTICK, 0.1);
        rightStick = new AttackThree(RobotMap.C_RIGHT_JOYSTICK, 0.1);
        xbox = new XboxController(RobotMap.C_XBOX_CONTROLLER, 0.1);

        //CONTROL ASSIGNMENTS
        leftStick.getButton(TOGGLE_DRIVE).whenPressed(new ToggleDriveModeCommand());
        leftStick.getButton(CAMERA_PID).whileHeld(new CameraPIDMecanumCommand());
        rightStick.getButton(CALIBRATE_GYRO).whenPressed(new CalibrateGyroCommand());
        rightStick.getButton(JOYSTICK_PID).whileHeld(new JoystickPIDMecanumCommand());
        rightStick.getButton(STOP_DRIVE).whenPressed(new StopDriveCommand(0.1));

        recorder = new RecordCommand(20); //interval is 20 ms
        rightStick.getButton(RECORD).whileHeld(recorder);
        rightStick.getButton(PLAY_RECORDING).whenPressed(new PlayRecordingCommand(recorder));
        rightStick.getButton(PRINT_RECORDING).whenPressed(new PrintRecordingCodeCommand(recorder));

        xbox.getButtonX().whileHeld(new RapidFireCommandGroup());
        xbox.getButtonRightBumper().whenPressed(new ChangeShooterSpeedCommand(0.1));
        xbox.getButtonLeftBumper().whenPressed(new ChangeShooterSpeedCommand(-0.1));
        xbox.getButtonY().whileHeld(new CameraPIDTiltShooterCommand());
        //  xbox.getButtonY().whenReleased(new TiltShooterPositionPIDCommand(RobotMap.DS_FLAT_ANGLE_CH));
        // xbox.getButtonA().whileHeld(new  CameraPIDTiltShooterCommand());
        // xbox.getButtonB().whileHeld(new TiltShooterPositionPIDCommand(RobotMap.DS_FEEDER_ANGLE_CH));
        // xbox.getButtonA().whileHeld(new CameraPIDTiltShooterCommand());
        // xbox.getButtonBack().whileHeld(new CameraTiltShooterCommand());
        xbox.getButtonB().whenPressed(new IntakeLiftCommand());
        xbox.getButtonA().whenPressed(new IntakeRollerCommand());
    }

    /**
     * Get the left joystick
     *
     * @return left AttackThree object
     */
    public AttackThree getLeftJoystick() {
        return leftStick;
    }

    /**
     * Get right joystick
     *
     * @return right AttackThree
     */
    public AttackThree getRightJoystick() {
        return rightStick;
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
