// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter_subsystem;

public class Shooter_command extends Command {
  private final Shooter_subsystem shooter;
  double speed = 0;

  /** Creates a new Shooter_command. */
  public Shooter_command(Shooter_subsystem shooter_subsystem, double spd) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooter = shooter_subsystem;
    speed = spd;
    addRequirements(shooter_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.Shooter_speed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.Shooter_speed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
