// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Drive_constants;
public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private final WPI_VictorSPX sag1 = new WPI_VictorSPX(Drive_constants.sag1);
  private final WPI_VictorSPX sag2 = new WPI_VictorSPX(Drive_constants.sag2);
  private final WPI_VictorSPX sol2 = new WPI_VictorSPX(Drive_constants.sol1);
  private final WPI_VictorSPX sol1 = new WPI_VictorSPX(Drive_constants.sol2);
   private final DifferentialDrive drive = new DifferentialDrive(sag1, sol1);

  public DriveSubsystem() {
    sag1.configFactoryDefault();
    sag2.configFactoryDefault();
    sol1.configFactoryDefault();
    sol2.configFactoryDefault();

    sag1.setInverted(true);
    sag2.setInverted(false);

    sag2.follow(sag1);
    sol2.follow(sol1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void arcadeDrive(Double M_speed,Double i){
    drive.arcadeDrive(-M_speed, -i);

  }
}
