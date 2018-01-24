package org.firstinspires.ftc.teamcode;

/**
 * Created by singhv on 1/12/2018.
 */
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous(name = "Vuforia", group = "Exercises")

public class VuforiaStuff extends LinearOpMode {

    public static final String TAG = "Vuforia VuMark Sample";
    OpenGLMatrix lastLocation = null;
    VuforiaLocalizer vuforia;
    DcMotor LFMotor, RFMotor, RBMotor, LBMotor, LiftMotor;
    ColorSensor ColorS;
    Servo JewelServo, rightArm, UpperRightArm, UpperLeftArm, leftArm;
    //This class converts inches to encoder counts for ease of programming.
    //For more info on this class please see the class EncoderCountsCalc
    EncoderCountsCalc calc = new EncoderCountsCalc();

    //This method helps clean up repetitive code. The EncooderReseeter()
    //stops and resets the encoder as well as sets it to the proper run mode
    //every time there is a new command
    public void EncooderReseeter(){
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
    public int Encodercounts(int encoderCounts){
        return encoderCounts;
    }
    //MotorStop() is a simple method which stops all motors, that way when the motors
    //are in the correct position, there is no unneccesary power sent to them.
    public void MotorStop(){
        LFMotor.setPower(0);
        RBMotor.setPower(0);
        RFMotor.setPower(0);
        LBMotor.setPower(0);
    }

    //This waitBlock() is used to track the state of the motors, as well as allow the
    //motors to reach their position
    public void waitBlock(){
        while (opModeIsActive() && LFMotor.isBusy() && RFMotor.isBusy() && LBMotor.isBusy() && RBMotor.isBusy()){
            telemetry.addData("LFMotor", LFMotor.getCurrentPosition());
            telemetry.addData("LBMotor", LBMotor.getCurrentPosition());
            telemetry.addData("RFMotor", RFMotor.getCurrentPosition());
            telemetry.addData("RBMotor", RBMotor.getCurrentPosition());

            telemetry.addData("LFMotor Power", LFMotor.getPower());
            telemetry.update();
            idle();
        }
    }

    @Override
    public void runOpMode() {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "ATsODcD/////AAAAAVw2lR...d45oGpdljdOh5LuFB9nDNfckoxb8COxKSFX";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);

        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

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

        telemetry.addData(">", "Press Play to start");
        telemetry.update();
        waitForStart();

        relicTrackables.activate();

        //init
        waitForStart();

        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

        int chips;
        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {
            telemetry.addData("VuMark", "%s visible", vuMark);

            if (vuMark == RelicRecoveryVuMark.LEFT) {
                chips = 1300;
            }

            if (vuMark == RelicRecoveryVuMark.CENTER) {
                chips = 1200;
            }

            if (vuMark == RelicRecoveryVuMark.RIGHT) {
                chips = 1100;
            }

        } else {
            telemetry.addData("VuMark", "not visible");
        }




        telemetry.update();

    //This block of commands sets the arms to a closed position to grab the
    // glyph and then the drawer slide goes up, with the glyph, for 900 milliseconds
            rightArm.setPosition(0.0);
            UpperLeftArm.setPosition(0.5);

    sleep(1500);
            LiftMotor.setPower(0.9);

    sleep(1000);
            LiftMotor.setPower(0);

    //The encoders on the motors are reset, then they are set to the run-to-position mode
    //After that, the servo on which the color sensor is mounted on is set to a position of 0.83
    //Then the color of the jewel is read

    EncooderReseeter();
            JewelServo.setPosition(0.94);
            ColorS.enableLed(true);

    sleep(2000);
            telemetry.addData("colorSEnsor",ColorS.red());
            telemetry.addData("Blue",ColorS.blue());
            telemetry.addData("servoPos",JewelServo.getPosition());
            telemetry.update();

    //If the color is blue and the arm is down, then the robot does the following commands
    // in the while statement to knock off the blue jewel.
            while(Math.round(JewelServo.getPosition()*100)==94&&ColorS.red()<=20)

    {

        //Turn counter-clockwise to knock off the blue jewel
        LFMotor.setTargetPosition(-39);
        LBMotor.setTargetPosition(-39);
        RBMotor.setTargetPosition(39);
        RFMotor.setTargetPosition(39);

        LFMotor.setPower(-.30);
        RBMotor.setPower(.30);
        LBMotor.setPower(-.30);
        RFMotor.setPower(.30);

        //wait till the position is reached before stopping the motors
        waitBlock();

        //stop the motors
        MotorStop();


        //reset the encoders, and change back to run-to-position
        EncooderReseeter();

        //Turn back clockwise to the original position
        LFMotor.setTargetPosition(39);
        LBMotor.setTargetPosition(39);
        RBMotor.setTargetPosition(-39);
        RFMotor.setTargetPosition(-39);

        LFMotor.setPower(.30);
        RBMotor.setPower(-.30);
        LBMotor.setPower(.30);
        RFMotor.setPower(-.30);

        waitBlock();


        MotorStop();

        //Set the arm back to an upright position
        JewelServo.setPosition(0.35);
    }

    //if the color is red and the arm is down, then do the following commands
            while(Math.round(JewelServo.getPosition()*100)==94&&ColorS.red()>=25)

    {

        //Turn clockwise to knock off the blue jewel

        LFMotor.setTargetPosition(45);
        LBMotor.setTargetPosition(45);
        RBMotor.setTargetPosition(-45);
        RFMotor.setTargetPosition(-45);

        LFMotor.setPower(.25);
        RBMotor.setPower(-.25);
        LBMotor.setPower(.25);
        RFMotor.setPower(-.25);

        waitBlock();

        MotorStop();

        EncooderReseeter();

        //Turn counter-clockwise to return to the original position on the balancing stone
        LFMotor.setTargetPosition(-42);
        LBMotor.setTargetPosition(-42);
        RBMotor.setTargetPosition(47);
        RFMotor.setTargetPosition(47);

        LFMotor.setPower(-.25);
        RBMotor.setPower(.25);
        LBMotor.setPower(-.25);
        RFMotor.setPower(.25);

        waitBlock();

        MotorStop();

        //Set the servo arm upright position
        JewelServo.setPosition(0.35);

    }

    EncooderReseeter();

    //Using the inches to encoders converter, the motors are moving 19 inches forward
            LFMotor.setTargetPosition(calc.CountCalc(13));
            LBMotor.setTargetPosition(calc.CountCalc(13));
            RBMotor.setTargetPosition(calc.CountCalc(13));
            RFMotor.setTargetPosition(calc.CountCalc(13));

            LFMotor.setPower(.5);
            LBMotor.setPower(.5);
            RBMotor.setPower(.5);
            RFMotor.setPower(.5);

    waitBlock();

    MotorStop();

    EncooderReseeter();

    //Turn the robot to face the cryptobox
            LFMotor.setTargetPosition(0);
            LBMotor.setTargetPosition(1300);
            RBMotor.setTargetPosition(-1300);
            RFMotor.setTargetPosition(-1300);

            LFMotor.setPower(.6);
            LBMotor.setPower(.6);
            RBMotor.setPower(-.6);
            RFMotor.setPower(-.6);

    waitBlock();

    MotorStop();

    EncooderReseeter();

    //Make the motors move forward 17 inches
            LFMotor.setTargetPosition(calc.CountCalc(34));
            LBMotor.setTargetPosition(calc.CountCalc(34));
            RBMotor.setTargetPosition(calc.CountCalc(34));
            RFMotor.setTargetPosition(calc.CountCalc(34));

            LFMotor.setPower(.6);
            LBMotor.setPower(.6);
            RFMotor.setPower(.6);
            RBMotor.setPower(.6);

    waitBlock();

    MotorStop();

    //Set the linear slide down, then the arms open to deposit the glyph in the cryptobox
            LiftMotor.setPower(-.9);

    sleep(900);
            LiftMotor.setPower(0);
            rightArm.setPosition(0.2);
            UpperLeftArm.setPosition(0.2);

    EncooderReseeter();

    //Make the robot go back two inches
            LBMotor.setTargetPosition(calc.CountCalc(-2));
            LFMotor.setTargetPosition(calc.CountCalc(-2));
            RBMotor.setTargetPosition(calc.CountCalc(-2));
            RFMotor.setTargetPosition(calc.CountCalc(-2));

            LFMotor.setPower(-.2);
            RBMotor.setPower(-.2);
            LBMotor.setPower(-.2);
            RFMotor.setPower(-.2);

    waitBlock();

    MotorStop();

    EncooderReseeter();

    //Make the robot go forward two inches, in order to push the glyph into the cryptobox
            LFMotor.setTargetPosition(calc.CountCalc(2));
            RFMotor.setTargetPosition(calc.CountCalc(2));
            RBMotor.setTargetPosition(calc.CountCalc(2));
            LBMotor.setTargetPosition(calc.CountCalc(2));

            LFMotor.setPower(.5);
            LBMotor.setPower(.5);
            RBMotor.setPower(.5);
            RFMotor.setPower(.5);

    waitBlock();

    MotorStop();

    EncooderReseeter();

    //Make the robot go back one inch to back away from the glyph,
    //this allows the robot to distance itself form the glyph, but still park in
    //the marked off triangle area.
            LFMotor.setTargetPosition(calc.CountCalc(-1));
            RFMotor.setTargetPosition(calc.CountCalc(-1));
            RBMotor.setTargetPosition(calc.CountCalc(-1));
            LBMotor.setTargetPosition(calc.CountCalc(-1));

            LFMotor.setPower(-.2);
            LBMotor.setPower(-.2);
            RBMotor.setPower(-.2);
            RFMotor.setPower(-.2);

    waitBlock();

    MotorStop();
}



    }




