
package domain;

/**
 *Tämä luokka kuvaa polkusten sidontaa
 */
public class Treadles {
    int treadles; //polkusten lkm
    int shafts;   //niisivarsien lkm
    Grid grid; //1 musta ruutu, 0 valkoinen ruutu

    public Treadles(int treadles, int shafts) {
        this.treadles = treadles;
        this.shafts = shafts;
        this.grid = new Grid(shafts, treadles);
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    @Override
    public String toString() {
        return "Treadles{"  + grid + '}';
    }
    

}
