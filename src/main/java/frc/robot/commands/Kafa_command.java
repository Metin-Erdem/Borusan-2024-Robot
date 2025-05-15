// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Kafa_subsystem;

public class Kafa_command extends Command {
  private final Kafa_subsystem kafa;
  double speed;

  /** Creates a new Kafa_command. */
  public Kafa_command(Kafa_subsystem kafa_subsystem, double spd) {
    // Use addRequirements() here to declare subsystem dependencies.
    kafa = kafa_subsystem;
    speed = spd;
    addRequirements(kafa_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    kafa.kafa_speed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    kafa.kafa_speed(-0.05);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
