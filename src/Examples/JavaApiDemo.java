package Examples;

import java.util.Arrays;

public class JavaApiDemo {
    public static void main(String[] args) {
        String input = "张三:21:98|李四:22:89|王五:20:70";
        String[] result = input.split("\\|");
        Student[] students = new Student[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i].split(":");
            students[i] = new Student(temp[0], Integer.parseInt(temp[1]), Double.parseDouble(temp[2]));
        }
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}

class Student implements Comparable<Student> {

    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        super();
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student stu) {
        if (this.score < stu.score) {
            return 1;
        } else if (this.score > stu.score) {
            return -1;
        } else {
            return this.age - stu.age;
        }
    }

    @Override
    public String toString() {
        return "【学生信息】姓名：" + name + "、年龄：" + age + "、成绩：" + score;
    }
}
