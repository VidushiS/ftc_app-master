package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by singhv on 3/9/2018.
 */
@TeleOp(name = "Black Car", group = "Exercises")
public class CarTeleOp extends LinearOpMode{

    DcMotor Engine;
    Servo turnWheel;
    double leftY, leftX;
    @Override
    public void runOpMode(){

        Engine = hardwareMap.dcMotor.get("Engine");
        turnWheel = hardwareMap.servo.get("turnWheel");

        telemetry.addData("Mode", "Waiting");
        telemetry.update();

        waitForStart();

        sleep(500);

        telemetry.addData("Mode", "Active");
        telemetry.update();

        while (opModeIsActive()) {

            leftY = Range.clip(gamepad1.left_stick_y, -1.0, 1.0);
            leftX = Range.clip(gamepad1.left_stick_x, -1.0, 1.0);

            Engine.setPower(leftY);
            turnWheel.setPosition(leftX);
        }
        }
}
