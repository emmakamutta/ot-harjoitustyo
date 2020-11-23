
package emmakamutta.domain;

/**
 * ruudukko
 */
public interface Grid {
    int[] getColumn(int columnNmbr);
    int[] getRow(int rowNmbr);
    @Override
    String toString();

}
