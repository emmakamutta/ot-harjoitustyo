

import emmakamutta.domain.Heddles;
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
    
    @Test
    public void constructorWorksWithArrayInput() {
        int[][] ex = {{0,0,0,1},
                      {0,0,1,0},
                      {1,0,0,0},
                      {0,1,0,0}};
        Heddles heddles = new Heddles(ex);
        
        Assert.assertArrayEquals(ex, heddles.grid);
    }
    
    @Test
    public void getColumnReturnsCorrectColumn() {
        int[][] ex = {{0,0,0,1},
                      {0,0,1,0},
                      {1,0,0,0},
                      {0,1,0,0}};
        Heddles heddles = new Heddles(ex);
        
        int[] col = {0,0,0,1};
        Assert.assertArrayEquals(col, heddles.getColumn(1));
    }
    
    @Test
    public void constructorByDimensionsWorks() {
        Heddles heddles = new Heddles(2,7);
        
        int[][] correct = new int[2][7];
        
        Assert.assertArrayEquals(correct, heddles.grid);
    }
}
