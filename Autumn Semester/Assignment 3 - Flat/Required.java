package flatshare;

/**
* An enum to indicate the sort of things that everyone will have to pay for
* @author sdn
*/
public enum Required {
   BIN_BAGS,
   FLOOR_CLEANER,
   SURFACE_CLEANER,
   TOILET_ROLL,
   WASHING_UP_LIQUID;
   
   /**
   * A static method takes a text string and returns the matching item as
   * an enum or null if the item is not in the list
   * @param name The name of the item.  Case is irrelevant and spaces are expected
   *              not underscore characters
   * @return The item matching the parameter or null if there isnt one
   */
   public static Required itemCalled(String name) {
   		switch (name.toUpperCase())  {
   			case "BIN BAGS" : return BIN_BAGS;
   			case "FLOOR CLEANER" : return FLOOR_CLEANER;
   			case "SURFACE CLEANER" : return SURFACE_CLEANER;
   			case "TOILET ROLL" : return TOILET_ROLL;
   			case "WASHING UP LIQUID" : return WASHING_UP_LIQUID;
   		}
   		return null;
   	}
   	
   	/**
   	* a standard toString() method
   	* @return the name of the item in lower case with spaces instead of underscore
   	*         characters
   	*/
   	public String toString() {
   		return  name().toLowerCase().replaceAll("_"," ");
   	}
   	
}
   
