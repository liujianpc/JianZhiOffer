/**
 * Date: 2019/1/21
 * Created by Liuian
 */

import java.util.Arrays;

/**
 * 场景：最大公共子序列、最大公共子串、求回文（逆转后DP）、求编辑距离、求字符串相似度
 * 最大公共子序列   注意区别最大公共子序列和最大公共子串（必须是连续）
 * 1、动态规划实现
 * 2、递归打印最大子序列
 */
class MaxCommonSequence {

    public static void main(String[] args) {
        String str_a = "abcdefghjklmn";//"cnblogs"; //"abcdefghjklmn";
        String str_b = "affbfcfaglkm";//"belong";//"affbfcfaglkm";
        int[][] flags = new int[str_a.length() + 1][str_b.length() + 1];
        //System.out.println("this common lCS--->"+findLCS(str_a,str_a.length(),str_b,str_b.length()));
        System.out.println("this common LCS is-->" + maxCommonSequenceLCS(str_a, str_b, flags));


        String s1 = "erecadhssjdgd";
        String s2 = "abcadhssjda";
        System.out.println("common String--->" + getMaxCommonZichuan2(s1, s2));
        printLCS(str_a, str_a.length(), str_b.length(), flags);
    }

    private static void printLCS(String str1, int len_a, int len_b, int[][] flags) {
        if (len_a == 0 || len_b == 0) {
            return;
        }

        if (flags[len_a][len_b] == 0) {
            printLCS(str1, len_a - 1, len_b - 1, flags);
            System.out.println("--" + str1.charAt(len_a - 1));
        } else if (flags[len_a][len_b] == 1) {
            printLCS(str1, len_a - 1, len_b, flags);
        } else if (flags[len_a][len_b] == 2) {//相等情况下可以打印出不同的数
            printLCS(str1, len_a, len_b - 1, flags);
        } else {
            printLCS(str1, len_a, len_b - 1, flags);
        }
    }

    private static int maxCommonSequenceLCS(String str1, String str2, int[][] flags) {

        if (str1 == null || str2 == null) {
            return 0;
        }

        int len_a = str1.length();
        int len_b = str2.length();
        int[][] array = new int[len_a + 1][len_b + 1];

        //第一行第一列
        //第一列，全部置位0
        for (int i = 0; i <= len_a; i++) {
            array[i][0] = 0;
        }
        //第一行，全部置位0
        for (int j = 0; j <= len_b; j++) {
            array[0][j] = 0;
        }

        System.out.println("the first row-->" + Arrays.toString(array[0]));

        for (int i = 1; i <= len_a; i++) {
            for (int j = 1; j <= len_b; j++) {
                char char1 = str1.charAt(i - 1);
                char char2 = str2.charAt(j - 1);
                if (char1 == char2) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                    flags[i][j] = 0;
                } else if (array[i - 1][j] > array[i][j - 1]) {
                    array[i][j] = array[i - 1][j];
                    flags[i][j] = 1;//上方向
                } else if (array[i - 1][j] == array[i][j - 1]) {
                    array[i][j] = array[i - 1][j];
                    flags[i][j] = 2;
                } else {
                    array[i][j] = array[i][j - 1];
                    flags[i][j] = -1;//左方向
                }
            }
        }

        //负责打印公共子序列
       /* Stack<Character> stack = new Stack<>();
        int i = len_a - 1;
        int j = len_b - 1;
        while (i >= 0 && j >= 0) {
            if (str1.charAt(i) == str2.charAt(j)) {
                stack.push(str1.charAt(i));
                i--;
                j--;

            } else {
                if (array[i + 1][j] > array[i][j + 1]) {
                    j--;
                } else {
                    i--;
                }
            }

        }

        while (!stack.isEmpty()) {
            System.out.print("~~~" + stack.pop());
        }*/
        return array[len_a][len_b];
    }


    public static int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n + 1][m + 1];
        /*for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }*/
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }


    /**
     * 公共子串  子串和子序列是不一样的
     * 状态转移方程：f（i,j） = f(i-1, j-1) + 1,当 a[i-1] = b[j-1]
     * 其他时候：f(i,j) = 0;
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int getMaxCommonZichuan(String str1, String str2) {
        int len_a = str1.length();
        int len_b = str2.length();
        int[][] array = new int[len_a + 1][len_b + 1];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i <= len_a; i++) {
            for (int j = 0; j <= len_b; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 0;
                } else {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        array[i][j] = array[i - 1][j - 1] + 1;
                        result = Math.max(result, array[i][j]);

                    } else {
                        array[i][j] = 0;
                    }
                }
            }
        }

        return result;
    }


    /**
     * 找出公共的字符串
     *
     * @param str1
     * @param str2
     * @return
     */

    public static String getMaxCommonZichuan2(String str1, String str2) {

        int len_a = str1.length();
        int len_b = str2.length();

        int[] maxIndexies = new int[Math.max(len_a, len_b)];
        int max = 0;
        int sign = -1;


        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        maxIndexies[j] = 1;
                        if (max == 0) {
                            max = 1;
                            sign = j;
                        }
                    } else {
                        maxIndexies[j] = maxIndexies[j - 1] + 1;
                        if (maxIndexies[j] > max) {
                            max = maxIndexies[j];
                            sign = j;
                        }
                    }
                }
            }

        }

        char[] charArray = str2.toCharArray();
        return new String(charArray, sign - max + 1, max);

    }

    /**
     * 双重for切割  n^3
     * @param a
     * @param b
     * @return
     */
    public int getMaxZichuanLen(String a, String b) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    int tempI = i;
                    int tempJ = j;
                    int total = 0;
                    while (tempI < a.length() && tempJ < b.length() && a.charAt(tempI) == b.charAt(tempJ)) {
                        tempI++;
                        tempJ++;
                        total++;
                    }
                    if (total > max) {
                        max = total;
                    }

                }
            }
        }

        return max;
    }


    public int getMaxZichuanSize(String a, String b) {
        int len_a = a.length();
        int len_b = b.length();

        int max = Integer.MIN_VALUE;
        int[][] array = new int[len_a + 1][len_b + 1];

        for (int i = 0; i < len_a + 1; i++) {
            array[i][0] = 0;
        }

        for (int j = 0; j < len_b + 1; j++) {
            array[0][j] = 0;
        }


        int maxIndex = -1;
        for (int i = 1; i < len_a + 1; i++) {
            for (int j = i; j < len_b + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j - 1] + 1;

                    if (array[i][j] > max) {
                        max = array[i][j];
                        maxIndex = j;
                    }
                } else {
                    array[i][j] = 0;
                }
            }
        }

        String maxCommonString = new String(b.toCharArray(), maxIndex - max + 1, max);
        return max;


    }

}
