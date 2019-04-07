/**
 * Date: 2019/4/7
 * Created by LiuJian
 *
 * @author LiuJian
 */

/**
 * 基数排序
 */
class RadixSort {

    private static final int MAX_LEN = 10;

    void radixSort(int[] array) {
        int[] bucket = new int[MAX_LEN];
        int maxVal = 0;
        int digitPosition = 1;

        //找出最大值，确定循环的次数
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        while (maxVal / digitPosition > 0) {
            //0-9的基数数据，统计每个基数的存放的元素个数
            int[] digitCount = new int[10];

            //根据基数找到应该放在哪个基数对应的数组，且将该基数数组的个数增加
            for (int i = 0; i < array.length; i++) {
                digitCount[array[i] / digitPosition % 10]++;
            }
            //统计总的个数，来确定下一轮的位置
            for (int i = 0; i < 10; i++) {
                digitCount[i] += digitCount[i - 1];

            }

            //逆序遍历，保证排序的稳定性,基数排序操作开始，将元素按基数放进新bucket
            for (int i = array.length - 1; i >= 0; i--) {

                bucket[--digitCount[array[i] / digitPosition % 10]] = array[i];

            }

            System.arraycopy(bucket, 0, array, 0, array.length);

            digitPosition *= 10;
        }



    }
}
