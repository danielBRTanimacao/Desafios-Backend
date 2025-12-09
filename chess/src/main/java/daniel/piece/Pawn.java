package daniel.piece;


import daniel.piece.meta.Piece;

public class Pawn extends Piece {
    
    @Override
    protected String getPieceFileName() {
        return "pawn";
    }

    public Pawn(int color, int col, int row) {
        super(color, col, row);
    }
}
