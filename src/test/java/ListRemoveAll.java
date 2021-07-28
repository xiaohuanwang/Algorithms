import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algorithms
 * @description: list交集，并集，差集
 * @author: 王小欢
 * @create: 2021-07-25 23:34
 **/
public class ListRemoveAll {
    public static void main(String[] args) {
/*        List<String> listA_01 = new ArrayList<String>(){{
            add("A");
            add("B");
        }};
        List<String> listB_01 = new ArrayList<String>(){{
            add("B");
            add("C");
        }};
        listA_01.retainAll(listB_01);
        System.out.println(listA_01); // 结果:[B]
        System.out.println(listB_01); // 结果:[B, C]*/

// 差集
        List<String> listA_02 = new ArrayList<String>(){{
            add("A");
            add("B");
        }};
        List<String> listB_02 = new ArrayList<String>(){{
            add("B");
        //    add("C");
        }};
        listA_02.removeAll(listB_02);
        System.out.println(listA_02); // 结果:[A]
        System.out.println(listB_02); // 结果:[B, C]

// 并集
/*        List<String> listA_03 = new ArrayList<String>(){{
            add("A");
            add("B");
        }};
        List<String> listB_03 = new ArrayList<String>(){{
            add("B");
            add("C");
        }};
        listA_03.removeAll(listB_03);
        listA_03.addAll(listB_03);
        System.out.println(listA_03); // 结果:[A, B, C]
        System.out.println(listB_03); // 结果:[B, C]*/
    }
}
