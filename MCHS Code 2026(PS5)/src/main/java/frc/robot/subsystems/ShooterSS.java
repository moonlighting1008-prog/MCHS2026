/*
* This is the subsystem for the shooter.
* It contains methods to control the motors and commands for shooting.
*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Constants;
//import com.revrobotics.*;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;


public class ShooterSS extends SubsystemBase {
  private final SparkMax shooter = new SparkMax(6, MotorType.kBrushless);
  private double speed; 

  public void setShooterSpeed(double speed) {
    shooter.set(speed);
    this.speed = speed;
  }
  public Command shootNormal() {
    // Start shooter while held, stop when released
    return startEnd(() -> setShooterSpeed(1.0), () -> setShooterSpeed(0));
  }


public Command reverseShooter() {
  return startEnd(() -> setShooterSpeed(-0.5), () -> setShooterSpeed(0));
}

public Command addSpeed()
{
  if(speed + 0.1 > 1)
  {
    System.out.println("Out of bounds speed");
    return null;
  }
  else
  {
    return run(() -> setShooterSpeed(speed + 0.1));
  }
}

public Command subtractSpeed()
{
  if(speed - 0.1 < -1)
  {
    System.out.println("Out of bounds speed");
    return null;
  }
  else
  {
    return run(() -> setShooterSpeed(speed - 0.1));
  }
}

}