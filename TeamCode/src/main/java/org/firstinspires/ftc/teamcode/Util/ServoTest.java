package org.firstinspires.ftc.teamcode.Util;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Subsystems.Claw;


@TeleOp
@Config
public class ServoTest extends LinearOpMode {
    public static double clawPos = 0.0;
    public static double armPos = 0.0;
    public static double orientPos = 0.0;
    @Override
    public void runOpMode() throws InterruptedException {
        Claw claw = new Claw(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            claw.setClawPos(clawPos);
            claw.setArmPos(armPos);
            claw.setOrient(orientPos);

            telemetry.addData("Claw Pos", clawPos);
            telemetry.addData("Arm Pos", armPos);
            telemetry.addData("Orientation", orientPos);
            telemetry.update();
        }

    }
}
