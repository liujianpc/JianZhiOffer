/**
 * Date: 2019/1/5
 * Created by Liuian
 */

/**
 * 冒泡排序
 */
class BubbleSort {

    private void bubbleSort(int[] array){
        boolean exchanged = false;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1]= array[j];
                    array[j] = temp;
                    exchanged = true;
                }
            }
            if (!exchanged){
                break;
            }
        }
    }
}
