package emmakamutta.domain;

import java.util.*;

/**
 * Kangaspuita kuvaava luokka.
 */
public class Loom {

    /**
     * Kangaspuiden niisivarsien lukumäärä.
     */
    public int shafts;
    /**
     * Kangaspuiden polkusten lukumäärä.
     */
    public int treadleAmount;
    /**
     * Kankaan leveys ruutuina.
     */
    public int fabricWidth;
    /**
     * Ruudukko, joka kuvaa niisintää.
     */
    public Grid heddles;
    /**
     * Ruudukko, joka kuvaa polkusten sidontaa.
     */
    public Grid treadles;
    /**
     * Ruudukko, joka kuvaa kangasta.
     */
    public Fabric fabric;
    /**
     * HashMap, joka sisältää yhden rivin taulukkoina kutakin polkusta
     * painamalla syntyvän kudotun rivin.
     */
    public HashMap<Integer, int[]> weaveTreadles;
    /**
     * Jono, johon tallentuu polkusten polkemisjärjestys.
     */
    public Deque<Integer> treadOrder;

    /**
     * Luokan Loom konstruktori
     *
     * @param shafts Niisivarsien lukumäärä
     * @param treadleamount Polkusten lukumäärä
     * @param fabricWidth Kankaan leveys ruutuina
     */
    public Loom(int shafts, int treadleamount, int fabricWidth) {
        this.shafts = shafts;
        this.treadleAmount = treadleamount;
        this.fabricWidth = fabricWidth;
        this.heddles = new Heddles(shafts, this.fabricWidth);
        this.treadles = new UniversalGrid(shafts, treadleamount);
        this.fabric = new Fabric(this.fabricWidth);
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

    /**
     * Metodi asettaa valmiin Heddles olion kangaspuiden niisinnäksi. Tämä on
     * mahdollista vain, jos valmiissa niisinnässä on käytetty yhtä montaa
     * niisivartta, kuin kangaspuilla on käytössä.
     *
     * @param heddles valmis niisintä Heddles-oliona
     */
    public void setHeddles(Heddles heddles) {
        if (heddles.length == this.shafts) {
            this.heddles = heddles;
        }
    }

    /**
     * Metodi asettaa valmiin ruudukon kangaspuiden polkusten sidonnaksi.
     * Ruudukon täytyy olla samankokoinen, kuin kangaspuihin on määritelty.
     *
     * @param treadles valmis polkusten sidonta Grid-rajapinnan toteuttavana ruudukkona.
     */
    public void setTreadles(Grid treadles) {
        if (treadles.getRow(0).length == this.treadleAmount && treadles.getColumn(0).length == this.shafts) {
            this.treadles = treadles;
        }
    }

    /**
     * Metodi kuvaa viimeisimmän kudotun rivin purkamista. Purkaminen onnistuu
     * vain, jos jotakin on jo kudottu.
     */
    public void undo() {
        if (!this.treadOrder.isEmpty()) {

            this.fabric.unWeave();
            this.treadOrder.pollLast();
        }
    }

}
