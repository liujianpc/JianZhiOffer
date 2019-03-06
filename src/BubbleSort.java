/**
 * Date: 2019/1/5
 * Created by Liuian
 */

import java.util.Arrays;

/**
 * 冒泡排序
 * 注意冒泡的优化
 */
class BubbleSort {

    private static int[] bubbleSort(int[] array) {
        boolean exchanged = false;
        for (int i = 0; i < array.length; i++) {//多少次冒泡
            for (int j = 0; j < array.length - i - 1; j++) {//比较次数
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    exchanged = true;
                }
            }
            if (!exchanged) {
                break;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println((Arrays.toString(bubbleSort(new int[]{9, 8, 7, 6, 5}))));
    }
}
