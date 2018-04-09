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

    DcMotor Engine, Engine2;
    Servo turnWheel;
    double leftY, rightupX, rightY;
    @Override
    public void runOpMode(){

        Engine = hardwareMap.dcMotor.get("Engine");
        Engine2 = hardwareMap.dcMotor.get("Engine2");
        turnWheel = hardwareMap.servo.get("turnWheel");

        telemetry.addData("Mode", "Waiting");
        telemetry.update();

        waitForStart();

        sleep(500);

        telemetry.addData("Mode", "Active");
        telemetry.update();

        while (opModeIsActive()) {

            leftY = Range.clip(gamepad1.right_stick_y, -1.0, 1.0);
            rightY = Range.clip(gamepad1.right_stick_y, -1.0, 1.0);
            //rightdownX = Range.clip(gamepad1.right_stick_x, 0, .5);

            if (gamepad1.dpad_right == true && 0.0<= rightupX && rightupX <= 0.6){

                rightupX += 0.1;
            }

            if (gamepad1.dpad_left == true && rightupX >= 0.0 && rightupX <= 0.6){
                rightupX = rightupX - 0.1;
            }
            if (!gamepad1.dpad_left && !gamepad1.dpad_right){
                rightupX = 0.3;
            }

            Engine.setPower(-leftY);
            Engine2.setPower(leftY);
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
