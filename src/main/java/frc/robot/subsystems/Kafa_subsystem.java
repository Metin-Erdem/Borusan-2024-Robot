// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Kafa_constants;

public class Kafa_subsystem extends SubsystemBase {

  private final WPI_VictorSPX pg_sag = new WPI_VictorSPX(Kafa_constants.pg_sag);
  private final WPI_VictorSPX pg_sol = new WPI_VictorSPX(Kafa_constants.pg_sol);

  /** Creates a new Kafa. */
  public Kafa_subsystem() {
    pg_sag.configFactoryDefault();
    pg_sol.configFactoryDefault();
    pg_sol.setInverted(true);
  }

  public void kafa_speed(double speed){
    pg_sag.set(speed);
    pg_sol.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
