

	import java.math.*;

	import sheffield.* ;

	public class Change {

		public static void main(String[] args) {
			//claim of all the temporary funcation and final integer
			double tempCostForShopping ;
			double tempCashOffered ;
			double change ;
			int changeInPence ;
			final int CHANGE_RATE_FOR_POUNDS_TO_PENCE =100 ;
			//call for 'sheffeld' class 
			EasyReader keyboard = new EasyReader() ;
			EasyWriter screen   = new EasyWriter() ;
			//ask for input of cost
			tempCostForShopping = keyboard.readDouble("How much is your shopping? ") ;
			//ask for input of cash offered
			tempCashOffered = keyboard.readDouble("How much cash did you offer? ") ;
			//use of BigDecimal method to eliminate accuracy errors
			BigDecimal costForShopping = new BigDecimal(Double.toString(tempCostForShopping)) ;
			BigDecimal cashOffered     = new BigDecimal(Double.toString(tempCashOffered)) ;
			//calculation for change(use the BigDecimal method)
			change = (cashOffered.subtract(costForShopping).doubleValue()) ; 
			//convert change in pounds to pence
			changeInPence = (int)(change*CHANGE_RATE_FOR_POUNDS_TO_PENCE) ;
			//printing process
			screen.println("Your change should be "+change) ;
			screen.println("Made up of") ;
			screen.print("10 pound notes:");
			screen.println((changeInPence/1000),4) ;
			screen.print("5 pound notes:");
			screen.println((changeInPence%1000/500),5) ;
			screen.print("2 pound notes:");
			screen.println((changeInPence%1000%500/200),5) ;
			screen.print("1 pound notes:");
			screen.println((changeInPence%1000%500%200/100),5) ;
			screen.print("50 pence coins:");
			screen.println((changeInPence%1000%500%200%100/50),4) ;
			screen.print("20 pence coins:");
			screen.println((changeInPence%1000%500%200%100%50/20),4) ;
			screen.print("10 pence coins:");
			screen.println((changeInPence%1000%500%200%100%50%20/10),4) ;
			screen.print("5 pence coins:");
			screen.println((changeInPence%1000%500%200%100%50%20%10/5),5) ;
			screen.print("2 pence coins:");
			screen.println((changeInPence%1000%500%200%100%50%20%10%5/2),5) ;
			screen.print("1 pence coins:");
			screen.println((changeInPence%1000%500%200%100%50%20%10%5%2/1),5) ;
			//ask for name of the file from the user
			String nameOfFile = keyboard.readString("What is the name of your file?") ;
			//call for 'sheffield' EasyReader for file
			EasyReader fileInput = new EasyReader(nameOfFile) ;
			//declare of the funcation to read from the file
			double tempCostForShopping1 = fileInput.readDouble();
			double tempCashOffered1 = fileInput.readDouble();
			double tempCostForShopping2 = fileInput.readDouble();
			double tempCashOffered2 = fileInput.readDouble();
		    double tempCostForShopping3 = fileInput.readDouble();
			double tempCashOffered3 = fileInput.readDouble();
			//use of BigDecimal method to eliminate accuracy errors
			BigDecimal costForShopping1 = new BigDecimal(Double.toString(tempCostForShopping1)) ;
			BigDecimal cashOffered1     = new BigDecimal(Double.toString(tempCashOffered1)) ;
			BigDecimal costForShopping2 = new BigDecimal(Double.toString(tempCostForShopping2)) ;
			BigDecimal cashOffered2     = new BigDecimal(Double.toString(tempCashOffered2)) ;
			BigDecimal costForShopping3 = new BigDecimal(Double.toString(tempCostForShopping3)) ;
			BigDecimal cashOffered3     = new BigDecimal(Double.toString(tempCashOffered3)) ;
			//printing process
			screen.println("Price    Paid    Change") ;
			screen.print(tempCostForShopping1,2,0) ;
			screen.print(tempCashOffered1,2,9) ;
			screen.println((cashOffered1.subtract(costForShopping1).doubleValue()),2,9);
			screen.print(tempCostForShopping2,2) ;
			screen.print(tempCashOffered2,2,9) ;
			screen.println(+(cashOffered2.subtract(costForShopping2).doubleValue()),2,9);
			screen.print(tempCostForShopping3,2) ;
			screen.print(tempCashOffered3,2,9) ;
			screen.println((cashOffered3.subtract(costForShopping3).doubleValue()),2,9);
			
	}

}

