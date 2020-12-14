package emmakamutta.ui;

import emmakamutta.domain.Loom;
import java.util.HashMap;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Luokka kuvaa graafisesti poljentajärjestystä. Perii JavaFx-luokan GridPane.
 *
 */
public class TreadOrderPane extends GridPane {

    private int squareSize;
    /**
     * Oliomuuttuja kertoo, kuinka monta riviä on kudottu.
     */
    private int weaved;
    private HashMap<String, Rectangle> rectangles;
    private int length;
    private int width;

    /**
     * Luokan TreadOrderPane konstruktori. Alustaa tyhjän valkoisen ruudukon
     * kokoa kankaan leveys*polkusten lkm.
     *
     * @param loom käytettävät kangaspuut
     * @param squareSize yksittäisen ruudun sivun pituus
     */
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

    /**
     * Metodi visualisoi ruudukkoon sen, mitä polkusta painettiin.
     *
     * @param treadle painetun polkusen nro
     */
    public void visualize(int treadle) {
        if (weaved >= length) {
            return;
        }
        changeRecColor(treadle, length - weaved - 1, Color.BLACK);
        weaved++;
    }

    /**
     * Metodi muuttaa yksittäisen ruudun värin halutuksi.
     * 
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     * @param color haluttu väri
     */
    private void changeRecColor(int x, int y, Color color) {
        String key = Integer.toString(x) + Integer.toString(y);
        if (rectangles.containsKey(key)) {
            rectangles.get(key).setFill(color);
        }

    }

    /**
     * Metodi tyhjentää viimeisimmän visualisoidun rivin.
     */
    public void clearLatestRow() {
        if (weaved > 0) {

            for (int i = 0; i < width; i++) {
                String key = Integer.toString(i) + Integer.toString(length - weaved);
                rectangles.get(key).setFill(Color.WHITE);
            }
            weaved--;
        }
    }

    /**
     * Metodi tyhjentää koko ruudukon. 
     */
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
