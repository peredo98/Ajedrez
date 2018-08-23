import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.util.LinkedList;


public class Peon extends Piece{

	public Peon(int id, boolean isWhite){
		super(id, isWhite);
		if(isWhite){
		casillaActual = Tablero.tablero[id][6];
		}
		else{
		casillaActual = Tablero.tablero[id][1];
		}
		centrarPieza();
	}

	public void tick(){

	}

	public void render(Graphics g){
		try {
  			  img = ImageIO.read(new File("ChessSprite.png"));
		} 
		catch (IOException e) {
		}
		if(isWhite){
			img = img.getSubimage(533, 0, 106, 106);
		}
		else{
			img = img.getSubimage(533, 106, 106, 106);
		}
		g.drawImage(img, x, y, 58, 58, null);
	}

	public void mover(){
		try{
			if(isWhite){
				CasillasDestino.add(Tablero.tablero[casillaActual.getX()][casillaActual.getY() - 1]);
				if(!isMoved){
					CasillasDestino.add(Tablero.tablero[casillaActual.getX()][casillaActual.getY() - 2]);
				}
			}
			else{
				CasillasDestino.add(Tablero.tablero[casillaActual.getX()][casillaActual.getY() + 1]);
				if(!isMoved){
					CasillasDestino.add(Tablero.tablero[casillaActual.getX()][casillaActual.getY() + 2]);
				}
			}
			verificar();
			isEnemy();
		}
		catch(ArrayIndexOutOfBoundsException e){}

	}


	private void isEnemy(){
		for(int i = 0; i < PieceManager.pieces.size(); i++){
			if(this.isWhite != PieceManager.pieces.get(i).isWhite){
				if(isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX() + 1][casillaActual.getY() - 1]){
					CasillasDestino.add(Tablero.tablero[casillaActual.getX() + 1][casillaActual.getY() - 1]);
				}
				else if(isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX() - 1][casillaActual.getY() - 1]){
					CasillasDestino.add(Tablero.tablero[casillaActual.getX() - 1][casillaActual.getY() - 1]);
				}
				else if(!isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX() + 1][casillaActual.getY() + 1]){
					CasillasDestino.add(Tablero.tablero[casillaActual.getX() + 1][casillaActual.getY() + 1]);
				}
				else if(!isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX() - 1][casillaActual.getY() + 1]){
					CasillasDestino.add(Tablero.tablero[casillaActual.getX() - 1][casillaActual.getY() + 1]);
				}
				else if(isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX()][casillaActual.getY() - 1]){
					CasillasDestino.remove(Tablero.tablero[casillaActual.getX() ][casillaActual.getY() - 1]);
				}
				else if(!isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX()][casillaActual.getY() + 1]){
					CasillasDestino.remove(Tablero.tablero[casillaActual.getX() ][casillaActual.getY() + 1]);
				}

			}
		}
	}
}