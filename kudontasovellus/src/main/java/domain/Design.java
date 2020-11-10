
package domain;

/**
 * Kokonaista kudontamallia kuvaava luokka
 */
public class Design {
    int shafts;           //niisivarsien lkm;
    int treadleamount;    //polkusten lkm;
    int length;
    Heddles heddles;
    Treadles treadles;
    int[][] grid;

    public Design() {
        this.shafts = 4;
        this.treadleamount = 4;
        this.length = 10;      //HUOM!!! nyt 10 - onko tämä lopullinen oletusarvo?
        this.heddles = new Heddles(shafts, length);
        this.treadles = new Treadles(shafts, treadleamount);
    }

    public Design(int shafts, int treadleamount) {
        this.shafts = shafts;
        this.treadleamount = treadleamount;
        this.heddles = new Heddles(shafts, length);
        this.treadles = new Treadles(shafts, treadleamount);
    }
    
    
    
    
}
