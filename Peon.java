import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.util.LinkedList;


public class Peon extends Piece{

	public Peon(String id, int x, int y, boolean isWhite){
		super(id, x, y, isWhite);
	}

	public void tick(){
		coronarse();
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
			verificar();
			isEnemy();
			}
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(!isWhite){
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

	private void coronarse(){
		if((casillaActual.getY() == 7 || casillaActual.getY() == 0) && isMoved){
			Dama coronacion = new Dama(id, casillaActual.getX(), casillaActual.getY(), isWhite);
			centrarPieza();
			PieceManager.addPiece(coronacion);
			PieceManager.removePiece(this);
		}
	}


	private void isEnemy(){
		try{
		for(int i = 0; i < PieceManager.pieces.size(); i++){
			if(this.isWhite != PieceManager.pieces.get(i).isWhite){
				if(isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX() + 1][casillaActual.getY() - 1]){
					CasillasDestino.add(Tablero.tablero[casillaActual.getX() + 1][casillaActual.getY() - 1]);
					break;
				}
			}
		}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
		for(int i = 0; i < PieceManager.pieces.size(); i++){
			if(this.isWhite != PieceManager.pieces.get(i).isWhite){		
				if(isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX() - 1][casillaActual.getY() - 1]){
					CasillasDestino.add(Tablero.tablero[casillaActual.getX() - 1][casillaActual.getY() - 1]);
					break;
				}
			}
		}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
		for(int i = 0; i < PieceManager.pieces.size(); i++){
			if(this.isWhite != PieceManager.pieces.get(i).isWhite){	
				if(!isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX() + 1][casillaActual.getY() + 1]){
					CasillasDestino.add(Tablero.tablero[casillaActual.getX() + 1][casillaActual.getY() + 1]);
					break;
				}
			}
		}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
		for(int i = 0; i < PieceManager.pieces.size(); i++){
			if(this.isWhite != PieceManager.pieces.get(i).isWhite){	
				if(!isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX() - 1][casillaActual.getY() + 1]){
					CasillasDestino.add(Tablero.tablero[casillaActual.getX() - 1][casillaActual.getY() + 1]);
					break;
				}
			}
		}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
		for(int i = 0; i < PieceManager.pieces.size(); i++){
			if(this.isWhite != PieceManager.pieces.get(i).isWhite){	
				if(isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX()][casillaActual.getY() - 1]){
					CasillasDestino.remove(Tablero.tablero[casillaActual.getX() ][casillaActual.getY() - 1]);
					break;
				}
			}
		}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
		for(int i = 0; i < PieceManager.pieces.size(); i++){
			if(this.isWhite != PieceManager.pieces.get(i).isWhite){	
				if(!isWhite && PieceManager.pieces.get(i).casillaActual == Tablero.tablero[casillaActual.getX()][casillaActual.getY() + 1]){
					CasillasDestino.remove(Tablero.tablero[casillaActual.getX() ][casillaActual.getY() + 1]);
					break;
				}
			}
		}
		}catch(ArrayIndexOutOfBoundsException e){}
	}
}