package org.firstinspires.ftc.teamcode.Util;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Sweep;

@TeleOp
@Config
public class SweepTest extends LinearOpMode {
    public static double sweepPos = 0.0;
    public void runOpMode() throws InterruptedException {
        Sweep sweep = new Sweep(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {
            sweep.setSweepSpecific(sweepPos);

            telemetry.addData("Sweep Position", sweepPos);
            telemetry.update();
        }
    }
}
