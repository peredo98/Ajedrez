import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.LinkedList;

public abstract class Piece{

	public Casilla casillaActual;
	protected int x, y, id;
	protected BufferedImage img = null;

	protected boolean isWhite;

	public LinkedList<Casilla> CasillasDestino = new LinkedList<Casilla>();
	
	public Piece(int id, boolean isWhite){
		this.id = id;
		this.isWhite = isWhite;
	}

	public int getID(){
		return id;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public void centrarPieza(){
		try{
		setX((casillaActual.getX() * 75) + 11);
		setY((casillaActual.getY() * 75) + 11);
		}
		catch(NullPointerException e){
		}
	}

	public void verificar(){
		for(int i = 0; i < PieceManager.pieces.size(); i++){
			if(this.isWhite == PieceManager.pieces.get(i).isWhite){
				CasillasDestino.remove(PieceManager.pieces.get(i).casillaActual);
			}
		}
	}

	public abstract void mover();
	public abstract void tick();
	public abstract void render(Graphics g);
}