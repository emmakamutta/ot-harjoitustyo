
package domain;

/**
 * Kudontamallia kuvaava luokka
 */
public class Design {
    int shafts;           //niisivarsien lkm;
    int treadleamount;    //polkusten lkm;
    int length;
    Heddles heddles;
    Treadles treadles;
    Grid grid;

    public Design() {
        this.shafts = 4;
        this.treadleamount = 4;
        this.length = 10;      //HUOM!!! nyt 10 - onko tämä lopullinen oletusarvo?
        this.heddles = new Heddles(shafts, length);
        this.treadles = new Treadles(shafts, treadleamount);
        this.grid = new Grid(length, length);
    }

    public Design(int shafts, int treadleamount) {
        this.shafts = shafts;
        this.treadleamount = treadleamount;
        this.heddles = new Heddles(shafts, length);
        this.treadles = new Treadles(shafts, treadleamount);
        this.grid = new Grid(length, length);
    }
    
    public void weave(int treadle) {
        if (treadle >= treadleamount || treadle < 0) {
            // tällöin polkusta ei olemassa -> virheilmoitus?
        }  
        
    }

    @Override
    public String toString() {
        return "Design{" + "shafts=" + shafts + ", treadleamount=" + treadleamount + ", length=" + length + ", heddles=" + heddles + ", treadles=" + treadles + ", grid=" + grid + '}';
    }
    
    
    
}
