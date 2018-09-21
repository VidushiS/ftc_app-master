 package org.firstinspires.ftc.teamcode;

/**
 * Created by singhv on 10/12/2017.
 */

public class MyGamepad{

    boolean buttonPressedA = false;
    boolean buttonA = true;
    int buttonAcounter = 2;

    boolean buttonPressedB = false;
    boolean buttonB = true;
    int buttonBcounter = 2;

    boolean buttonPressedX = false;
    boolean buttonX = true;
    int buttonXcounter = 2;

    boolean buttonPressedY = false;
    boolean buttonY = true;
    int buttonYcounter = 2;

    boolean rightTriggerPressed = false;
    boolean rightTrigger = false;
    int rightTriggerCounter = 2;

    int buttonX2counter = 2;
    boolean buttonPressedX2 = false;
    boolean buttonX2 = true;
    //int buttonX2stage = 1;
  /* boolean buttonPressedX2 = false;
   boolean buttonX2 = true;
   int buttonX2counter = 2;*/
  boolean leftTriggerPressed = false;
    boolean leftTrigger = false;
    int leftTriggerCounter = 2;

    boolean buttonPressedD_padUP = false;
    boolean buttonPressedD_padDOWN = false;
    boolean buttonPressedD_padLEFT = false;
    boolean buttonPressedD_padRIGHT = false;
    boolean rightBumper_2= false;


    public boolean a(boolean gamepad){

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

    public boolean b(boolean gamepad){

        if (gamepad){
            if(!buttonPressedB){
                buttonBcounter += 1;
                if(buttonBcounter % 2 == 1){
                    buttonB = true;
                }
                else if(buttonBcounter %2 == 0){
                    buttonB = false;
                }
                buttonPressedB = true;
            }
            else{buttonPressedB = true;}
        }
        else buttonPressedB = false;


        return buttonB;
    }

    public boolean x(boolean gamepad){

   /*     if (gamepad){
            if(!buttonPressedX){
                buttonXcounter += 1;
                if(buttonXcounter % 2 == 1){
                    buttonX = true;
                }
                else if(buttonXcounter %2 == 0){
                    buttonX = false;
                }
                buttonPressedX = true;
            }
            else{buttonPressedX = true;}
        }
        else buttonPressedX = false;


        return buttonX;*/
        if(gamepad){
            buttonPressedX= true;
        }
        else buttonPressedX= false;
        return buttonPressedX;
    }

    public boolean x2(boolean gamepad){
      /*  if(gamepad){
            if(!buttonPressedX2){
                buttonX2counter += 1;

                if(buttonX2counter % 3 == 2){
                    buttonX2stage = 1;
                }
                else if(buttonX2counter %3 == 1){
                    buttonX2stage = 2;
                }
                else if(buttonX2counter % 3 == 0){
                    buttonX2stage = 3;
                }
                buttonPressedX2 = true;
            }
            else buttonPressedX2 = true;

        }
        else buttonPressedX2 = false;

        return buttonX2stage;*/
        if (gamepad){
            if(!buttonPressedX2){
                buttonX2counter += 1;
                if(buttonX2counter % 2 == 1){
                    buttonX2 = true;
                }
                else if(buttonX2counter %2 == 0){
                    buttonX2 = false;
                }
                buttonPressedX2 = true;
            }
            else{buttonPressedX2 = true;}
        }
        else buttonPressedX2 = false;


        return buttonX2;

    }

    public boolean y(boolean gamepad){

      /*  if (gamepad){
            if(!buttonPressedY){
                buttonYcounter += 1;
                if(buttonYcounter % 2 == 1){
                    buttonY = true;
                }
                else if(buttonYcounter %2 == 0){
                    buttonY = false;
                }
                buttonPressedY = true;
            }
            else{buttonPressedY = true;}
        }
        else buttonPressedY = false;


        return buttonY;*/
        if(gamepad){
            buttonPressedY= true;
        }
        else buttonPressedY= false;
        return buttonPressedY;
    }

    public boolean d_padUp(boolean gamepad){
        if(gamepad){
            buttonPressedD_padUP = true;
        }
        else buttonPressedD_padUP = false;
        return buttonPressedD_padUP;
    }

    public boolean d_padDown(boolean gamepad){
        if(gamepad){
            buttonPressedD_padDOWN = true;
        }
        else buttonPressedD_padDOWN = false;
        return buttonPressedD_padDOWN;
    }

    public boolean d_padLeft(boolean gamepad){
        if(gamepad){
            buttonPressedD_padLEFT = true;
        }
        else buttonPressedD_padLEFT = false;
        return buttonPressedD_padLEFT;
    }
    public boolean rightBumper2(boolean gamepad){
        if(gamepad){
            rightBumper_2 = true;
        }
        else rightBumper_2 = false;
        return rightBumper_2;
    }
    public boolean leftBumper2(boolean gamepad){
        if (gamepad){
            if(!leftTriggerPressed){
                leftTriggerCounter += 1;
                if(leftTriggerCounter % 2 == 1){
                    leftTrigger = true;
                }
                else if(leftTriggerCounter %2 == 0){
                    leftTrigger = false;
                }
                leftTriggerPressed = true;
            }
            else{leftTriggerPressed = true;}
        }
        else leftTriggerPressed = false;
        return leftTrigger;
    }
    public boolean d_padRight(boolean gamepad){
        if(gamepad){
            buttonPressedD_padRIGHT = true;
        }
        else buttonPressedD_padRIGHT = false;
        return buttonPressedD_padRIGHT;
    }

    public boolean right_Bumper(boolean gamepad){

        if (gamepad){
            if(!rightTriggerPressed){
                rightTriggerCounter += 1;
                if(rightTriggerCounter % 2 == 1){
                    rightTrigger = true;
                }
                else if(rightTriggerCounter %2 == 0){
                    rightTrigger = false;
                }
                rightTriggerPressed = true;
            }
            else{rightTriggerPressed = true;}
        }
        else rightTriggerPressed = false;


        return rightTrigger;
    }
}

