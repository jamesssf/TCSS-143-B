/*
* James Stevens
* AbstractShape.java
* TCSS 143 – Summer 2017
* Assignment 5
*/
/**
 * AbstractShape implements Shape
 *
 * @author James Stevens
 * @version jamesssf@uw.edu
 */
 
public abstract class AbstractShape implements Shape
{  
   private String shapeName;
   
   public AbstractShape(String theName, int theID)
   {
      shapeName = theName + theID;
   }
   
   public abstract double calculateArea();
   
   public int compareTo(Shape theShape)
   {
      return (int)(theShape.calculateArea() - calculateArea());
   }
   
   public String getName()
   {
      return shapeName;
   }
}