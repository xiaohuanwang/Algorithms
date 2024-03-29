import common.dataUtil.InitStudent;
import common.util.NumberUtil;
import entity.Student;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: Algorithms
 * @description: Lambda测试
 * @author: 王小欢
 * @create: 2021-07-12 15:54
 **/
public class LambdaTest {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("hello world")).start();

        List<String> stars = Arrays.asList("aa", "bb", "cc");
        stars.forEach(System.out::println);
        List<Student> studentList = InitStudent.init();
        studentList.parallelStream().forEach(student -> System.out.println(student.getStuName()));

        List<String> strings = Stream.of("dd", "ee", "ff").collect(Collectors.toList());
        strings.parallelStream().filter(
                ss -> ss.equals("ff")
        ).map(String::toUpperCase)
                .forEach(System.out::println);

        List<Integer> nums = Stream.of(Arrays.asList(6, 7, 8), Arrays.asList(9, 10))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        nums.forEach(System.out::println);

        List<Integer> numMaxList = Stream.of(100, 200, 300, 400, 500).collect(Collectors.toList());
        System.out.println(numMaxList.stream().reduce(0, (sum, x) -> sum + x));

        int[] arr = NumberUtil.getNumbers();
        LocalDateTime startTime = LocalDateTime.now();
        Arrays.sort(arr);
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("串行排序时间：" + duration.toMillis() + " ms");
        arr = NumberUtil.getNumbers();
        LocalDateTime startTime1 = LocalDateTime.now();
        Arrays.parallelSort(arr);
        LocalDateTime endTime1 = LocalDateTime.now();
        Duration duration1 = Duration.between(startTime1, endTime1);
        System.out.println("并行排序时间：" + duration1.toMillis() + " ms");


    }
}
