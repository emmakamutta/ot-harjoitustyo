package emmakamutta.ui;

import emmakamutta.domain.Fabric;
import emmakamutta.domain.Loom;
import java.util.HashMap;
import java.util.TreeMap;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 *
 */
public class FabricPane extends GridPane {

    private int squareSize;
    private int length;

    public HashMap<String, Rectangle> rectangles;

    public FabricPane(Loom loom, int squareSize) {
        this.squareSize = squareSize;
        this.length = loom.fabricWidth;
        this.rectangles = new HashMap<>();

        for (int i = 0; i < loom.fabricWidth; i++) {
            for (int j = 0; j < loom.fabricWidth; j++) {
                Rectangle rec = new Rectangle(this.squareSize - 2, this.squareSize - 2);
                rec.setStroke(Color.LIGHTGRAY);
                rec.setFill(Color.WHITE);

                String key = Integer.toString(i) + "," + Integer.toString(j);
                
                rectangles.put(key, rec);

                add(rec, i, j);
            }
        }
    }

    public void visualizeFabric(Fabric fabric) {

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (fabric.grid[i][j] == 1) {
                    changeRecColor(j, i, Color.BLACK);
                } else {
                    changeRecColor(j, i, Color.WHITE);
                }
            }
        }
    }

    public void changeRecColor(int x, int y, Color color) {
        String key = Integer.toString(x) + "," + Integer.toString(y);
        

        rectangles.get(key).setFill(color);

    }
    

}
