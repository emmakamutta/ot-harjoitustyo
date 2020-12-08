
package emmakamutta.domain;

/**
 * Rajapinta kaksiulotteiselle ruudukolle.
 */
public interface Grid {
    /**
     * Metodi hakee ja palauttaa pyydetyn sarakkeen ruudukosta.
     *
     * @param columnNmbr sarakkeen numero
     * @return kysytty sarake
     */
    int[] getColumn(int columnNmbr);
    /**
     * Metodi hakee ja palauttaa halutun rivin ruudukosta.
     * @param rowNmbr rivin numero
     * @return haluttu rivi
     */
    int[] getRow(int rowNmbr);

}
