// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;
import frc.robot.Constants.DrivetrainConstants;

public class DriveSubsystem extends SubsystemBase {
  private final Spark leftMotor, rightMotor;
  // private Spark leftMotor;
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    leftMotor = new Spark(DrivetrainConstants.LEFT_MOTOR_PORT);
    rightMotor = new Spark(DrivetrainConstants.RIGHT_MOTOR_PORT);
  }

  public void drive(double left, double right){
    leftMotor.set(left);
    rightMotor.set(right);
  }

  public void stop(){
    leftMotor.set(0);
    rightMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
