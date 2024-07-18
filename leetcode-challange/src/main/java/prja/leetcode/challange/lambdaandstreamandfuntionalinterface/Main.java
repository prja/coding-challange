package prja.leetcode.challange.lambdaandstreamandfuntionalinterface;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import prja.leetcode.challange.lambda.Employee;
import prja.leetcode.challange.lambda.Skill;



// Custom functional interface example
@FunctionalInterface
interface FunctionalInterfaceExample {
    int calculate(int a, int b);
}

public class Main {
    // Custom predicate for filtering employees by age range
    private static Predicate<Employee> ageBetween(int minAge, int maxAge) {
        return emp -> emp.getAge() >= minAge && emp.getAge() <= maxAge;
    }
	private static void extracted1() {
		List<Employee> employees = Arrays.asList(
	            new Employee(1, "John Doe", 30, 50000),
	            new Employee(2, "Jane Smith", 25, 60000),
	            new Employee(3, "Bob Johnson", 35, 75000),
	            new Employee(4, "Alice Williams", 28, 45000),
	            new Employee(5, "Michael Brown", 32, 80000)
	        );
		// 1. Filtering employees based on salary greater than 60000
        List<Employee> highSalaryEmployees = employees.stream()
                .filter(e -> e.getSalary2() > 60000)
                .collect(Collectors.toList());

        System.out.println("Employees with salary greater than 60000:");
        highSalaryEmployees.forEach(e -> System.out.println(e.getName()));

        // 2. Mapping employee names to a list
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\nEmployee names:");
        employeeNames.forEach(System.out::println);

        // 3. Aggregation: Calculating average age of employees
        double averageAge = employees.stream()
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0);

        System.out.println("\nAverage age of employees: " + averageAge);

        // 4. Sorting employees by salary (ascending)
        List<Employee> sortedBySalary = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary2(), e2.getSalary2()))
                .collect(Collectors.toList());

        System.out.println("\nEmployees sorted by salary:");
        sortedBySalary.forEach(e -> System.out.println(e.getName() + ": " + e.getSalary()));
	}
	
