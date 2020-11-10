
package domain;

/**
 *Tämä luokka kuvaa polkusten sidontaa
 */
public class Treadles {
    int treadles; //polkusten lkm
    int shafts;   //niisivarsien lkm
    int[][] grid;

    public Treadles(int treadles, int shafts) {
        this.treadles = treadles;
        this.shafts = shafts;
        this.grid = new int[shafts][treadles];
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
    
    
}
