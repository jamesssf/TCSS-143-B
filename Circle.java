/*
* James Stevens
* Circle.java
* TCSS 143 – Summer 2017
* Assignment 5
*/
import java.lang.Math;
/**
 * Circle extends AbstractShape
 *
 * @author James Stevens
 * @version jamesssf@uw.edu
 */
 
public class Circle extends AbstractShape
{
   private double myRadius;
   private static int myID = 0;
   
   public Circle()
   {
      this(1.0);
   }
   
   public Circle(final double theRadius)
   {
      super("Circle", ++myID);
      
      if(theRadius <= 0) 
      {
         myID--;
         throw new IllegalArgumentException("ERROR! Negative or 0 " +
                       "value can't be applied to a circle radius.");
      }
      
      myRadius = theRadius;
   }
   
   public void setRadius(final double theRadius)
   {
      myRadius = theRadius;
   }
   
   public double calculateArea()
   {
      return myRadius * myRadius * Math.PI;
   }
   
   public final Shape copyShape()
   {
      Circle newC = new Circle();
      newC.myRadius = myRadius;
      return newC;
   }
   
   public String toString()
   {    
      return String.format("Circle [Radius: %.2f] Area: %.2f"
         , myRadius, calculateArea());
   }
}