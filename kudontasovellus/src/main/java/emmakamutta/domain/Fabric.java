package emmakamutta.domain;

/**
 *
 * Tämä luokka kuvaa kudottua kangasta
 */
public class Fabric extends UniversalGrid {

    public int weavedRows;

    public Fabric(int length, int width) {
        super(length, width);
        this.weavedRows = 0;
    }

    public Fabric(int[][] grid) {
        super(grid);
        this.weavedRows = 0;
    }

    public void weaveRow(int[] row) {
        this.grid[weavedRows] = row;
        weavedRows++;
    }

}
