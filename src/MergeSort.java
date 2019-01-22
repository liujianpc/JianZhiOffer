/**
 * Date: 2019/1/5
 * Created by Liuian
 */

import java.util.Arrays;

/**
 * 归并排序
 */
class MergeSort {

    private int[] mergeSort(int[] array){
        if (array == null){
            return null;
        }
        if (array.length == 1){
            return array;
        }

        int mid = array.length / 2;
        int[] leftArray = Arrays.copyOfRange(array,0,mid);
        int[] rightArray = Arrays.copyOfRange(array,mid,array.length);
        return mergeArray(mergeSort(leftArray),mergeSort(rightArray));

    }

    private int[] mergeArray(int[] leftArray, int[] rightArray) {

        int[] newArray = new int[leftArray.length+ rightArray.length];
        for (int i = 0, index = 0, j = 0; index< newArray.length; i++,j++,index++) {

            if (i > leftArray.length){
                newArray[index] = rightArray[j++];
            }
            else if (j > rightArray.length){
                newArray[index] = leftArray[i++];
            }else if (leftArray[i] > rightArray[j]){
                newArray[index] = rightArray[j++];
            }else {
                newArray[index] = leftArray[i++];
            }

        }
        return newArray;
    }


}
