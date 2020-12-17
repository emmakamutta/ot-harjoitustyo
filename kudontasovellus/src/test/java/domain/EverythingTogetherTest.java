package domain;

import emmakamutta.domain.Heddles;
import emmakamutta.domain.Loom;
import emmakamutta.domain.UniversalGrid;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 */
public class EverythingTogetherTest {

    public EverythingTogetherTest() {
    }

    @Test
    public void createLoomWeaveAndThenChangeHeddles() {
        Loom loom = new Loom(3, 4, 5);

        int[][] hed = {{1, 0, 0, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 1, 0, 0}};
        Heddles heddles = new Heddles(hed);

        loom.setHeddles(heddles);

        int[][] tread = {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}};

        UniversalGrid treadles = new UniversalGrid(tread);

        loom.setTreadles(treadles);

        loom.weave(0);
        loom.weave(1);
        loom.weave(2);
        loom.weave(3);

        int[][] hed2 = {{0, 0, 1, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1, 0}};
        Heddles heddles2 = new Heddles(hed2);

        loom.setHeddles(heddles2);

        loom.weave(1);

        int[][] correct = {{1, 0, 0, 0, 1},
        {1, 1, 0, 1, 1},
        {0, 1, 1, 1, 0},
        {0, 0, 1, 0, 0},
        {1, 1, 0, 1, 1}};

        Assert.assertArrayEquals(correct, loom.fabric.grid);
    }
;

}
