
package domain;

import emmakamutta.domain.UniversalGrid;
import org.junit.Assert;
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
    public void constructorWithGivenGridWorks() {
        int[][] ex = {{0,1,1}, 
                     {1,0,1}};
        
        UniversalGrid grid = new UniversalGrid(ex);
        
        boolean ok = true;
        if (grid.grid != ex || grid.length != ex.length || grid.width !=ex[0].length ) {
            ok = false;
        }
        assertTrue(ok);
    }
    
    @Test
    public void constructorWithGivenWidthAndLengthWorks() {
        UniversalGrid grid = new UniversalGrid(7,4);
        Assert.assertArrayEquals(new int[7][4], grid.grid);
    }
   
    @Test(expected = IllegalArgumentException.class)
    public void getColumnWithNegativeNmbrDoesntWork() {
        int[][] ex = {{0,0,1,1},
                      {0,0,0,0},
                      {0,0,0,0},
                      {0,1,0,0}};
        UniversalGrid grid = new UniversalGrid(ex);
        
        grid.getColumn(-8);
    }

     @Test(expected = IllegalArgumentException.class)
    public void getColumnWithTooBigNmbrDoesntWork() {
        int[][] ex = {{0,0,1,1},
                      {0,0,0,0},
                      {0,0,0,0},
                      {0,1,0,0}};
        UniversalGrid grid = new UniversalGrid(ex);
        
        grid.getColumn(50);
    }
}
