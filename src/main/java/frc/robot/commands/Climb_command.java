// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climb_subsystem;

public class Climb_command extends Command {
  private final Climb_subsystem climb;
  double speed = 0;
  boolean state;
  double encoder_value;
  double hedef;
  /** Creates a new Climb. */

  public Climb_command(Climb_subsystem climb_subsystem, double spd) {
    // Use addRequirements() here to declare subsystem dependencies.
    climb = climb_subsystem;
    speed = spd;
    addRequirements(climb_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    state = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climb.Climb_speed(speed);
    
    /*
    encoder_value = climb.get_encoder();
    if(goal < encoder_value){
      if(encoder_value <= goal){
        m_wrist.WristSpeed(0.0);
        state = true;
      }
      else{
        m_wrist.WristSpeed(0.8);
      }
      
    }
    else if(goal > encoder_value){
      if(encoder_value >= goal){
        climb.Climb_speed(0.0);
        state = true;
      }
      else{
        m_wrist.WristSpeed(-1);
      }
      
    }
    */
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climb.Climb_speed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return state;
  }
}
