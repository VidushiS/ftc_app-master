/*
Hello there, today we can start out with working on a simple teleop class. This class will introduce you to the basics
of making teleop code (and ensuring that it works). In the main class below, you will seem some methods that might be unfamiliar
I would recommend reading through the CleanedButtonToogle class...*/





package org.firstinspires.ftc.teamcode.ABeginnersGuide;

//This is all the stuff we need to import in order to recoginze the motors and the fact that this is a Teleop class
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo; //Helpful hint continous rotation servos are DIFFERENT from regular servos
/**
 * Created by singhv on 2/14/2018.
 */

//This allows us to name our class so that it can show up on the driver station phone
@TeleOp(name = "TeleOpButtonToggle", group = "Exercises")
public class CleanedTeleop extends LinearOpMode{
    //Lets begin by naming the motors...

    DcMotor leftMotor, rightMotor;

    public void runOpMode(){

    }
}
