package emmakamutta.ui;

import emmakamutta.domain.Fabric;
import emmakamutta.domain.Loom;
import java.util.HashMap;
import java.util.TreeMap;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Luokka kuvaa kangasta graafisena ruudukkona. Luokka kuuluu käyttöliittymän
 * olioihin. Perii JavaFX-luokan GridPane.
 *
 */
public class FabricPane extends GridPane {

    private int squareSize;
    /**
     * Oliomuuttuja kuvaa kuinka monta ruutua pitkä ja leveä ruudukko on.
     */
    private int length;

    public HashMap<String, Rectangle> rectangles;

    /**
     * Luokan FabricPane konstruktori. Alustaa kankaan tyhjäksi bvalkoiseksi
     * ruudukoksi.
     *
     * @param loom käytettävissä olevat kangaspuut
     * @param squareSize yhden ruudun sivun pituus
     */
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

    /**
     * Metodi esittää sovelluslogiikan luokan Fabric olion graafisena
     * FabricPane-oliona.
     *
     * @param fabric Fabric-olio, joka kuvaaa visualisoitavaa kangasta
     */
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

    /**
     * Metodi muuttaa yksittäisen ruudun värin halutuksi.
     * 
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     * @param color haluttu väri
     */
    public void changeRecColor(int x, int y, Color color) {
        String key = Integer.toString(x) + "," + Integer.toString(y);

        rectangles.get(key).setFill(color);

    }

}
