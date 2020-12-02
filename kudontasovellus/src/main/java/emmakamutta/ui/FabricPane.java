
package emmakamutta.ui;

import emmakamutta.domain.Fabric;
import emmakamutta.domain.Loom;
import java.util.HashMap;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * 
 */
public class FabricPane extends GridPane{
    
    private int SQUARE_SIZE;
    private int length;
    
    private HashMap<String, Rectangle> rectangles;
    
    public FabricPane(Loom loom, int squareSize) {
        this.SQUARE_SIZE = squareSize;
        this.length = loom.fabricWidth;
        this.rectangles = new HashMap<>();
        
        for (int i = 0; i < loom.fabricWidth; i++) {
            for (int j = 0; j < loom.fabricWidth; j++) {
                Rectangle rec = new Rectangle(SQUARE_SIZE - 2, SQUARE_SIZE - 2);
                rec.setStroke(Color.LIGHTGRAY);
                rec.setFill(Color.WHITE);
                
                String key = Integer.toString(i) + Integer.toString(j);
                rectangles.put(key, rec);

                add(rec, i, j);
            }
        }
    }
    
    public void vizualiseWeave(Loom loom, int treadle) {
        
    }
    
    public void visualizeFabric(Fabric fabric) {
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (fabric.grid[i][j] == 1) {
                    changeRecColor(length-i,j, Color.BLACK);
                }
            }
        }
    }
    
    public void changeRecColor(int x, int y, Color color) {
        String key = "" + x + y;

        rectangles.get(key).setFill(color);

    }
    
}
