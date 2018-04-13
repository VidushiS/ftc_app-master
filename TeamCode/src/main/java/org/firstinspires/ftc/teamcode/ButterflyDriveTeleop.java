package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by singhv on 4/13/2018.
 */
@TeleOp(name = "Butter-Drive", group = "Exercises")
public class ButterflyDriveTeleop extends LinearOpMode {

    HardwareInit init = new HardwareInit();
    MyGamepad gamepad = new MyGamepad();
    @Override
    public void runOpMode(){
        init.intHardware(this);

        telemetry.addData("Mode", "Waiting");
        telemetry.update();

        waitForStart();

        sleep(500);

        telemetry.addData("Mode", "Active");
        telemetry.update();

        while (opModeIsActive()) {
            if(gamepad.d_padDown(gamepad1.dpad_down)){
                init.PulleyMotor.setPower(-.25);
            }
            else if(!gamepad.d_padDown(gamepad1.dpad_down)){
                init.PulleyMotor.setPower(0);
            }
            if(gamepad.d_padUp(gamepad1.dpad_up)){
                init.PulleyMotor.setPower(.25);
            }
            else if(!gamepad.d_padUp(gamepad1.dpad_up)){
                init.PulleyMotor.setPower(0);
            }
            double leftJoystickStraight = Range.clip(-gamepad1.left_stick_y, -1, 1);
            double rightJoystick = Range.clip(-gamepad1.right_stick_y, -1, 1);

            init.RBMotor.setPower(rightJoystick);
            init.RFMotor.setPower(rightJoystick);
            init.LBMotor.setPower(leftJoystickStraight);
            init.LFMotor.setPower(leftJoystickStraight);

            idle();
        }
    }
}
