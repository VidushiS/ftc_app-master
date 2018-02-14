package org.firstinspires.ftc.teamcode.ABeginnersGuide;

/**
 * Created by singhv on 2/7/2018.
 */

public class CleanedButtonToogle {
    /*
    Hello there, if you are reading this you must the new vict- I mean programmer of Team 9876, The CountDown.
    All the classes in this package will teach you needed skills that you can use in whatever challenge you are doing.

    Today's Topic: How to make a simple button toggle system and expand upon it!
     */

    //The purpose of a button toggle system is to allow one button to control multiple parts of the robot.
    //So one button can be used to turn a motor on and off or set a servo to two different positions.
    //This helps make debugging easier, and it is also more intuitive for the drivers
    //Let's start by making some variables to make the latched state for the 'A' button

    boolean buttonPressedA = false; //This variable makes sure that the button toggle is counted only once... More on that later
    boolean buttonA = true; //This variable determines the value sent by the public boolean
    int buttonAcounter = 2; //This variable checks how many times the button was pressed

    public boolean a(boolean gamepad){ // the boolean gamepad is a parameter. Basically it sets which button we are tracking
        //For the purpose of this example, lets say that the boolean gamepad is gamepad1.a();
        //So gamepad = gamepad1.a()
        //
        if (gamepad){
            if(!buttonPressedA){
                buttonAcounter += 1;
                if(buttonAcounter % 2 == 1){
                    buttonA = false;
                }
                else if(buttonAcounter %2 == 0){
                    buttonA = true;
                }
                buttonPressedA = true;
            }
            else{buttonPressedA = true;}
        }
        else buttonPressedA = false;


        return buttonA;
    }
}
