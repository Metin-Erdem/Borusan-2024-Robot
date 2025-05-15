// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Shooter_constants;

public class Shooter_subsystem extends SubsystemBase {
  private final CANSparkMax shooter_neo_1 = new CANSparkMax(Shooter_constants.shooter_neo_1, MotorType.kBrushless);
  private final CANSparkMax shooter_neo_2 = new CANSparkMax(Shooter_constants.shooter_neo_2, MotorType.kBrushless);

  /** Creates a new Shooter. */
  public Shooter_subsystem() {
    shooter_neo_1.restoreFactoryDefaults();
    shooter_neo_2.restoreFactoryDefaults();
    shooter_neo_2.setInverted(false); //Bir motor terslendi
  }

  public void Shooter_speed(double speed){
    shooter_neo_1.set(speed);
    shooter_neo_2.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
