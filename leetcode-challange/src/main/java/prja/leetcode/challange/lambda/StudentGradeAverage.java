package prja.leetcode.challange.lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
 * Scenario
 * Given a list of `StudentGrade` objects containing each student's
 * name and grades in various subjects, 
 * 
 * your objective is to determine the
 * average grade for each subject across all students and identify the subject
 * with the highest average grade.
 */
public class StudentGradeAverage {
    public static void main(String[] args) {
    	List<Grade> studentGrades = new ArrayList<>();
        Map<String, Integer> val = new HashMap<>();
        val.put("Math", 90);
        val.put("Physics", 85);
        val.put("History", 78);
        Grade student1 = new Grade("Student1", val);
        
        Map<String, Integer> val2 = new HashMap<>();
        val2.put("Math", 92);
        val2.put("Physics", 88);
        val2.put("History", 75);
        Grade student2 = new Grade("Student2", val2);
        
        Map<String, Integer> val3 = new HashMap<>();
        val3.put("Math", 85);
        val3.put("Physics", 95);
        val3.put("History", 80);
        Grade student3 = new Grade("Student3", val3);
        studentGrades.add(student1);
        studentGrades.add(student2); 	    	        
        studentGrades.add(student3);

        Map<String, Double> subjectAverages = studentGrades.stream()
                .flatMap(
                		student -> student.getGrades().entrySet().stream()
                        .map(entry -> Map.entry(entry.getKey(), (double) entry.getValue())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.averagingDouble(Map.Entry::getValue)));
        
       

        String highestAverageSubject = subjectAverages.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        System.out.println("Highest average grade: " + highestAverageSubject + " (" + subjectAverages.get(highestAverageSubject) + ")");
    }
}

class Grade {
    private String name;
    private Map<String, Integer> grades;
	public Grade(String name, Map<String, Integer> grades) {
		super();
		this.name = name;
		this.grades = grades;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Integer> getGrades() {
		return grades;
	}
	public void setGrades(Map<String, Integer> grades) {
		this.grades = grades;
	}

}