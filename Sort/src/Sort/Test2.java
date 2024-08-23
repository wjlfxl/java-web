package Sort;

import java.util.Arrays;


public class Test2 {
    public static void main(String[] args) {
        int[][] a1=new int[11][11];
        a1[1][2]=1;
        a1[3][4]=2;
        //输出矩阵foreach
        for (int[] ints : a1) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
