package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by singhv on 3/12/2018.
 */
@TeleOp(name = "Mechanum Drive", group = "Exercises")
public class MechanumDrive extends LinearOpMode {

    DcMotor LFMotor, RFMotor, RBMotor, LBMotor;
    double leftY, rightX, leftX;

    MyGamepad gamepad = new MyGamepad();
    public void runOpMode(){

        LFMotor = hardwareMap.dcMotor.get("LFMotor");
        RFMotor = hardwareMap.dcMotor.get("RFMotor");
        LBMotor = hardwareMap.dcMotor.get("LBMotor");
        RBMotor = hardwareMap.dcMotor.get("RBMotor");

        RBMotor.setDirection(DcMotor.Direction.REVERSE);
        RFMotor.setDirection(DcMotor.Direction.REVERSE);

        LFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Mode", "Waiting");
        telemetry.update();
        waitForStart();

        sleep(500);

        telemetry.addData("Mode", "Active");
        telemetry.update();

        while(opModeIsActive()){
            if(gamepad.right_Bumper(gamepad1.right_bumper)){
                leftY = (Range.clip(gamepad1.left_stick_y, -.2, .2));
                rightX = (Range.clip(gamepad1.right_stick_y, -.2, .2));

                LFMotor.setPower(leftY);
                RFMotor.setPower(rightX);
                LBMotor.setPower(rightX);
                RBMotor.setPower(leftY);
            }
            else{
                leftY = (Range.clip(gamepad1.left_stick_y, -1.0, 1.0));
                rightX = (Range.clip(gamepad1.right_stick_y, -1.0, 1.0));

                LFMotor.setPower(leftY);
                RFMotor.setPower(rightX);
                LBMotor.setPower(leftY);
                RBMotor.setPower(rightX);
            }

        }

    }
}
