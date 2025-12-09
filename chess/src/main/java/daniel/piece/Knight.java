package daniel.piece;

import daniel.piece.meta.Piece;

public class Knight extends Piece {

    public Knight(int color, int col, int row) {
        super(color, col, row);
    }

    @Override
    protected String getPieceFileName() {
        return "knight";
    }
    
}
