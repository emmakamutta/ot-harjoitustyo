
package domain;

/**
 *Tämä luokka kuvaa polkusten sidontaa
 */
public class Treadles implements Grid{
    int treadles; //polkusten lkm                   //leveys
    int shafts;   //niisivarsien lkm                //korkeus
    int[][] grid; //1 musta ruutu, 0 valkoinen ruutu

    public Treadles(int treadles, int shafts) {
        this.treadles = treadles;
        this.shafts = shafts;
        this.grid = new int[shafts][treadles];
    }

    public Treadles(int[][] grid) {
        this.grid = grid;
        this.shafts = grid.length;
        this.treadles = grid[0].length;
    }
    
    

    @Override
    public int[] getColumn(int columnNmbr) {
        if (columnNmbr >= treadles) {
            return null;
        }

        int[] column = new int[shafts];

        for (int i = 0; i < treadles; i++) {
            column[i] = grid[i][columnNmbr];
        }

        return column;
    }

    @Override
    public int[] getRow(int rowNmbr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public String toString() {
        return "Treadles{"  + grid + '}';
    }
    

}
