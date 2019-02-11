package niuke.sword.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，
 * 输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @Title : 旋转数组的最小数字
 * @Author : Heper
 * @Time : 2019/2/10 14:46
 */
public class MinNumberInRotateArray {
    /**
     * 二分查找
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        int last = array.length;
        if (last == 0) {
            return 0;
        }
        int index = 0, start = 0;
        //作为索引,则最大长度减一
        last--;
        while (start < last) {
            index = start + (last - start) / 2;
            if (array[index] < array[last]) {
                last = index;
            } else if (array[index] == array[last]) {
                last--;
            } else if (array[index] > array[last]) {
                start = index + 1;
            }
        }
        return array[start];
    }
}
