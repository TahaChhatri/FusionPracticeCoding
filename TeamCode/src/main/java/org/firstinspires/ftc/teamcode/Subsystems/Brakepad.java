package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Brakepad {
    private Servo breakPad;
    public Brakepad(HardwareMap hw) {
        breakPad = hw.get(Servo.class, "break pad");
    }
    public void setBreakPad(double position) {
        breakPad.setPosition(position);
    }
}
