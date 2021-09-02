import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @program: Algorithms
 * @description:
 * @author: 王小欢
 * @create: 2021-08-16 22:36
 **/
public class Test {
    public static void main(String[] args) {
        BigDecimal aa = new BigDecimal(3.99);
        BigDecimal bb = new BigDecimal(3.99);
    //    System.out.println(bb.subtract(aa));

        //  long l = bd.setScale( 0, BigDecimal.ROUND_UP ).longValue(); // 向上取整
      //  long a = bd.setScale( 0, BigDecimal.ROUND_DOWN ).longValue(); // 向下取整
    //    System.out.println(aa.setScale(0, RoundingMode.DOWN));
       System.out.println(bb.subtract(aa.setScale(0, RoundingMode.DOWN),new MathContext(2)));
    }
}
