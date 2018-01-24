
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

   private DcMotor LFMotor, RFMotor, LBMotor, RBMotor, LiftMotor, LiftMotor2, SideArm, RelicMotor;
    private Servo rightArm, leftArm, UpperRightArm, UpperLeftArm, ClamperServo,  GrappleServo, JewelArm;
    //HalfCircleArm



    MyGamepad gamepad = new MyGamepad();


    @Override

    public void runOpMode() {

        LFMotor = hardwareMap.dcMotor.get("FrontLeft");
        RFMotor = hardwareMap.dcMotor.get("FrontRight");
        LBMotor = hardwareMap.dcMotor.get("BackLeft");
        RBMotor = hardwareMap.dcMotor.get("BackRight");
        LiftMotor = hardwareMap.dcMotor.get("DS");
        LiftMotor2 = hardwareMap.dcMotor.get("DS2");
      //  SideArm = hardwareMap.dcMotor.get("SideArm");
        rightArm = hardwareMap.servo.get("RA");
        UpperRightArm = hardwareMap.servo.get("URA");
        leftArm = hardwareMap.servo.get("LA");
        UpperLeftArm = hardwareMap.servo.get("ULA");
        GrappleServo = hardwareMap.servo.get("GrappleServo");
       // HalfCircleArm = hardwareMap.dcMotor.get("BalanceBoard");
        ClamperServo = hardwareMap.servo.get("ClamperServo");
        JewelArm = hardwareMap.servo.get("JewelArm");
        SideArm = hardwareMap.dcMotor.get("SideArm");
        RelicMotor = hardwareMap.dcMotor.get("RelicMotor");

        RBMotor.setDirection(DcMotor.Direction.REVERSE);
        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        LiftMotor2.setDirection(DcMotor.Direction.REVERSE);

        LFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LiftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //SideArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        telemetry.addData("Mode", "Waiting");
        telemetry.update();

        waitForStart();

        sleep(500);

        telemetry.addData("Mode", "Active");
        telemetry.update();



        while (opModeIsActive()) {

            JewelArm.setPosition(.35);
            //Tells what button A on whichever gamepad chosen should do when pressed. Toggle gives an on/off state
            if (gamepad.a(gamepad1.a)) {
                //set arms open
                rightArm.setPosition(0.2);
                UpperLeftArm.setPosition(0.2);
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

                //  telemetry.addData("Upper Left", UpperLeftArm.getPosition());
                //  telemetry.update();

            }
            else if (!gamepad.b(gamepad1.b)) {
                //set arms closed
                UpperRightArm.setPosition(0.2);

                leftArm.setPosition(0.2);

                //   telemetry.addData("UpperLeft", UpperLeftArm.getPosition());
                //  telemetry.update();
            }


            //Tells what button b should do on whichever gamepad

           if(gamepad.x(gamepad1.x)){

                RelicMotor.setPower(1.0);
                //  telemetry.addData("Clamper", ClamperServo.getPosition());
                //telemetry.update();
            }
            else if (!gamepad.x(gamepad1.x)){
                RelicMotor.setPower(0);

                //telemetry.addData("Clamper", ClamperServo.getPosition());
                //telemetry.update();
            }
            if(gamepad.y(gamepad1.y)){
                RelicMotor.setPower(-.5);
            }
            else if(!gamepad.y(gamepad1.y)){
                RelicMotor.setPower(0);
            }

            if(gamepad.x2(gamepad2.x)){
                ClamperServo.setPosition(.0);
                GrappleServo.setPosition(1.0);

                telemetry.addData("Clamper", ClamperServo.getPosition());
                telemetry.addData("Grapple", GrappleServo.getPosition());
                telemetry.update();
            }
            else if(!gamepad.x2(gamepad2.x)){
                ClamperServo.setPosition(.15);
                GrappleServo.setPosition(.9);
                telemetry.addData("Clamper", ClamperServo.getPosition());
                telemetry.addData("Grapple", GrappleServo.getPosition());
                telemetry.update();
            }

            //This button was chosen to have three states in order to control the GrappleServo
           /* if (gamepad.x2(gamepad2.x) == 2) {
                GrappleServo.setPosition(.46);
                ClamperServo.setPosition(.50);

                telemetry.addData("Servo Position", GrappleServo.getPosition());
                telemetry.update();
            }
            else if (gamepad.x2(gamepad2.x) == 3) {
                GrappleServo.setPosition(.40);

                ClamperServo.setPosition(.5);



                telemetry.addData("Servo Position", GrappleServo.getPosition());
                telemetry.update();
            }
            else if (gamepad.x2(gamepad2.x) == 1){
                GrappleServo.setPosition(.41);
                ClamperServo.setPosition(.20);

                telemetry.addData("Servo Position", GrappleServo.getPosition());
                telemetry.update();

            }*/

       /* if(gamepad.x2(gamepad2.x)){
           GrappleServo.setPosition(.37);
            telemetry.addData("Power", GrappleServo.getPosition());
            telemetry.update();
        }
        else if (!gamepad.x2(gamepad2.x)){
            GrappleServo.setPosition(.44);
            telemetry.addData("Power", GrappleServo.getPosition());
            telemetry.update();
        }*/

            //On/off state for button y on whichever chosen gamepad
         /* n   if (gamepad.rightBumper2(gamepad2.right_bumper))
            {
               HalfCircleArm.setPower(0.6);

                telemetry.addData("Balance board", HalfCircleArm.getPower());
                telemetry.update();
            }
            else if (!gamepad.rightBumper2(gamepad2.right_bumper))
            {
                HalfCircleArm.setPower(0);

                telemetry.addData("Balance board", HalfCircleArm.getPower());
                telemetry.update();
            }
            if(gamepad.leftBumper2(gamepad2.left_bumper)){
                HalfCircleArm.setPower(-0.6);

                telemetry.addData("Balance board", HalfCircleArm.getPower());
                telemetry.update();
            }
            else if (!gamepad.leftBumper2(gamepad2.left_bumper))
            {
                HalfCircleArm.setPower(0);

                telemetry.addData("Balance board", HalfCircleArm.getPower());
                telemetry.update();
            }*/

            //This button only does an action when pressed. Otherwise it will be inactive
            if (gamepad.leftBumper2(gamepad1.left_bumper)){
                JewelArm.setPosition(.85);
            }
            else if(!gamepad.leftBumper2(gamepad1.left_bumper)){

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

            if (gamepad.d_padLeft(gamepad2.dpad_left)) {

                    SideArm.setPower(0.75);
            }
            else if (!gamepad.d_padLeft(gamepad2.dpad_left)) {
                SideArm.setPower(0.0);
            }

            if (gamepad.d_padRight(gamepad2.dpad_right)){
                SideArm.setPower(-0.75);
            }
            else if (!gamepad.d_padRight(gamepad2.dpad_right)){
                SideArm.setPower(0);
            }

            if(gamepad.right_Trigger(gamepad1.right_bumper)){
                double leftJoystickStraight = Range.clip(-gamepad1.left_stick_y, -.8, .8);
                double rightJoystick = Range.clip(-gamepad1.right_stick_y, -.8, .8);

                LFMotor.setPower(-leftJoystickStraight);
                LBMotor.setPower(-leftJoystickStraight);
                RFMotor.setPower(-rightJoystick);
                RBMotor.setPower(-rightJoystick);

                telemetry.addData("Mode", "Low Power Drive");
                telemetry.update();
            }
            else if(!gamepad.right_Trigger(gamepad1.right_bumper)){
                double leftJoystickStraight = Range.clip(-gamepad1.left_stick_y, -.8, .8);
                double rightJoystick = Range.clip(-gamepad1.right_stick_y, -.8, .8);

                LFMotor.setPower(leftJoystickStraight);
                LBMotor.setPower(leftJoystickStraight);
                RFMotor.setPower(rightJoystick);
                RBMotor.setPower(rightJoystick);
                telemetry.addData("Mode", "Tank Drive");
                telemetry.update();
            }


            idle();

        }

        telemetry.addData("Mode", "completed");
        telemetry.update();
    }
}



