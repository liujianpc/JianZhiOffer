/**
 * Date: 2019/1/17
 * Created by Liuian
 */

import java.util.Random;

/**
 * 洗牌算法
 * 1、费雪耶茨算法
 */
class Shuffle {


    public static void shuffle(int[] array) {

        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;

        }

        int len = array.length;
        for (int i = len - 1; i >= 0; i--) {
            int randIndex = (new Random().nextInt(i + 1));
            int temp = array[i];
            array[i] = array[randIndex];
            array[randIndex] = temp;

        }
    }

    /**
     * 蓄水池抽样算法
     *
     * @param array 长度为n的蓄水池
     * @param n     蓄水池长度
     * @param k     收取K个样本
     */
    public static void reserviorSample(int[] array, int n, int k) {
        for (int i = k; i < n; i++) {
            int randIndex = new Random().nextInt(i + 1);
            if (randIndex < k) {
                int temp = array[i];
                array[i] = array[randIndex];
                array[randIndex] = temp;
            }


        }
    }

}
