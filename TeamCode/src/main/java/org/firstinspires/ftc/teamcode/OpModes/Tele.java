package org.firstinspires.ftc.teamcode.OpModes;

import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Brakepad;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Pivot;
import org.firstinspires.ftc.teamcode.Subsystems.Slides;
import org.firstinspires.ftc.teamcode.Subsystems.SpecArm;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

import java.util.List;

@TeleOp
public class Tele extends LinearOpMode {
    private Claw claw;
    private Brakepad brakepad;
    private Follower follower;
    private Pivot pivot;
    private Slides slide;
    private SpecArm specarm;
    private List<LynxModule> hubs;

    private double orientPos = 0.0;

    //pick up logic
    private int pickStage = 0;
    private boolean aPressedLast = false;

    //drop logic
    private boolean dropSequenceRunning = false;
    //spec logic
    private int specStage = 0;
    private boolean xPressedLast = false;

    public void runOpMode() throws InterruptedException {
        follower = Constants.createFollower(hardwareMap);
        follower.update();
        claw = new Claw(hardwareMap);
        brakepad = new Brakepad(hardwareMap);
        pivot = new Pivot(hardwareMap);
        slide = new Slides(hardwareMap);
        specarm = new SpecArm(hardwareMap);

        orientPos = claw.getOrientPos();

        hubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : hubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }

        waitForStart();
        follower.startTeleopDrive();

        while (opModeIsActive()) {
            for (LynxModule hub : hubs) {
                hub.clearBulkCache();
            }
            runDrive();
            pickSample();
            dropSample();
            bucket();
            reset();
            specimen();
        }
    }

    public void runDrive() {
        follower.setTeleOpDrive(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x * 0.75,
                true
        );
        follower.update();
    }

    //make all the poses correct (0.0 = down)
    public void pickSample() {
        boolean aPressed = gamepad1.a;
        boolean aJustPressed = aPressed && !aPressedLast;

        if (aJustPressed && pickStage == 0) {
            //brakepad up
            brakepad.setBreakPad(0.0);
            //pivot servo up
            pivot.setPivotServo(0.0);
            //claw arm up
            claw.setArmPos(0.0);
            //slide out
            slide.setMotorPos(1000, 0.5);
            pickStage = 1;
        }
        if (pickStage == 1 && slide.getMotorPos() > 700) {
            claw.setArmPos(1.0);
            brakepad.setBreakPad(1.0);
            pivot.setPivotServo(1.0);
        }

        if (aJustPressed && pickStage == 1 && slide.getMotorPos() > 700) {
            claw.setClawPos(1.0);
            pickStage = 2;
        }

        //claw orientation
        if (gamepad1.dpad_left) {
            orientPos += 0.01;
            orientPos = Math.min(orientPos, 1.0);
            claw.setOrient(orientPos);
        }
        if (gamepad1.dpad_right) {
            orientPos -= 0.01;
            orientPos = Math.max(orientPos, 0.0);
            claw.setOrient(orientPos);
        }

        aPressedLast = aPressed;
    }

    public void dropSample() {
        boolean yPressed = gamepad1.y;

        if (yPressed && !dropSequenceRunning) {
            slide.setMotorPos(1000, 0.5);
            dropSequenceRunning = true;
        }
        if (dropSequenceRunning && slide.getMotorPos() > 700) {
            claw.setArmPos(0.0);
            claw.setClawPos(0.0);
            dropSequenceRunning = false;
        }
    }

    public void bucket() {
        if (gamepad1.dpad_up) {
            //pivot up and slide extending to high basket
            pivot.setPivotMotor(1000, 0.5);
            slide.setMotorPos(1000, 0.5);
        }
        if (gamepad1.dpad_down) {
            //pivot up and slide exteding to low basket
            pivot.setPivotMotor(1000, 0.5);
            slide.setMotorPos(500, 0.5);
        }
    }

    // spec logic
    public void specimen() {
        boolean xPressed = gamepad1.x;
        boolean xJustPressed = xPressed && !xPressedLast;

        if (xJustPressed && specStage == 0) {
            //reset so that the base of the spec arm is down and the arm part is also down
            specarm.setSpecArmPos(0.0);
            specarm.setBasePos(0.0);
            specStage = 1;
        } else if (xJustPressed && specStage == 1) {
            //close the claw and flip the arm and the base around
            specarm.setSpecClawPos(1.0);
            specarm.setBasePos(1.0);
            specarm.setSpecArmPos(1.0);
            specStage = 2;
        } else if (xJustPressed && specStage == 2) {
            specarm.setSpecClawPos(0.0);
            specStage = 0;
        }

        xPressedLast = xPressed;
    }
//reset everything back to base condition in case something goes wrong
    public void reset() {
        if (gamepad1.b) {
            pickStage = 0;
            specStage = 0;
            dropSequenceRunning = false;

            slide.setMotorPos(0, 0.5);
            pivot.setPivotMotor(0, 0.5);
            pivot.setPivotServo(0.0);
            brakepad.setBreakPad(0.0);
            claw.setClawPos(0.0);
            claw.setArmPos(0.0);
            specarm.setSpecClawPos(0.0);
            specarm.setBasePos(0.0);
            specarm.setSpecArmPos(0.0);
        }
    }
}