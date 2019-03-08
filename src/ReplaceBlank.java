/**
 * Date: 2019/1/2
 * Created by Liuian
 */

/**
 * 从后面开始遍历
 * 使用两个指针，可以减少移动次数
 */
class ReplaceBlank {

    private String replace(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }


        //用c的方式寫
       /* int index = 0;
        while(str.charAt(index) != '\0'){
            index++;
        }
        int blankCount = 0;
        for (int i = 0; i <= index; i++) {
            if (str.charAt(index) == ' '){
                blankCount++;
            }
        }
        char[] newString = new char[index + 2 * blankCount];
        int previous = index;
        int behind = newString.length - 1;
        while(previous >= 0 && behind >= 0 && behind > previous){
            char c = str.charAt(previous);
            if ( c != ' '){
                newString[behind] = c;
                behind--;
            }else{
                newString[behind] = '0';
                newString[--behind] = '2';
                newString[--behind] = '%';
            }
            previous--;

        }
        return new String(newString);*/

        //使用java的stringbuilder方法
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("%20");
            }
        }

        return new String(stringBuilder);


    }
}
