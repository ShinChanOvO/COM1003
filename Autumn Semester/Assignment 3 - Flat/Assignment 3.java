package flatshare;
import sheffield.*;
/**
* A class to represent a flat
* @author ZHAOWEI JI
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
		//**************Task 1 involves writing this************************
		//using split method to split the String and create an array to store.
		String [] tempTenants=listOfNames.split(",");
		//create an array of objects
		tenants=new Person[tempTenants.length];
		//for loop to store value into array of object using the Person(String n)
		for(int x=0;x<tempTenants.length;x++) {
		tenants[x]=new Person(tempTenants[x]);
		}
	}
    
    
    /**
    * A method to save the list of tenants to a file one to a line using the
    * toString() method of Person to print them out
    * @param fileName the name of the file to store the tenants in
    */
    public void saveToFile(String fileName)  {
 		//***************Task 2 involves writing this****************
    	EasyWriter writeToFlie = new EasyWriter(fileName);
    	//using for loop to write all the name to the file
    	for(int x=0;x<tenants.length;x++) {
    		writeToFlie.println(tenants[x].toString());
    		}
    	//print last line with a "*"
    	writeToFlie.println("*");
    }
    
	/**
	* Constructor
	* creates a flat with tenants identified from a file containing tenants details
	* one tenant to a line
	* @param file An EasyReader accessing the file
	*/
	public Flat (EasyReader file) {
 		//***************Task 2 involves writing this too********************
		//***************Task 6 involves improving this********************
		EasyReader readFile = file;
		//integer to count the length 
		int count=0;
		//creating an tempArray to store the reading from the backup file
		String []tempArray=new String[MAX_TENANTS];
		for(int x=0;x<MAX_TENANTS;x++) {
			tempArray[x]=readFile.readString();
			if(tempArray[x].equals("*")) {
				break;
			}
			count++;
		}
		//creating a new tenants object array and store the data
		tenants=new Person[count];
		for(int y=0;y<count;y++) {
			tenants[y]=new Person(tempArray[y]);
			}
		}
	
 		
		
    
    /**
    * Adds another tenant to the end of the existing list of tenants
    * @param newOne The name of the new tenant
    */
    public void addTenant(String newOne)  {
  		//*****************Task 3 involves writing this**********************
    	//creating a new array to store the new data
    	Person[]newTenants=new Person[tenants.length+1];
    	//assign the existing value in tenants array to new array
    	for(int x=0;x<tenants.length;x++) {
    		newTenants[x]=tenants[x];
    	}
    	//add new tenant to the new array 
    	newTenants[newTenants.length-1]=new Person(newOne);
    	//creating a new Person tenants array with new value
    	tenants=new Person[newTenants.length];
    	for(int x=0;x<newTenants.length;x++) {
    	tenants[x]=newTenants[x];
    	}
    }
    
    /**
    * Removes a tenant from the list of tenants
    * The order of the remaining tenants stays the same
    * @param remove The name of the tenant to remove
    */
  //Task 3 involves writing this too
    public void removeTenant(String remove)  {
    	//creating a new array with 1 length less than origin array
    	Person[]newTenants=new Person[tenants.length-1];
    	//integer to count 
    	int count=0;
    	//assign the value in tenants array to new array
    	for(int x=0;x<tenants.length;x++) {
    		//check if the value is been deleted
    		if(tenants[x].isCalled(remove)) {
    			continue;
    		}
    		else {
    		newTenants[count]=tenants[x];
    		count++;
    		}
    	}
    	//creating a new tenants array and assign the value to it
    	tenants=new Person[newTenants.length];
    	for(int x=0;x<newTenants.length;x++) {
        	tenants[x]=newTenants[x];
        	}
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
 		//Task 4 involves writing this and
	   //Task 5 involves changing it
	   //create an enum class object
	   Required bought =Required.itemCalled(item);
	   //declare the constant
	   double totalPaid=0;
	   //check if the bought is belong to the enum class
	   if ( bought != null ) {
		totalPaid+=price;
		//using for loop to apply data to everyone
	   for(int x=0;x<tenants.length;x++) {
	  if (tenants[x].isCalled(shopper)) {
		  double contribution=price-(totalPaid/(tenants.length));
		  tenants[x].hasPaid(contribution);}
	  else {
		  double contribution=-(totalPaid/(tenants.length));
		  tenants[x].hasPaid(contribution);
	  }
	}
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
     	 	 
     	 
     	 
	
	
