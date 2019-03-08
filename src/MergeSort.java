/**
 * Date: 2019/1/5
 * Created by Liuian
 */

import java.util.Arrays;

/**
 * 归并排序
 */
class MergeSort {

    private static int[] mergeSort(int[] array) {
        if (array == null) {
            return null;
        }
        if (array.length == 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] leftArray = Arrays.copyOfRange(array, 0, mid);
        int[] rightArray = Arrays.copyOfRange(array, mid, array.length);
        return mergeArray(mergeSort(leftArray), mergeSort(rightArray));

    }

    /**
     * 合并两个有序序列
     * @param leftArray
     * @param rightArray
     * @return
     */
    private static int[] mergeArray(int[] leftArray, int[] rightArray) {

        int[] newArray = new int[leftArray.length + rightArray.length];

        for (int i = 0, index = 0, j = 0; index < newArray.length; index++) {

            if (i > leftArray.length - 1) {
                newArray[index] = rightArray[j++];

            } else if (j > rightArray.length - 1) {
                newArray[index] = leftArray[i++];

            } else if (leftArray[i] > rightArray[j]) {
                newArray[index] = rightArray[j++];
            } else {
                newArray[index] = leftArray[i++];
            }

        }

        /*
        合并两个有序序列

         int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArray.length && j < rightArray.length && k < leftArray.length + rightArray.length) {
            if (leftArray[i] <= rightArray[j]){
                newArray[k] = leftArray[i];
                i++;
            }else {
                newArray[k] = rightArray[j];
                j++;
            }
            k++;

        }


        while (i < leftArray.length){
            newArray[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length){
            newArray[k] = rightArray[j];
            j++;
            k++;
        }*/
        return newArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 7, 10, 6, 5, 3, 4, 2, 11, 1};
        System.out.println(Arrays.toString(mergeSort(array)));
    }

}
