
package emmakamutta.ui;

import emmakamutta.domain.Loom;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * 
 */
public class FabricPane extends GridPane{
    
    private int SQUARE_SIZE;
    //private Loom loom;
    
    public FabricPane(Loom loom, int squareSize) {
        this.SQUARE_SIZE = squareSize;
        
        for (int i = 0; i < loom.fabricWidth; i++) {
            for (int j = 0; j < loom.fabricWidth; j++) {
                Rectangle rec = new Rectangle(SQUARE_SIZE - 2, SQUARE_SIZE - 2);
                rec.setStroke(Color.LIGHTGRAY);
                rec.setFill(Color.WHITE);

                add(rec, i, j);
            }
        }

    }
    
}
