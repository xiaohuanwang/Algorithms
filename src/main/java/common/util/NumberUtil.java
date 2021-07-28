package common.util;

import java.util.List;
import java.util.Random;
/**
 * <p>description</p>
 *
 * @author wxh_work@163.com
 * @date  2021-07-13 14:37:45
 */
public class NumberUtil {

    /**
     * @description 判断一个数是否为质数，是返回true，不是返回false
     * @param  {@link }
     * @return null {@link null}
     * @author wxh_work@163.com
     * @date 2021-07-13 14:38:09
     */
    public static boolean isPrime(int number) {
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

    /**
     * @description 随机产生一个数组
     * @   {@link }
     * @return null {@link null}
     * @author wxh_work@163.com
     * @date 2021-07-13 14:38:38
     */
    public static int[] getNumbers() {
        int[] arr = new int[5000000];
        Random r = new Random();
        for (int i = 0; i < 5000000; ++i) {
            arr[i] = r.nextInt(1000) + 1;
        }
        return arr;
    }

}
