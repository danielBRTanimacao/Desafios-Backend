package daniel.ui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Panel extends JPanel implements Runnable {
    private static final int WIDTH = 1100;
    private static final int HEIGHT = 800;
    final int FPS = 60;
    Thread gameThread;
    Board board = new Board();

    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColor = WHITE;

    public Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
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

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    private void update() {

    }

    public void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        Graphics2D graph2d = (Graphics2D) graph;

        board.drawn(graph2d);
    }

}
