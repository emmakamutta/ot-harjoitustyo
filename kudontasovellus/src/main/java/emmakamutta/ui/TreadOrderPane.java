package emmakamutta.ui;

import emmakamutta.domain.Loom;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 *
 */
public class TreadOrderPane extends GridPane {

    private int squareSize;

    public TreadOrderPane(Loom loom, int squareSize) {
        this.squareSize = squareSize;

        for (int i = 0; i < loom.treadleAmount; i++) {
            for (int j = 0; j < loom.fabricWidth; j++) {
                Rectangle rec = new Rectangle(this.squareSize - 2, this.squareSize - 2);
                rec.setStroke(Color.LIGHTGRAY);
                rec.setFill(Color.WHITE);

                add(rec, i, j);
            }
        }
    }
}
