import java.math.BigDecimal;

/**
 * @program: Algorithms
 * @description:
 * @author: 王小欢
 * @create: 2021-08-16 22:36
 **/
public class Test {
    public static void main(String[] args) {
        BigDecimal aa = new BigDecimal(3);
        BigDecimal bb = new BigDecimal(3);

        System.out.println(aa.equals(bb));

        BigDecimal cc = new BigDecimal(3);
        BigDecimal dd = new BigDecimal(3.00);

        System.out.println(cc.equals(dd));

        BigDecimal ee = new BigDecimal("3");
        BigDecimal ff = new BigDecimal("3.00");

        System.out.println(ee.equals(ff));

    }
}
