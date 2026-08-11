package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class SpecArm {
    private Servo base1;
    private Servo base2;
    private Servo arm;
    private Servo claw;
    public SpecArm(HardwareMap hw) {
        base1 = hw.get(Servo.class, "base servo 1");
        base2 = hw.get(Servo.class, "base servo 2");
        arm = hw.get(Servo.class, "arm servo");
        claw = hw.get(Servo.class, "claw servo");
    }
    public void setBasePos(double position) {
        base1.setPosition(position);
        base2.setPosition(position);
    }
    public void setSpecArmPos(double position) {
        arm.setPosition(position);
    }
    public void setSpecClawPos(double position) {
        claw.setPosition(position);
    }
}
