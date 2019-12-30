/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor; //import for compressor 
import edu.wpi.first.wpilibj.DoubleSolenoid; //import for double staged solenoids
import edu.wpi.first.wpilibj.Solenoid; // the import for using single stage solenoids
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  /**
   * note that making a compressor in not needed and should only be used if you need to query it's status or want greater control over it
   * 9 times out of ten this is not needed
   */

  Compressor compressor = new Compressor(0); // create a compressor on port 1

  Solenoid SingleStage = new Solenoid(1); // create a SINGLE stage solenoid on port 1
  DoubleSolenoid DoubleStage = new DoubleSolenoid(2, 3); // create double solenoid on port 2 and 3



  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }


  @Override
  public void robotPeriodic() {
  }

  

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    compressor.setClosedLoopControl(true); // turn compressor on
    compressor.setClosedLoopControl(false); // turn compressor off
    boolean enabled = compressor.enabled(); // if compressor is curently on
    boolean pressureSwitch = compressor.getPressureSwitchValue(); // if pressure switch is on
    double current = compressor.getCompressorCurrent(); // how much is the compressor drawing (good for debugging)

    SingleStage.set(true); // set the single stage solenoid to be activated
    SingleStage.set(false); // set the single stage solenoid to be deactivated

    DoubleStage.set(DoubleSolenoid.Value.kOff); // set double solenoid to be off (not pushing or pulling)
    DoubleStage.set(DoubleSolenoid.Value.kForward); //set double to be pushing out
    DoubleStage.set(DoubleSolenoid.Value.kReverse); //set double to be pulling in 

  }


}
