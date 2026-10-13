package org.firstinspires.ftc.teamcode.Project2;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

public class MotorCommandOpMode extends CommandOpMode {

    private MotorSubsystem motorSubsystem;
    private GamepadEx driver;

    @Override
    public void initialize() {

        motorSubsystem = new MotorSubsystem(hardwareMap);

        driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.A)
                .whenPressed(new InstantCommand(
                        motorSubsystem::runForward,
                        motorSubsystem));

        driver.getGamepadButton(GamepadKeys.Button.B)
                .whenPressed(new InstantCommand(
                        motorSubsystem::runReverse,
                        motorSubsystem));

        driver.getGamepadButton(GamepadKeys.Button.X)
                .whenPressed(new InstantCommand(
                        motorSubsystem::stopMotor,
                        motorSubsystem));
    }











}
