import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class MouseInput extends MouseInputAdapter{
	private Piece selectedPiece;

	public static boolean blackTurn;

	public MouseInput(){
	}

	public void mouseMoved(MouseEvent e){
		
	}
	public void mouseReleased(MouseEvent e){
		try{
			Tablero.movePiece(selectedPiece);
			selectedPiece = null;
		}catch(NullPointerException ex){}
	}

	public void mouseDragged(MouseEvent e){
		try{
			for(int i = 0; i < PieceManager.pieces.size(); i++){
				try{
					Piece tempPiece =  PieceManager.pieces.get(i);
					if(tempPiece.isWhite != blackTurn && selectedPiece == null && e.getX() >= tempPiece.getX() && e.getX() <= (tempPiece.getX() + 58) && e.getY() >= tempPiece.getY() && e.getY() <= (tempPiece.getY() + 58)){
						selectedPiece = tempPiece;			
					}
				}
				catch(NullPointerException ex){
				}
			}
			if(selectedPiece != null){
				selectedPiece.mover();
				Tablero.marcarCasillas(selectedPiece);
				selectedPiece.setX(e.getX()-29);
				selectedPiece.setY(e.getY()-29);

			}
		}catch(NullPointerException ex){}
	}
}