package niuke.sword.offer;

/**
 * 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字
 * 符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * @Author : Heper
 * @Time : 2019/2/4 14:09
 */
public class Match {
    public boolean match(char[] str, char[] pattern) {
        //如果匹配字符串为空,则只能有两种情况
        //情况1:字符串为空,则true
        //情况2:字符串不空,缺乏匹配条件,false
        if (pattern.length == 0) {
            //简洁的写法
            return str.length == 0;
        }
        /**
         * 递归的尝试
         */
        return matchChar(str, 0, pattern, 0);
    }

    /**
     * 递归匹配
     * 判断准则:
     * 首先判断对应位置的字符是否相等,
     * 相等,则true,进行下一次迭代
     * 不相等,则判断该字符是否为特殊字符"."与该字符的下一个字符是否为"*"
     * 若是".",则true,若下一个字符为"*",则true,并跳到下下个字符
     * 否则false
     * <p>
     * 判断是否达到边界
     *
     * @param str
     * @param strIndex
     * @param pattern
     * @param patIndex
     * @return
     */
    public boolean matchChar(char[] str, int strIndex, char[] pattern, int patIndex) {
        //考虑*的情况,使得字符串长度为0
        if (str.length == 0) {
            if (pattern.length == 2 && pattern[1] == '*') {
                return true;
            } else {
                return false;
            }
        }
        //如果索引同时到达了末尾
        if (strIndex == str.length && patIndex == pattern.length) {
            return true;
            //如果部分到达,则说明另一个没有完结,即匹配失败
        } else if (strIndex == str.length) {
            if (patIndex + 2 == pattern.length && pattern[patIndex + 1] == '*') {
                return true;
            } else {
                return false;
            }
        }
        if (patIndex + 1 < pattern.length && pattern[patIndex + 1] == '*') {
            if (pattern[patIndex] == str[strIndex] || pattern[patIndex] == '.') {
                return matchChar(str, strIndex + 1, pattern, patIndex);
            } else {
                return matchChar(str, strIndex + 1, pattern, patIndex + 2);
            }
        } else {
            //与*无关的情况
            if (str[strIndex] != pattern[patIndex] && pattern[patIndex] != '.') {
                return false;
            } else {
                return matchChar(str, strIndex + 1, pattern, patIndex + 1);
            }
        }
    }


    /**
     * 更优的方案
     *
     * @param str
     * @param strIndex
     * @param pattern
     * @param patternIndex
     * @return
     */
    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                //Fixme:三种匹配模式的方法
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Match match = new Match();
        char[] str = {'a', 'a', 'a'};
        char[] pattern = {'a', '*', 'a'};

        match.match(str, pattern);
    }
}
