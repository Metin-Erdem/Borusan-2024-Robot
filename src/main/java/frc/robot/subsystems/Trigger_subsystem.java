// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Trigger_constants;

public class Trigger_subsystem extends SubsystemBase {
  
  private final CANSparkMax trigger_alt_neo = new CANSparkMax(Trigger_constants.trigger_alt_neo, MotorType.kBrushless);
  private final CANSparkMax trigger_ust_neo = new CANSparkMax(Trigger_constants.trigger_ust_neo, MotorType.kBrushless);
  /** Creates a new Trigger. */
  public Trigger_subsystem() {
    trigger_alt_neo.restoreFactoryDefaults();
    trigger_ust_neo.restoreFactoryDefaults();
    trigger_alt_neo.setInverted(false);
    trigger_ust_neo.setInverted(true);
  }

  public void Trigger_speed(double speed){
    trigger_alt_neo.set(-speed);
    trigger_ust_neo.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
