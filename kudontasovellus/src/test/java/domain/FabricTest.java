
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
        this.fabric = new Fabric(4,5);
    }
    
    @Test
    public void weaveRowWeavesCorrectRow() {
        int[] ex = {1,1,1,1,1};
        fabric.weaveRow(ex);
        
        Assert.assertArrayEquals(ex, fabric.grid[0]);
    }
    
   
}
