// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Climb_constants;

public class Climb_subsystem extends SubsystemBase {

  private final CANSparkMax Climb_neo = new CANSparkMax(Climb_constants.climb_neo, MotorType.kBrushless);
  double alt_limit = 0;
  double ust_limit = -1050;
  /** Creates a new Climb. */
  public Climb_subsystem() {
    Climb_neo.restoreFactoryDefaults();
  }

  public void Climb_speed(double speed){
    
    Climb_neo.set(speed);
  }

  public double get_encoder(){
    return Climb_neo.getEncoder().getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("climb pos",Climb_neo.getEncoder().getPosition());
  }
}
