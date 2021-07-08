/**
 * @program: Algorithms
 * @description:交换两个变量的值
 * @author: 王小欢
 * @create: 2021-07-08 11:27
 **/
public class ChangeTwoValueTest {
    public static void main(String[] args) {
        int one = 1;
        int two = 2;
        System.out.println("two = " + two);
        System.out.println("one = " + one);
        System.out.println("数据变化后");
        one = one ^ two;
        two = one ^ two;
        one = two ^ one;
        System.out.println("two = " + two);
        System.out.println("one = " + one);
    }
}
