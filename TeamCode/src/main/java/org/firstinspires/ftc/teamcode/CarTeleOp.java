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
    double leftY, rightupX, rightdownX;
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

            leftY = Range.clip(gamepad1.right_stick_y, -1.0, 1.0);
            //rightdownX = Range.clip(gamepad1.right_stick_x, 0, .5);

            while (gamepad1.b == true && rightupX <= 0.6){

                rightupX += 1;
            }
            while (!gamepad1.b && rightupX >= 0.0){
                rightupX = rightupX-1;
            }
            Engine.setPower(-leftY);
            turnWheel.setPosition(rightupX);
            //turnWheel.setPosition(rightdownX);


            telemetry.addData("Servo", rightupX);
            //telemetry.addData("servo Up", rightupX);
            telemetry.addData("gamepad right x axis", gamepad1.left_stick_x);
            telemetry.update();

            idle();
        }
        telemetry.addData("Mode", "completed");
        telemetry.update();
        }
}
