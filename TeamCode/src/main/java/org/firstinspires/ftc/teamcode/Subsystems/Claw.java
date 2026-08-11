package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private Servo claw;
    private Servo arm;
    private Servo orientation;

    public Claw (HardwareMap hw) {
        claw = hw.get(Servo.class, "claw");
        arm = hw.get(Servo.class, "arm");
        orientation = hw.get(Servo.class, "orientation");
    }
    public void setClawPos(double position) {
        claw.setPosition(position);
    }
    public void setArmPos(double position) {
        arm.setPosition(position);
    }
    public void setOrient(double position) {
        orientation.setPosition(position);
    }
    public double getOrientPos() {
        return orientation.getPosition();
    }
}
