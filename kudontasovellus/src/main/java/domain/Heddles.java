package domain;

/**
 * Tämä luokka kuvaa kangaspuiden niisintää
 */
public class Heddles implements Grid {

    int[][] grid;

    public Heddles(int shafts, int columns) {
        this.grid = new int[shafts][columns];
    }

    public Heddles(int[][] grid) {
        if (hasTooManyOnes(grid)) {
            throw new IllegalArgumentException("Niisintä ei ole oikein");
        }
        this.grid = grid;
    }

    @Override
    public String toString() {
        return "Heddles{" + grid + '}';
    }

    @Override
    public int[] getColumn(int columnNmbr) {
        if (columnNmbr >= grid[0].length) {
            return null;
        }

        int[] column = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            column[i] = grid[i][columnNmbr];
        }

        return column;
    }

    @Override
    public int[] getRow(int rowNmbr) {
        return grid[rowNmbr];
    }

    //Kudonnassa niisimisessä on tärkeää, että yksi lanka ei mene kuin yhden niidensilmän läpi, muuten kangaspuut eivät toimi
    // Siis tässä koodissa niisinnässä saa olla vain yksi ykkönen yhdessä sarakkseessa.
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
}
