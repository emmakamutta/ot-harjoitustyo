package emmakamutta.ui;

import emmakamutta.domain.Heddles;
import emmakamutta.domain.Loom;
import java.util.HashMap;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 *
 */
public class HeddlesPane extends GridPane {

    private int squareSize;
    private int height;
    private int width;

    private boolean modifiable;
    private HashMap<String, Rectangle> rectangles;

    public HeddlesPane(Loom loom, int squareSize) {
        this.squareSize = squareSize;
        this.modifiable = true;
        this.rectangles = new HashMap<>();
        this.width = loom.fabricWidth;
        this.height = loom.shafts;

        for (int i = 0; i < loom.fabricWidth; i++) {
            for (int j = 0; j < loom.shafts; j++) {
                Rectangle rec = new Rectangle(this.squareSize - 2, this.squareSize - 2);
                rec.setStroke(Color.LIGHTGRAY);
                rec.setFill(Color.WHITE);

                String key = Integer.toString(i) + Integer.toString(j);
                rectangles.put(key, rec);
                
                int col = i;
                
                rec.setOnMouseClicked((event) -> {
                    if (modifiable) {
                        if (rec.getFill() == Color.BLACK) {
                            rec.setFill(Color.WHITE);
                        } else {
                            if (columnHasBlackSquare(col)) {
                                clearColumn(col);
                            }
                            rec.setFill(Color.BLACK);
                        }
                    }
                });

                add(rec, i, j);
            }
        }

    }

    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }

    public void changeRecColor(int x, int y, Color color) {
        String key = "" + x + y;

        rectangles.get(key).setFill(color);

    }

    public Heddles convertToHeddles() {
        int[][] grid = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String s = Integer.toString(j) + Integer.toString(i);
                if (rectangles.get(s).getFill() == Color.BLACK) {
                    grid[i][j] = 1;
                }

            }
        }

        Heddles hed = new Heddles(grid);

        return hed;
    }
    
    public void clearColumn(int column) {
        for (int i = 0; i < height; i++) {
            String key = Integer.toString(column) + Integer.toString(i);
            rectangles.get(key).setFill(Color.WHITE);
        }
    }

    public Boolean columnHasBlackSquare(int column) {
        Boolean hasBlack = false;
        
        for (int i = 0; i < height; i++) {
            String key = Integer.toString(column) + Integer.toString(i);
            if (rectangles.get(key).getFill() == Color.BLACK) {
                hasBlack = true;
            }
        }
        
        return hasBlack;
    }
    
    public void setLockedColors() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String s = Integer.toString(j) + Integer.toString(i);
                if (rectangles.get(s).getFill() == Color.BLACK) {
                    rectangles.get(s).setFill(Color.DARKGRAY);
                }

            }
        }
    }
}
