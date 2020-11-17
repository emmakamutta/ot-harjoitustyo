
package domain;

/**
 * Kudontamallia kuvaava luokka
 */
public class Design {
    int shafts;           //niisivarsien lkm;
    int treadleamount;    //polkusten lkm;
    int length;
    Grid heddles;
    Grid treadles;
    Grid grid;

    public Design() {
        this.shafts = 4;
        this.treadleamount = 4;
        this.length = 10;      //HUOM!!! nyt 10 - onko tämä lopullinen oletusarvo?
        this.heddles = new UniversalGrid(shafts, length);
        this.treadles = new UniversalGrid(shafts, treadleamount);
        this.grid = new UniversalGrid(length, length);
    }

    public Design(int shafts, int treadleamount) {
        this.shafts = shafts;
        this.treadleamount = treadleamount;
        this.heddles = new UniversalGrid(shafts, length);
        this.treadles = new UniversalGrid(shafts, treadleamount);
        this.grid = new UniversalGrid(length, length);
    }

    public Design(Grid heddles, Grid treadles) {
        this.heddles = heddles;
        this.treadles = treadles;
        this.shafts = heddles.getColumn(0).length;
        this.length = heddles.getRow(0).length;
        this.treadleamount = treadles.getRow(0).length;
        this.grid = this.grid = new UniversalGrid(length, length);
    }
    
    
    
    public int[] weave(int treadle) {
        if (treadle >= treadleamount || treadle < 0) {
            return null;
            // tällöin polkusta ei olemassa -> virheilmoitus?
        }  
        int[] bounded = treadles.getColumn(treadle);
        int[] weavedRow = new int[length];
        
        for (int i = 0; i < shafts; i++) {
            if (bounded[i]== 0) {
                continue;
            }
            int[] relevant = heddles.getRow(i);
            for (int j = 0; j < length; j++) {
                if (relevant[j]==1) {
                    weavedRow[j] = 1;
                }
            }
        }
        return weavedRow;
    }

    @Override
    public String toString() {
        return "Design{" + "shafts=" + shafts + ", treadleamount=" + treadleamount + ", length=" + length + ", heddles=" + heddles + ", treadles=" + treadles + ", grid=" + grid + '}';
    }
    
    
    
}
