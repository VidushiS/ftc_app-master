package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by singhv on 3/19/2018.
 */
@TeleOp(name = "H-Drive", group = "Exercises")
public class HDrive extends LinearOpMode{

    DcMotor LFMotor, RFMotor, RBMotor, LBMotor;
    Servo   LFServoUp,LFServoDown, LBServoUp, LBServoDown, RBServoUp, RBServoDown, RFServoUp, RFServoDown;

    public void runOpMode(){
        
    }
}
