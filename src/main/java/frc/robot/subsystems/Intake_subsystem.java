// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Intake_constants;

public class Intake_subsystem extends SubsystemBase {
  private final CANSparkMax intake_neo = new CANSparkMax(Intake_constants.Intake_neo, MotorType.kBrushless);

  /** Creates a new Intake. */
  public Intake_subsystem() {
    intake_neo.restoreFactoryDefaults();
  }

  public void Intake_speed(double spd){
    intake_neo.set(spd);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
