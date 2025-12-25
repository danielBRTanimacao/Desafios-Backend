package daniel.piece.meta;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import daniel.ui.Board;
import daniel.ui.Panel;

public abstract class Piece {
    public BufferedImage img;
    public int x, y;
    public int col, row, preCol, preRow;
    public int color;
    public Piece hitting;

    protected abstract String getPieceFileName();

    public Piece(int color, int col, int row) {
        this.color = color;
        this.col = col;
        this.row = row;
        this.x = getX(col);
        this.y = getY(row);
        this.preCol = col;
        this.preRow = row;

        this.img = loadPieceImage();
    }

    private BufferedImage loadPieceImage() {
        String pieceName = getPieceFileName();

        String colorFolder = (this.color == Panel.WHITE) ? "white" : "black";
        String imgPath = "/sprites/pieces/" + colorFolder + "/" + pieceName;

        return getImage(imgPath);
    }

    public BufferedImage getImage(String imgPath) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(getClass().getResourceAsStream(imgPath + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public int getX(int col) {
        return col * Board.SQUARE_SIZE;
    }

    public int getY(int row) {
        return row * Board.SQUARE_SIZE;
    }

    public int getCol(int x) {
        return (x + Board.HALF_SQUARE_SIZE) / Board.SQUARE_SIZE;
    }

    public int getRow(int y) {
        return (y + Board.HALF_SQUARE_SIZE) / Board.SQUARE_SIZE;
    }

    public int getIndex() {
        for (int i = 0; i < Panel.simPieces.size(); i++) {
            if (Panel.simPieces.get(i) == this) {
                return i;
            }
        }
        return 0;
    }
    
    public void resetPosition() {
        col = preCol;
        row = preRow;
        x = getX(col);
        y = getY(row);
    }

    public void updatePosition() {
        x = getX(col);
        y = getY(row);
        preCol = getCol(x);
        preRow = getRow(y);
    }

    public boolean canMove(int targetCol, int targetRow) {
        return false;
    }

    public boolean isWithinBoard(int targetCol, int targetRow) {
        if (targetCol >= 0 && targetCol <= 7 && targetRow >= 0 && targetRow <= 7) {
            return true;
        }
        return false;
    }

    public Piece getHitting(int targetCol, int targetRow) {
        for (Piece piece : Panel.simPieces) {
            if (piece.col == targetCol && piece.row == targetRow && piece != null) {
                return piece;
            }
        }
        return null;
    }

    public boolean isValidSquare(int targetCol, int targetRow)  {
        hitting = getHitting(targetCol, targetRow);

        if (hitting == null) {
            return true;
        } else {
            if (hitting.color != this.color) {
                return true;
            } else {
                hitting = null;
            }
        }
        return false;
    }

    public void drawn(Graphics2D graph2d) {
        graph2d.drawImage(img, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
    }
}
