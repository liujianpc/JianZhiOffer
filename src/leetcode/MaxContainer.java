package leetcode;

/**
 * Date: 2019/3/15
 * Created by LiuJian
 *
 * @author LiuJian
 */

class MaxContainer {


    /**
     * 第一种方法，两重for循环遍历
     *
     * @param array
     * @return
     */
    private int[] getTheMaxContainer(int[] array) {
        int max = Integer.MIN_VALUE;
        int max_i = -1;
        int max_j = -1;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int volume = getVolume(i, j, array);
                if (volume > max) {
                    max = volume;
                    max_i = i;
                    max_j = j;
                }

            }
        }

        int[] maxContainer = new int[2];
        maxContainer[0] = array[max_i];
        maxContainer[1] = array[max_j];
        return maxContainer;
    }

    private int getVolume(int i, int j, int[] array) {

        return Math.min(array[i], array[j]) * (j - i);
    }


    /**
     * 双指针方法
     *
     * @param array
     * @return
     */
    private int[] getMaxContainer2(int[] array) {
        int front = 0;
        int tail = array.length - 1;
        int max = Integer.MIN_VALUE;
        int temp;
        while (front < tail) {
            if (array[front] < array[tail]) {
                temp = getVolume(front,tail,array);
                front++;
            } else {
                temp = getVolume(front,tail,array);
                tail--;
            }

            if (temp > max) {
                max = temp;
            }


        }

        int[] maxContainer = new int[2];
        maxContainer[0] = front;
        maxContainer[1] = tail;
        return maxContainer;

    }

}
