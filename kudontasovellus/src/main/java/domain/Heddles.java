
package domain;

/**
 *Tämä luokka kuvaa kangaspuiden niisintää
 */
public class Heddles {
    
    int[][] grid;

    public Heddles(int shafts, int columns) {
        this.grid = new int[shafts][columns];
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
    
    
    
    
    
}
