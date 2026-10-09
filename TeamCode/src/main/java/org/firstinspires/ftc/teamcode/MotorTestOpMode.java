package org.firstinspires.ftc.teamcode;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Motor Test")
public class MotorTestOpMode extends CommandOpMode {
    private MotorSubsystem motorSubsystem;
    private GamepadEx driverGamepad;
    @Override
    public void initialize() {
        motorSubsystem = new MotorSubsystem(hardwareMap);
        register(motorSubsystem);
        // Connect to gamepad1
        driverGamepad = new GamepadEx(gamepad1);
      // all contorls to move the robot
        driverGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(new InstantCommand(() -> motorSubsystem.runForward()
            ));
        driverGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(new InstantCommand(() -> motorSubsystem.runReverse()
            ));
        driverGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(new InstantCommand(() -> motorSubsystem.stop()
            ));
    }
}
