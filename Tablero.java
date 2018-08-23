
import java.awt.Graphics;
import java.awt.Color;

public class Tablero{

	public static Casilla tablero [][] = new Casilla [8][8];

	public Tablero(){
		for(int i = 0; i<tablero.length; i++){
			for(int j = 0; j<tablero.length; j++){
				tablero[i][j] = new Casilla(i, j);
			}
		}
	}

	public void tRender(Graphics g){
		for(int i = 0; i<tablero.length; i++){
			for(int j = 0; j<tablero.length; j++){

				if(i%2 == 0 && j%2 == 0 || i%2 == 1 && j%2 == 1){
					g.setColor(Color.white);
				}

				else{
					g.setColor(Color.gray);
				}

				g.fillRect(i*75, j*75, 75, 75);
			}
		}
	}

	public static void movePiece(Piece piece){
		for(int i = 0; i<tablero.length; i++){
			for(int j = 0; j<tablero.length; j++){
				if((piece.getX() + 29) >= (i*75) && (piece.getX() + 29)  <= ((i+1)*75) && (piece.getY() + 29)  >= (j*75) && (piece.getY() + 29) <= ((j+1)*75)){
					piece.casillaActual = tablero[i][j];
					piece.centrarPieza();
				}
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