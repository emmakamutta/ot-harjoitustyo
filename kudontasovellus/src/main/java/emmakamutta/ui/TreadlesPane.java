package emmakamutta.ui;

import emmakamutta.domain.Grid;
import emmakamutta.domain.Loom;
import emmakamutta.domain.UniversalGrid;
import java.util.HashMap;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Luokka kuvaa polkusten sidontaa graafisena ruudukkona osana käyttöliittymää.
 * Perii JavaFX-luokan GridPane.
 *
 */
public class TreadlesPane extends GridPane {

    private int squareSize;
    /**
     * Oliomuuttuja kuvaa sitä, saako polkusten sidontaan tehdä muutoksia.
     */
    private boolean modifiable;
    private HashMap<String, Rectangle> rectangles;
    private int height;
    private int width;

    /**
     * Luokan TreadlesPane konstruktori. Alustaa polkusten sidonnan täysin
     * valkoisena ruudukkona, johon sidonnan voi määritellä klikkaamalla
     * ruutuja. Muutoksen voi peruuttaa klikkaamalla ruutua uudelleen.
     *
     * @param loom kangaspuut, joiden polkusten sidontaa halutaan esittää
     * @param squareSize ruudukon ruudun sivun pituus
     */
    public TreadlesPane(Loom loom, int squareSize) {
        this.squareSize = squareSize;
        this.modifiable = true;
        this.rectangles = new HashMap<>();
        this.width = loom.treadleAmount;
        this.height = loom.shafts;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
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

    /**
     * Metodi muuntaa graafisen TreadlesPane-olion luokalle Loom sopivaksi
     * UniversalGrid-olioksi, joka vastaa graafista polkusten sidontaa.
     *
     * @return UniversalGrid, joka vastaa määriteltyä polkusten sidontaa.
     */
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

    /**
     * Muuttaa oliomuuttujan modifiable parametrina annetuksi totuusarvoksi.
     * 
     * @param modifiable haluttu totuusarvo
     */
    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }

    /**
     * Metodi muuttaa ruudukon 'lukirusväreihin', eli mustat ruudut muuttuvat
     * tummanharmaiksi sen merkiksi, että niisintä on lukittu.
     */
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
