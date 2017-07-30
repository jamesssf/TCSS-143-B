/*
* James Stevens
* Triangle.java
* TCSS 143 – Summer 2017
* Assignment 5
*/
import java.lang.Math;
/**
 * Triangle extends AbstractShape
 *
 * @author James Stevens
 * @version jamesssf@uw.edu
 */

public class Triangle extends AbstractShape
{
   private double mySideA;
   private double mySideB;
   private double mySideC;
   private static int myID = 0;
   
   public Triangle()
   {
      this(1.0, 1.0, 1.0);
   }
   
   public Triangle(final double theSideA, final double theSideB, 
                                          final double theSideC)
   {
      super("Triangle", ++myID);
      
      if(((theSideA + theSideB) < theSideC) || 
            ((theSideA + theSideC) < theSideB) ||
               ((theSideB + theSideC) < theSideA)) 
      {
         myID--;
         throw new IllegalArgumentException("ERROR! Not a Triangle. " +
                                            "Longest side too long");
      }
      
      mySideA = theSideA;
      mySideB = theSideB;
      mySideC = theSideC;
   }
   
   public void setSideA(final double theSideA)
   {
      mySideA = theSideA;
   }
   
   public void setSideB(final double theSideB)
   {
      mySideB = theSideB;
   }
   
   public void setSideC(final double theSideC)
   {
      mySideC = theSideC;
   }      
   
   public double calculateArea()
   {
      double s = .5 * (mySideA + mySideB + mySideC);
      double num = s * ((s - mySideA) * (s - mySideB) * (s - mySideC));
      return Math.sqrt(num);
   }
   
   public final Shape copyShape()
   {
      Triangle newT = new Triangle();
      newT.mySideA = mySideA;
      newT.mySideB = mySideB;
      newT.mySideC = mySideC;
      return newT;
   }
   
   public String toString()
   {     
      return String.format("Triangle[SideA: %.2f, SideB: %.2f, SideC: %.2f] Area: %.2f"
         , mySideA, mySideB, mySideC, calculateArea());
   }   
}