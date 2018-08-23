
import java.awt.Graphics;
import java.awt.Color;
import java.util.LinkedList;

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
					if(tablero[i][j].isMarked){
						g.setColor(new Color(179, 148, 186));
					}
				}

				else{
					g.setColor(Color.gray);
					if(tablero[i][j].isMarked){
						g.setColor(new Color(124, 96, 128));
					}
				}

				g.fillRect(i*75, j*75, 75, 75);
			}
		}
	}

	public static void movePiece(Piece piece){
		for(int i = 0; i<tablero.length; i++){
			for(int j = 0; j<tablero.length; j++){
				if((piece.getX() + 29) >= (i*75) && (piece.getX() + 29)  <= ((i+1)*75) && (piece.getY() + 29)  >= (j*75) && (piece.getY() + 29) <= ((j+1)*75)){
					desmarcarCasillas(piece);
					for(int k = 0; k<piece.CasillasDestino.size(); k++){
						if(Tablero.tablero[i][j] == piece.CasillasDestino.get(k)){
							piece.casillaActual = Tablero.tablero[i][j];
							piece.isMoved = true;
							piece.kill();
							if(!MouseInput.blackTurn){
								MouseInput.blackTurn = true;
								piece.centrarPieza();
								piece.CasillasDestino.clear();
								return;
							}
							else{
								MouseInput.blackTurn = false;
								piece.centrarPieza();
								piece.CasillasDestino.clear();
								return;
							}
						}
					}
					piece.centrarPieza();
					piece.CasillasDestino.clear();
				}
			}
		}
	}

	public static void marcarCasillas(Piece piece){
		for(int i = 0; i<piece.CasillasDestino.size(); i++){
			piece.CasillasDestino.get(i).isMarked = true;
		}
	}
	public static void desmarcarCasillas(Piece piece){
		for(int i = 0; i<piece.CasillasDestino.size(); i++){
			piece.CasillasDestino.get(i).isMarked = false;
		}
	}

}