/**
 * Date: 2019/1/5
 * Created by Liuian
 */

/**
 * 希尔排序，简单插入排序的一个变种
 */
class ShellSort {


    private void shellSort(int[] array){
        int gap = array.length / 2;
        while (gap > 0){
            for (int i = 0; i < array.length - 1; i++) {
                int current = array[i + 1];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > current){
                    array[preIndex+gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex+gap] = current;
            }
            gap = gap / 2;
        }
    }
}
