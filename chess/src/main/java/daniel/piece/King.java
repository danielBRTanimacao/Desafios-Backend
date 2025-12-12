package daniel.piece;

import daniel.piece.meta.Piece;

public class King extends Piece{

    public King(int color, int col, int row) {
        super(color, col, row);
    }

    @Override
    protected String getPieceFileName() {
        return "king";
    }
    
}
