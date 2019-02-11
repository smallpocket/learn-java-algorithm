package niuke.sword.offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author Heper
 * @title 矩阵覆盖
 * @date 2019/2/10 22:48
 */
public class RectCover {
    /**
     * 斐波那契数列
     *
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if (target <= 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return rectCover(target - 1) + rectCover(target - 2);
        }
    }
}
