package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Slides {
    private DcMotor slide1;
    private DcMotor slide2;
    public Slides(HardwareMap hw) {
        slide1 = hw.get(DcMotor.class, "slide1");
        slide2 = hw.get(DcMotor.class, "slide2");

        slide1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        slide1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void setMotorPos(int position, double power) {
        slide1.setTargetPosition(position);
        slide1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slide1.setPower(Math.abs(power));

        slide2.setTargetPosition(position);
        slide2.setDirection(DcMotorSimple.Direction.REVERSE);
        slide2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slide2.setPower(Math.abs(power));
    }
    public int getMotorPos() {
        return slide1.getCurrentPosition();
    }
}
