package org.firstinspires.ftc.teamcode.OpModes.Autos;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.Subsystems.SpecArm;
import org.firstinspires.ftc.teamcode.Subsystems.Sweep;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous
public class BlueSpec extends LinearOpMode {
    private SpecArm specarm;
    private Sweep sweep;
    private Follower follower;
    public PathChain Chain1, Chain2,Chain3, Chain4,Chain5, Chain6, Chain7, Chain8, Chain9, Chain10, Chain11, Chain12, Chain13, Chain14, Chain15, Chain16;
    private int pathState = 0;
    @Override
    public void runOpMode() {
        specarm = new SpecArm(hardwareMap);
        sweep = new Sweep(hardwareMap);
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
        switch (pathState) {
            case 0:
                follower.followPath(Chain1);
                setPathState(1);
                specPut();
                break;
            case 1:
                if (!follower.isBusy()) {
                    follower.followPath(Chain2);
                    setPathState(2);
                    sweep();
                }
                break;
            case 2:
                if (!follower.isBusy()) {
                    follower.followPath(Chain3);
                    setPathState(3);
                    sweepUp();
                }
                break;
            case 3:
                if (!follower.isBusy()) {
                    follower.followPath(Chain4);
                    setPathState(4);
                    sweep();
                }
                break;
            case 4:
                if (!follower.isBusy()) {
                    follower.followPath(Chain5);
                    setPathState(5);
                    sweepUp();
                }
                break;
            case 5:
                if (!follower.isBusy()) {
                    follower.followPath(Chain6);
                    setPathState(6);
                    sweep();
                }
                break;
            case 6:
                if (!follower.isBusy()) {
                    follower.followPath(Chain7);
                    setPathState(7);
                    sweepUp();
                }
                break;
            case 7:
                if (!follower.isBusy()) {
                    specPick();
                    follower.followPath(Chain8);
                    setPathState(8);
                }
                break;
            case 8:
                if (!follower.isBusy()) {
                    specPut();
                    follower.followPath(Chain9);
                    setPathState(9);
                }
                break;
            case 9:
                if (!follower.isBusy()) {
                    specPick();
                    follower.followPath(Chain10);
                    setPathState(10);
                }
                break;
            case 10:
                if (!follower.isBusy()) {
                    specPut();
                    follower.followPath(Chain11);
                    setPathState(11);
                }
                break;
            case 11:
                if (!follower.isBusy()) {
                    specPick();
                    follower.followPath(Chain12);
                    setPathState(12);
                }
                break;
            case 12:
                if (!follower.isBusy()) {
                    specPut();
                    follower.followPath(Chain13);
                    setPathState(13);
                }
                break;
            case 13:
                if (!follower.isBusy()) {
                    specPick();
                    follower.followPath(Chain14);
                    setPathState(14);
                }
                break;
            case 14:
                if (!follower.isBusy()) {
                    specPut();
                    follower.followPath(Chain15);
                    setPathState(15);
                }
                break;
            case 15:
                if (!follower.isBusy()) {
                    follower.followPath(Chain16);
                    setPathState(16);
                }
                break;
        }
    }
    public void specPick() {
        specarm.setBasePos(0.0);
        specarm.setSpecArmPos(0.0);
        specarm.setSpecClawPos(1.0);
    }
    public void specPut() {
        specarm.setBasePos(1.0);
        specarm.setSpecArmPos(1.0);
        specarm.setSpecClawPos(0.0);
    }
    public void sweep() {
        sweep.setSweepSpecific(1.0);
    }
    public void sweepUp() {
        sweep.setSweepSpecific(0.0);
    }
    public void setPathState(int pState) {
        pathState = pState;
    }
    public void buildPaths() {
        Chain1 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(8.000, 62.000),
                                new Pose(38.000, 62.000)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();
        Chain2 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(38.000, 62.000),
                                new Pose(12.000, 48.000),
                                new Pose(42.000, 40.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(-30))
                .build();
        Chain3 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(42.000, 40.000),
                                new Pose(27.000, 36.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(-30), Math.toRadians(270))
                .build();
        Chain4 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(27.000, 36.000),
                                new Pose(42.000, 27.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(-30))
                .build();
        Chain5 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(42.000, 27.000),
                                new Pose(28.000, 23.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(-30), Math.toRadians(270))
                .build();
        Chain6 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(28.000, 23.000),
                                new Pose(43.000, 16.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(-30))
                .build();
        Chain7 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(43.000, 16.000),
                                new Pose(28.000, 12.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(-30), Math.toRadians(270))
                .build();
        Chain8 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(28.000, 12.000),
                                new Pose(46.000, 35.000),
                                new Pose(11.000, 33.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(0))
                .build();
        Chain9 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(11.000, 33.000),
                                new Pose(6.000, 66.000),
                                new Pose(36.000, 66.000)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
        Chain10 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(36.000, 66.000),
                                new Pose(10.000, 33.000)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
        Chain11 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(10.000, 33.000),
                                new Pose(6.000, 66.000),
                                new Pose(36.000, 67.000)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
        Chain12 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(36.000, 67.000),
                                new Pose(10.000, 33.000)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
        Chain13 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(10.000, 33.000),
                                new Pose(6.000, 66.000),
                                new Pose(37.000, 69.000)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
        Chain14 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(37.000, 69.000),
                                new Pose(11.000, 34.000)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
        Chain15 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(11.000, 34.000),
                                new Pose(6.000, 66.000),
                                new Pose(36.000, 71.000)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
        Chain16 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(36.000, 71.000),
                                new Pose(18.000, 46.000)
                            )
                        )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
}

