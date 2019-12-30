/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Encoder; //encoder import
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  Encoder sampleEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // autoSelected = SmartDashboard.getString("Auto Selector",
    // defaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    // 0 and 1 are the port numbers for the two digital inputs and false tells the encoder to not invert the counting direction
  // k4X makes sure that an encoder module from the FPGA is used and 4X accuracy is obtained
    sampleEncoder.setMaxPeriod(.1);// time between pulses on an individual channel in seconds 
    sampleEncoder.setMinRate(10);  // minimum rate before the device is considered stopped
    sampleEncoder.setDistancePerPulse(5); // Pulses per Revolution
    sampleEncoder.setReverseDirection(true); // flips which way the encoder counts... used for reverse mounter motors
    sampleEncoder.setSamplesToAverage(7); // samples taken to find average change(duh)/ higher equals more accurate but more time to get
    sampleEncoder.reset(); // reset encoder count
    // getting data for encoder-----------------//
  int count = sampleEncoder.get(); // how mnay counts have passed sense created
  double distance = sampleEncoder.getRaw(); // distance reading without compensation for decoding scale factor (dont use unless needed)
  double rate = sampleEncoder.getRate();// rate of the counter in units/sec
  boolean stopped = sampleEncoder.getStopped();// if counter is stopped true or false
  boolean direction = sampleEncoder.getDirection(); // direction of values up is true, down is false
  double distance2 = sampleEncoder.getDistance(); // The current distance reading from the counter. This is the count multiplied by the Distance Per Count scale factor.


//USES OF AN ENCODER
//used for mesuring motor movment for more accurate movment in things such as arm lift


  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
