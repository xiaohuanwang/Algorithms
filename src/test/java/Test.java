import common.util.TimeHelper;

import java.time.LocalDate;
import java.util.List;

/**
 * @program: Algorithms
 * @description:
 * @author: 王小欢
 * @create: 2021-08-16 22:36
 **/
public class Test {
    public static void main(String[] args) {


        List<LocalDate> thatDayList = TimeHelper.listLocalDateOfTimePageReqByDay(LocalDate.of(2021, 10, 5), LocalDate.of(2021, 10, 5), 366, 0);
        System.out.println(thatDayList.toString());


    }

}
