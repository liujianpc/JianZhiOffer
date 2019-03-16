package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Date: 2019/3/15
 * Created by LiuJian
 *
 * @author LiuJian
 */

class FourSum {

    /**
     * 第一种方法：分割成三个数和的问题
     *
     * @param array
     * @param target
     * @return
     */
    private List<List<Integer>> getFourSum(int[] array, int target) {

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(array);
        for (int left = 0; left < array.length - 3; left++) {

            int temp = target - array[left];

            if (left > 0 && array[left] == array[left - 1]) {
                continue;
            }

            for (int left2 = left + 1; left2 < array.length - 2; left2++) {
                int temp2 = temp - array[left2];
                if (left2 > 0 && array[left2] == array[left2 - 1]) {
                    continue;
                }
                int mid = left2 + 1;
                int right = array.length - 1;
                while (mid < right) {
                    if (array[mid] + array[right] == temp2) {
                        lists.add(Arrays.asList(array[left], array[left2], array[mid], array[right]));

                        while (array[mid] + array[right - 1] == temp2) {
                            right--;
                        }

                        while (array[mid + 1] + array[right] == temp2) {
                            mid++;
                        }
                    } else if (array[mid] + array[right] > temp2) {
                        right--;
                    } else {
                        mid++;
                    }
                }
            }
        }
        return lists;
    }

    /**
     * 第二种：优化，最小最大，等于极端情况的优化
     *
     * @param array
     * @param target
     * @return
     */
    private List<List<Integer>> getFourSum2(int[] array, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(array);
        for (int left = 0; left < array.length - 3; left++) {
            if (4 * array[left] > target) {
                return null;
            } else if (4 * array[array.length - 1] < target) {
                return null;
            } else if (4 * array[left] == target) {
                if (left + 3 < array.length && array[left + 3] == array[left]) {
                    lists.add(Arrays.asList(array[left], array[left + 1], array[left + 2], array[left + 3]));
                }
            } else if (4 * array[left] < target) {
                lists.addAll(getThreeSum(array, target - array[left], lists, left));
            }

        }
        return lists;

    }

    private Collection<? extends List<Integer>> getThreeSum(int[] mArray, int mTarget, List<List<Integer>> mLists, int mLeft) {
        for (int left = mLeft + 1; left < mArray.length - 2; left++) {
            if (3 * mArray[left] > mTarget) {
                return null;
            } else if (3 * mArray[left] == mTarget) {
                if (left + 2 < mArray.length && mArray[left + 2] == mArray[left]) {
                    mLists.add(Arrays.asList(mLeft, mArray[left], mArray[left + 1], mArray[left + 2]));
                }
            } else if (3 * mArray[mArray.length - 1] < mTarget) {
                return null;
            } else if (3 * mArray[left] < mTarget) {
                mLists.addAll(getTwoSum(mArray, mTarget - mArray[left], mLists, mLeft, left));
            }
        }

        return mLists;

    }

    private Collection<? extends List<Integer>> getTwoSum(int[] mArray, int target, List<List<Integer>> mLists, int firstLeft, int mLeft) {
        int front = mLeft + 1;
        int tail = mArray.length - 1;

        while (front < tail) {
            while (mArray[front] + mArray[tail] > target && front < tail) {
                tail--;
            }

            if (mArray[front] + mArray[tail] == target) {
                mLists.add(Arrays.asList(mArray[firstLeft], mArray[mLeft], mArray[front], mArray[tail]));
            }
            while (mArray[front] + mArray[tail] < target) {
                front++;
            }

            if (mArray[front] + mArray[tail] == target) {
                mLists.add(Arrays.asList(mArray[firstLeft], mArray[mLeft], mArray[front], mArray[tail]));
            }


        }
        return mLists;

    }
}
