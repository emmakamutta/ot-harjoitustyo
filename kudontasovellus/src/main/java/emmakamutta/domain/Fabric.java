package emmakamutta.domain;

/**
 *
 * Tämä luokka kuvaa kudottua kangasta.
 */
public class Fabric extends UniversalGrid {

    /**
     * Kuinka monta riviä on jo kudottu.
     */
    public int weavedRows;

    /**
     * Konstruktori, joka luo uuden kangasta kuvaavan ruudukon annetun leveyden
     * perusteella.
     *
     * @param width kankaan leveys loimilankojen lukumääränä
     */
    public Fabric(int width) {
        super(width, width);
        this.weavedRows = 0;
    }

    /**
     * Metodi merkitsee ruudukkoon parametrina annetun rivin. Siis kutoo
     * kankaaseen annetun rivin.
     *
     * @param row kudottava rivi taulukkona
     */
    public void weaveRow(int[] row) {
        if (weavedRows < this.length) {
            this.grid[weavedRows] = row;
            weavedRows++;
        }
    }

    /**
     * Metodi poistaa ruudukosta uusimman rivin.
     * Se siis purkaa kankaasta viimeisimmän kuteen.
     */
    public void unWeave() {
        weavedRows--;
        int[] emptyRow = new int[this.length];
        weaveRow(emptyRow);
        weavedRows--;
    }

}
