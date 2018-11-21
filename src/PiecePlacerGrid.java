import java.util.ArrayList;
import javafx.scene.image.ImageView;

public class PiecePlacerGrid {
	private ArrayList<ImageView> piecePlacerList;
	private final int PIECE_PLACER_LIST_SIZE = 7;
	
	public PiecePlacerGrid() {
		for(int i = 0 ; i < PIECE_PLACER_LIST_SIZE; i++) {
			piecePlacerList.add(null);
		}
	}
	
	public void setPiecePlace(int pieceColumnNumber, ImageView piece) {
		piecePlacerList.add(PIECE_PLACER_LIST_SIZE, piece);
	}
	
	public int getPieceLocation() {
		int index = 0;
		for(int i = 0; i < PIECE_PLACER_LIST_SIZE; i++) {
			if(piecePlacerList.get(i) != null) {
				index = i;
			}
		}
		return index;
	}
}
