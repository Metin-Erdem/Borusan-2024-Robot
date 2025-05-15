// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    
    public static final int kLeftX=0, kLeftY=1, kRightX=4, kRightY=5, kLTrig=2, kRTrig=3; 
    public static final int kButtonA=1, kButtonB=2, kButtonX=3, kButtonY=4, kButtonLB=5, 
                                    kButtonRB=6, kButtonBack = 7,kButtonSt=8, kButtonRSB=10, kButtonLSB=9;
  }
  public static class OperatorConstants_2 {
    public static final int kDriverControllerPort = 1;
    
    public static final int kLeftX=0, kLeftY=1, kRightX=4, kRightY=5, kLTrig=2, kRTrig=3; 
    public static final int kButtonA=1, kButtonB=2, kButtonX=3, kButtonY=4, kButtonLB=5, 
                                    kButtonRB=6, kButtonBack = 7,kButtonSt=8, kButtonRSB=10, kButtonLSB=9;
  }

  public static class Intake_constants {
    public static final int Intake_neo = 1;
  }

  public static class Trigger_constants {
    public static final int trigger_alt_neo = 2;
    public static final int trigger_ust_neo = 10;
  }

  public static class Shooter_constants {
    public static final int shooter_neo_1 = 9;
    public static final int shooter_neo_2 = 11;
  }

  public static class Kafa_constants {
    public static final int pg_sag = 6;
    public static final int pg_sol = 7;
  }

  public static class Climb_constants { 
    public static final int climb_neo = 12;
  }

  public static class Drive_constants { 
    public static final int sag1 = 4;
    public static final int sag2 = 5;
    public static final int sol1 = 2;
    public static final int sol2 = 3;
  }
}
