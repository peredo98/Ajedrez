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
		addPiece(new Peon("P1 blanco", 0, 6, true));
		addPiece(new Peon("P2 blanco", 1, 6, true));
		addPiece(new Peon("P3 blanco", 2, 6, true));
		addPiece(new Peon("P4 blanco", 3, 6, true));
		addPiece(new Peon("P5 blanco", 4, 6, true));
		addPiece(new Peon("P6 blanco", 5, 6, true));
		addPiece(new Peon("P7 blanco", 6, 6, true));
		addPiece(new Peon("P8 blanco", 7, 6, true));

		addPiece(new Torre("T1 balnco", 0, 7, true));
		addPiece(new Caballo("C1 balnco", 1, 7, true));
		addPiece(new Alfil("A1 balnco", 2, 7, true));
		addPiece(new Dama("D balnco", 3, 7, true));
		addPiece(new Rey("R balnco", 4, 7, true));
		addPiece(new Alfil("A2 balnco", 5, 7, true));
		addPiece(new Caballo("C2 balnco", 6, 7, true));
		addPiece(new Torre("T2 balnco", 7, 7, true));

		addPiece(new Peon("P1 negro", 0, 1, false));
		addPiece(new Peon("P2 negro", 1, 1, false));
		addPiece(new Peon("P3 negro", 2, 1, false));
		addPiece(new Peon("P4 negro", 3, 1, false));
		addPiece(new Peon("P5 negro", 4, 1, false));
		addPiece(new Peon("P6 negro", 5, 1, false));
		addPiece(new Peon("P7 negro", 6, 1, false));
		addPiece(new Peon("P8 negro", 7, 1, false));

		addPiece(new Torre("T1 negro", 0, 0, false));
		addPiece(new Caballo("C1 negro", 1, 0, false));
		addPiece(new Alfil("A1 negro", 2, 0, false));
		addPiece(new Dama("D negro", 3, 0, false));
		addPiece(new Rey("R negro", 4, 0, false));
		addPiece(new Alfil("A2 negro", 5, 0, false));
		addPiece(new Caballo("C2 negro", 6, 0, false));
		addPiece(new Torre("T2 negro", 7, 0, false));
		
		MouseInput.blackTurn = false;
		
	}

}