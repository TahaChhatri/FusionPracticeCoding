package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Sweep {
    private Servo sweep;

    public Sweep (HardwareMap hw) {
        sweep = hw.get(Servo.class, "sweep");
    }

    public void setSweepSpecific(double position) {
        sweep.setPosition(position);
    }
}
