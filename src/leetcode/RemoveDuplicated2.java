package leetcode;

/**
 * Date: 2019/3/15
 * Created by LiuJian
 *
 * @author LiuJian
 */

/**
 * 给定义一个数组和一个基准值，去除元素中的所有该值，返回剔除该值后的长度
 * 1、前后指针
 * 2、把所有等于该值的数都放到最后（交换）
 */
class RemoveDuplicated2 {

    private int getRemovedLen(int[] array, int target) {
        int front = 0;
        int tail = array.length - 1;
        while (front <= tail) {
            if (array[front] == target && array[tail] != target) {
                array[front] = array[tail];
                array[tail] = target;
            }
            if (array[front] != target) {
                front++;
            }
            if (array[tail] == target) {
                tail--;
            }
        }
        return tail + 1;
    }


    private int getRemovedLen2(int[] array, int target) {
        int front = 0;
        int tail = array.length - 1;
        while (front <= tail) {
            while (array[front] != target && front <= tail) {
                front++;
            }

            while (array[tail] == target && front <= tail) {
                tail--;
            }

            if (array[front] == target && array[tail] != target) {
                array[front] = array[tail];
                array[tail] = target;

            }
        }
        return tail + 1;
    }


    private int getRemovedLen3(int[] array, int target) {
        int newLen = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != target) {
                array[newLen++] = array[i];
            }
        }
        return newLen;
    }
}
