package array;

/**
 * @program: algorithms
 * @description: 翻转数组
 * @author: 王小欢
 * @create: 2019-10-23 14:09
 **/
public class FlipArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
        System.out.print(a);
    }
}
