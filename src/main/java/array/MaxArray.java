package array;

/**
 * 描述：找出数组中最大的元素<br>
 * 作者：王小欢 <br>
 * 修改日期：Oct 21, 201911:01:31 PM <br>
 * E-mail:  <br>
 *
 * @author wangxiaohuan
 */
public class MaxArray {

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 6, 7, 4, 8};
        int max = a[0];
        for (int j : a) {
            if (j > max) {
                max = j;
            }
        }
        System.out.println(max);

    }
}
