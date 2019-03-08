/**
 * Date: 2019/1/2
 * Created by Liuian
 */

import java.util.Arrays;

/**
 * 查找升序排列的数组，旋转后的数组，求旋转后数组的最小值
 * 利用二分查找法
 */
class RotateArrayMin {

    private static int searchMin(int[] array){

        if (array == null){
            throw new IllegalArgumentException("输入的数组错误");
        }

        if (array.length == 1){
            return array[0];
        }
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while(array[low] >= array[high] && low < high){
            if (high - low == 1){
                mid = high;
                break;
            }
            mid = low + (high - low) /2; //防止溢出
            if (array[mid] == array[low] && array[low] == array[high]){
                //利用for循環查找
            }else if (array[mid] > array[low]){//左边区间
                low = mid + 1;
            }else if (array[mid] < array[high]){//在右边区间
                high = mid - 1;
            }
        }

        return array[mid];
    }


    public static void main(String[] args){
        int[] array = new int[]{4,5,6,7,8,9,1,2,3};
        System.out.println(searchMin(array));
    }
}
