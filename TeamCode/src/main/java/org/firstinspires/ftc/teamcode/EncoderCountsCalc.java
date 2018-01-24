package org.firstinspires.ftc.teamcode;

/**
 * Created by singhv on 12/6/2017.
 */

public class EncoderCountsCalc {
    public int CountCalc(float inches){

        float diameter = (float)12.566;
        float rotations = inches/diameter;
        int encoderCounts = Math.round(rotations * 1200);

        return encoderCounts;

    }
}
