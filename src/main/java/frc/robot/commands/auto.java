// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Intake_subsystem;
import frc.robot.subsystems.Shooter_subsystem;
import frc.robot.subsystems.Trigger_subsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class auto extends SequentialCommandGroup {
  /** Creates a new auto. */
  public auto(DriveSubsystem m_drive, Trigger_subsystem m_trigger, Shooter_subsystem m_shooter, Intake_subsystem m_intake) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new twoMetersBackCommand(m_drive, -0.5).withTimeout(0.7),
      new ParallelCommandGroup(
        new Shooter_command(m_shooter, 1).withTimeout(4),
        new SequentialCommandGroup(new WaitCommand(2),new Trigger_command(m_trigger, 1).withTimeout(2))
      ),
      new ParallelCommandGroup(new Intake_command(m_intake, 1).withTimeout(1),
        new twoMetersBackCommand(m_drive, -0.7).withTimeout(0.8)),
      new twoMetersBackCommand(m_drive, 0.7).withTimeout(0.7),
      new ParallelCommandGroup(
        new Shooter_command(m_shooter, 1).withTimeout(4),
        new SequentialCommandGroup(new WaitCommand(2),new Trigger_command(m_trigger, 1).withTimeout(2))
      ),
      new twoMetersBackCommand(m_drive, -0.7).withTimeout(1)

    );
  }
}

