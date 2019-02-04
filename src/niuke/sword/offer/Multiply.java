package niuke.sword.offer;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * @Author : Heper
 * @Time : 2019/2/3 22:59
 */
public class Multiply {
    /**
     * 运行时间：16ms
     * 占用内存：9304k
     *
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int[] C = new int[A.length - 1];
        int[] D = new int[A.length - 1];
        B[1] = A[0];
        C[0] = A[0];
        D[0] = A[A.length - 1];
        for (int i = 1; i < A.length - 1; i++) {
            C[i] = C[i - 1] * A[i];
            D[i] = D[i - 1] * A[A.length - 1 - i];
        }
        B[0] = D[D.length - 1];
        B[A.length - 1] = C[C.length - 1];
        for (int i = 1; i < A.length - 1; i++) {
            B[i] = C[i - 1] * D[A.length - i - 2];
        }
        return B;
    }

    /**
     * 三角求解思路
     * https://www.nowcoder.com/profile/645151/codeBookDetail?submissionId=1516453
     *
     * @param A
     * @return
     */
    public int[] multiply2(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            //计算下三角连乘
            for (int i = 1; i < length; i++) {
                //计算B的一部分
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            //计算上三角
            //从末尾开始计算上去
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }
//    public static void main(String[] args) {
//        Multiply multiply = new Multiply();
//        int[] A = new int[5];
//        A[0] = 1;
//        A[1] = 2;
//        A[2] = 3;
//        A[3] = 4;
//        A[4] = 5;
//        multiply.multiply(A);
//    }
}
