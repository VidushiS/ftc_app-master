package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by singhv on 3/19/2018.
 */
@TeleOp(name = "H-Drive", group = "Exercises")
public class HDrive extends LinearOpMode{

    DcMotor LFMotor, RFMotor, RBMotor, LBMotor;
    Servo   LFServoUp,LFServoDown, LBServoUp, LBServoDown, RBServoUp, RBServoDown, RFServoUp, RFServoDown;
    double leftY, rightY;
    public void runOpMode(){
        leftY = Range.clip(gamepad1.left_stick_y, -1.0, 1.0);
        rightY = Range.clip(gamepad1.left_stick_y, -1.0, 1.0);
    }
}
