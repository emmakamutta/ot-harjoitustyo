package emmakamutta.domain;

/**
 *
 * tämä luokka on tavallinen ruudukko
 */
public class UniversalGrid implements Grid {

    int length;
    int width;
    int[][] grid;

    public UniversalGrid() {
    }

    public UniversalGrid(int length, int width, int[][] grid) {
        this.length = length;
        this.width = width;
        this.grid = grid;
    }
    
    public UniversalGrid(int length, int width) {
        this.length = length;
        this.width = width;
        this.grid = new int[length][width];
    }

    public UniversalGrid(int[][] grid) {
        this.grid = grid;
        this.length = grid.length;
        this.width = grid[0].length;
    }

    @Override
    public String toString() {
        String s = "\n";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    s += "1";
                } else {
                    s += "0";
                }
            }
            s += "\n";
        }
        return s;
    }

    @Override
    public int[] getColumn(int columnNmbr) {
        if (columnNmbr > width) {
            return null;
        }

        int[] column = new int[length];

        for (int i = 0; i < length; i++) {
            column[i] = grid[i][columnNmbr];
        }

        return column;
    }
    
    @Override
    public int[] getRow(int rowNmbr) {
        return grid[rowNmbr];
    } 
}
