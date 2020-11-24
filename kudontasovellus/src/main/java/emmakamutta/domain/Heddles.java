package emmakamutta.domain;

/**
 * Tämä luokka kuvaa kangaspuiden niisintää
 */
public class Heddles extends UniversalGrid {

    int length;
    int width;
    public int[][] grid;

    public Heddles(int shafts, int columns) {
        this.length = shafts;
        this.width = columns;
        this.grid = new int[shafts][columns];
    }

    public Heddles(int[][] grid) {
        if (hasTooManyOnes(grid)) {
            throw new IllegalArgumentException("Niisintä ei ole oikein");
        }
        this.grid = grid;
        this.length = grid.length;
        this.width = grid[0].length;
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