private static void extracted2() {
	List<Employee> employees = Arrays.asList(
            new Employee(1, "John Doe", 30, 50000, "IT"),
            new Employee(2, "Jane Smith", 25, 60000, "Finance"),
            new Employee(3, "Bob Johnson", 35, 75000, "IT"),
            new Employee(4, "Alice Williams", 28, 45000, "HR"),
            new Employee(5, "Michael Brown", 32, 80000, "Finance")
    );

    // 6. Grouping employees by department
    Map<String, List<Employee>> employeesByDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

    System.out.println("Employees grouped by department:");
    employeesByDepartment.forEach((dept, empList) -> {
        System.out.println(dept + ":");
        empList.forEach(emp -> System.out.println("\t" + emp.getName()));
    });

    // 7. Reduction: Finding the employee with the highest salary
    Optional<Employee> highestPaidEmployee = employees.stream()
            .max((e1, e2) -> Double.compare(e1.getSalary2(), e2.getSalary2()));

    highestPaidEmployee.ifPresent(emp -> System.out.println("\nEmployee with highest salary: " + emp.getName()));

    // 8. FlatMapping: Example of using flatMap to work with nested collections
    List<List<String>> nestedSkills = Arrays.asList(
            Arrays.asList("Java", "SQL"),
            Arrays.asList("Python", "JavaScript"),
            Arrays.asList("C++", "Ruby", "Swift")
    );

    List<String> allSkills = nestedSkills.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());

    System.out.println("\nAll skills: " + allSkills);

    // 9. Parallel Processing: Example of using parallel streams for faster processing
    long count = employees.parallelStream()
            .filter(emp -> emp.getSalary2() > 50000)
            .count();

    System.out.println("\nNumber of employees with salary greater than 50000: " + count);
}
	private static void extracted3() {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, 50000, "IT"),
                new Employee(2, "Jane Smith", 25, 60000, "Finance"),
                new Employee(3, "Bob Johnson", 35, 75000, "IT"),
                new Employee(4, "Alice Williams", 28, 45000, "HR"),
                new Employee(5, "Michael Brown", 32, 80000, "Finance")
        );

        // 10. Mapping and Filtering Combined: Get names of employees in IT department with salary > 60000
        List<String> namesOfEmployeesInITWithHighSalary = employees.stream()
                .filter(e -> e.getDepartment().equals("IT") && e.getSalary2() > 60000)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("Employees in IT department with salary > 60000:");
        namesOfEmployeesInITWithHighSalary.forEach(System.out::println);

        // 11. Collecting into Maps: Create a map of employee id to employee object
        Map<Integer, Employee> employeeMapById = employees.stream()
                .collect(Collectors.toMap(Employee::getEmployeeId, e -> e));

        System.out.println("\nEmployee map by ID:");
        employeeMapById.forEach((id, emp) -> System.out.println(id + " -> " + emp));

        // 12. Chaining Stream Operations: Find the youngest employee in Finance department
        Optional<Employee> youngestEmployeeInFinance = employees.stream()
                .filter(e -> e.getDepartment().equals("Finance"))
                .min((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));

        youngestEmployeeInFinance.ifPresent(emp -> System.out.println("\nYoungest employee in Finance department: " + emp.getName()));

        // 13. Handling Null Values: Using Optional to safely access potentially null values
        Employee unknownEmployee = null; // Simulating a scenario where an employee might be null
        Optional.ofNullable(unknownEmployee)
                .ifPresent(emp -> System.out.println("\nFound employee (if not null): " + emp.getName()));

        // 14. Custom Collectors: Concatenate names of employees into a single comma-separated string
        String allEmployeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        System.out.println("\nAll employee names: " + allEmployeeNames);
	}

	private static void extracted4() {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, 50000, "IT"),
                new Employee(2, "Jane Smith", 25, 60000, "Finance"),
                new Employee(3, "Bob Johnson", 35, 75000, "IT"),
                new Employee(4, "Alice Williams", 28, 45000, "HR"),
                new Employee(5, "Michael Brown", 32, 80000, "Finance")
        );

        // 15. Combining Streams: Example of combining two streams to perform a complex transformation
        List<String> combinedList = Stream.concat(
                employees.stream().map(Employee::getName),
                employees.stream().map(Employee::getDepartment)
        ).collect(Collectors.toList());

        System.out.println("Combined list of employee names and departments:");
        System.out.println(combinedList);

        // 16. Stateful Operations: Using reduce to calculate total salary of all employees
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary2)
                .reduce(0, (a, b) -> a + b);

        System.out.println("\nTotal salary of all employees: " + totalSalary);

        // 17. Lazy Evaluation: Demonstrating lazy evaluation with intermediate and terminal operations
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> {
                    System.out.println("Filtering employee: " + e.getName());
                    return e.getSalary2() > 50000;
                })
                .collect(Collectors.toList());

        System.out.println("\nFiltered employees:");
        filteredEmployees.forEach(System.out::println);

        // 18. Handling Exceptions: Example of handling exceptions in stream processing
        try {
            double averageSalary = employees.stream()
                    .mapToDouble(e -> {
                        if (e.getSalary2() <= 0) {
                            throw new IllegalStateException("Invalid salary for employee: " + e.getName());
                        }
                        return e.getSalary2();
                    })
                    .average()
                    .orElseThrow(() -> new IllegalStateException("No employees found"));

            System.out.println("\nAverage salary of employees: " + averageSalary);
        } catch (IllegalStateException e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }

        // 19. Infinite Streams: Generating an infinite stream of random numbers and limiting it
        System.out.println("\nFirst 10 random numbers:");
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
	}

	private static void extracted5() {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, 50000, "IT"),
                new Employee(2, "Jane Smith", 25, 60000, "Finance"),
                new Employee(3, "Bob Johnson", 35, 75000, "IT"),
                new Employee(4, "Alice Williams", 28, 45000, "HR"),
                new Employee(5, "Michael Brown", 32, 80000, "Finance")
        );

        // 20. Parallel Streams: Example of using parallel streams for faster processing
        long count = employees.parallelStream()
                .filter(emp -> emp.getSalary2() > 50000)
                .count();

        System.out.println("Number of employees with salary > 50000 (parallel): " + count);

        // 21. Custom Comparator: Sorting employees by age in descending order
        List<Employee> employeesSortedByAgeDescending = employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .collect(Collectors.toList());

        System.out.println("\nEmployees sorted by age (descending):");
        employeesSortedByAgeDescending.forEach(System.out::println);

        // 22. Stream from Files: Reading employee data from a CSV file and processing using streams
        String fileName = "employees.csv";
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            List<Employee> employeesFromFile = lines.skip(1) // Skip header line
                    .map(line -> {
                        String[] parts = line.split(",");
                        return new Employee(
                                Integer.parseInt(parts[0]),
                                parts[1],
                                Integer.parseInt(parts[2]),
                                Double.parseDouble(parts[3]),
                                parts[4]
                        );
                    })
                    .collect(Collectors.toList());

            System.out.println("\nEmployees read from file:");
            employeesFromFile.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 23. Grouping with Downstream Collectors: Grouping employees by department and counting by age group
        Map<String, Map<Integer, Long>> departmentAgeGroupCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(e -> {
                            if (e.getAge() < 30) return 20;
                            else if (e.getAge() < 40) return 30;
                            else return 40;
                        }, Collectors.counting())));

        System.out.println("\nDepartment-wise count of employees by age group:");
        departmentAgeGroupCount.forEach((dept, ageGroupCountMap) -> {
            System.out.println(dept + ":");
            ageGroupCountMap.forEach((ageGroup, cc) ->
                    System.out.println("\tAge group " + ageGroup + "s: " + cc));
        });

        // 24. Stream from Network: Handling a stream of data fetched from a network source
        // Example: Fetching data from an API and processing it using streams
        // (Code for network fetching and processing would vary based on specific API)
	}

	private static void extracted6() {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, 50000, "IT"),
                new Employee(2, "Jane Smith", 25, 60000, "Finance"),
                new Employee(3, "Bob Johnson", 35, 75000, "IT"),
                new Employee(4, "Alice Williams", 28, 45000, "HR"),
                new Employee(5, "Michael Brown", 32, 80000, "Finance")
        );

        // 25. Stream from Database: Example of processing data fetched from a database
        // Assuming employees are fetched from a database, we'll simulate it with the existing list
        // For real scenario, you would replace this with JDBC or JPA operations
        System.out.println("Employees fetched from database:");

        // Processing employees from database (simulated with the existing list)
        employees.stream()
                .forEach(System.out::println);

        // 26. Stateless Operations: Using stateless operations like map and filter
        // Example: Calculate total salary of employees using map and reduce
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary2)
                .reduce(0, Double::sum);

        System.out.println("\nTotal salary of employees (stateless operation): " + totalSalary);

        // 27. Collecting and Then: Collecting employees into a list and then performing additional operation
        List<Employee> employeesFilteredBySalary = employees.stream()
                .filter(e -> e.getSalary2() > 60000)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        filteredList -> {
                            System.out.println("\nEmployees with salary > 60000:");
                            filteredList.forEach(System.out::println);
                            return filteredList;
                        }));

        // 28. Peek: Using peek for debugging or logging purposes without affecting the stream
        System.out.println("\nPeeking into employee processing:");
        List<String> employeeNames = employees.stream()
                .peek(e -> System.out.println("Processing employee: " + e.getName()))
                .map(Employee::getName)
                .collect(Collectors.toList());

        // 29. Stream Iteration: Example of generating Fibonacci sequence using streams
        System.out.println("\nFirst 10 Fibonacci numbers:");
        List<Integer> fibonacciSequence = Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(10)
                .map(arr -> arr[0])
                .collect(Collectors.toList());
        
        System.out.println(fibonacciSequence);
	}

	private static void extracted7() {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, 50000, "IT"),
                new Employee(2, "Jane Smith", 25, 60000, "Finance"),
                new Employee(3, "Bob Johnson", 35, 75000, "IT"),
                new Employee(4, "Alice Williams", 28, 45000, "HR"),
                new Employee(5, "Michael Brown", 32, 80000, "Finance")
        );

        // 30. Windowed Operations: Calculate moving average salary using windowed stream
        System.out.println("Moving average salary of employees:");
        IntStream.range(0, employees.size())
                .mapToDouble(i -> {
                    if (i == 0) {
                        return employees.get(i).getSalary2();
                    } else {
                        double sum = employees.subList(0, i + 1).stream()
                                .mapToDouble(Employee::getSalary2)
                                .sum();
                        return sum / (i + 1);
                    }
                })
                .forEach(avg -> System.out.printf("%.2f%n", avg));

        // 31. Partitioning: Partition employees into two groups based on salary > 60000
        Map<Boolean, List<Employee>> partitionedEmployees = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary2() > 60000));

        System.out.println("\nEmployees partitioned by salary > 60000:");
        partitionedEmployees.forEach((isHighSalary, empList) -> {
            System.out.println(isHighSalary ? "High Salary:" : "Low Salary:");
            empList.forEach(System.out::println);
        });

        // 32. Custom Stream Sources: Generate stream of even numbers using Stream.iterate
        System.out.println("\nFirst 10 even numbers:");
        List<Integer> evenNumbers = Stream.iterate(2, n -> n + 2)
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);

        // 33. Combining Collectors: Collecting employees by department and then finding the average salary in each department
        Map<String, Double> averageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary2)));

        System.out.println("\nAverage salary by department:");
        averageSalaryByDepartment.forEach((dept, avgSalary) ->
                System.out.println(dept + ": " + avgSalary));

        // 34. Stream to Array/Collection: Convert stream of employee names to array
        String[] employeeNamesArray = employees.stream()
                .map(Employee::getName)
                .toArray(String[]::new);

        System.out.println("\nEmployee names as array:");
        System.out.println(Arrays.toString(employeeNamesArray));
	}

	private static void extracted8() {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, 50000, "Java", "Spring"),
                new Employee(2, "Jane Smith", 25, 60000, "Python", "Django"),
                new Employee(3, "Bob Johnson", 35, 75000, "JavaScript", "React"),
                new Employee(4, "Alice Williams", 28, 45000, "C#", ".NET"),
                new Employee(5, "Michael Brown", 32, 80000, "Java", "Spring", "Hibernate")
        );

        // 35. FlatMap: Example of flattening skills of all employees into a single set
        Set<Skill> allSkills = employees.stream()
                .flatMap(emp -> emp.getSkills().stream())
                .collect(Collectors.toSet());

        System.out.println("All unique skills across employees:");
        System.out.println(allSkills);

        // 36. Mapping and Filtering Nested Collections: Finding employees who know Java
        List<Employee> javaExperts = employees.stream()
                .filter(emp -> emp.getSkills().contains("Java"))
                .collect(Collectors.toList());

        System.out.println("\nEmployees who know Java:");
        javaExperts.forEach(System.out::println);

        // 37. Collecting to Specific Collection Types: Grouping employees by department into a Map
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nEmployees grouped by department:");
        employeesByDepartment.forEach((dept, empList) -> {
            System.out.println(dept + ":");
            empList.forEach(System.out::println);
        });

        // 38. Stream Performance Considerations: Avoiding unnecessary operations in stream pipeline
        // Example: Calculate total salary of employees under age 30
        double totalSalaryUnder30 = employees.stream()
                .filter(emp -> emp.getAge() < 30)
                .mapToDouble(Employee::getSalary2)
                .sum();

        System.out.println("\nTotal salary of employees under age 30: " + totalSalaryUnder30);

        // 39. Stream Debugging: Using peek for intermediate debugging
        List<String> employeeNames = employees.stream()
                .filter(emp -> emp.getSalary2() > 60000)
                .peek(emp -> System.out.println("Processing employee: " + emp.getName()))
                .map(Employee::getName)
                .collect(Collectors.toList());

        // 40. Advanced Stream Composition: Example of composing complex stream pipeline
        double averageAgeOfJavaExperts = employees.stream()
                .filter(emp -> emp.getSkills().contains("Java"))
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0);

        System.out.println("\nAverage age of employees who know Java: " + averageAgeOfJavaExperts);
	}

	private static void extracted9() {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, 50000, "IT"),
                new Employee(2, "Jane Smith", 25, 60000, "Finance"),
                new Employee(3, "Bob Johnson", 35, 75000, "IT"),
                new Employee(4, "Alice Williams", 28, 45000, "HR"),
                new Employee(5, "Michael Brown", 32, 80000, "Finance")
        );

        // 41. Custom Reducers: Calculating total salary using custom reducer with reducing()
        double totalSalary = employees.stream()
                .collect(Collectors.reducing(0.0, Employee::getSalary2, Double::sum));

        System.out.println("Total salary of all employees: " + totalSalary);

        // 42. Early Termination: Finding first employee with salary > 60000
        Employee highSalaryEmployee = employees.stream()
                .filter(emp -> emp.getSalary2() > 60000)
                .findFirst()
                .orElse(null);

        System.out.println("\nFirst employee with salary > 60000: " + highSalaryEmployee);

        // 43. Stateful Operations: Using distinct() to remove duplicates based on age
        List<Employee> uniqueByAge = employees.stream()
                .filter(emp -> emp.getAge() < 35)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nUnique employees (based on age < 35):");
        uniqueByAge.forEach(System.out::println);

        // 44. Parallelism Control: Processing in parallel and then sequentially
        employees.parallelStream()
                .map(Employee::getName)
                .forEach(System.out::println);

        employees.stream()
                .sequential()
                .map(Employee::getDepartment)
                .forEach(System.out::println);

        // 45. Stream Concatenation: Concatenating two streams of employees
        Stream<Employee> combinedStream = Stream.concat(
                employees.stream(),
                employees.stream().filter(emp -> emp.getSalary2() > 60000));

        System.out.println("\nCombined stream of all employees and those with salary > 60000:");
        combinedStream.forEach(System.out::println);

        // 46. Stream Performance Tuning: Using unordered() for potentially faster processing
        long count = employees.stream()
                .unordered()
                .filter(emp -> emp.getSalary2() > 50000)
                .count();

        System.out.println("\nNumber of employees with salary > 50000 (unordered): " + count);

        // 47. Handling Large Data Sets: Processing large data sets with chunking
        List<Employee> largeDataSet = generateLargeDataSet();
        largeDataSet.stream()
                .forEach(emp -> {
                    // Process each employee
                });

        // 48. Stream API Enhancements: Using newer features in Java Stream API
        // Example: Stream.dropWhile to skip employees with salary < 50000
        List<Employee> filteredEmployees = employees.stream()
                .dropWhile(emp -> emp.getSalary2() < 50000)
                .collect(Collectors.toList());

        System.out.println("\nEmployees with salary >= 50000:");
        filteredEmployees.forEach(System.out::println);

        // 49. Custom Collectors: Creating a custom collector to partition employees by salary range
        Map<String, List<Employee>> employeesBySalaryRange = employees.stream()
                .collect(Collectors.groupingBy(emp -> {
                    if (emp.getSalary2() < 60000) {
                        return "Low Salary";
                    } else {
                        return "High Salary";
                    }
                }));

        System.out.println("\nEmployees partitioned by salary range:");
        employeesBySalaryRange.forEach((range, empList) -> {
            System.out.println(range + ":");
            empList.forEach(System.out::println);
        });

        // 50. Error Handling in Streams: Handling exceptions in stream processing
        List<String> employeeNames = employees.stream()
                .map(emp -> {
                    try {
                        return emp.getName();
                    } catch (Exception e) {
                        System.err.println("Error processing employee: " + emp.getEmployeeId());
                        return "Unknown";
                    }
                })
                .collect(Collectors.toList());

        System.out.println("\nEmployee names (handling errors gracefully):");
        employeeNames.forEach(System.out::println);
	}
	private static void extracted10() {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, 50000, "IT"),
                new Employee(2, "Jane Smith", 25, 60000, "Finance"),
                new Employee(3, "Bob Johnson", 35, 75000, "IT"),
                new Employee(4, "Alice Williams", 28, 45000, "HR"),
                new Employee(5, "Michael Brown", 32, 80000, "Finance")
        );

        // 51. Grouping and Aggregating: Group employees by department and find average salary in each department
        Map<String, Double> averageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary2)));

        System.out.println("Average salary by department:");
        averageSalaryByDepartment.forEach((dept, avgSalary) ->
                System.out.println(dept + ": " + avgSalary));

        // 52. Parallel Stream Processing: Using parallel stream to calculate total salary
        double totalSalaryParallel = employees.parallelStream()
                .mapToDouble(Employee::getSalary2)
                .sum();

        System.out.println("\nTotal salary using parallel stream: " + totalSalaryParallel);

        // 53. Combining Streams: Combine employees and their managers into a single stream
        List<Employee> managers = Arrays.asList(
                new Employee(6, "Sarah Johnson", 40, 90000, "IT"),
                new Employee(7, "Emily Davis", 38, 85000, "Finance")
        );

        Stream<Employee> combinedStream = Stream.concat(
                employees.stream(),
                managers.stream());

        System.out.println("\nCombined stream of employees and managers:");
        combinedStream.forEach(System.out::println);

        // 54. Stream APIs in Collections: Using stream() directly on a list and performing operations
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\nEmployee names:");
        System.out.println(employeeNames);

        // 55. Handling Optional in Streams: Finding the highest salary among employees
        Optional<Double> maxSalary = employees.stream()
                .map(Employee::getSalary2)
                .max(Double::compare);

        maxSalary.ifPresent(max -> System.out.println("\nHighest salary among employees: " + max));

        // 56. State Management: Demonstrating use of effectively final variables in lambda expressions
        double bonusFactor = 1.1;
        List<Double> salariesWithBonus = employees.stream()
                .map(emp -> emp.getSalary2() * bonusFactor)
                .collect(Collectors.toList());

        System.out.println("\nSalaries with bonus factor applied:");
        System.out.println(salariesWithBonus);

        // 57. Custom Functional Interfaces: Defining and using a custom functional interface
        FunctionalInterfaceExample functionalInterface = (a, b) -> a * b;
        int result = functionalInterface.calculate(5, 10);

        System.out.println("\nResult of custom functional interface: " + result);

        // 58. Stream Performance Profiling: Measuring performance with stream operations
        long startTime = System.nanoTime();
        List<Employee> highSalaryEmployees = employees.stream()
                .filter(emp -> emp.getSalary2() > 60000)
                .collect(Collectors.toList());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Milliseconds

        System.out.println("\nTime taken to filter high salary employees: " + duration + " ms");

        // 59. Immutable Streams: Ensure immutability by using Collectors.toUnmodifiableList() for result collection
        List<String> immutableNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toUnmodifiableList());

        // 60. Advanced Stream Patterns: Implementing sliding window pattern using custom logic
        System.out.println("\nEmployees processed in pairs:");
        IntStream.range(0, employees.size() - 1)
                .mapToObj(i -> employees.get(i).getName() + " - " + employees.get(i + 1).getName())
                .forEach(System.out::println);
	}
	private static void extracted11() {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, 50000, "IT"),
                new Employee(2, "Jane Smith", 25, 60000, "Finance"),
                new Employee(3, "Bob Johnson", 35, 75000, "IT"),
                new Employee(4, "Alice Williams", 28, 45000, "HR"),
                new Employee(5, "Michael Brown", 32, 80000, "Finance")
        );

		employees.stream().max(Comparator.comparing(Employee::getAge)).get();
		
        // 71. Stream API Collectors: Using toMap() for advanced mapping operations
        Map<Integer, String> idToNameMap = employees.stream()
                .collect(Collectors.toMap(Employee::getEmployeeId, Employee::getName));

        System.out.println("Employee ID to Name mapping:");
        System.out.println(idToNameMap);

        // 72. Stream FlatMap vs Map: Using flatMap to flatten nested lists
        List<List<String>> nestedSkills = Arrays.asList(
                Arrays.asList("Java", "Spring"),
                Arrays.asList("Python", "Django"),
                Arrays.asList("JavaScript", "React", "Node.js")
        );

        List<String> allSkills = nestedSkills.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("\nAll skills combined from nested lists:");
        System.out.println(allSkills);

        // 73. Stream Reduce: Using reduce to find the highest salary
        Optional<Double> maxSalary = employees.stream()
                .map(Employee::getSalary2)
                .reduce(Double::max);

        maxSalary.ifPresent(max -> System.out.println("\nHighest salary among employees: " + max));

        // 74. Stream CollectingAndThen: Using collectingAndThen for post-processing after collection
        List<Employee> highPaidEmployees = employees.stream()
                .filter(emp -> emp.getSalary2() > 70000)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));

        System.out.println("\nHigh paid employees (salary > 70000):");
        highPaidEmployees.forEach(System.out::println);

        // 75. Stream GroupingBy with Downstream Collectors: Grouping employees by department and finding average salary
        Map<String, Double> averageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary2)));

        System.out.println("\nAverage salary by department:");
        averageSalaryByDepartment.forEach((dept, avgSalary) ->
                System.out.println(dept + ": " + avgSalary));

        // 76. Stateful Transformations: Using Stream.iterate for stateful transformations
        List<Integer> powersOfTwo = Stream.iterate(1, n -> n * 2)
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nPowers of two:");
        System.out.println(powersOfTwo);

        // 77. Stream Filtering and Mapping: Advanced filtering and mapping with predicates and functions
        List<String> namesStartingWithJ = employees.stream()
                .filter(emp -> emp.getName().startsWith("J"))
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\nEmployee names starting with 'J':");
        System.out.println(namesStartingWithJ);

        // 78. Stream Peeking and Side Effects: Using peek for debugging and logging in stream pipelines
        List<Employee> employeesWithHighSalary = employees.stream()
                .peek(emp -> System.out.println("Processing employee: " + emp.getName()))
                .filter(emp -> emp.getSalary2() > 60000)
                .collect(Collectors.toList());

        System.out.println("\nEmployees with salary > 60000:");
        employeesWithHighSalary.forEach(System.out::println);

        // 79. Stream Iteration and Streams of Primitives: Using IntStream to calculate sum of employee ages
        int totalAge = employees.stream()
                .mapToInt(Employee::getAge)
                .sum();

        System.out.println("\nTotal age of all employees: " + totalAge);

        // 80. Custom Stream Operations: Defining and using custom stream operations with lambdas and functional interfaces
        List<Employee> filteredByAgeRange = employees.stream()
                .filter(ageBetween(25, 35))
                .collect(Collectors.toList());

        System.out.println("\nEmployees aged between 25 and 35:");
        filteredByAgeRange.forEach(System.out::println);
	}
	private static void extracted12() {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, 50000, "IT"),
                new Employee(2, "Jane Smith", 25, 60000, "Finance"),
                new Employee(3, "Bob Johnson", 35, 75000, "IT"),
                new Employee(4, "Alice Williams", 28, 45000, "HR"),
                new Employee(5, "Michael Brown", 32, 80000, "Finance")
        );

        // 81. Stream Collectors.joining: Concatenate employee names into a single string
        String allNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        System.out.println("All employee names: " + allNames);

        // 82. Stream Partitioning: Partition employees into two groups based on salary threshold
        Map<Boolean, List<Employee>> salaryPartition = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary2() >= 60000));

        System.out.println("\nEmployees partitioned by salary >= 60000:");
        System.out.println("High salary: " + salaryPartition.get(true));
        System.out.println("Low salary: " + salaryPartition.get(false));

        // 83. Stream Custom Reduction: Custom reduction to find the total salary of all employees
        Double totalSalary = employees.stream()
                .collect(Collectors.reducing(0.0, Employee::getSalary2, Double::sum));

        System.out.println("\nTotal salary of all employees: " + totalSalary);

        // 84. Stream Custom Collectors: Custom collector to concatenate employee names by department
        Map<String, String> namesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.joining(", "))));

        System.out.println("\nEmployee names by department:");
        namesByDepartment.forEach((dept, names) -> System.out.println(dept + ": " + names));

        // 85. Stream Infinite Streams: Generate infinite stream of random numbers and limit to 10
        List<Integer> randomNumbers = IntStream.generate(() -> (int) (Math.random() * 100))
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("\nGenerated random numbers:");
        System.out.println(randomNumbers);

        // 86. Stream Primitives and Boxing: Map int ages to Integer and find average age
        OptionalDouble averageAge = employees.stream()
                .mapToInt(Employee::getAge)
                .average();

        System.out.println("\nAverage age of employees: " + (averageAge.isPresent() ? averageAge.getAsDouble() : "N/A"));

        // 87. Stream Stateful Operations: Building a stream with Stream.Builder
        Stream.Builder<Employee> employeeBuilder = Stream.builder();
        employees.forEach(employeeBuilder::add);

        System.out.println("\nStream of employees built with Stream.Builder:");
        employeeBuilder.build().forEach(System.out::println);

        // 88. Stream Limiting and Skipping: Limiting and skipping elements in a stream
        List<Employee> limitedEmployees = employees.stream()
                .skip(2)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("\nEmployees after skipping 2 and limiting to 2:");
        limitedEmployees.forEach(System.out::println);

        // 89. Stream Min and Max: Finding employee with minimum and maximum salary
        Optional<Employee> minSalaryEmployee = employees.stream()
                .min((emp1, emp2) -> Double.compare(emp1.getSalary2(), emp2.getSalary2()));

        Optional<Employee> maxSalaryEmployee = employees.stream()
                .max((emp1, emp2) -> Double.compare(emp1.getSalary2(), emp2.getSalary2()));

        System.out.println("\nEmployee with minimum salary: " + minSalaryEmployee.orElse(null));
        System.out.println("Employee with maximum salary: " + maxSalaryEmployee.orElse(null));

        // 90. Stream Distinct: Finding distinct departments among employees
        List<String> distinctDepartments = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nDistinct departments among employees:");
        System.out.println(distinctDepartments);

        // 91. Stream Sorted: Sorting employees by department and age
        List<Employee> sortedEmployees = employees.stream()
                .sorted((emp1, emp2) -> {
                    if (emp1.getDepartment().equals(emp2.getDepartment())) {
                        return emp1.getAge() - emp2.getAge();
                    } else {
                        return emp1.getDepartment().compareTo(emp2.getDepartment());
                    }
                })
                .collect(Collectors.toList());

        System.out.println("\nEmployees sorted by department and age:");
        sortedEmployees.forEach(System.out::println);

        // 92. Stream Peek vs ForEach: Using peek and forEach for debugging and terminal actions
        employees.stream()
                .peek(emp -> System.out.println("Processing employee: " + emp.getName()))
                .forEach(emp -> System.out.println("Finished processing: " + emp.getName()));

        // 93. Stream Reduce with Identity and Accumulator: Using reduce with identity and accumulator functions
        Optional<Employee> highestPaidEmployee = employees.stream()
                .reduce((emp1, emp2) -> emp1.getSalary2() > emp2.getSalary2() ? emp1 : emp2);

        System.out.println("\nEmployee with highest salary: " + highestPaidEmployee.orElse(null));

        // 94. Stream Parallel Processing and Thread Safety: Handling thread safety with parallel streams
        employees.parallelStream()
                .forEach(emp -> System.out.println("Employee processed in parallel: " + emp.getName()));

        // 95. Stream Performance Tuning: Optimizing performance with fewer pipeline stages
        List<String> highSalaryEmployees = employees.stream()
                .filter(emp -> emp.getSalary2() > 60000)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\nHigh salary employees (salary > 60000):");
        System.out.println(highSalaryEmployees);

        // 96. Stream Lazy Evaluation Optimization: Using lazy evaluation to defer computations
	}
	private static void extracted13() {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, 50000, "IT"),
                new Employee(2, "Jane Smith", 25, 60000, "Finance"),
                new Employee(3, "Bob Johnson", 35, 75000, "IT"),
                new Employee(4, "Alice Williams", 28, 45000, "HR"),
                new Employee(5, "Michael Brown", 32, 80000, "Finance")
        );
     // 97. Stream Error Handling: Handling exceptions in stream operations
        try {
            Optional<Employee> employee = employees.stream()
                    .filter(emp -> emp.getAge() < 25)
                    .findFirst();

            employee.ifPresent(emp -> System.out.println("Employee found: " + emp));
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        }

        // 98. Stream API Refactoring and Code Smells: Refactoring complex stream pipelines
        List<String> departments = employees.stream()
                .map(Employee::getDepartment)
                .filter(dept -> !dept.isEmpty())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nDistinct non-empty departments:");
        System.out.println(departments);

        // 99. Stream Optional and Null Handling: Handling null references and Optional values
        Employee nullEmployee = null;
        Optional<Employee> optionalEmployee = Optional.ofNullable(nullEmployee);
        optionalEmployee.ifPresent(emp -> System.out.println("\nOptional employee found: " + emp));

        // 100. Stream API Best Practices and Patterns: Applying best practices with Java Streams
        List<String> employeeNames = employees.stream()
                .filter(emp -> emp.getSalary2() > 50000)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\nEmployee names with salary > 50000:");
        System.out.println(employeeNames);

        // 101. Stream API Performance Considerations: Optimizing stream performance
        List<Employee> highSalaryEmployees = employees.stream()
                .parallel()
                .filter(emp -> emp.getSalary2() > 60000)
                .collect(Collectors.toList());

        System.out.println("\nHigh salary employees (parallel stream):");
        System.out.println(highSalaryEmployees);

        // 102. Stream API Debugging Techniques: Using peek for debugging stream operations
        List<Employee> filteredEmployees = employees.stream()
                .peek(emp -> System.out.println("Filtering employee: " + emp.getName()))
                .filter(emp -> emp.getAge() >= 30)
                .peek(emp -> System.out.println("After filtering: " + emp.getName()))
                .collect(Collectors.toList());

        System.out.println("\nEmployees filtered by age >= 30:");
        System.out.println(filteredEmployees);

        // 103. Stream API Use Cases in Real-World Applications: Example in finance domain
        // Example would involve processing financial data using streams

        // 104. Stream API Integration with External Libraries: Using Guava's Collectors
        // Example integration with Guava's functional collections for advanced operations

        // 105. Stream API Streamlining and Simplification: Simplifying stream operations
        List<String> departmentsStartingWithF = employees.stream()
                .filter(emp -> emp.getDepartment().startsWith("F"))
                .map(Employee::getDepartment)
                .collect(Collectors.toList());

        System.out.println("\nDepartments starting with 'F':");
        System.out.println(departmentsStartingWithF);

        // 106. Stream API Parallelization Strategies: Managing parallel streams and concurrency
        int totalEmployees = employees.parallelStream()
                .mapToInt(emp -> 1)
                .sum();

        System.out.println("\nTotal number of employees (parallel stream): " + totalEmployees);

        // 107. Stream API Performance Testing and Benchmarking: Benchmarking stream performance
        long startTime = System.currentTimeMillis();
        List<Employee> filteredByAge = employees.stream()
                .filter(emp -> emp.getAge() >= 30)
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();

        System.out.println("\nTime taken to filter employees by age: " + (endTime - startTime) + " ms");

        // 108. Stream API Advanced Sorting and Comparator: Advanced sorting with custom comparators
        List<Employee> sortedBySalaryDescending = employees.stream()
                .sorted((emp1, emp2) -> Double.compare(emp2.getSalary2(), emp1.getSalary2()))
                .collect(Collectors.toList());

        System.out.println("\nEmployees sorted by salary (descending):");
        System.out.println(sortedBySalaryDescending);

        // 109. Stream API Advanced Grouping and Aggregation: Advanced grouping with Collectors
        Map<String, Double> averageSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary2)));

        System.out.println("\nAverage salary by department:");
        averageSalaryByDept.forEach((dept, avgSalary) -> System.out.println(dept + ": " + avgSalary));

        // 110. Stream API Stream Chaining and Composition: Chaining multiple stream operations
        List<Employee> chainedOperations = employees.stream()
                .filter(emp -> emp.getSalary2() > 50000)
                .sorted((emp1, emp2) -> emp1.getName().compareTo(emp2.getName()))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("\nChained operations (filtered, sorted, limited):");
        System.out.println(chainedOperations);
	}
	// Helper method to generate a large data set of employees (for demonstration)
	private static List<Employee> generateLargeDataSet() {
	    // Implement your logic to generate a large list of employees
	    // For example, create thousands of employees
	    return Arrays.asList(
	            new Employee(101, "Large John", 30, 50000, "IT"),
	            new Employee(102, "Large Jane", 25, 60000, "Finance"),
	            // Add more employees...
	            new Employee(1000, "Large Michael", 32, 80000, "Finance")
	    );
	}
	 public static void main(String[] args) {
		 
        // Example operations using Streams and Lambdas
        extracted1();
        extracted2();
        extracted3();        
        extracted4();
        
        extracted5();
        extracted6();
        
        extracted7();
        
        extracted8();
        
        extracted9();

        extracted10();
        
        extracted11();
        extracted12();
        
        extracted13();
        
    }
}
