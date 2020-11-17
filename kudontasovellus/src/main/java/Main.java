
import domain.*;



public class Main {
    public static void main(String[] args) {
        Loom design = new Loom();
        System.out.println(design);

        System.out.println("-------");
        int[][] apu = {{0,0,1,0},
                       {0,1,0,0},
                       {0,0,0,1},
                       {1,0,0,0}};
        Grid test = new UniversalGrid(apu);
        int[] column = test.getColumn(0);
        for (int i = 0; i < column.length; i++) {
            System.out.println(column[i]);
        }
        System.out.println("-------");
        System.out.println("kokeillaan kudontaa: poljetaan 1. poljinta");
       
        Heddles heddles = new Heddles(apu);
        Grid treadles = new UniversalGrid(apu);
        Loom design2 = new Loom(heddles, treadles);
        int[] fabric = design2.weave(0);
        String s = "";
        for (int i = 0; i < fabric.length; i++) {
            s += fabric[i];
        }
        System.out.println(s);
        
        System.out.println("----------");

        
        int[][] ex = {{0,0,0,1},
                      {0,0,1,0},
                      {1,0,0,0},
                      {0,1,0,0}};
        Heddles hed = new Heddles(ex);      
        int[] row3 = hed.getRow(3);
        s = "";
        for (int i = 0; i < row3.length; i++) {
            s += row3[i];
        }
        System.out.println(s);
    }
}
