package domain;

import emmakamutta.domain.Heddles;
import emmakamutta.domain.UniversalGrid;
import emmakamutta.domain.Loom;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 *
 */
public class LoomTest {

    Loom loom;

    public LoomTest() {
    }

    @Before
    public void setUp() {
        int[][] ex = {{0, 0, 0, 1},
                      {0, 0, 1, 0},
                      {1, 0, 0, 0},
                      {0, 1, 0, 0}};
        Heddles hed = new Heddles(ex);
        int[][] ex2 = {{0, 0, 1, 1},
                       {1, 1, 0, 0},
                       {0, 1, 0, 1},
                       {1, 0, 1, 0}};
        UniversalGrid treadles = new UniversalGrid(ex2);
        this.loom = new Loom(hed, treadles);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantWeaveWithTooBigTreadle() {
        loom.weave(80);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void cantWeaveWithNegativeTreadle() {
        loom.weave(-2);
    }

    @Test
    public void getWeavedRowReturnsCorrectly() {
        int[] correct = {0, 1, 1, 0};
        
        Assert.assertArrayEquals(correct, loom.getWeavedRow(0));
    }
    
    @Test
    public void firstTimeWeavingWithTreadleWeavesCorrectly() {
        loom.weave(0);
        int[] correct = {0, 1, 1, 0};
        int[] weaved = loom.fabric.getRow(0);
        Assert.assertArrayEquals(correct, weaved);
    }
    
    @Test
    public void weavingWithPreviousTreadleGetsRowFromHashMap() {
        loom.weave(2);
        int[] fromMap = loom.weaveTreadles.get(2);
        loom.weave(2);
        Assert.assertArrayEquals(fromMap, loom.fabric.getRow(1));
    }
    
    @Test
    public void loomRemembersTreadleOrderAfterWeaving() {
        loom.weave(0);
        loom.weave(1);
        loom.weave(3);
        
        String s = "";
        for (Integer integer : loom.treadOrder) {
            s += integer;
        }
        
        assertEquals("013",s);
    }
    
    @Test
    public void undoRemovesLastFromTreadOrder() {
        loom.weave(0);
        loom.weave(1);
        loom.weave(2);
        
        loom.undo();
        
        //int last = loom.treadOrder.getLast();
        
        String s = "";
        for (Integer integer : loom.treadOrder) {
            s += integer;
        }
        
        assertEquals("01",s);
        
        //assertEquals(1, last);
    }

}
