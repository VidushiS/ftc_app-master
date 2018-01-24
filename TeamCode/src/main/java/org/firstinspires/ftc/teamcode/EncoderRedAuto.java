package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by singhv on 11/7/2017.
 */
@Autonomous(name = "EncoderRedAuto", group = "Exercises")
@Disabled


public class EncoderRedAuto extends LinearOpMode {

    DcMotor LFMotor, RFMotor, RBMotor, LBMotor, LiftMotor;
    ColorSensor ColorS;
    Servo JewelServo, rightArm, UpperRightArm, UpperLeftArm, leftArm;

    EncoderCountsCalc calc = new EncoderCountsCalc();
    @Override
    public void runOpMode() {
        LFMotor = hardwareMap.dcMotor.get("FrontLeft");
        RFMotor = hardwareMap.dcMotor.get("FrontRight");
        LBMotor = hardwareMap.dcMotor.get("BackLeft");
        RBMotor = hardwareMap.dcMotor.get("BackRight");
        LiftMotor = hardwareMap.dcMotor.get("DS");

        rightArm = hardwareMap.servo.get("RA");
        UpperRightArm = hardwareMap.servo.get("URA");
        leftArm = hardwareMap.servo.get("LA");
        UpperLeftArm = hardwareMap.servo.get("ULA");

        ColorS = hardwareMap.colorSensor.get("colorSensor");
        JewelServo = hardwareMap.servo.get("JewelArm");

        LFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        RBMotor.setDirection(DcMotor.Direction.REVERSE);
        RFMotor.setDirection(DcMotor.Direction.REVERSE);

        LFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        telemetry.addData("Mode", "waiting");
        telemetry.update();

        waitForStart();

        JewelServo.setPosition(0.88);
        ColorS.enableLed(true);
        sleep(2000);
        telemetry.addData("colorSEnsor" , ColorS.red());
        telemetry.addData("Blue", ColorS.blue());
        telemetry.addData("servoPos", JewelServo.getPosition());
        telemetry.update();

        while ( Math.round(JewelServo.getPosition() * 100 )== 88) {
            LFMotor.setTargetPosition(calc.CountCalc(24));
            LBMotor.setTargetPosition(calc.CountCalc(24));
            RBMotor.setTargetPosition(calc.CountCalc(24));
            RFMotor.setTargetPosition(calc.CountCalc(24));

            LFMotor.setPower(.5);
            LBMotor.setPower(.5);
            RBMotor.setPower(.5);
            RFMotor.setPower(.5);

            while (opModeIsActive() && LFMotor.isBusy() && RFMotor.isBusy() && LBMotor.isBusy() && RBMotor.isBusy()){
                telemetry.addData("LFMotor", LFMotor.getCurrentPosition());
                telemetry.update();
                idle();
            }

            LFMotor.setPower(0);
            LBMotor.setPower(0);
            RBMotor.setPower(0);
            RFMotor.setPower(0);

            JewelServo.setPosition(.35);

        }


    }
}