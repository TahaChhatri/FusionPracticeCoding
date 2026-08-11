package org.firstinspires.ftc.teamcode.Util;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.SpecArm;

@TeleOp
@Config
public class SpecArmTest extends LinearOpMode {
    public static double specArmPos = 0.0;
    public static double clawPos = 0.0;
    public static double basePos = 0.0;
    @Override
    public void runOpMode() throws InterruptedException {
        SpecArm specarm = new SpecArm(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {
            specarm.setSpecArmPos(specArmPos);
            specarm.setBasePos(basePos);
            specarm.setSpecClawPos(clawPos);

            telemetry.addData("Arm Pos", specArmPos);
            telemetry.addData("Claw Pos", clawPos);
            telemetry.addData("Base Pos", basePos);
            telemetry.update();
        }
    }
}
