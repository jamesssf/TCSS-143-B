/*
* James Stevens
* Rectangle.java
* TCSS 143 – Summer 2017
* Assignment 5
*/
/**
 * Rectangle extends AbstractShape
 *
 * @author James Stevens
 * @version jamesssf@uw.edu
 */

public class Rectangle extends AbstractShape
{
   private double myLength;
   private double myWidth;
   private static int myID = 0;
   
   public Rectangle()
   {
      this(1.0, 1.0);
   }
   
   public Rectangle(final double theLength, final double theWidth)
   {
      super("Rectangle", ++myID);
      
      if (theLength <= 0 || theWidth <= 0)
      {
         myID--;
         throw new IllegalArgumentException("Error! Negative or 0 value(s) " +
                                          "can't be applied to a rectangle."); 
      }
      
      myLength = theLength;
      myWidth = theWidth;
   }
   
   public void setLength(final double theLength)
   {
      myLength = theLength;
   }
   
   public void setWidth(final double theWidth)
   {
      myWidth = theWidth;
   }
   
   public double calculateArea()
   {
      return myLength * myWidth;
   }
   
   public final Shape copyShape()
   {
      Rectangle newR = new Rectangle();
      newR.myLength = myLength;
      newR.myWidth = myWidth;
      return newR;
   }
   
   public String toString()
   {     
      return String.format("Rectangle [Length: %.2f, Width: %.2f] Area: %.2f"
         , myLength, myWidth, calculateArea());
   }
   
}