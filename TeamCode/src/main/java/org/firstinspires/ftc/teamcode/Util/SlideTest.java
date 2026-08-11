package org.firstinspires.ftc.teamcode.Util;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Subsystems.Slides;

@TeleOp
@Config
public class SlideTest extends LinearOpMode {
    public static double slidepower = 0.0;
    public static int slidepos = 0;
    @Override
    public void runOpMode() throws InterruptedException{
        Slides slide = new Slides(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            slide.setMotorPos(slidepos, slidepower);
            telemetry.addData("slide pos: ", slidepos);
            telemetry.addData("slide power: ", slidepower);
            telemetry.update();
        }
    }
}
