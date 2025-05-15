// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class twoMetersBackCommand extends Command {
  /** Creates a new twoMetersBackCommand. */
  DriveSubsystem drive;
  double percentPower;

  public twoMetersBackCommand(DriveSubsystem m_drive, double percentPower) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive=m_drive;
    this.percentPower = percentPower;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //drive.arcadeDrive(percentPower, percentPower);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.arcadeDrive(0.0, percentPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
