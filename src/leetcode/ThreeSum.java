package leetcode;

/**
 * Date: 2019/3/15
 * Created by LiuJian
 *
 * @author LiuJian
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个数组和一个目标值(0)，找出数组中的三个元素（元素之和为目标值）
 * 1、排序
 * 2、双指针
 */
class ThreeSum {

    private List<List<Integer>> getThreeIndex(int[] array, int target) {


        List<List<Integer>> lists = new ArrayList<>();
        int right = array.length - 1;
        int[] copyArray = Arrays.copyOf(array, array.length);
        Arrays.sort(copyArray);
        int[] indexies = new int[3];
        for (int left = 0; left <= right && copyArray[left] < 0; left++) {
            int mid = left + 1;
            int temp = target - copyArray[left];

            if (left > 0 && copyArray[left] == copyArray[left - 1]) {
                continue;
            }

            while (mid < right) {
                while (copyArray[mid] + copyArray[right] > temp && mid < right) {
                    right--;
                }

                if (copyArray[mid] + copyArray[right] == temp) {
                    while (copyArray[mid] + copyArray[right - 1] == temp) {
                        right--;
                    }

                    lists.add(Arrays.asList(copyArray[left], copyArray[mid], copyArray[right]));
                }


                while (copyArray[mid] + copyArray[right] < temp && mid < right) {
                    left++;
                }

                if (copyArray[mid] + copyArray[right] == temp) {
                    while (copyArray[mid + 1] + copyArray[right] == temp) {
                        mid++;
                    }


                    lists.add(Arrays.asList(copyArray[left], copyArray[mid], copyArray[right]));

                }
            }
        }

        return lists;

    }


}
