// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.OperatorConstants_2;
import frc.robot.commands.Climb_command;
import frc.robot.commands.Intake_command;
import frc.robot.commands.Kafa_command;
import frc.robot.commands.Shooter_command;
import frc.robot.commands.Trigger_command;
import frc.robot.commands.auto;
import frc.robot.subsystems.Climb_subsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Intake_subsystem;
import frc.robot.subsystems.Kafa_subsystem;
import frc.robot.subsystems.Shooter_subsystem;
import frc.robot.subsystems.Trigger_subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class RobotContainer {
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final Intake_subsystem m_intake = new Intake_subsystem();
  private final Trigger_subsystem m_trigger = new Trigger_subsystem();
  private final Kafa_subsystem m_kafa = new Kafa_subsystem();
  private final Climb_subsystem m_climb = new Climb_subsystem();
  private final Shooter_subsystem m_shooter = new Shooter_subsystem();

  private final XboxController m_driverController = new XboxController(OperatorConstants.kDriverControllerPort);
  private final Joystick m_driver2 = new Joystick(OperatorConstants_2.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
    m_drive.setDefaultCommand(new RunCommand( ()-> m_drive.arcadeDrive(-1* m_driverController.getRawAxis(Constants.OperatorConstants.kRightX),
                                                                       1* m_driverController.getRawAxis(Constants.OperatorConstants.kLeftY)),
                                                                       m_drive));
  }

  private void configureBindings() {
    // birinci driver xbox 
    //new JoystickButton(m_driverController, OperatorConstants.kButtonA).whileTrue(new Intake_command(m_intake, 0.8));
    new JoystickButton(m_driverController, OperatorConstants.kButtonRB).whileTrue(new Shooter_command(m_shooter, 1));
    new JoystickButton(m_driverController, OperatorConstants.kButtonLB).whileTrue(new Intake_command(m_intake, 1));
    new JoystickButton(m_driverController, OperatorConstants.kButtonB).whileTrue(new Trigger_command(m_trigger, 1));
    //new JoystickButton(m_driverController, OperatorConstants.kButtonY).whileTrue(new Climb_command(m_climb, -1));
    //new JoystickButton(m_driverController, OperatorConstants.kButtonX).whileTrue(new Climb_command(m_climb, 1));
    new POVButton(m_driverController,0).whileTrue(new Climb_command(m_climb, -1));
    new POVButton(m_driverController,180).whileTrue(new Climb_command(m_climb, 1));
    //ikinci f310
        new JoystickButton(m_driver2, OperatorConstants_2.kButtonY).whileTrue(new Shooter_command(m_shooter, 1));
        new JoystickButton(m_driver2, OperatorConstants_2.kButtonB).whileTrue(new Shooter_command(m_shooter, -1));
        new JoystickButton(m_driver2, OperatorConstants_2.kButtonLB).whileTrue(new Trigger_command(m_trigger, 1));
        new JoystickButton(m_driver2, OperatorConstants_2.kButtonX).whileTrue(new Trigger_command(m_trigger, -1));
        new JoystickButton(m_driver2, OperatorConstants_2.kButtonA).whileTrue(new Intake_command(m_intake, -1));
        new POVButton(m_driver2, 180).whileTrue(new Kafa_command(m_kafa,0.7));
        new POVButton(m_driver2, 0).whileTrue(new Kafa_command(m_kafa, -0.5));

  }

  public Command getAutonomousCommand() {
    return new auto(m_drive,m_trigger,m_shooter,m_intake);
  }
}
