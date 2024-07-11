package prja.leetcode.challange.lambda;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Employee {
	private int employeeId;
	private LocalDate hireDate;
    private String name;
    private String department;
    private BigDecimal salary;
    private double salary2;
    private List<Project> projects;
    private List<Skill> skills;
    private List<String> skill_str;
    private int age;
    public Employee(int id, String name, int age, double salary, String... skills) {
        this.employeeId = id;
        this.name = name;
        this.age = age;
        this.salary2 = salary;
        this.skill_str = Arrays.asList(skills);
    }
    public Employee(int id, String name, int age, double salary, String department) {
        this.employeeId = id;
        this.name = name;
        this.age = age;
        this.salary2 = salary;
        this.department = department;
    }
    public Employee(int id, String name, int age, double salary) {
        this.employeeId = id;
        this.name = name;
        this.age = age;
        this.salary2 = salary;
    }
    public Employee(int employeeId, String name, String department, BigDecimal salary, LocalDate hireDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.hireDate = hireDate;
    }
    public Employee(String name, String department, BigDecimal salary, Project... projects) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.projects = Arrays.asList(projects);
    }
    public Employee(String name, String department, double salary, Skill... skills) {
        this.name = name;
        this.department = department;
        this.salary2 = salary;
        this.skills = Arrays.asList(skills);
    }
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public List<Project> getProjects() {
        return projects;
    }
	public double getSalary2() {
		return salary2;
	}
	public void setSalary2(double salary2) {
		this.salary2 = salary2;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

