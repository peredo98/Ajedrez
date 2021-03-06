import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.util.LinkedList;


public class Dama extends Piece{

	public Dama(String id, int x, int y, boolean isWhite){
		super(id, x, y, isWhite);
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
			img = img.getSubimage(106, 0, 106, 106);
		}
		else{
			img = img.getSubimage(106, 106, 106, 106);
		}
		g.drawImage(img, x, y, 58, 58, null);
	}

	public void mover(){
		try{				
			for(int j = 1; j<8; j++){
				for(int i = 0; i<PieceManager.pieces.size(); i++){
					if(Tablero.tablero[casillaActual.getX()][casillaActual.getY() + j] == PieceManager.pieces.get(i).casillaActual){
						if(isWhite != PieceManager.pieces.get(i).isWhite){
							CasillasDestino.add(Tablero.tablero[casillaActual.getX()][casillaActual.getY() + j]);
						}
						j = 9;
						break;
					}				
				}
				CasillasDestino.add(Tablero.tablero[casillaActual.getX()][casillaActual.getY() + j]);
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			for(int j = 1; j<8; j++){
				for(int i = 0; i<PieceManager.pieces.size(); i++){
					if(Tablero.tablero[casillaActual.getX()][casillaActual.getY() - j] == PieceManager.pieces.get(i).casillaActual){
						if(isWhite != PieceManager.pieces.get(i).isWhite){
							CasillasDestino.add(Tablero.tablero[casillaActual.getX()][casillaActual.getY() - j]);
						}
						j = 9;
						break;
					}
						
				}
				CasillasDestino.add(Tablero.tablero[casillaActual.getX()][casillaActual.getY() - j]);
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{				
			for(int j = 1; j<8; j++){
				for(int i = 0; i<PieceManager.pieces.size(); i++){		
					if(Tablero.tablero[casillaActual.getX() + j][casillaActual.getY()] == PieceManager.pieces.get(i).casillaActual){
						if(isWhite != PieceManager.pieces.get(i).isWhite){
							CasillasDestino.add(Tablero.tablero[casillaActual.getX() + j][casillaActual.getY()]);
						}
						j = 9;
						break;
					}
				}
				CasillasDestino.add(Tablero.tablero[casillaActual.getX() + j][casillaActual.getY()]);
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{				
			for(int j = 1; j<8; j++){
				for(int i = 0; i<PieceManager.pieces.size(); i++){		
					if(Tablero.tablero[casillaActual.getX() - j][casillaActual.getY()] == PieceManager.pieces.get(i).casillaActual){
						if(isWhite != PieceManager.pieces.get(i).isWhite){
							CasillasDestino.add(Tablero.tablero[casillaActual.getX() - j][casillaActual.getY()]);
						}
						j = 9;
						break;
					}
				}
				CasillasDestino.add(Tablero.tablero[casillaActual.getX() - j][casillaActual.getY()]);
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		//Diagonales
		try{				
			for(int j = 1; j<8; j++){
				for(int i = 0; i<PieceManager.pieces.size(); i++){		
					if(Tablero.tablero[casillaActual.getX() - j][casillaActual.getY() - j] == PieceManager.pieces.get(i).casillaActual){
						if(isWhite != PieceManager.pieces.get(i).isWhite){
							CasillasDestino.add(Tablero.tablero[casillaActual.getX() - j][casillaActual.getY() - j]);
						}
						j = 9;
						break;
					}
				}
				CasillasDestino.add(Tablero.tablero[casillaActual.getX() - j][casillaActual.getY() - j]);
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{				
			for(int j = 1; j<8; j++){
				for(int i = 0; i<PieceManager.pieces.size(); i++){		
					if(Tablero.tablero[casillaActual.getX() - j][casillaActual.getY() + j] == PieceManager.pieces.get(i).casillaActual){
						if(isWhite != PieceManager.pieces.get(i).isWhite){
							CasillasDestino.add(Tablero.tablero[casillaActual.getX() - j][casillaActual.getY() + j]);
						}
						j = 9;
						break;
					}
				}
				CasillasDestino.add(Tablero.tablero[casillaActual.getX() - j][casillaActual.getY() + j]);
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{				
			for(int j = 1; j<8; j++){
				for(int i = 0; i<PieceManager.pieces.size(); i++){		
					if(Tablero.tablero[casillaActual.getX() + j][casillaActual.getY() - j] == PieceManager.pieces.get(i).casillaActual){
						if(isWhite != PieceManager.pieces.get(i).isWhite){
							CasillasDestino.add(Tablero.tablero[casillaActual.getX() + j][casillaActual.getY() - j]);
						}
						j = 9;
						break;
					}
				}
				CasillasDestino.add(Tablero.tablero[casillaActual.getX() + j][casillaActual.getY() - j]);
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{				
			for(int j = 1; j<8; j++){
				for(int i = 0; i<PieceManager.pieces.size(); i++){		
					if(Tablero.tablero[casillaActual.getX() + j][casillaActual.getY() + j] == PieceManager.pieces.get(i).casillaActual){
						if(isWhite != PieceManager.pieces.get(i).isWhite){
							CasillasDestino.add(Tablero.tablero[casillaActual.getX() + j][casillaActual.getY() + j]);
						}
						j = 9;
						break;
					}
				}
				CasillasDestino.add(Tablero.tablero[casillaActual.getX() + j][casillaActual.getY() + j]);
			}
		}catch(ArrayIndexOutOfBoundsException e){}
	}


}