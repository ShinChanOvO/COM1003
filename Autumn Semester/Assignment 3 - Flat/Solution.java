package flatshare;
import sheffield.*;
/**
* A class to represent a flat
* @author sdn
*/
public class Flat {
	
    final int MAX_TENANTS = 20;
	
    private Person [] tenants;
	
    /**
    * Constructor
    * creates a flat with tenants identified from the parameter
    * @param listOfNames A list of names separated by commas and possibly spaces as well
    */
    public Flat (String listOfNames) {
        String [] names = listOfNames.split(",");
        tenants = new Person[names.length];
        int count = 0;
        for (String name : names) {
            tenants[count] = new Person(name.trim());
            count++;
        }
    }
    
    /**
    * A method to save the list of tenants to a file one to a line using the
    * toString() method of Person to print them out
    * @param fileName the name of the file to store the tenants in
    */
    public void saveToFile(String fileName)  {
     	 EasyWriter file = new EasyWriter(fileName);
     	 for (Person p : tenants)
     	 	 file.println(p);
     	 file.println("*");
    }
   
    /**
    * Constructor
    * creates a flat with tenants identified from a file containing tenants details
    * one tenant to a line
    * @param file An EasyReader accessing the file
    */
    public Flat (EasyReader file) {
        Person[] maximum = new Person[MAX_TENANTS];
        int count=0;
        String line = file.readString().trim();
        while  (  count < MAX_TENANTS && line.charAt(0)!='*' )  {
            //If the tenant has a contribution the line may contain more than a name
            if  (  line.contains("(")  )  {
                int bracket = line.indexOf("(");
                double contribution = 
                        Double.valueOf(line.substring(bracket+1,line.length()-2));
                maximum[count] = 
                        new Person(line.substring(0,bracket).trim(), contribution);
            }
            else 
                maximum[count] = new Person(line);
            count++;
            line = file.readString().trim();
        }
        tenants = new Person[count];
        System.arraycopy(maximum, 0, tenants, 0, count);		
    }
    
    /**
    * Adds another tenant to the end of the existing list of tenants
    * @param newOne The name of the new tenant
    */
    public void addTenant(String newOne)  {
    	Person[] newVersion = new Person[tenants.length+1];
    	System.arraycopy(tenants, 0, newVersion, 0, tenants.length);
    	newVersion[tenants.length] = new Person (newOne);
    	tenants = newVersion;
    }
    
    /**
    * Removes a tenant from the list of tenants
    * The order of the remaining tenants stays the same
    * @param remove The name of the tenant to remove
    */
    public void removeTenant(String remove)  {
    	//Find their position in the array
    	int toGo=0;
    	while ( ! tenants[toGo].isCalled(remove)  )  toGo++;
    	
     	Person[] newVersion = new Person[tenants.length-1];
     	if  (  toGo > 0  )
     		System.arraycopy(tenants, 0, newVersion, 0, toGo);
     	if  (  toGo < tenants.length-1)
     		System.arraycopy(tenants, toGo+1, newVersion, toGo, tenants.length-toGo-1);
    	tenants = newVersion;
   }
   
   /**
   * Records the fact that someone has bought something useful for the flat
   * Everyone contributes the same amount to the purchase but the person
   * who did the shopping gets the money they paid as a credit unless
   * they don't actually live there
   * Something useful is something that appears in the Requirements
   * @param shopper the name of the person who did the shopping
   * @param item what was bought
   * @param price what was paid for it
   */
   public void purchase(String shopper, String item, double price) {
        if  (  Required.itemCalled(item) != null  )  {
            double share = price/tenants.length;
   	        for (Person p : tenants) 
                if  (  p.isCalled(shopper)  )  
                    p.hasPaid(price-share);
                else p.hasPaid(-share);
        }
   }
   	   
   /**
   * A standard toString method.  Lists the tenants in order using the toString
   * method of the Person class to print them out
   * @return A String listing the tenants
   */
   public String toString() {
   	   if  (  tenants == null  ) return "The flat is empty";
   	   String result = "The tenants are : ";
   	   for (Person t : tenants) result += ", "+t.toString();
   	   result = result.replace(": ,",":");
   	   return result;
   }
   
}
     	 	 
     	 
     	 
	
	
