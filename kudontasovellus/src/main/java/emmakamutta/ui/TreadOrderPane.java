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
    private int width;

    public TreadOrderPane(Loom loom, int squareSize) {
        this.squareSize = squareSize;
        this.rectangles = new HashMap<>();
        this.weaved = 0;
        this.length = loom.fabricWidth;
        this.width = loom.treadleAmount;

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
        String key = Integer.toString(x) + Integer.toString(y);
        if (rectangles.containsKey(key)) {
            rectangles.get(key).setFill(color);
        }

    }

    public void clearLatestRow() {
        if (weaved > 0) {

            for (int i = 0; i < width; i++) {
                String key = Integer.toString(i) + Integer.toString(length - weaved);
                rectangles.get(key).setFill(Color.WHITE);
            }
            weaved--;
        }
    }

    public void clear() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.length; j++) {
                String key = Integer.toString(i) + Integer.toString(j);
                rectangles.get(key).setFill(Color.WHITE);
            }
        }
        this.weaved = 0;
    }
}
