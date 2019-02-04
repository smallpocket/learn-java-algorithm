package niuke.sword.offer;

import java.util.LinkedList;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @Author : Heper
 * @Time : 2019/2/4 16:33
 */
public class FirstRepeat {
    LinkedList<Character> linkedList = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (linkedList.contains(ch)) {
            linkedList.removeFirstOccurrence(ch);
        } else {
            linkedList.add(ch);
        }
    }

    /**
     * 利用一个int型数组表示256个字符，这个数组初值置为-1.
     * 没读出一个字符，将该字符的位置存入字符对应数组下标中。
     * 若值为-1标识第一次读入，不为-1且》0表示不是第一次读入，将值改为-2.
     * 之后在数组中找到>0的最小值，该数组下标对应的字符为所求。
     */
//    //return the first appearence once char in current stringstream
//    public char FirstAppearingOnce() {
//        if (!linkedList.isEmpty()) {
//            return linkedList.getFirst();
//        } else {
//            return '#';
//        }
//    }
//
//    int count[]=new int[256];
//    //Insert one char from stringstream
//    int index=1;
//    public void Insert(char ch)
//    {
//        if(count[ch]==0){
//            count[ch]=index++;
//        }
//        else{
//            count[ch]=-1;
//        }
//    }
//    //return the first appearence once char in current stringstream
//    public char FirstAppearingOnce()
//    {
//        int temp=Integer.MAX_VALUE;
//        char ch='#';
//        for(int i=0;i<256;i++){
//            if(count[i]!=0&&count[i]!=-1&&count[i]<temp){
//                temp=count[i];
//                ch=(char)i;
//            }
//        }
//        return ch;
//    }
}
