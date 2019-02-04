package niuke.sword.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重
 * 复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第
 * 一个重复的数字2。
 *
 * @Author : Heper
 * @Time : 2019/2/3 22:14
 */
public class Duplicate {

    /**
     * @param numbers     an array of integers 一个int的数组
     * @param length      the length of array numbers 数组长度
     * @param duplication (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
     *                    Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
     *                    存放第一个重复的数字
     * @return true if the input is valid, and there are some duplications in the array number
     * 如果输入有效，则为true，并且数组编号中存在一些重复项
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null) {
            return false;
        }
        Set<Integer> arraySet = new HashSet<>();
        for (int number : numbers) {
            // FIXME:更简洁的判别法
            // if(!hs.add(numbers[i])) {
            if (!arraySet.contains(number)) {
                arraySet.add(number);
            } else {
                duplication[0] = number;
                return true;
            }
        }
        return false;
    }

    /**
     * 更高效的解法
     * 不需要额外的数组或者hash table来保存，题目里写了数组里数字的范围保证在0 ~ n-1 之间，
     * 所以可以利用现有数组设置标志，当一个数字被访问过后，可以设置对应位上的数 + n，
     * 之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
     */
    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null) {
            return false;
        }
        int index;
        for (int number :
                numbers) {
            index = number;
            //防止超出边界
            if (index > length) {
                index -= length;
            }
            //该位置数字已被标记
            if (numbers[index] > length) {
                duplication[0] = index;
                return true;
            } else {
                //未标记的数字,
                numbers[index] += length;
            }
        }
        return false;
    }
}
