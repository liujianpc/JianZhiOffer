/**
 * Date: 2019/1/5
 * Created by Liuian
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 選擇排序，切割数组，找到最小的放到前面去（最小值位置与开始的位置交换值）
 */
class SelectSort {

    private static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }

            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 6, 7, 4, 3, 5, 1, 2};
        System.out.println(Arrays.toString(selectSort(array)));
    }

}
