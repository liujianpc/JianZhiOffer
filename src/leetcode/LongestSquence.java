package leetcode;

/**
 * Date: 2019/3/16
 * Created by LiuJian
 *
 * @author LiuJian
 */

/**
 * 给定一个字符串，找出字串中没有重复字符的最大字串
 * 动态规划：
 * 1、所有字符都是再256以内
 * 2、一个256数组来标记出现
 * 3、如果已经出现，则后指针跳转到第一次出现的下一个位置
 * 4、如果未出现，则前指针后移
 * 5、统计len大小
 *
 */
class LongestSquence {

    private int getMaxLen(String s) {
        int[] hash = new int[256];
        int i = 0;
        int j = 0;
        int len = 0;
        while (i < s.length() && j < s.length()) {
            if (hash[s.charAt(j)] == 1) {
                while (s.charAt(i) != s.charAt(j)) {
                    hash[s.charAt(i++)] = 0;
                }
                i++;
            }
            hash[s.charAt(j)] = 1;
            j++;
            len = Math.max(len, j - i);

        }

        return len;
    }
}
