package leetcode;

/**
 * Date: 2019/3/15
 * Created by LiuJian
 *
 * @author LiuJian
 */

import java.util.Arrays;

/**
 * 给出一个数组和一个目标值，找出数组中三个元素，三个元素的和与目标值最接近
 * 1、排序
 * 2、双指针（三指针）
 * 3、遍历，保存最小
 */
class ThreeClosestSum {

    private int[] getThreeIndexies(int[] array, int target) {
        int[] copyArray = Arrays.copyOf(array, array.length);
        int[] threeNumbers = new int[3];

        Arrays.sort(copyArray);
        int min = copyArray[0] + copyArray[1] + copyArray[2];
        for (int left = 0; left < array.length - 2; left++) {
            int mid = left + 1;
            int right = array.length - 1;
            int temp = target - copyArray[left];
            while (mid < right) {
                if (Math.abs(temp - copyArray[mid] - copyArray[right]) < Math.abs(target - min)) {
                    min = temp - copyArray[mid] - copyArray[right];
                }

                if (copyArray[mid] + copyArray[right] == temp) {
                    threeNumbers[0] = copyArray[left];
                    threeNumbers[1] = copyArray[mid];
                    threeNumbers[2] = copyArray[right];
                    return threeNumbers;
                } else if (copyArray[mid] + copyArray[right] > temp) {
                    right--;
                } else {
                    mid++;
                }
            }
        }

        int[] threeIndexis = new int[3];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == threeNumbers[0] || array[i] == threeNumbers[1] || array[i] == threeNumbers[2]) {
                threeIndexis[count++] = i;
            }
        }

        return threeIndexis;

    }


}
