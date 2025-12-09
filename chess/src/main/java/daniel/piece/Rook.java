package daniel.piece;

import daniel.piece.meta.Piece;

public class Rook extends Piece {

    public Rook(int color, int col, int row) {
        super(color, col, row);
    }

    @Override
    protected String getPieceFileName() {
        return "rook";
    }
    
}
