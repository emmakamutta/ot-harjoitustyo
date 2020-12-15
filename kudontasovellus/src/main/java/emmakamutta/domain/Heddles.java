package emmakamutta.domain;

/**
 * Luokka kuvaa kangaspuiden niisintää.
 */
public class Heddles extends UniversalGrid {

    /**
     * Konstruktori, joka luo uuden niisinnän annetuilla dimensioilla. Käyttää
     * suoraan luokan UniversalGrid vastaavaa konstruktoria.
     *
     * @param shafts niisivarsien lukumäärä
     * @param columns sarakkeiden lukumäärä (sama kuin kankaan leveys)
     *
     * @see emmakamutta.domain.UniversalGrid#UniversalGrid(int,int)
     *
     */
    public Heddles(int shafts, int columns) {
        super(shafts, columns);
    }

    /**
     * Konstruktori, joka luo uuden niisinnän valmiin int[][] -taulukon
     * pohjalta.
     *
     * @param grid kaksiulotteinen kokonaislukutaulukko
     */
    public Heddles(int[][] grid) {
        if (hasTooManyOnes(grid)) {
            throw new IllegalArgumentException("Niisintä ei ole oikein");
        }
        this.grid = grid;
        this.length = grid.length;
        this.width = grid[0].length;
    }

    /**
     * Metodi tarkastaa, onko jossain ruudukon sarakkeessa useampi kuin yksi 1,
     * sillä muutoin kangaspuut eivät toimisi.
     *
     * @param grid
     * @return
     */
    private boolean hasTooManyOnes(int[][] grid) {
        int ones = 0;

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    ones++;
                }
            }
            if (ones > 1) {
                return true;
            }
            ones = 0;
        }

        return false;
    }

    @Override
    public int[] getColumn(int columnNmbr) {

        int[] column = new int[grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            column[i] = grid[i][columnNmbr];
        }

        return column;
    }

    @Override
    public int[] getRow(int rowNmbr) {
        return grid[rowNmbr];
    }
}
