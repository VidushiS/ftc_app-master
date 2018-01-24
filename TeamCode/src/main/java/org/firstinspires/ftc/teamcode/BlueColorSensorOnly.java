package org.firstinspires.ftc.teamcode;

//Import the needed classes for the code, such as Auto and LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by singhv on 11/7/2017.
 */
@Autonomous(name = "BlueColorOnly", group = "Exercises")
public class BlueColorSensorOnly extends LinearOpMode {

    //Declare variables and their types.
    DcMotor LFMotor, RFMotor, RBMotor, LBMotor, LiftMotor;
    ColorSensor ColorS;
    Servo JewelServo, rightArm, UpperRightArm, UpperLeftArm, leftArm;

    //This class converts inches to encoder counts for ease of programming.
    //For more info on this class please see the class EncoderCountsCalc
    EncoderCountsCalc calc = new EncoderCountsCalc();

    //This method helps clean up repetitive code. The EncooderReseeter()
    //stops and resets the encoder as well as sets it to the proper run mode
    //every time there is a new command
    public void EncooderReseeter() {
        LFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        sleep(500);

        LFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    //MotorStop() is a simple method which stops all motors, that way when the motors
    //are in the correct position, there is no unneccesary power sent to them.
    public void MotorStop() {
        LFMotor.setPower(0);
        RBMotor.setPower(0);
        RFMotor.setPower(0);
        LBMotor.setPower(0);
    }

    //This waitBlock() is used to track the state of the motors, as well as allow the
    //motors to reach their position
    public void waitBlock() {
        while (opModeIsActive() && LFMotor.isBusy() && RFMotor.isBusy() && LBMotor.isBusy() && RBMotor.isBusy()) {
            telemetry.addData("LFMotor", LFMotor.getCurrentPosition());
            telemetry.update();
            idle();
        }
    }

    @Override
    public void runOpMode() {

        //init
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

        LiftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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

        //This block of commands sets the arms to a closed position to grab the
        // glyph and then the drawer slide goes up, with the glyph, for 900 milliseconds


        //The encoders on the motors are reset, then they are set to the run-to-position mode
        //After that, the servo on which the color sensor is mounted on is set to a position of 0.83
        //Then the color of the jewel is read
        EncooderReseeter();
        JewelServo.setPosition(0.93);
        ColorS.enableLed(true);
        sleep(2000);
        telemetry.addData("colorSEnsor", ColorS.red());
        telemetry.addData("Blue", ColorS.blue());
        telemetry.addData("servoPos", JewelServo.getPosition());
        telemetry.update();

        //If the color is red and the arm is down, then the robot does the following commands
        //in the while statement to knock off the red jewel.
        while (Math.round(JewelServo.getPosition() * 100) == 93 && ColorS.red() >= 25) {

            telemetry.addData("This works", "yes!");
            telemetry.update();
            sleep(1000);

            //turn counter-clockwise to knock off the red jewel
            LFMotor.setTargetPosition(-100);
            LBMotor.setTargetPosition(-100);
            RBMotor.setTargetPosition(100);
            RFMotor.setTargetPosition(100);

            LFMotor.setPower(-.35);
            RBMotor.setPower(.35);
            LBMotor.setPower(-.35);
            RFMotor.setPower(.35);

            //Wait till the position is reached before stopping the motors
            waitBlock();

            //Stop the motors
            MotorStop();


            //Reset the encoders, and change back to run-to-position
            EncooderReseeter();

            //Turn back clockwise to the original position
            //Set the arm back to an upright position
            JewelServo.setPosition(0.35);
        }

        //If the color is blue and the arm is down, then do the following commands
        while (Math.round(JewelServo.getPosition() * 100) == 93 && ColorS.red() <= 20) {

            //Turn clockwise to knock off the red jewel
            LFMotor.setTargetPosition(100);
            LBMotor.setTargetPosition(100);
            RBMotor.setTargetPosition(-100);
            RFMotor.setTargetPosition(-100);

            LFMotor.setPower(.25);
            RBMotor.setPower(-.25);
            LBMotor.setPower(.25);
            RFMotor.setPower(-.25);

            waitBlock();

            MotorStop();

            EncooderReseeter();

            //Turn counter-clockwise back to the original position

            JewelServo.setPosition(0.35);
        }

        MotorStop();
    }
}