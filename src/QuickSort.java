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
 * 1、选择low-mid-high中的中位数，防止最差的情况  三数取中法：
 * 选择这组数据的第一个元素、中间的元素、最后一个元素，这三个元素里面值居中的元素作为基准数。
 * 2、随机选择基准
 * 3、小区间优化 当划分的子序列很小的时候(一般认为小于13个元素左右时)，
 * 我们在使用快速排序对这些小序列排序反而不如直接插入排序高效。
 * 因为快速排序对数组进行划分最后就像一颗二叉树一样，
 * 当序列小于13个元素时我们再使用快排的话就相当于增加了二叉树的最后几层的结点数目，增加了递归的次数。
 * 所以我们在当子序列小于13个元素的时候就改用直接插入排序来对这些子序列进行排序。
 * 4、
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
        int index = partitionSuanfaDaolun(array, low, high);
        if (index > low)
            sort(array, low, index - 1);
        if (high > index)
            sort(array, index + 1, high);
    }

    /**
     * 左右指针法：前后指针都是先遍历停下， 然后交换，最后将停下的碰撞点的值和基准数交换
     * @param array
     * @param left
     * @param right
     * @return
     */
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
     * 挖坑法，其实也是左右指针
     * 挖坑法是前后指针只要找到满足条件的就停下来做前后数据的交换。
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
     * 前后指针法
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

        while (i <= j && i <= high && j <= high) {
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
