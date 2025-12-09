package daniel.piece;

import daniel.piece.meta.Piece;

public class Bishop extends Piece {

    public Bishop(int color, int col, int row) {
        super(color, col, row);
    }

    @Override
    protected String getPieceFileName() {
        return "bishop";
    }
    
}
