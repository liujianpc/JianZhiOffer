package leetcode;

/**
 * Date: 2019/3/16
 * Created by LiuJian
 *
 * @author LiuJian
 */

class GuessNumber {

    private int getTarget(int n) {
        int front = 1;
        int tail = n;
        while (front < tail) {
            int mid = front + (tail - front) / 2;
            if (guess(mid) == 1) {
                tail = mid - 1;
            } else if (guess(mid) == -1) {
                front = mid + 1;
            } else if (guess(mid) == 0) {
                return mid;
            }
        }
        return front;
    }

    private int guess(int mMid) {
        return 1;
    }
}
