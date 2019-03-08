/**
 * Date: 2019/1/4
 * Created by Liuian
 */

/**
 * 斐波那契查找算法
 * 1、先构造一个斐波那契数组
 * 2、斐波那契最大值作为填充数组的长度
 * 3、变种二分法
 */
class FibonacciSearch {
    private int fibonacciSearch(int[] array, int key) {
        int fibonacciLen = getFibonacciLen(array);
        int[] fibonacciArray = new int[fibonacciLen];

        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        for (int i = 2; i < fibonacciLen; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }

        int filledArrayLen = fibonacciArray[fibonacciLen - 1];
        int[] filledArray = new int[filledArrayLen];
        System.arraycopy(array, 0, filledArray, 0, filledArrayLen);

        for (int i = array.length; i < fibonacciLen; i++) {
            filledArray[i] = array[array.length - 1];
        }

        int low = 0;
        int high = array.length - 1;
        int mid = -1;
        int k = fibonacciLen - 1;
        while (low < high) {
            mid = low + fibonacciArray[k-1] - 1;

            if (filledArray[mid] > key) {
                high = mid - 1;
                k = k - 1;
            } else if (filledArray[mid] < key) {
                low = mid + 1;
                k = k - 2;
            } else {
                if (filledArray[mid] == key) {
                    return mid;
                }

                if (mid > high) {
                    return high;
                }
            }
        }

        return -1;
    }

    /**
     * 获得斐波那契长度
     *
     * @param array
     * @return
     */
    private int getFibonacciLen(int[] array) {

        int f1 = 1;
        int f2 = 1;
        int f3 = 2;
        int fibonacciLen = 2;
        while (f3 < array.length) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
            fibonacciLen++;
        }
        return fibonacciLen;
    }
}
