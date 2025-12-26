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

    @Override
    public boolean canMove(int targetCol, int targetRow) {
        if (isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false) {
            if (targetCol == preCol || targetRow == preRow) {
                if (isValidSquare(targetCol, targetRow)) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
