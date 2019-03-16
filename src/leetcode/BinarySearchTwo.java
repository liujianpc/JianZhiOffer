package leetcode;

/**
 * Date: 2019/3/16
 * Created by LiuJian
 *
 * @author LiuJian
 */

/**
 * 二分查找：
 * 1、给定一个有序数组和值，找出数组中值的开始位置和结束位置
 */
class BinarySearchTwo {

    private int[] getTargetBeginAndEnd(int[] array, int target) {

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (array[low] != target) {
            return result;
        }

        result[0] = low;


        high = array.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2 + 1;
            if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        result[1] = high;

        return result;
    }


}
