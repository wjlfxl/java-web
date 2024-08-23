package Sort;

import java.util.Arrays;


public class Test1 {
    public static void main(String[] args) {
        int[] a={20,9,8,15,10,12};
        int[] array=MaoPaoSort(a);
        System.out.println(Arrays.toString(array));
    }

    //冒泡
    public static int[] MaoPaoSort(int[] array) {
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    x = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = x;
                }
            }
        }
        return array;
    }




}
