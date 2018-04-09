
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

    private Servo rightArm, leftArm, UpperRightArm, UpperLeftArm, JewelArm;
    private DcMotor LFMotor, RFMotor;

    MyGamepad gamepad = new MyGamepad();


    @Override

    public void runOpMode() {

        LFMotor = hardwareMap.dcMotor.get("LeftMotors");
        RFMotor = hardwareMap.dcMotor.get("RightMotors");

      //  LiftMotor = hardwareMap.dcMotor.get("DS");
        //LiftMotor2 = hardwareMap.dcMotor.get("DS2");
        rightArm = hardwareMap.servo.get("RA");
        UpperRightArm = hardwareMap.servo.get("URA");
        leftArm = hardwareMap.servo.get("LA");
        UpperLeftArm = hardwareMap.servo.get("ULA");
        JewelArm = hardwareMap.servo.get("JewelArm");

        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        //LiftMotor2.setDirection(DcMotor.Direction.REVERSE);

        LFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //LiftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


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
                leftArm.setPosition(0.3);


            }
            else if (!gamepad.a(gamepad1.a)) {
                //set arms closed
                rightArm.setPosition(0.0);
                leftArm.setPosition(0.5);

            }

            if (gamepad.b(gamepad1.b)) {
                //set arms open
                UpperRightArm.setPosition(0.9);

                UpperLeftArm.setPosition(-1.0);

                telemetry.addData("Upper Right Position", UpperRightArm.getPosition());
               // telemetry.addData("Upper Left Direction", UpperLeftArm.getDirection());
                telemetry.update();
            }
            else if (!gamepad.b(gamepad1.b)) {
                //set arms closed
                UpperRightArm.setPosition(0.6);

                UpperLeftArm.setPosition(0.2);

                telemetry.addData("Upper Right Position", UpperRightArm.getPosition());
               // telemetry.addData("Upper Left Direction", UpperLeftArm.getDirection());
                telemetry.update();
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
                JewelArm.setPosition(.9);
            }
            else if(!gamepad.leftBumper2(gamepad1.left_bumper)){
                JewelArm.setPosition(.29);
            }
          /*  if (gamepad.d_padUp(gamepad1.dpad_up)) {

                LFMotor.setPower(0.80);
                RFMotor.setPower(.80);

            }
            else if (!gamepad.d_padUp(gamepad1.dpad_up)) {
                LFMotor.setPower(0);
                RFMotor.setPower(0);
            }
            //This button only does an action when pressed, Otherwise it will be inactive
            if (gamepad.d_padDown(gamepad1.dpad_down)) {

                LFMotor.setPower(-0.65);
                RFMotor.setPower(-.65);
            }
            else if (!gamepad.d_padDown(gamepad1.dpad_down)) {
                LFMotor.setPower(0);
                RFMotor.setPower(0);
            }

*/
                double leftJoystickStraight = Range.clip(-gamepad1.left_stick_y, -1, 1);
                double rightJoystick = Range.clip(-gamepad1.right_stick_y, -1, 1);

            LFMotor.setPower(leftJoystickStraight);
            RFMotor.setPower(rightJoystick);
                //LiftMotor.setPower(leftJoystickStraight);
                //LiftMotor2.setPower(rightJoystick);
            idle();

        }

        telemetry.addData("Mode", "completed");
        telemetry.update();
    }
}



