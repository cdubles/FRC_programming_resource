/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  public static WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(4);
  public static WPI_TalonSRX rearRightMotor = new WPI_TalonSRX(3);
  public static WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(2);
  public static WPI_TalonSRX rearLeftMotor = new WPI_TalonSRX(1);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
 

public static MecanumDrive mechDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

  public void MecanumDrive(double x, double y, double rotation) {
    mechDrive.driveCartesian(x, y, rotation);
  }

  @Override
  public void initDefaultCommand() {


    // Set the default command for a subsystem here.
     setDefaultCommand(new Drive());
  }
}
