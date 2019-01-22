/**
 * Date: 2019/1/5
 * Created by Liuian
 */

/**
 * 選擇排序
 */
class SelectSort {

    private void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j <array.length; j++) {
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }

            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
