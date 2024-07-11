package prja.leetcode.challange.lambda;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private String gender;
    private int grade;
    private List<Course> courses;

    public Student(String name, int age, String gender, int grade, Course... courses) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.courses = Arrays.asList(courses);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getGrade() {
        return grade;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", grade=" + grade +
                ", courses=" + courses +
                '}';
    }
}

