package org.firstinspires.ftc.teamcode.OpModes.Autos;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Pivot;
import org.firstinspires.ftc.teamcode.Subsystems.Slides;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous
public class BlueSample extends LinearOpMode {
    private Slides slides;
    private Claw claw;
    private Pivot pivot;
    private Follower follower;
    public PathChain Chain1, Chain2,Chain3, Chain4,Chain5, Chain6, Chain7, Chain8;
    private int pathState = 0;
    @Override
    public void runOpMode() {
        slides = new Slides(hardwareMap);
        claw = new Claw(hardwareMap);
        pivot = new Pivot(hardwareMap);
        follower = Constants.createFollower(hardwareMap);
        follower.update();

        buildPaths();

        waitForStart();

        while(opModeIsActive()) {
            autonomousPathUpdate();

            follower.update();
        }
    }
    public void autonomousPathUpdate() {
        switch(pathState) {
            case 0:
                follower.followPath(Chain1);
                setPathState(1);
                dropSample();
                break;
            case 1:
                if(!follower.isBusy()) {
                    grabSample();
                    follower.followPath(Chain2);
                    setPathState(2);
                }
                break;
            case 2:
                if(!follower.isBusy()) {
                    dropSample();
                    follower.followPath(Chain3);
                    setPathState(3);
                }
                break;
            case 3:
                if(!follower.isBusy()) {
                    grabSample();
                    follower.followPath(Chain4);
                    setPathState(4);
                }
                break;
            case 4:
                if(!follower.isBusy()) {
                    dropSample();
                    follower.followPath(Chain5);
                    setPathState(5);
                }
                break;
            case 5:
                if(!follower.isBusy()) {
                    grabSample();
                    follower.followPath(Chain6);
                    setPathState(6);
                }
                break;
            case 6:
                if(!follower.isBusy()) {
                    dropSample();
                    follower.followPath(Chain7);
                    setPathState(7);
                }
                break;
            case 7:
                if(!follower.isBusy()) {
                    follower.followPath(Chain8);
                    setPathState(8);
                }
                break;
        }
    }
    public void grabSample() {
        slides.setMotorPos(1000, 0.5);
        pivot.setPivotServo(0.0);
        claw.setClawPos(1.0);
    }
    public void dropSample() {
        pivot.setPivotMotor(1000, 0.5);
        slides.setMotorPos(1000, 0.5);
        claw.setArmPos(1.0);
        claw.setClawPos(0.0);
    }

    public void setPathState(int pState) {
        pathState = pState;
    }
    public void buildPaths() {
        Chain1 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(9.000, 118.000),
                                new Pose(14.000, 125.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(-45))
                .build();
        Chain2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(14.000, 125.000),
                                new Pose(24.000, 119.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(-45), Math.toRadians(0))
                .build();
        Chain3 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(24.000, 119.000),
                                new Pose(14.000, 127.000)
                        )
                )
                .setTangentHeadingInterpolation()
                .setReversed()
                .build();
        Chain4 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(14.000, 127.000),
                                new Pose(28.000, 129.500)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(-45), Math.toRadians(0))
                .build();
        Chain5 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(28.000, 129.500),
                                new Pose(14.000, 127.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(-45))
                .setReversed()
                .build();
        Chain6 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(14.000, 127.000),
                                new Pose(25.000, 131.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(-45), Math.toRadians(25))
                .build();
        Chain7 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(25.000, 131.000),
                                new Pose(14.000, 127.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(25), Math.toRadians(-45))
                .build();
        Chain8 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(14.000, 127.000),
                                new Pose(25.838, 112.053)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();
    }
}

