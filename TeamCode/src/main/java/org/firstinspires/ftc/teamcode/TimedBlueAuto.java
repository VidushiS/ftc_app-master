
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
@Autonomous(name = "TimedBlueAuto", group = "Exercises")
@Disabled
public class TimedBlueAuto extends LinearOpMode {

    DcMotor LFMotor, RFMotor, RBMotor, LBMotor, LiftMotor;
    ColorSensor ColorS;
    Servo JewelServo, rightArm, UpperRightArm, UpperLeftArm, leftArm;

@Override
    public void runOpMode(){
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

        RBMotor.setDirection(DcMotor.Direction.REVERSE);
        RFMotor.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        waitForStart();


        rightArm.setPosition(-0.1);
        UpperLeftArm.setPosition(0.6);
        sleep(1500);
        LiftMotor.setPower(0.9);
        sleep(1000);
        LiftMotor.setPower(0);

        JewelServo.setPosition(0.88);
        ColorS.enableLed(true);
        sleep(2000);
        telemetry.addData("colorSEnsor" , ColorS.red());
        telemetry.addData("Blue", ColorS.blue());
        telemetry.addData("servoPos", JewelServo.getPosition());
        telemetry.update();

        //if the color of the ball is red, then turn the other way and knock off the blue ball.
        while ( Math.round(JewelServo.getPosition() * 100 )== 88 && ColorS.red() >= 25) {

            sleep(1000);
            LFMotor.setPower(.35);
            telemetry.addData("LFMOtor", LFMotor.getPower());
            telemetry.update();

            RBMotor.setPower(-.35);
            LBMotor.setPower(.35);
            RFMotor.setPower(-.35);

            sleep(400);


            LFMotor.setPower(-.35);
            RFMotor.setPower(.35);
            LBMotor.setPower(-.35);
            RBMotor.setPower(.35);

            sleep(400);

            LFMotor.setPower(0);
            RBMotor.setPower(0);
            LBMotor.setPower(0);
            RFMotor.setPower(0);
            JewelServo.setPosition(0.34);
        }

        //if the color of the ball is blue, then turn that way and knock off the blue ball
        while ( Math.round(JewelServo.getPosition() * 100 )== 88 && ColorS.red() <= 20) {

            telemetry.addData("This works", "yes!");
            telemetry.update();
            sleep(1000);

            //turn and knock off the ball
            LFMotor.setPower(-.35);
            RBMotor.setPower(.35);
            LBMotor.setPower(-.35);
            RFMotor.setPower(.35);

            sleep(400);

            //reset to initial position

            LFMotor.setPower(.35);
            RBMotor.setPower(-.35);
            LBMotor.setPower(.35);
            RFMotor.setPower(-.35);

            sleep(400);


            LFMotor.setPower(0);
            RFMotor.setPower(0);
            RBMotor.setPower(0);
            LBMotor.setPower(0);

            //set the color sensor up
            JewelServo.setPosition(0.34);

        }

        sleep(500);

        //go forward from the plate
        LFMotor.setPower(0.6);
        LBMotor.setPower(0.6);
        RBMotor.setPower(0.6);
        RFMotor.setPower(0.6);


        sleep(1300);


        //turn towards the goal
        LFMotor.setPower(.85);
        LBMotor.setPower(.85);
        RBMotor.setPower(-.85);
        RFMotor.setPower(-.85);

        sleep(1400);

        //move towards the goal
        LFMotor.setPower(.95);
        RFMotor.setPower(.95);
        LBMotor.setPower(0.95);
        RBMotor.setPower(0.95);

        sleep(1250);

        //move towards the goal
        LFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);
        RFMotor.setPower(0);

        sleep(1000);

       /* LFMotor.setPower(.55);
        RFMotor.setPower(-.55);
        LBMotor.setPower(-.55);
        RBMotor.setPower(.55);

        sleep(2700);*/

       //deposit the block by making the lift go down and the arms go out
       LiftMotor.setPower(-.9);
        sleep(100);

        rightArm.setPosition(0.2);
        UpperLeftArm.setPosition(0.2);

        sleep(50);

        //move back a bit
        LFMotor.setPower(-.35);
        RFMotor.setPower(-.35);
        RBMotor.setPower(-.35);
        LBMotor.setPower(-.35);

        sleep(200);


        //just in case, push the block into the goal
        LFMotor.setPower(.35);
        RFMotor.setPower(.35);
        RBMotor.setPower(.35);
        LBMotor.setPower(.35);

        sleep(400);

        //move away from the block slightly
        LFMotor.setPower(-.35);
        RFMotor.setPower(-.35);
        RBMotor.setPower(-.35);
        LBMotor.setPower(-.35);

        sleep(200);

        //end program
        LFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);
        RFMotor.setPower(0);
    }





}



