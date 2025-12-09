package daniel.piece;

import daniel.piece.meta.Piece;

public class Queen extends Piece {

    public Queen(int color, int col, int row) {
        super(color, col, row);
    }

    @Override
    protected String getPieceFileName() {
        return "queen";
    }
    
}
