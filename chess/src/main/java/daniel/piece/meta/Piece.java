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

    public void drawn(Graphics2D graph2d) {
        graph2d.drawImage(img, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
    }
}
