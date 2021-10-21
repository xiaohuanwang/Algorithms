package array;

/**
 * 描述：计算数组元素的平均值<br>
 * 作者：王小欢 <br>
 * 修改日期：Oct 21, 201911:01:49 PM <br>
 * E-mail:  <br>
 *
 * @author wangxiaohuan
 */
public class AverageArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = a.length;
        double sum = 0.0;
        for (int j : a) {
            sum = sum + j;
        }
        double average = sum / n;
        System.out.println(average);
    }

}
