package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Pivot {
    private DcMotor pivot;
    private Servo pivotservo;
    public Pivot(HardwareMap hw) {
        pivot = hw.get(DcMotor.class, "pivot motor");
        pivotservo = hw.get(Servo.class, "pivot servo");

        pivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        pivot.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void setPivotServo(double position) {
        pivotservo.setPosition(position);
    }

    public void setPivotMotor(int position, double power) {
        pivot.setTargetPosition(position);
        pivot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        pivot.setPower(Math.abs(power));
    }
    public int getPivotMotor() {
        return pivot.getCurrentPosition();
    }
}
