package daniel.piece.meta;

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
}
