
        package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.hardware.Servo;
        import com.qualcomm.robotcore.util.Range;


/**
 * Created by singhv on 10/9/2017.
 */
@TeleOp(name = "TeleOpButtonToggle", group = "Exercises")

public class TeleOpButtonToggle extends LinearOpMode {

   private DcMotor LFMotor, RFMotor, LBMotor, RBMotor, LiftMotor, LiftMotor2;
    private Servo rightArm, leftArm, UpperRightArm, UpperLeftArm, JewelArm;

    MyGamepad gamepad = new MyGamepad();


    @Override

    public void runOpMode() {

        LFMotor = hardwareMap.dcMotor.get("FrontLeft");
        RFMotor = hardwareMap.dcMotor.get("FrontRight");
        LBMotor = hardwareMap.dcMotor.get("BackLeft");
        RBMotor = hardwareMap.dcMotor.get("BackRight");
        LiftMotor = hardwareMap.dcMotor.get("DS");
        LiftMotor2 = hardwareMap.dcMotor.get("DS2");
        rightArm = hardwareMap.servo.get("RA");
        UpperRightArm = hardwareMap.servo.get("URA");
        leftArm = hardwareMap.servo.get("LA");
        UpperLeftArm = hardwareMap.servo.get("ULA");
        JewelArm = hardwareMap.servo.get("JewelArm");

        RBMotor.setDirection(DcMotor.Direction.REVERSE);
        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        LiftMotor2.setDirection(DcMotor.Direction.REVERSE);

        LFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LiftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        telemetry.addData("Mode", "Waiting");
        telemetry.update();

        waitForStart();

        sleep(500);

        telemetry.addData("Mode", "Active");
        telemetry.update();

        while (opModeIsActive()) {
            
            //Tells what button A on whichever gamepad chosen should do when pressed. Toggle gives an on/off state
            if (gamepad.a(gamepad1.a)) {
                //set arms open
                rightArm.setPosition(0.2);
                UpperLeftArm.setPosition(0.3);
                telemetry.addData("Upper Left Position", UpperLeftArm.getPosition());
                telemetry.addData("Upper Left Direction", UpperLeftArm.getDirection());
                telemetry.update();

            }
            else if (!gamepad.a(gamepad1.a)) {
                //set arms closed
                rightArm.setPosition(0.0);
                UpperLeftArm.setPosition(0.5);

            }

            if (gamepad.b(gamepad1.b)) {
                //set arms open
                UpperRightArm.setPosition(0.3);

                leftArm.setPosition(-1.0);
            }
            else if (!gamepad.b(gamepad1.b)) {
                //set arms closed
                UpperRightArm.setPosition(0.2);

                leftArm.setPosition(0.2);
            }
            //Tells what button b should do on whichever gamepad

           if(gamepad.x(gamepad1.x)){

            }
            else if (!gamepad.x(gamepad1.x)){
              }
            if(gamepad.y(gamepad1.y)){

            }
            else if(!gamepad.y(gamepad1.y)){

            }

            //This button only does an action when pressed. Otherwise it will be inactive
            if (gamepad.leftBumper2(gamepad1.left_bumper)){
                JewelArm.setPosition(.85);
            }
            else if(!gamepad.leftBumper2(gamepad1.left_bumper)){
                JewelArm.setPosition(.29);
            }
            if (gamepad.d_padUp(gamepad2.dpad_up)) {

                LiftMotor.setPower(0.80);
                LiftMotor2.setPower(.80);

            }
            else if (!gamepad.d_padUp(gamepad2.dpad_up)) {
                LiftMotor.setPower(0);
                LiftMotor2.setPower(0);
            }
            //This button only does an action when pressed, Otherwise it will be inactive
            if (gamepad.d_padDown(gamepad2.dpad_down)) {

                LiftMotor.setPower(-0.65);
                LiftMotor2.setPower(-.65);
            }
            else if (!gamepad.d_padDown(gamepad2.dpad_down)) {
                LiftMotor.setPower(0);
                LiftMotor2.setPower(0);
            }


                double leftJoystickStraight = Range.clip(-gamepad1.left_stick_y, -.5, .5);
                double leftJoystickStraightB= Range.clip(-gamepad1.left_stick_y, -.9, .9);
                double rightJoystick = Range.clip(-gamepad1.right_stick_y, -.5, .5);
                double rightJoystickF = Range.clip(-gamepad1.right_stick_y, -.9, .9);

                LFMotor.setPower(leftJoystickStraight);
                LBMotor.setPower(leftJoystickStraightB);
                RFMotor.setPower(rightJoystickF);
                RBMotor.setPower(rightJoystick);

                telemetry.addData("LBmotor", LBMotor.getPower());
                telemetry.addData("RFmotor", RFMotor.getPower());
                telemetry.addData("Mode", "Low Power Drive");
                telemetry.update();


            idle();

        }

        telemetry.addData("Mode", "completed");
        telemetry.update();
    }
}



