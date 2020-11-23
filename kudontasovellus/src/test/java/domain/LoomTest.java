
package domain;

import emmakamutta.domain.Heddles;
import emmakamutta.domain.UniversalGrid;
import emmakamutta.domain.Loom;
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
public class LoomTest {
    
    public LoomTest() {
    }
    

    @Before
    public void setUp() {
        int[][] ex = {{0,0,0,1},
                      {0,0,1,0},
                      {1,0,0,0},
                      {0,1,0,0}};
        Heddles hed = new Heddles(ex);  
        int[][] ex2 = {{0,0,1,0},
                       {0,1,0,0},
                       {0,0,0,1},
                       {1,0,1,0}};
        UniversalGrid treadles = new UniversalGrid(ex);
        Loom loom = new Loom(hed, treadles);
    }
    
  


    
}
