package emmakamutta.domain;

import java.util.*;

/**
 * Kangaspuita kuvaava luokka.
 */
public class Loom {

    public int shafts;           //niisivarsien lkm;
    public int treadleAmount;    //polkusten lkm;
    public int fabricWidth;
    public Grid heddles;
    public Grid treadles;
    public Fabric fabric;
    public HashMap<Integer, int[]> weaveTreadles;
    public Deque<Integer> treadOrder;

    /**
     * Luokan Loom konstruktori
     *
     * @param shafts Niisivarsien lukumäärä
     * @param treadleamount Polkusten lukumäärä
     */
    public Loom(int shafts, int treadleamount) {
        this.shafts = shafts;
        this.treadleAmount = treadleamount;
        this.fabricWidth = 20;
        this.heddles = new Heddles(shafts, fabricWidth);
        this.treadles = new UniversalGrid(shafts, treadleamount);
        this.fabric = new Fabric(fabricWidth);
        this.weaveTreadles = new HashMap<>();
        this.treadOrder = new ArrayDeque<>();
    }

    /**
     * Luokan Loom konstruktori
     *
     * @param heddles Niisintää kuvaava Heddles-olio
     * @param treadles Polkusten sidontaa kuvaava Grid-olio
     */
    public Loom(Heddles heddles, Grid treadles) {
        this.heddles = heddles;
        this.treadles = treadles;
        this.shafts = heddles.getColumn(0).length;
        this.fabricWidth = heddles.getRow(0).length;
        this.treadleAmount = treadles.getRow(0).length;
        this.fabric = new Fabric(fabricWidth);
        this.weaveTreadles = new HashMap<>();
        this.treadOrder = new ArrayDeque<>();
    }

    /**
     * Metodi kuvaa yhden rivin kutomista kangaspuilla, kun parametrina annettu
     * polkunen on painettuna. Jos kyseistä polkusta on poljettu aiemminkin,
     * niin sen kutoma rivi muistetaan, eikä sitä siis tarvitse tuolloin
     * määritellä kokonaan uudestaan.
     *
     * @param treadle
     */
    public void weave(int treadle) {
        if (treadle >= treadleAmount || treadle < 0) {
            throw new IllegalArgumentException("Polkusta ei ole olemassa");
        }
        if (!weaveTreadles.containsKey(treadle)) {
            weaveTreadles.put(treadle, getWeavedRow(treadle));
        }
        int[] row = weaveTreadles.get(treadle);
        fabric.weaveRow(row);
        treadOrder.add(treadle);
    }

    /**
     * Metodi luo niisinnän ja polkusten sidonnan perusteella taulukon, joka
     * kuvastaa sitä kudottua kerrosta, joka syntyy painamalla parametrina
     * annettua polkusta ja heittämällä yhden heiton kudetta. Palautettavassa
     * taulukossa 1 tarkoittaa, että siinä kohdassa kudottua kangasta näkyisi
     * loimilanka ja 0 taas, että näkyviin jäisi kude.
     *
     * @param treadle painettu polkunen
     * @return kudottu rivi
     */
    public int[] getWeavedRow(int treadle) {

        int[] bounded = treadles.getColumn(treadle);
        int[] weavedRow = new int[fabricWidth];

        for (int i = 0; i < shafts; i++) {
            if (bounded[i] == 0) {
                continue;
            }
            int[] relevant = heddles.getRow(i);
            for (int j = 0; j < fabricWidth; j++) {
                if (relevant[j] == 1) {
                    weavedRow[j] = 1;
                }
            }
        }
        return weavedRow;
    }

    public void setHeddles(Heddles heddles) {
        this.heddles = heddles;
    }

    public void setTreadles(Grid treadles) {
        this.treadles = treadles;
    }

    /**
     * Metodi kuvaa viimeisimmän kudotun rivin purkamista.
     */
    public void undo() {
        if (!this.treadOrder.isEmpty()) {

            this.fabric.unWeave();
            this.treadOrder.pollLast();
        }
    }

}
