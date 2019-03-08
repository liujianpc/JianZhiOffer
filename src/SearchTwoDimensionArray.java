/**
 * Date: 2019/1/2
 * Created by Liuian
 */

/**
 * 二维数组中查找，从右上角找起
 * 变种二分
 */
class SearchTwoDimensionArray {


    private boolean search(int[][] array, int target) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;
        while (row <= array.length - 1 && column >= 0) {

            if (array[row][column] > target) {
                column--;
            } else if (array[row][column] < target) {
                row++;
            } else {
                return true;
            }

        }
        return false;
    }
}
