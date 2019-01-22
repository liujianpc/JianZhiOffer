/**
 * Date: 2019/1/2
 * Created by Liuian
 */

class Fibonacci {

    private long fibonacci(int n) {

        if (n <= 1) {
            return n;
        }
        long f0 = 0;
        long f1 = 1;
        long f2 = 0;
        for (int i = 2; i <= n; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }

        return f2;

    }
}
