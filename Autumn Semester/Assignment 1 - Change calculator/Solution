import sheffield.*;

public class Change {
	
	public static void main (String [] args)  {
		final int TEN_IN_PENCE = 1000;
		final int FIVE_IN_PENCE = 500;
		final int TWO_IN_PENCE = 200;
		final int ONE_IN_PENCE = 100;
		final int FIFTY = 50;
		final int TWENTY = 20;
		final int TEN = 10;
		final int FIVE = 5;	
		final int TWO = 2;	
		
		//Read the information in
		EasyReader keyboard = new EasyReader();
		double price = keyboard.readDouble("How much is your shopping? ");
		double paid = keyboard.readDouble("How much cash did you offer? ");
		
		//Print out the change
		EasyWriter screen = new EasyWriter();
		double change = paid-price;
		screen.print("Your change should be ");
		screen.println(change,2);
		
		//And what it comprises
		int changeInPence = (int)Math.round(change*100);
		screen.println("Made up of");
		
		//In 10 pounds
		screen.println("10 pound notes: "+changeInPence/TEN_IN_PENCE);
		changeInPence = changeInPence % TEN_IN_PENCE;
		
		//In 5 pounds
		screen.println("5 pound notes:  "+changeInPence/FIVE_IN_PENCE);
		changeInPence = changeInPence % FIVE_IN_PENCE;
		
		//In 2 pounds
		screen.println("2 pound coins:  "+changeInPence/TWO_IN_PENCE);
		changeInPence = changeInPence % TWO_IN_PENCE;
		
		//In 1 pounds
		screen.println("1 pound coins:  "+changeInPence/ONE_IN_PENCE);
		changeInPence = changeInPence % ONE_IN_PENCE;
		
		//In 50 pence
		screen.println("50 pence coins: "+changeInPence/FIFTY);
		changeInPence = changeInPence % FIFTY;
		
		//In 20 pence
		screen.println("20 pence coins: "+changeInPence/TWENTY);
		changeInPence = changeInPence % TWENTY;
		
		//In 10 pence
		screen.println("10 pence coins: "+changeInPence/TEN);
		changeInPence = changeInPence % TEN;
		
		//In 5 pence
		screen.println("5 pence coins:  "+changeInPence/FIVE);
		changeInPence = changeInPence % FIVE;
		
		//In 2 pence
		screen.println("2 pence coins:  "+changeInPence/TWO);
		changeInPence = changeInPence % TWO;
		
		//In 1 pence
		screen.println("1 pence coins:  "+changeInPence);
		
		//Input from the file
		String fileName = keyboard.readString("What is the name of your file? ");
		EasyReader file = new EasyReader(fileName);
		
		//Header
		screen.println(" Price    Paid  Change");
		//Line one
		price = file.readDouble();
		screen.print(price, 2, 6);
		paid = file.readDouble();
		screen.print(paid, 2, 8);
		screen.println(paid-price, 2, 8);
		//Line two
		price = file.readDouble();
		screen.print(price, 2, 6);
		paid = file.readDouble();
		screen.print(paid, 2, 8);
		screen.println(paid-price, 2, 8);
		//Line three
		price = file.readDouble();
		screen.print(price, 2, 6);
		paid = file.readDouble();
		screen.print(paid, 2, 8);
		screen.println(paid-price, 2, 8);
	}
	
}
	
