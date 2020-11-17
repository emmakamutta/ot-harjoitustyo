/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Opiskelija-Emma
 */
public class UniversalGridTest {

    public UniversalGridTest() {
        //Ota selvää miksi tämän täytyy olla tässä
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

}
