import java.awt.Graphics;

public abstract class Piece{

	public Piece(){

	}
	public abstract void tick();
	public abstract void render(Graphics g);
}