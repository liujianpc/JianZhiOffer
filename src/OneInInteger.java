/**
 * Date: 2019/1/2
 * Created by Liuian
 */

class OneInInteger {

    public static void main(String[] args){
        System.out.print(getZeros(8));
    }

    private int getOnes(int n) {
        int total = 0;
        while (n != 0) {
            total++;
            n = n & (n - 1);
        }

        return total;
    }

    private static int getZeros(int n) {
        int total = 0;
        while (n + 1 != 0) {
            total++;
            n = n | (n + 1);
        }

        return total;
    }
}
