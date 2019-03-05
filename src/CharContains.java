/**
 * Date: 2019/2/21
 * Created by Liuian
 */

/**
 * 判断一个字符串s是否是另一个字符串t的子串
 * 不准用java  string，只能用char数组
 * 如果s是t的子串，则返回位置index
 * 否则返回-1
 */
class CharContains {

    public int contains(char[] s, char[] t){
        char s0 = s[0];
        int beginIndex = -1;
        for (int i = 0; i < t.length; i++) {
            if (s0 == t[i]){
                beginIndex = i;
                int j = 0;
                while (s[j] == t[beginIndex] && j < s.length && beginIndex < t.length){
                    j++;
                    beginIndex++;
                }
                if (j == s.length - 1){
                    return i;
                }
            }
        }
        return -1;
    }
}
