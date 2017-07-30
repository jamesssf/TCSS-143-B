/*
* James Stevens
* Assignment5.java
* TCSS 143 – Summer 2017
* Assignment 5
*/
import java.io.File;
import java.io.PrintStream;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
 * Assignment5 main driver
 *
 * @author James Stevens
 * @version jamesssf@uw.edu
 */
public class Assignment5
{
   public static void main(String[] theArgs)
   {
      Scanner in5 = null;
      PrintStream out5 = null;
      
      try
      {
         in5 = new Scanner(new File("in5.txt"));
         out5 = new PrintStream(new File("out5.txt"));
      }
      catch (Exception e)
      {
         System.out.println("Cannot open file. " + e);
      }
      
      List<Shape> myList = new LinkedList<Shape>();
      getShape(in5, myList);
      out5.println("Original List[unsorted]:");
      printShapes(myList, out5);
      
      List<Shape> newList = new ArrayList<Shape>();
      for (Shape element: myList)
      {
         Shape s = element.copyShape();
         newList.add(s);
      }
      Collections.sort(newList);
      out5.println("\nCopied List[sorted]:");
      printShapes(newList, out5);
      
      out5.println("\nOriginal List[unsorted]:");
      printShapes(myList, out5);
   }
   
   public static List<Shape> getShape(Scanner theInputFile, 
                                      List<Shape> theList)
   {
      double value1 = 0, value2 = 0, value3 = 0;
          
      while (theInputFile.hasNextLine())
      {
         String currentLine = theInputFile.nextLine();
         Scanner currentScan = new Scanner(currentLine);
         String[] tokens = currentLine.split(" ");
         int tokenCount = tokens.length;
         int counter = 0;
         
         while (currentScan.hasNextDouble() && counter < 4)
         {
            counter++;
            if (counter == 1)
            {
               value1 = currentScan.nextDouble();
            }
            else if (counter == 2)
            {
               value2 = currentScan.nextDouble();
            }
            else
            {
               value3 = currentScan.nextDouble();
            }
         }
         
         if (tokenCount == counter)
         {
            try 
            {
               if (tokenCount == 1)
               {
                  theList.add(new Circle(value1));
               }
               else if (tokenCount == 2)
               {
                  theList.add(new Rectangle(value1, value2));
               }
               else if (tokenCount == 3)
               {
                  theList.add(new Triangle(value1, value2, value3));
               }
            }
            catch (Exception e)
            {
               System.out.println(e);
            }
         }
      }
      return theList;
   }
   
   public static void printShapes(List<Shape> theList, 
                            PrintStream theOutputFile)
   {
      for (Shape s : theList)
      {
         theOutputFile.println(s);
      }
   }
   
}