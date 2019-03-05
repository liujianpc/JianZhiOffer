/**
 * Date: 2019/1/5
 * Created by Liuian
 */

import java.util.Arrays;

/**
 * 希尔排序，简单插入排序的一个变种
 */
class ShellSort {


    public static void main(String[] agrs){
        int[] array = new int[]{9,10,2,8,6,5};
        System.out.println(Arrays.toString(shellSort(array)));
    }
    private static int[] shellSort(int[] array){
        int gap = array.length / 2;
        while (gap >= 1){
            for (int i = gap; i <= array.length - 1; i = i + gap) {
                int current = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > current){
                    array[preIndex+gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex+gap] = current;
            }
            gap = gap / 2;
        }
        return array;
    }
}
