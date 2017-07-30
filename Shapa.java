/*
* James Stevens
* Shape.java
* TCSS 143 – Summer 2017
* Assignment 5
*/
/**
 * Shape extends Comparable<Shape>
 *
 * @author James Stevens
 * @version jamesssf@uw.edu
 */

public interface Shape extends Comparable<Shape>
{
   public double calculateArea();
   
   public Shape copyShape();
   
   public String getName();
}
