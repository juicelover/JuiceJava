package Examples.Bean;

public class Student implements Comparable<Student> {

    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student obj) {
        return (int) (obj.score - this.score);
    }

    @Override
    public String toString() {
        return "ÐÕÃû£º" + this.name + "¡¢³É¼¨£º" + this.score;
    }
}
