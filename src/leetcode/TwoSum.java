package leetcode;

/**
 * Date: 2019/3/15
 * Created by LiuJian
 *
 * @author LiuJian
 */

import java.util.Arrays;

/**
 * 从一个数组中找出，两个元素，两个元素的和为目标值。返回这两个元素的下标
 * 1、两层for
 * 2、两个前后指针
 */
class TwoSum {

    private int[] getIndexies(int[] array, int target){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i]+ array[j] == target){
                    int[] indexies = new int[2];
                    indexies[0] = i;
                    indexies[1] = j;
                    return indexies;
                }
            }
        }
        return null;
    }

    /**
     * 前後指針法
     * 1、先排序
     * 2、前后指针，类似快排
     * 3、找到原来数组中的位置
     * @param array
     * @param target
     * @return
     */
    private int[]  getIndexByTwoPointer(int[] array, int target){


        int[] copyArray = Arrays.copyOf(array,array.length);
        Arrays.sort(copyArray);
        int front = 0;
        int tail = array.length - 1;
        int[] indexies = new int[2];
        while (front < tail){

            while (copyArray[front] + copyArray[tail] > target && front < tail){
                tail--;
            }

            if (copyArray[front] + copyArray[tail] == target){

                indexies[0] = copyArray[front];
                indexies[1] = copyArray[tail];
                break;
            }


            while (copyArray[front] + copyArray[tail] < target && front < tail){
                front++;
            }

            if (copyArray[front] + copyArray[tail] == target){
                indexies[0] = copyArray[front];
                indexies[1] = copyArray[tail];
                break;
            }
        }

        int count = 0;
        int[] arrayIndex = new int[2];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == indexies[0] || array[i] == indexies[1]){
                arrayIndex[count++] = i;
            }
        }


        return arrayIndex;
    }
}
