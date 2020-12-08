package domain;

import emmakamutta.domain.Fabric;
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
public class FabricTest {

    Fabric fabric;

    public FabricTest() {
    }

    @Before
    public void setUp() {
        this.fabric = new Fabric(5);
    }

    @Test
    public void weaveRowWeavesCorrectRow() {
        int[] ex = {1, 0, 1, 0, 1};
        fabric.weaveRow(ex);
        String s = "";
        for (int i = 0; i < 5; i++) {
            s += fabric.grid[0][i];
        }

        assertEquals("10101", s);
    }

    @Test
    public void weavingFullFabricDoesntChangeIt() {
        int[] ex = {1, 0, 1, 0, 1};
        for (int i = 0; i < 5; i++) {
            fabric.weaveRow(ex);
        }
        
        int[] row = {0,0,1,1,1};
        fabric.weaveRow(row);
        
        boolean correct = true;
        for (int i = 0; i < 5; i++) {
            if (fabric.grid[i] == row) {
                correct = false;
            }
        }
        assertTrue(correct);
    }

}
