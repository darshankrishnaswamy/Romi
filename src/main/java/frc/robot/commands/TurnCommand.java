// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class TurnCommand extends CommandBase {
  DriveSubsystem drivetrainSubsystem;
  double inches;
  public TurnCommand(RobotContainer robotContainer, double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    drivetrainSubsystem = robotContainer.driveSubsystem;
    addRequirements(drivetrainSubsystem);
    double percent = angle / 360.0;
    double circumference = Math.PI * (Constants.DrivetrainConstants.TRACKWIDTH / 2.0);
    inches = percent * circumference;
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrainSubsystem.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrainSubsystem.drive(.5, -.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return drivetrainSubsystem.getLeftInches() >= inches;
  }
}
