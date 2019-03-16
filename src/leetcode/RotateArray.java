package leetcode;

/**
 * Date: 2019/3/16
 * Created by LiuJian
 *
 * @author LiuJian
 */

/**
 * 有序数组，旋转后查找
 */
class RotateArray {

    private int getTarget(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int temp = array[mid] > array[array.length - 1] == target > array[array.length - 1] ? array[mid]
                    : target < array[array.length - 1] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (temp > target) {
                high = mid - 1;
            } else if (temp < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return array[low] == target ? low : -1;
    }

}

