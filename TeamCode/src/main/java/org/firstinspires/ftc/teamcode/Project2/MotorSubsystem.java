package org.firstinspires.ftc.teamcode.Project2;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

public class MotorSubsystem extends SubsystemBase {

    private final Motor motor;

    public MotorSubsystem(HardwareMap hardwareMap) {

        motor = new Motor(hardwareMap, "testMotor");

        motor.setRunMode(Motor.RunMode.RawPower);
        motor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    public void runForward() {
        motor.set(0.5);
    }

    public void runReverse() {
        motor.set(-0.5);
    }

    public void stopMotor() {
        motor.set(0);
    }

    @Override
    public void periodic() {
        
    }
}