package org.firstinspires.ftc.teamcode;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

public class MotorSubsystem extends SubsystemBase {
    private Motor m;
    private double ms = 0.0;
  
    public MotorSubsystem(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap) {
        motor = new Motor(hardwareMap, "SOLVERS_MOTORS");
        motor.stopMotor();
    }
  //method 1&2&3
    public void runForward() {
        motorSpeed = 0.5;
    }
    public void runReverse() {
        motorSpeed = -0.5;
    }

    public void stop() {
        motorSpeed = 0.0;
        motor.stopMotor();
    }
//update robots behaviour
    @Override
    public void periodic() {
        motor.set(motorSpeed);
    }
}
