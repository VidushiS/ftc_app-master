package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
/**
 * Created by singhv on 5/4/2018.
 */

@TeleOp(name = "ChairTeleop", group = "Exercises")
public class ChairTeleop extends LinearOpMode {
    private DcMotor LFMotor, RFMotor, LBMotor, RBMotor;

    @Override

    public void runOpMode() {
        LFMotor = hardwareMap.dcMotor.get("LFMotor");
        RFMotor = hardwareMap.dcMotor.get("RFMotor");
        RBMotor = hardwareMap.dcMotor.get("RBMotor");
        LBMotor = hardwareMap.dcMotor.get("LBMotor");

        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        RBMotor.setDirection(DcMotor.Direction.REVERSE);
        LFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Mode", "Waiting");
        telemetry.update();

        waitForStart();

        sleep(500);

        telemetry.addData("Mode", "Active");
        telemetry.update();

        while (opModeIsActive()) {
            double leftJoystickStraight = Range.clip(-gamepad1.left_stick_y, -1, 1);
            double rightJoystick = Range.clip(-gamepad1.right_stick_y, -1, 1);

            LFMotor.setPower(leftJoystickStraight);
            LBMotor.setPower(leftJoystickStraight);
            RFMotor.setPower(rightJoystick);
            RBMotor.setPower(rightJoystick);
            idle();
        }
        telemetry.addData("Mode", "completed");
        telemetry.update();
    }

    }
