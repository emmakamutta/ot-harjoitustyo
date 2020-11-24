package emmakamutta.domain;

import java.util.*;

/**
 * Kangaspuita kuvaava luokka
 */
public class Loom {

    int shafts;           //niisivarsien lkm;
    int treadleAmount;    //polkusten lkm;
    int length;
    Grid heddles;
    Grid treadles;
    Fabric fabric;
    HashMap<Integer, int[]> weaveTreadles;

    public Loom() {
        this.shafts = 4;
        this.treadleAmount = 4;
        this.length = 10;      //HUOM!!! nyt 10 - onko tämä lopullinen oletusarvo?
        this.heddles = new Heddles(shafts, length);
        this.treadles = new UniversalGrid(shafts, treadleAmount);
        this.fabric = new Fabric(length, length);
        this.weaveTreadles = new HashMap<>();
    }

    public Loom(int shafts, int treadleamount) {
        this.shafts = shafts;
        this.treadleAmount = treadleamount;
        this.length = 10;
        this.heddles = new Heddles(shafts, length);
        this.treadles = new UniversalGrid(shafts, treadleamount);
        this.fabric = new Fabric(length, length);
        this.weaveTreadles = new HashMap<>();
    }

    public Loom(Heddles heddles, Grid treadles) {
        this.heddles = heddles;
        this.treadles = treadles;
        this.shafts = heddles.getColumn(0).length;
        this.length = heddles.getRow(0).length;
        this.treadleAmount = treadles.getRow(0).length;
        this.fabric = new Fabric(length, length);
        this.weaveTreadles = new HashMap<>();
    }

    public void weave(int treadle) {
        if (treadle >= treadleAmount || treadle < 0) {
            throw new IllegalArgumentException("Polkusta ei ole olemassa");
        }
        if (!weaveTreadles.containsKey(treadle)) {
            weaveTreadles.put(treadle, getWeavedRow(treadle));
        }
        int[] row = weaveTreadles.get(treadle);
        fabric.weaveRow(row);
    }

    public int[] getWeavedRow(int treadle) {
        
        int[] bounded = treadles.getColumn(treadle);
        int[] weavedRow = new int[length];

        for (int i = 0; i < shafts; i++) {
            if (bounded[i] == 0) {
                continue;
            }
            int[] relevant = heddles.getRow(i);
            for (int j = 0; j < length; j++) {
                if (relevant[j] == 1) {
                    weavedRow[j] = 1;
                }
            }
        }
        return weavedRow;
    }

    @Override
    public String toString() {
        return "Design{" + "shafts=" + shafts + ", treadleamount=" + treadleAmount + ", length=" + length + ", heddles=" + heddles + ", treadles=" + treadles + ", grid=" + fabric + '}';
    }

}
