package emmakamutta.domain;

/**
 *
 * Tämä luokka kuvaa kudottua kangasta
 */
public class Fabric extends UniversalGrid {

    public int weavedRows;

    public Fabric(int width) {
        super(width, width);
        this.weavedRows = 0;
    }

    public void weaveRow(int[] row) {
        if (weavedRows < this.length) {
            this.grid[weavedRows] = row;
            weavedRows++;
        }
    }

    public void unWeave() {
        weavedRows--;
        int[] emptyRow = new int[this.length];
        weaveRow(emptyRow);
        weavedRows--;
    }

}
