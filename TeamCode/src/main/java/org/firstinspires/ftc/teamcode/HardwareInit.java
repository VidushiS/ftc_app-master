package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

import java.util.Timer;

/**
 * Created by singhv on 4/9/2018.
 */

public class HardwareInit {
    DcMotor LFMotor, RFMotor, LBMotor, RBMotor, PulleyMotor;

    public void intHardware(LinearOpMode op){
        LFMotor = op.hardwareMap.dcMotor.get("LFMotor");
        RFMotor = op.hardwareMap.dcMotor.get("RFMotor");
        LBMotor = op.hardwareMap.dcMotor.get("LBMotor");
        RBMotor = op.hardwareMap.dcMotor.get("RBMotor");
        PulleyMotor = op.hardwareMap.dcMotor.get("PulleyMotor");

        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        RBMotor.setDirection(DcMotor.Direction.REVERSE);

    }
}
