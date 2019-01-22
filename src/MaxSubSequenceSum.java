/**
 * Date: 2019/1/20
 * Created by Liuian
 */

/**
 * 连续子数组的最大和
 * 1、遍历数组方式
 * 2、动态规划方式
 */
class MaxSubSequenceSum {


    public static void main(String[] args) {
        int[] a = {-2, 11, -4, 13, -5, -2};
        System.out.print(getMaxSubSequenceSum(a));
    }

    /**
     * 双重for循环
     *
     * @param array
     * @return
     */
    public static int getMaxSubSequenceSum(int[] array) {

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int sum = Integer.MIN_VALUE;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int maxCurr = 0;
            for (int j = i; j < len; j++) {
                maxCurr += array[j];
                if (maxCurr > sum) {
                    sum = maxCurr;
                }
            }
        }

        return sum;
    }

    /**
     * 动态规划
     * 分解：设fk为以k游标结束的子数组的最大和。（k满足0到n），
     * 则只需要求max（fk）（0<=k<n）
     * fk = a[k] 当 f[k] < 0
     * <p>
     * fk = fk-1 + a[k]  当 f[k-1] > 0
     * 状态转移方程： sum[i]=max(sum[i-1]+a[i],a[i])
     */

    public static int getMaxSubSum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int max = Integer.MIN_VALUE;
        int maxCurr = Integer.MIN_VALUE;//或者二者初始化成  a[0],然后内部不要i=0的判断你
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                maxCurr = array[0];
            } else if (maxCurr >= 0) {
                maxCurr += array[i];
            } else if (maxCurr < 0) {
                maxCurr = array[i];
            }

            if (maxCurr > max) {
                max = maxCurr;
            }

        }

        return max;


    }
}
