package array;

import java.util.Arrays;

/**
 * @program: algorithms
 * @description: 复制数组
 * @author: 王小欢
 * @create: 2019-10-22 00:09
 **/
public class CopyArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int n = a.length;
        int[] b = new int[n];
        //传统写法
        /*for (int i=0;i<n;i++){
            b[i] = a[i];
        }*/
        //简化写法
        System.arraycopy(a, 0, b, 0, n);
        System.out.print(Arrays.toString(b));
    }
}
