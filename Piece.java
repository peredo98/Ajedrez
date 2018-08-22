import java.awt.Graphics;

public abstract class Piece{

	protected Casilla casillaOrigen;
	protected Casilla casillaActual;
	protected Casilla casillaDestino;
	
	public Piece(){

	}
	public abstract void tick();
	public abstract void render(Graphics g);
}