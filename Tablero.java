
import java.awt.Graphics;
import java.awt.Color;

public class Tablero{

	public Casilla tablero [][] = new Casilla [8][8];

	public Tablero(){

	}

	public void tRender(Graphics g){
		for(int i = 0; i<tablero.length; i++){
			for(int j = 0; j<tablero.length; j++){

				if(i%2 == 0 && j%2 == 0 || i%2 == 1 && j%2 == 1){
					g.setColor(Color.white);
				}

				else{
					g.setColor(Color.black);
				}

				g.fillRect(i*75, j*75, 75, 75);
			}
		}
	}

	public enum cellState{
		None(),
		Friendly(),
		Enemy(),
		Free(),
		OutOfBounds()
	}


}