
package domain;

/**
 *Tämä luokka kuvaa kangaspuiden niisintää
 */
public class Heddles {
    
    Grid grid;

    public Heddles(int shafts, int columns) {
        this.grid = new Grid(shafts, columns);
    }

    @Override
    public String toString() {
        return "Heddles{" + grid + '}';
    }
    
    
    
    
    
}
