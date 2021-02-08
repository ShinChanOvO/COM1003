/**
* @author SDN
*/

import sheffield.*;

public class Dino{

	public static void main(String [] args)  {
		
		final int ROWS = 35;
		final int COLUMNS = 123;
		final int SCALE = 4;
		final int HORIZON = 5;
		final int SHIFT = 246;
		
		//read the dinosaur picture into an array 
		boolean [] [] isDino = new boolean [ROWS][COLUMNS];
		EasyReader dinoFile = new EasyReader("dino.txt");

		for (int r = ROWS-1; r>=0; r--)
			for (int c=0; c<COLUMNS; c++)
			   isDino[r][c] = ((int)dinoFile.readChar()) % 2 == 0;
		
		//Create window to display it
		EasyGraphics window = new EasyGraphics(COLUMNS*SCALE*2, ROWS*SCALE);
		
		//The ground
		window.setColor(255, 200, 0);
		window.fillRectangle(0,0,COLUMNS*SCALE*2,HORIZON*SCALE);
		
		//The the sky
		window.setColor(0, 0, 0);
		window.fillRectangle(0,HORIZON*SCALE,COLUMNS*SCALE*2,
			ROWS*SCALE-HORIZON*SCALE);
		
		//With 50 stars at random 
		window.setColor(255, 255, 255);
		for (int i=0; i<50; i++)
			window.plot(
				(int)(Math.random()*COLUMNS*SCALE*2), 
				HORIZON*SCALE+(int)(Math.random()*(ROWS*SCALE-HORIZON*SCALE)));
			
		//The Dinos
		window.setColor(150, 150, 150);
	 	for (int r = 0; r<ROWS; r++)
			for (int c=0; c<COLUMNS; c++)  
				if  (  isDino[r][c]  )  {
					//left most dino
					window.fillRectangle(c*SCALE, r*SCALE, SCALE, SCALE);	
					//middle dino
					window.fillRectangle(SHIFT+c*SCALE, r*SCALE, SCALE, SCALE);	
					//right dino
					window.fillRectangle(SHIFT*2+c*SCALE, r*SCALE, SCALE, SCALE);	
				} 
		
	}
}
