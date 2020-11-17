

import domain.Heddles;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * 
 */
public class HeddlesTest {
    
    public HeddlesTest() {
    }
    
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void getRowReturnsCorrectRow() {
        int[][] ex = {{0,0,1,1},
                      {0,0,0,0},
                      {0,0,0,0},
                      {0,1,0,0}};
        Heddles heddles = new Heddles(ex);
        
        int[] row = heddles.getRow(3);
        String s = "";
        for (int i = 0; i < row.length; i++) {
            s += row[i];
        }
        assertEquals("0100", s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorThrowsExceptionWithFaultyInput() {
        int[][] ex = {{0,0,1,1},
                      {0,0,1,0},
                      {0,0,1,0},
                      {0,1,0,0}};
        Heddles heddles = new Heddles(ex);
    }
}
