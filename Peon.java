import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;

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
}