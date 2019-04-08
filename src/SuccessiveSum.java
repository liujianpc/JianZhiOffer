/**
 * Date: 2019/1/22
 * Created by Liuian
 */

/**
 * 一个数字可以表示成小于他自己的，连续几个数字的和
 */
class SuccessiveSum {


    public static void main(String[] args) {
        deconstruct(18);
        deconstruct2(20);
        deconstruct2(30);
        deconstruct2(40);
    }


    /**
     * 双重for循环
     * o(n^2)
     *
     * @param target
     */
    public static void deconstruct(int target) {

        for (int i = 1; i <= target / 2 + 1; i++) {
            int sum = 0;
            int start = i;
            int end;
            for (int j = i; j <= target / 2; j++) {

                sum += j;
                if (sum == target) {
                    end = j;
                    for (int k = start; k <= end; k++) {
                        System.out.print(k + "---");
                    }
                    System.out.println("\n");
                    break;
                }
            }
        }
    }

    /**
     * 利用等差数列公式  假设N是有k个连续的数相加而得，则有设第一个数为i。
     * 则，i+（i+1）+...+(i+k-1) = N
     * k*(2i+k-1)/2 = N, 则，i = N/k - k/2+1/2;而i，可以判断最大为 N/2+1；
     * o(n)
     *
     * @param target
     */
    public static void deconstruct2(int target) {

        int i;
        /**
         * 外部循环，先确定至多有k个数连续相加。内部判断，如果初始值，算出来是正整数，则就符合条件
         */
        for (int k = 1; k < target / 2 + 1; k++) {
            if ((2 * target / k - k + 1) % 2 == 0) {
                i = (2 * target / k - k + 1) / 2;

                if (i > 0 && i != 0) {
                    if (k > 1) {
                        for (int j = i; j < i + k; j++) {
                            System.out.print("---" + j);
                        }
                        System.out.print("\n");
                    }
                }
            }
        }

    }
}
