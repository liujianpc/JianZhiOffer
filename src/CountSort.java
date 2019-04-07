/**
 * Date: 2019/4/7
 * Created by LiuJian
 *
 * @author LiuJian
 */

/**
 * 计数排序：
 * 1、找到最大值和最小值，确定需要多少个桶
 * 2、遍历列表，放进对应桶里
 * 3、遍历桶，放回原数组
 */
class CountSort {

    void countSort(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }

        int bucketSize = max - min + 1;
        int[] buckets = new int[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            buckets[array[i] - min]++;
        }

        for (int i = min,index = 0; i <= max; i++) {
            for (int j = 0; j < buckets[i - min]; j++) {
                array[index++] = i;
            }
        }
    }
}
