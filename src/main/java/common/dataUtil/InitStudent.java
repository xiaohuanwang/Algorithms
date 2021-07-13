package common.dataUtil;

import entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algorithms
 * @description:
 * @author: 王小欢
 * @create: 2021-07-12 16:14
 **/
public  class InitStudent {
    public static List<Student> init() {
        List<Student> students = new ArrayList<>();
        Student stu = new Student();
        stu.setStuName("stu1");
        stu.setAge(22);
        stu.setCountry("China");
        students.add(stu);
        stu = new Student();
        stu.setStuName("stu2");
        stu.setAge(25);
        stu.setCountry("USA");
        students.add(stu);
        stu = new Student();
        stu.setStuName("stu3");
        stu.setAge(23);
        stu.setCountry("China");
        students.add(stu);
        return students;
    }
}
