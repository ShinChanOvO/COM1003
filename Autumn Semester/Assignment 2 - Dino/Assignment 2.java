import sheffield.*;

public class Dino {

public static void main(String[] args) {
	//decalre of constant
	final int X_SIZE_OF_IMAGE=123*4*2;
	final int Y_SIZE_OF_IMAGE=35*4;
	final int ROW=35;
	final int COLUMN=123;
	final int HEIGHT_OF_THE_LAND=8;
	final int SCALE_FACTOR=4;
	//declare of sheffield package 
	EasyReader fileInput = new EasyReader("dino.txt");
	EasyGraphics g =new EasyGraphics(X_SIZE_OF_IMAGE,Y_SIZE_OF_IMAGE);
	//declare of the array of char
	char [][]charArray = new char[ROW][COLUMN];
	//reading the file and store the data to an array
	for(int y=ROW-1;y>0;y--) {
		for(int x=0;x<COLUMN;x++) {
			charArray[y][x]=fileInput.readChar();
		}
	}
	//drawing the background
	g.setColor(0, 0, 0);
	g.fillRectangle(0, 0, X_SIZE_OF_IMAGE,Y_SIZE_OF_IMAGE);
	//drawing the horizon
	g.setColor(255,218,185);
	for(int y=34;y>0;y--) {
		for(int x=0;x<123;x++) {
			if(y<HEIGHT_OF_THE_LAND) {
				for(int i=0;i<SCALE_FACTOR;i++) {
					for (int u=0;u<SCALE_FACTOR;u++) {
						g.plot(x*SCALE_FACTOR+i,y*SCALE_FACTOR-u);
						g.plot(123*SCALE_FACTOR+x*SCALE_FACTOR+u,y*SCALE_FACTOR-i);}
				}	
			}
		}
	}
	//drawing the stars
		//set color to white
	g.setColor(255, 255, 255);
	for(int z=0;z<50;z++) {
		//get two random number
		int xPosition =(int)(Math.random()*X_SIZE_OF_IMAGE);
		int yPosition =(int)(Math.random()*Y_SIZE_OF_IMAGE+HEIGHT_OF_THE_LAND*SCALE_FACTOR);
		g.setColor(255,255,255);
		g.plot(xPosition,yPosition);
	}
	//drawing the first dino
		//convert char into unicode
	for(int y=34;y>0;y--) {
		for(int x=0;x<123;x++) {
			int unicode_data = (int)(charArray[y][x]);
			//check if the unicode is even or odd
			if (unicode_data%2==0) {
				g.setColor(176,224,230);
				//drawing the first dino
				for(int i=0;i<SCALE_FACTOR;i++) {
					for (int u=0;u<SCALE_FACTOR;u++) {
						g.plot(x*SCALE_FACTOR+i,y*SCALE_FACTOR+SCALE_FACTOR-u);}
				}
			}
		}
	}
	//drawing the right dino 
		//convert char into unicode
	for(int y=34;y>0;y--) {
		for(int x=0;x<123;x++) {
			int unicode_data = (int)(charArray[y][x]);

		//check if the unicode is even or odd
		if (unicode_data%2==0) {
			g.setColor(176,224,230);
			for(int i=0;i<SCALE_FACTOR;i++) {
				for (int u=0;u<SCALE_FACTOR;u++) {
					g.plot(123*SCALE_FACTOR+x*SCALE_FACTOR+i,y*SCALE_FACTOR+SCALE_FACTOR-u);}
					}
				}	
			}
		}
	//drawing the middle dino 
		//convert char into unicode
	for(int y=34;y>0;y--) {
		for(int x=0;x<123;x++) {
			int unicode_data = (int)(charArray[y][x]);
			//check if it is odd or even
			if (unicode_data%2==0) {
				g.setColor(176,224,230);
				//drawing the middle dino
				for(int i=0;i<SCALE_FACTOR;i++) {
					for (int u=0;u<SCALE_FACTOR;u++) {
						g.plot(123*SCALE_FACTOR/2+x*SCALE_FACTOR+i,y*SCALE_FACTOR+SCALE_FACTOR-u);}
					}
				}
			}
		}
	}
}
		
	

	

