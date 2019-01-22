/**
 * Date: 2019/1/4
 * Created by Liuian
 */

/**
 * 插值查找法，二分查找的变种
 */
class InjectSearch {

    private int injectSearch(int[] array,int key){
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while(array[low] != array[high] && key >= array[low] && key <= array[high]){
            mid = low + (high - low)*(key - array[low])/(array[high] - array[low]);
            if (mid < low){
                return -1;
            }
            if (array[mid] > key){
                high = mid -1;
            }else if (array[mid] < key){
                low = mid + 1;
            }else {
                return mid;
            }
        }

        if (key  == array[low]) return low;
        return -1;
    }
}
