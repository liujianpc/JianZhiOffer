/**
 * Date: 2019/1/2
 * Created by Liuian
 */

import java.util.Arrays;
/**
 * 快拍實現
 * 1、左右指針法
 * 2、挖坑法
 * 3、前面前面遍歷與
 * <p>
 * 优化：
 * 1、选择low-mid-high中的中位数
 * 2、随机选择基准
 */

/**
 * 快速排序，3个while循环
 */
class QuickSort {
    public static void main(String[] args) {
        int[] array = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        sort(array, 0, 9);
        //quickSort(array,0,9);
        System.out.print(Arrays.toString(array));
    }

    private static void sort(int[] array, int low, int high) {
        int index = partitionHole(array, low, high);
        if (index > low)
            sort(array, low, index - 1);
        if (high > index)
            sort(array, index + 1, high);
    }

    private static int partition(int[] array, int left, int right) {
        int key = array[left];
        int low = left;
        int high = right;


        while (high > low) {
            while (array[high] >= key && high > low) {
                high--;
            }

           /* if (array[high] <= key){
                int temp = array[low];
                array[low] =array[high];
                array[high] = temp;
            }*/


            while (array[low] <= key && high > low) {
                low++;
            }

           /* if (array[low] >= key){
                int temp = array[low];
                array[low] =array[high];
                array[high] = temp;
            }*/

            if (array[low] >= key && array[high] <= key) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }


        }

        array[left] = array[low];
        array[low] = key;

        return high;//or return low
    }


    /**
     * 左右指针法
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partitionByTwoPointer(int[] array, int low, int high) {
        int key = array[low];
        int left = low;
        int right = high;
        while (right > left) {
            while (right > left && array[right] >= key) {
                right--;
            }

            while (right > left && array[left] <= key) {
                left++;
            }

            if (array[left] >= key && array[right] <= key) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }


        }

        array[low] = array[right];
        array[right] = key;

        return right;
    }

    /**
     * 挖坑实现法1
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partitionHole(int[] array, int low, int high) {
        int key = array[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            if (array[right] <= key) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

            while (left < right && array[left] <= key) {
                left++;
            }
            if (array[left] >= key) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        return right;

    }

    /**
     * 挖坑实现方法2
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partitionHole2(int[] array, int low, int high) {
        int left = low;
        int right = high;
        int key = array[low];

        while (left < right) {
            while (array[right] >= key && right > left) {
                right--;
            }
            if (right > left) {
                array[left++] = array[right];
            }

            while (array[left] <= key && right > left) {
                left++;
            }

            if (right > left) {
                array[right--] = array[left];
            }
        }

        array[right] = key;
        return right;

    }

    public static void quickSort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];


        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) quickSort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) quickSort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个
    }


    /**
     * 算法导论的方法，将最后的数作为key piovt基准值
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partitionSuanfaDaolun(int[] array, int low, int high) {
        int i = low - 1;
        int j = low;
        int key = array[high];

        while (i <= j && i < high && j < high) {
            if (array[j] <= key) {
                int temp = array[++i];
                array[i] = array[j];
                array[j++] = temp;
            } else {
                j++;
            }
        }
        return i;

    }
}
