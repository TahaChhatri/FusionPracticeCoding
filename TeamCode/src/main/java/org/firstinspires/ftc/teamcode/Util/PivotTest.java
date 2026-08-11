package org.firstinspires.ftc.teamcode.Util;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Pivot;

@TeleOp
@Config
public class PivotTest extends LinearOpMode {
    public static double pivotPos = 0.0;
    public static int pivotMotorPos = 0;
    public static double pivotMotorPower = 0.0;
    @Override
    public void runOpMode() throws InterruptedException {
        Pivot pivot = new Pivot(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {
            pivot.setPivotServo(pivotPos);
            pivot.setPivotMotor(pivotMotorPos, pivotMotorPower);

            telemetry.addData("Pivot Motor", pivotMotorPos);
            telemetry.addData("Pivot Servo", pivotPos);
        }
    }
}
