package emmakamutta.domain;

/**
 * Luokka kuvaa kaksiulotteista ruudukkoa.
 */
public class UniversalGrid implements Grid {

    /**
     * Ruudukon korkeus.
     */
    public int length;
    /**
     * Ruudukon leveys.
     */
    public int width;
    /**
     * Ruudukko int-muodossa.
     */
    public int[][] grid;

    public UniversalGrid() {
    }

    /**
     * Konstruktori, joka luo uuden ruudukon annetuilla dimensioilla.
     *
     * @param length rivien lukumäärä
     * @param width sarakkeiden lukumäärä
     */
    public UniversalGrid(int length, int width) {
        this.length = length;
        this.width = width;
        this.grid = new int[length][width];
    }

    /**
     * Konstruktori, joka luo uuden UniversalGrid olion valmiista int[][]
     * ruudukosta.
     *
     * @param grid
     */
    public UniversalGrid(int[][] grid) {
        this.grid = grid;
        this.length = grid.length;
        this.width = grid[0].length;
    }

    /**
     * Metodi hakee ja palauttaa pyydetyn sarakkeen ruudukosta.
     *
     * @param columnNmbr sarakkeen numero
     * @return kysytty sarake
     */
    @Override
    public int[] getColumn(int columnNmbr) {

        if (columnNmbr > width || columnNmbr < 0) {
            throw new IllegalArgumentException("Column doesn't exist");
        }
        int[] column = new int[length];

        for (int i = 0; i < length; i++) {
            column[i] = grid[i][columnNmbr];
        }

        return column;
    }

    /**
     * Metodi hakee ja palauttaa halutun rivin ruudukosta.
     *
     * @param rowNmbr rivin numero
     * @return haluttu rivi
     */
    @Override
    public int[] getRow(int rowNmbr) {
        return grid[rowNmbr];
    }
}
