package daniel.ui;

import javax.swing.JPanel;

import daniel.event.Mouse;
import daniel.piece.Bishop;
import daniel.piece.King;
import daniel.piece.Knight;
import daniel.piece.Pawn;
import daniel.piece.Queen;
import daniel.piece.Rook;
import daniel.piece.meta.Piece;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Panel extends JPanel implements Runnable {
    private static final int WIDTH = 1100;
    private static final int HEIGHT = 800;
    final int FPS = 60;
    Thread gameThread;
    Board board = new Board();
    Mouse mouse = new Mouse();

    public static ArrayList<Piece> pieces = new ArrayList<>();
    public static ArrayList<Piece> simPieces = new ArrayList<>();
    Piece activePiece;

    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColor = WHITE;

    boolean canMove;
    boolean validSquare;

    public Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        addMouseMotionListener(mouse);
        addMouseListener(mouse);

        setPieces();
        copyPiece(pieces, simPieces);
    }

    @Override
    public void run() {
        double drawnInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawnInterval;
            lastTime = currentTime;
            
            if (delta >= 1) {
                this.update();
                repaint();
                delta--;
            }
        }

    }

    private void update() {
        if (mouse.pressed) {
            if (activePiece == null) {
                for (Piece piece : simPieces) {
                    if (piece.color == currentColor && 
                        piece.col == mouse.x/Board.SQUARE_SIZE && 
                        piece.row == mouse.y/Board.SQUARE_SIZE) {
                        
                            activePiece = piece;
                    }
                }
            } else {
                simulate();
            }
        }

        if (mouse.pressed == false) {
            if (activePiece != null) {
                activePiece.updatePosition();
                activePiece = null;
            }
        }
    }

    private void simulate() {
        canMove = false;
        validSquare = false;
        activePiece.x = mouse.x - Board.HALF_SQUARE_SIZE;
        activePiece.y = mouse.y - Board.HALF_SQUARE_SIZE;
        activePiece.col = activePiece.getCol(activePiece.x);
        activePiece.row = activePiece.getRow(activePiece.y);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void setPieces() {
        for (int i = 0; i < 8; i++) { 
            pieces.add(new Pawn(WHITE, i, 6));
        }

        pieces.add(new Rook(WHITE, 0, 7));
        pieces.add(new Rook(WHITE, 7, 7));

        pieces.add(new Knight(WHITE, 1, 7));
        pieces.add(new Knight(WHITE, 6, 7));

        pieces.add(new Bishop(WHITE, 2, 7));
        pieces.add(new Bishop(WHITE, 5, 7));

        pieces.add(new Queen(WHITE, 3, 7));
        pieces.add(new King(WHITE, 4, 7));

        for (int i = 0; i < 8; i++) { 
            pieces.add(new Pawn(BLACK, i, 1));
        }

        pieces.add(new Rook(BLACK, 0, 0));
        pieces.add(new Rook(BLACK, 7, 0));

        pieces.add(new Knight(BLACK, 1, 0));
        pieces.add(new Knight(BLACK, 6, 0));

        pieces.add(new Bishop(BLACK, 2, 0));
        pieces.add(new Bishop(BLACK, 5, 0));

        pieces.add(new Queen(BLACK, 3, 0));
        pieces.add(new King(BLACK, 4, 0));
    }

    private void copyPiece(ArrayList<Piece> source, ArrayList<Piece> target) {
        target.clear();
        for (int i = 0; i < source.size(); i++) {
            target.add(source.get(i));
        }
    }

    public void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        Graphics2D graph2d = (Graphics2D) graph;

        board.drawn(graph2d);

        for (Piece piece : simPieces) {
            piece.drawn(graph2d);
        }

        if (activePiece !=  null) {
            graph2d.setColor(Color.white);
            graph2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .7f));
            graph2d.fillRect(activePiece.col * Board.SQUARE_SIZE, activePiece.row * Board.SQUARE_SIZE, 
                Board.SQUARE_SIZE, Board.SQUARE_SIZE);
            graph2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

            activePiece.drawn(graph2d);
        }
    }

}
