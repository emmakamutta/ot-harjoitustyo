
package domain;

import emmakamutta.domain.UniversalGrid;
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
public class UniversalGridTest {

    public UniversalGridTest() {
    }


    @Test
    public void getColumnReturnsCorrectColumn() {
        int[][] ex = {{0, 0, 0, 1},
        {0, 0, 1, 0},
        {1, 0, 0, 0},
        {0, 1, 0, 0}};
        UniversalGrid grid = new UniversalGrid(ex);

        int[] col = {0, 0, 0, 1};
        Assert.assertArrayEquals(col, grid.getColumn(1));
    }
    
    @Test
    public void getRowReturnsCorrectRow() {
        int[][] ex = {{0,0,1,1},
                      {0,0,0,0},
                      {0,0,0,0},
                      {0,1,0,0}};
        UniversalGrid grid = new UniversalGrid(ex);
        
        int[] row = {0,1,0,0};
        
        Assert.assertArrayEquals(row, grid.getRow(3));
    }
    
    @Test
    public void toStringWorks() {
        int[][] ex = {{0,1,1}, 
                     {1,0,1}};
        
        UniversalGrid grid = new UniversalGrid(ex);
        
        assertEquals("\n011\n101\n",grid.toString());
    }
    
   

}
