import java.awt.Graphics;
import java.util.LinkedList;

public class PieceManager{

	public static LinkedList<Piece> pieces = new LinkedList<Piece>();

	public void tick(){
		for(int i = 0; i < pieces.size(); i++){
			Piece tempPiece = pieces.get(i);
			tempPiece.tick();
		}
	}

	public void render(Graphics g){
		for(int i = 0; i < pieces.size(); i++){
			Piece tempPiece = pieces.get(i);
			tempPiece.render(g);
		}
	}

	public static void addPiece(Piece piece){
		pieces.add(piece);
	}

	public static void removePiece(Piece piece){
		pieces.remove(piece);
	}

	public void setBoard(){
		addPiece(new Peon(0, true));
		addPiece(new Peon(1, true));
		addPiece(new Peon(2, true));
		addPiece(new Peon(3, true));
		addPiece(new Peon(4, true));
		addPiece(new Peon(5, true));
		addPiece(new Peon(6, true));
		addPiece(new Peon(7, true));
		addPiece(new Peon(0, false));
		addPiece(new Peon(1, false));
		addPiece(new Peon(2, false));
		addPiece(new Peon(3, false));
		addPiece(new Peon(4, false));
		addPiece(new Peon(5, false));
		addPiece(new Peon(6, false));
		addPiece(new Peon(7, false));
		addPiece(new Dama(0, true));
		addPiece(new Dama(0, false));
		addPiece(new Torre(0, true));
		addPiece(new Torre(1, true));
		addPiece(new Torre(0, false));
		addPiece(new Torre(1, false));
		addPiece(new Alfil(0, true));
		addPiece(new Alfil(1, true));
		addPiece(new Alfil(0, false));
		addPiece(new Alfil(1, false));
		addPiece(new Caballo(0, true));
		addPiece(new Caballo(1, true));
		addPiece(new Caballo(0, false));
		addPiece(new Caballo(1, false));
		MouseInput.blackTurn = false;
		
	}

}