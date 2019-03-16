package bytedis.exam.result;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/3/16 10:37
 */
public class Main_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //注意while处理多个case
        while (in.hasNextInt()) {
            //存在的绳子
            int a = in.nextInt();
            //需要的绳子
            int b = in.nextInt();
            //存放绳子的长度
            double date[] = new double[a];
            for (int i = 0; i < a; i++) {
                date[i] = in.nextInt();
            }
            Arrays.sort(date);
            int used;
            //当前绳子的最短长度
            double minLen;
            //如果存在的绳子多，则选当前最大的第b根
            if (a > b) {
                used = a - b;
                minLen = date[used];
            } else {
                //否则选最短的绳子
                used = 0;
                minLen = date[used];
            }
            int index = a - 1;
            //切分的段数
            int cut;
            //首先该绳子的长度要大于最短长度，其次要是可以使用的绳子
            while (date[index] >= minLen && index > used) {
                //截取的段数
                cut = 2;
                //如果截取一半依然大于最小值，则更新
                while (date[index] / cut > minLen) {
                    cut++;
                    //舍弃前面的最短绳
                    used++;
                    minLen = Math.min(date[index] / cut, date[++used]);
                }
                //更新当前的最短长度
                index--;
            }
        }
    }
}
