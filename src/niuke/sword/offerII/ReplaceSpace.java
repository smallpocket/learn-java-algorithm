package niuke.sword.offerII;

/**
 * @author Heper
 * @title
 * @date 2019/3/8 20:04
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int len = str.length();
        int spaceNum = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        int newlen = len + spaceNum * 2;
        str.setLength(newlen);
        int oldlen = len - 1;
        int nowIndex = newlen - 1;
        for (; oldlen >= 0 && nowIndex >= 0; oldlen--) {
            if (str.charAt(oldlen) == ' ') {
                str.setCharAt(nowIndex--, '0');
                str.setCharAt(nowIndex--, '2');
                str.setCharAt(nowIndex--, '%');
            } else {
                str.setCharAt(nowIndex--, str.charAt(oldlen));
            }
        }
        return str.toString();
    }
}
