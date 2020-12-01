
package emmakamutta.ui;

import emmakamutta.domain.Loom;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * 
 */
public class TreadlesPane extends GridPane{
    
    private int SQUARE_SIZE;
    private boolean modifiable;
    
    public TreadlesPane(Loom loom, int squareSize) {
        this.SQUARE_SIZE = squareSize;
        this.modifiable = true;
        
        for (int i = 0; i < loom.shafts; i++) {
            for (int j = 0; j < loom.treadleAmount; j++) {
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

                add(rec, i, j);
            }
        }
    }

    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }
    
    
    
}
