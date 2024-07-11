package prja.leetcode.challange.lambda;
public class Skill {
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                '}';
    }
}
