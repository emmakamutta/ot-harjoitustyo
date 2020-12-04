package emmakamutta.ui;

import emmakamutta.domain.Loom;
import java.util.HashMap;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 *
 */
public class TreadOrderPane extends GridPane {

    private int squareSize;
    private int weaved;
    private HashMap<String, Rectangle> rectangles;
    private int length;

    public TreadOrderPane(Loom loom, int squareSize) {
        this.squareSize = squareSize;
        this.rectangles = new HashMap<>();
        this.weaved = 0;
        this.length = loom.fabricWidth;

        for (int i = 0; i < loom.treadleAmount; i++) {
            for (int j = 0; j < loom.fabricWidth; j++) {
                Rectangle rec = new Rectangle(this.squareSize - 2, this.squareSize - 2);
                rec.setStroke(Color.LIGHTGRAY);
                rec.setFill(Color.WHITE);

                String key = Integer.toString(i) + Integer.toString(j);
                rectangles.put(key, rec);
                add(rec, i, j);
            }
        }
    }

    public void visualize(int treadle) {
        if (weaved >= length) {
            return;
        }
        changeRecColor(treadle, length - weaved - 1, Color.BLACK);
        weaved++;
    }

    private void changeRecColor(int x, int y, Color color) {
        String key = "" + x + y;

        rectangles.get(key).setFill(color);

    }
}
