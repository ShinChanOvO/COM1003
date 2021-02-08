package flatshare;
/**
* A class to represent a person living in a flat who is expected to contribute
* to expenses
* @author sdn
*/
public class Person {
	
	  //The instance variables
      private String name;
      private double contribution;
      
      //Instance methods    
      /**
      * Accessor method that returns the name of the person
      * @return their name
      */
      public String getName() {
         return name;
      }
      
      /**
      * Checks if the person's name matches the parameter
      * @param s The name to be tested
      * @return True if the name matches the parameter and false otherwise
      */
      public boolean isCalled(String s)  {
      	  return name.equals(s.trim());
      }
      
      /**
      * Accessor method for the person's current contribution
      * @return contribution
      */
      public double getContribution() {
      	  return contribution;
      }
      
      /**
      * A method to adjust the person's comtribution.  The parameter is treated
      * as a positive contribution
      * @param price the amount they have paid (which could be negative if someone
      *             else did the shopping)
      */         
      public void hasPaid(double price){
      	  contribution+=price;
      }
      
      //Constructors
      /**
      * Constructor 
      * Creates a person with the name provided and no initial contribution
      * @param n The new person's name
      */
      public Person (String n) { 
          name = n.trim();
          contribution = 0;
      }
      
      /**
      * Constructor where the person starts with a positive or negative contribution
      * @param n The name of the person
      * @param c Their initial contribution
      */
      public Person (String n, double c) { 
          name = n.trim();
          contribution = c;
      }
      
      //The toString method
      /**
      * A standard toString method
      * Prints out the person's details in the form of their name followed by
      * there current contribution in brackets
      * If their contribution is zero (or as near as a double gets to zero)
      * only their name will be printed out
      * @return The person's details
      */
      public String toString() {
      	  if  (  Math.abs(contribution) < 0.005  )
      	  	  return name;
      	  if  (  contribution < 0  )
      	  	  return name+" ("+Math.round(contribution*100)/100.0+")";
      	  else
      	  	  return name+" ("+Math.round(contribution*100)/100.0+")";
      }
      
}