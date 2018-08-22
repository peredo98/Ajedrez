import java.awt.Graphics;

public abstract class Piece{

<<<<<<< HEAD
=======
	protected Casilla casillaOrigen;
	protected Casilla casillaActual;
	protected Casilla casillaDestino;
	
>>>>>>> Cris
	public Piece(){

	}
	public abstract void tick();
	public abstract void render(Graphics g);
}