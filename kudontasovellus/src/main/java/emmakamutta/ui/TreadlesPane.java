package emmakamutta.ui;

import emmakamutta.domain.Grid;
import emmakamutta.domain.Loom;
import emmakamutta.domain.UniversalGrid;
import java.util.HashMap;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 *
 */
public class TreadlesPane extends GridPane {

    private int squareSize;
    private boolean modifiable;
    private HashMap<String, Rectangle> rectangles;
    private int height;
    private int width;

    public TreadlesPane(Loom loom, int squareSize) {
        this.squareSize = squareSize;
        this.modifiable = true;
        this.rectangles = new HashMap<>();
        this.width = loom.treadleAmount;
        this.height = loom.shafts;

        for (int i = 0; i < loom.shafts; i++) {
            for (int j = 0; j < loom.treadleAmount; j++) {
                Rectangle rec = new Rectangle(this.squareSize - 2, this.squareSize - 2);
                rec.setStroke(Color.LIGHTGRAY);
                rec.setFill(Color.WHITE);

                rec.setOnMouseClicked((event) -> {
                    if (modifiable) {

                        if (rec.getFill() == Color.BLACK) {
                            rec.setFill(Color.WHITE);
                        } else {
                            rec.setFill(Color.BLACK);
                        }
                    }

                });

                String key = Integer.toString(i) + Integer.toString(j);
                rectangles.put(key, rec);

                add(rec, i, j);
            }
        }
    }

    public Grid convertToTreadles() {
        int[][] grid = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String s = Integer.toString(j) + Integer.toString(i);
                if (rectangles.get(s).getFill() == Color.BLACK) {
                    grid[i][j] = 1;
                }

            }
        }

        UniversalGrid tre = new UniversalGrid(grid);

        return tre;
    }

    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }

}
