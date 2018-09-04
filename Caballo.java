import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.util.LinkedList;


public class Caballo extends Piece{

	public Caballo(String id, int x, int y, boolean isWhite){
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
			img = img.getSubimage(320, 0, 106, 106);
		}
		else{
			img = img.getSubimage(320, 106, 106, 106);
		}
		g.drawImage(img, x, y, 58, 58, null);
	}

	public void mover(){
		try{
			CasillasDestino.add(Tablero.tablero[casillaActual.getX() + 2][casillaActual.getY() - 1]);
			verificar();
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			CasillasDestino.add(Tablero.tablero[casillaActual.getX() + 2][casillaActual.getY() + 1]);
			verificar();
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			CasillasDestino.add(Tablero.tablero[casillaActual.getX() - 2][casillaActual.getY() - 1]);
			verificar();
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			CasillasDestino.add(Tablero.tablero[casillaActual.getX() - 2][casillaActual.getY() + 1]);
			verificar();
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			CasillasDestino.add(Tablero.tablero[casillaActual.getX() + 1][casillaActual.getY() + 2]);
			verificar();
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			CasillasDestino.add(Tablero.tablero[casillaActual.getX() - 1][casillaActual.getY() + 2]);
			verificar();
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			CasillasDestino.add(Tablero.tablero[casillaActual.getX() + 1][casillaActual.getY() - 2]);
			verificar();
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			CasillasDestino.add(Tablero.tablero[casillaActual.getX() - 1][casillaActual.getY() - 2]);
			verificar();
		}catch(ArrayIndexOutOfBoundsException e){}

	}
		

}