package common.util;

/**
 * @program: Algorithms
 * @description:
 * @author: 王小欢
 * @create: 2021-07-12 17:55
 **/
public class NumberUtil {
    //判断一个数是否为质数，是返回true，不是返回false
    private static boolean isPrime(int number) {
        int x = number;
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
