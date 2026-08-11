package org.firstinspires.ftc.teamcode.Util;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Brakepad;
import org.firstinspires.ftc.teamcode.Subsystems.Sweep;

@TeleOp
@Config
public class BrakePadTest extends LinearOpMode {
    public static double brakePadPos = 0.0;
    @Override
    public void runOpMode() throws InterruptedException {
        Brakepad brakepad = new Brakepad(hardwareMap);
        waitForStart();

        while(opModeIsActive()) {
            brakepad.setBreakPad(brakePadPos);

            telemetry.addData("Brake Pod Pos", brakePadPos);
            telemetry.update();
        }
    }
}
