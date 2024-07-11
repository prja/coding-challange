package prja.leetcode.challange.lambda;

import java.util.Map;

public class StudentGrade {

	private String name;
	private Map<String,Integer> grades;
	
	    public StudentGrade(String name, Map<String, Integer> grades) {
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