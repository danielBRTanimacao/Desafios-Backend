package daniel.ui;

import java.awt.Color;
import java.awt.Graphics2D;

public class Board {
    final int MAX_COL = 8;
    final int MAX_ROW = 8;

    final Color DARK_BOARD = new Color(62, 137, 72);
    final Color LIGHT_BOARD = new Color(99, 199, 77);

    public static final int SQUARE_SIZE = 100;
    public static final int HALF_SQUARE_SIZE = SQUARE_SIZE / 2;

    public void drawn(Graphics2D graph2d) {
       int c = 0; 

        for (int row = 0; row < MAX_ROW; row++) {
            for (int col = 0; col < MAX_COL; col++) {
                if (c == 0) {
                    graph2d.setColor(LIGHT_BOARD);
                    c = 1;
                } else {
                    graph2d.setColor(DARK_BOARD);
                    c = 0;
                }
                graph2d.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }

            if (c == 0) {
                c = 1;
            } else {
                c = 0;
            }
        }

    }
}
