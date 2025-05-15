// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Trigger_subsystem;

public class Trigger_command extends Command {
  private final Trigger_subsystem trigger;
  double speed = 0;
  
  /** Creates a new Trigger_command. */
  public Trigger_command(Trigger_subsystem trigger_subsystem, double spd) {
    // Use addRequirements() here to declare subsystem dependencies.
    trigger = trigger_subsystem;
    speed = spd;
    addRequirements(trigger_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    trigger.Trigger_speed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    trigger.Trigger_speed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
