package emmakamutta;


import emmakamutta.domain.*;



public class Main {
    public static void main(String[] args) {
      
        System.out.println("-----");
        Fabric fabric = new Fabric(4,5);
        System.out.println(fabric.weavedRows);
        int[] apu = {1,1,1,1,1};
        fabric.weaveRow(apu);
        System.out.println(fabric);
        fabric.weaveRow(apu);
        System.out.println(fabric);
        System.out.println(fabric.weavedRows);
    }
}
