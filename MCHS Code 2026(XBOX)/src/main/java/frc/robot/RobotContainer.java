/*
* This file contains the RobotContainer class
* It is where the bulk of the robot should be declared.
* The RobotContainer is used to define subsystems, commands, and button mappings.
*/

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Agitate;
import frc.robot.commands.Autos;
import frc.robot.commands.JoystickDriveC;
import frc.robot.subsystems.DriveTrainSS;
import frc.robot.subsystems.ShooterSS;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LoaderSS;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ServoSS;
// Import other subsystems and commands as needed




// line 19, test commit message


public class RobotContainer {
  private final DriveTrainSS driveTrainSS = new DriveTrainSS();
  private final ShooterSS shooterSS = new ShooterSS();
  private final LoaderSS loaderSS = new LoaderSS();
  // Instantiate subsystems

  public static CommandXboxController controller = new CommandXboxController(0);

  public static ServoSS servo = new ServoSS();

  public static Agitate agi = new Agitate(servo);

  // Instantiate the controller


  public RobotContainer() {
    configureBindings();




  }
  // Constructor to set up button bindings
  // PS5
  private void configureBindings() {
    
    driveTrainSS.setDefaultCommand(new JoystickDriveC(driveTrainSS));
    // Set default command for driving
    controller.leftBumper().whileTrue(driveTrainSS.fasterTurning());
    // Run the fasterTurning command only while Square is held
    controller.rightTrigger().whileTrue(shooterSS.shootNormal());
    // Run the shootNormal command only while R2 is held
    controller.leftTrigger().whileTrue(shooterSS.reverseShooter());
    controller.b().whileTrue(loaderSS.load());
    // Run the load command only while Circle is held
    controller.y().toggleOnTrue(loaderSS.unload());
    // Run the unload command when Triangle is pressed, stop when pressed again

    controller.rightBumper().toggleOnTrue(driveTrainSS.turn180());

    controller.x().toggleOnTrue(agi);
    controller.pov(90).whileTrue(driveTrainSS.addDriveSpeed());
    controller.pov(270).whileTrue(driveTrainSS.subtractDriveSpeed());
    controller.pov(0).whileTrue(shooterSS.addSpeed());
    controller.pov(180).whileTrue(shooterSS.subtractSpeed());

    //                                                  END OF PS5 BINDINGS
    // -----------------------------------------------------------------------------------------------------------------------




    

  
  
  
  
  
  
  
  
  
  }

   public Command getAutonomousCommand() {
    return Autos.simpleAuto1(driveTrainSS);
  }   // Returns the command to run in autonomous
  // I don't know how this part works yet
}
