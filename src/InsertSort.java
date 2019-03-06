/**
 * Date: 2019/1/5
 * Created by Liuian
 */

/**
 * 插入排序
 */
class InsertSort {

    private void insertSort(int[] array){
        if (array.length == 1){
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i + 1];
            int preIndex = i;
            while (current < array[preIndex] && preIndex >= 0){//也可以改成for(int j = i; current < array[i]&& i >= 0; j - 1)
                array[preIndex + 1] = array[preIndex];
                preIndex--;

            }
            array[preIndex + 1] = current;
        }
    }
}
