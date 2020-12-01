
package emmakamutta.ui;

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
public class HeddlesPane extends GridPane{
    
    private int SQUARE_SIZE;
    private boolean modifiable;
    HashMap<String, Rectangle> rectangles;
    
    public HeddlesPane(Loom loom, int squareSize) {
        this.SQUARE_SIZE = squareSize;
        this.modifiable = true;
        this.rectangles = new HashMap<>();
        
         for (int i = 0; i < loom.fabricWidth; i++) {
            for (int j = 0; j < loom.shafts; j++) {
                Rectangle rec = new Rectangle(SQUARE_SIZE - 2, SQUARE_SIZE - 2);
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
                
                String key =""+ i + j;
                rectangles.put(key, rec);
                
                add(rec, i, j);
            }
        }

    }

    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }
    
    public void changeRecColor(int x, int y) {
        String key = "" + x + y;
        
        rectangles.get(key).setFill(Color.BLANCHEDALMOND);
        
    }
    
}
