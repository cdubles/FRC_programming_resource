/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {

  public static WPI_TalonSRX Right = new WPI_TalonSRX(0);
  public static WPI_TalonSRX Left = new WPI_TalonSRX(1);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static DifferentialDrive diffDrive = new DifferentialDrive(Left, Right);

public void tankDrive(double Left, Double Right ){
  diffDrive.tankDrive(Left, Right);
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new Drive());
  }
}
