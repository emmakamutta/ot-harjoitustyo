
package domain;

/**
 * ruudukko
 */
public class Grid {
    int length;
    int width;
    int[][] grid;

    public Grid(int length, int width) {
        this.length = length;
        this.width = width;
        this.grid = new int[length][width];
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
    
}
