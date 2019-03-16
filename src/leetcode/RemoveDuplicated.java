package leetcode;

/**
 * Date: 2019/3/15
 * Created by LiuJian
 *
 * @author LiuJian
 */

/**
 * 去除有序列表的重复元素
 */
class RemoveDuplicated {

    private int removeDuplicated(int[] array) {
        int newLen = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                array[newLen] = array[i];
                newLen++;
            }
        }

        return newLen;

    }

}
