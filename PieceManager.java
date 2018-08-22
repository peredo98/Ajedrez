import java.awt.Graphics;
import java.util.LinkedList;

public class PieceManager{

	LinkedList<Piece> pieces = new LinkedList<Piece>();

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

}