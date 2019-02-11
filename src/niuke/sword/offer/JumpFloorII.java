package niuke.sword.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @Title : 变态跳台阶
 * @Author : Heper
 * @Time : 2019/2/10 22:43
 */
public class JumpFloorII {
    public int jumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return (int) Math.pow(2, target - 1);
    }
}
