package prja.leetcode.challange.lambda;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	
    static class YearMonthKey {
	        private int year;
	        private Month month;

	        public YearMonthKey(int year, Month month) {
	            this.year = year;
	            this.month = month;
	        }

	        @Override
	        public boolean equals(Object o) {
	            if (this == o) return true;
	            if (o == null || getClass() != o.getClass()) return false;

	            YearMonthKey that = (YearMonthKey) o;

	            if (year != that.year) return false;
	            return month == that.month;
	        }

	        public Month getMonth() {
	            return month;
	        }

	        public int getYear() {
	            return year;
	        }

	        @Override
	        public int hashCode() {
	            int result = year;
	            result = 31 * result + (month != null ? month.hashCode() : 0);
	            return result;
	        }

	        @Override
	        public String toString() {
	            return "YearMonthKey{" +
	                    "year=" + year +
	                    ", month=" + month +
	                    '}';
	        }
	    }

	public static void main(String[] args) {
    	
		/*
		 * Scenario-1
		 * 
		 * Suppose we have a list of sales transactions, where each transaction includes
		 * information about the sales amount, the product category, and the
		 * salesperson's name. We want to perform the following operations using Java
		 * Lambda/Streams:
		 * 
		 * Average Sales Amount by Product Category: Calculate the average sales amount
		 * for each product category.
		 * 
		 * Total Sales Amount by Salesperson: Calculate the total sales amount for each
		 * salesperson.
		 * 
		 * Group Sales Transactions by Product Category: Group the sales transactions by
		 * product category.
		 */
        Scenario1();
        
        
		/*
		 * Scenario-2
		 * 
		 * Suppose we have a list of Employee objects, where each employee has
		 * attributes such as name, department, salary, and a list of Project objects
		 * they are involved in. We want to perform the following operations using Java
		 * Lambda/Streams:
		 * 
		 * Filter Employees by Department: Filter employees who belong to a specific
		 * department.
		 * 
		 * Map Employees to Project Names: Create a list of project names for each
		 * employee.
		 * 
		 * Sort Employees by Salary: Sort employees based on their salary in descending
		 * order.
		 * 
		 * Summarize Employee Statistics: Calculate the total number of employees,
		 * average salary, and highest salary in the company.
		 */  
        
        scenario2();
    
        
		/*
		 * Scenario-3
		 * 
		 * Suppose we have a list of Book objects, where each book has attributes such
		 * as title, author, genre, publication year, and rating. We want to perform the
		 * following operations using Java Lambda/Streams:
		 * 
		 * Filter Books by Genre: Filter books that belong to a specific genre (e.g.,
		 * "Fiction").
		 * 
		 * Map Books to Titles: Create a list of book titles for books published after a
		 * certain year.
		 * 
		 * Group Books by Author: Group books by author and collect them into a map
		 * where the key is the author's name and the value is a list of books written
		 * by that author.
		 * 
		 * Calculate Average Rating: Calculate the average rating of books published
		 * between a specified range of years.
		 */ 
        
        scenario3();
    
		/*
		 * Scenario-4
		 * 
		 * Suppose we have a list of Student objects, each representing a student with
		 * their information and the courses they are enrolled in. We want to perform
		 * the following operations using Java Lambda/Streams:
		 * 
		 * Filter Students by Grade: Filter students who are in a specific grade level
		 * (e.g., Grade 12).
		 * 
		 * Sort Students by Age: Sort students based on their age in ascending order.
		 * 
		 * Map Students to Course Names: Create a list of course names for each student.
		 * 
		 * Calculate Total Number of Courses: Calculate the total number of courses
		 * across all students.
		 * 
		 * Calculate average grade for each subject 
		 * across all students and identify the subject with the highest average grade. 
		 */
        
        scenario4();
        
		/*
		 * Scenario-5
		 * 
		 * Suppose we have a list of Order objects, each representing an order placed by
		 * a customer. Each order has attributes such as customer name, order date, a
		 * list of OrderItem objects, and total order value. We want to perform the
		 * following operations using Java Lambda/Streams:
		 * 
		 * Filter Orders by Customer: Filter orders placed by a specific customer.
		 * 
		 * Map Orders to Total Order Value: Calculate the total order value for each
		 * order.
		 * 
		 * Group Orders by Year: Group orders by the year in which they were placed and
		 * calculate the total order value for each year.
		 * 
		 * Calculate Total Sales: Calculate the overall total sales from all orders.
		 */
        scenario5();
        
		/*
		 * Scenario-6
		 * 
		 * Suppose we have a list of Employee objects, each representing an employee in
		 * a company. Each employee has attributes such as name, department, salary, and
		 * a list of Skill objects. We want to perform the following operations using
		 * Java Lambda/Streams:
		 * 
		 * Filter Employees by Department: Filter employees who belong to a specific
		 * department (e.g., "Engineering").
		 * 
		 * Sort Employees by Salary: Sort employees based on their salary in descending
		 * order.
		 * 
		 * Map Employees to Skills: Create a list of all unique skills across all
		 * employees.
		 * 
		 * Calculate Average Salary: Calculate the average salary of employees in a
		 * specific department.
		 */
        scenario6();
    
		/*
		 * Scenario-7
		 * 
		 * Suppose we have a list of Product objects, each representing a product in an
		 * e-commerce platform. Each product has attributes such as name, category,
		 * price, and availability status. We want to perform the following operations
		 * using Java Lambda/Streams:
		 * 
		 * Filter Products by Category: Filter products belonging to a specific category
		 * (e.g., "Electronics").
		 * 
		 * Sort Products by Price: Sort products based on their price in ascending
		 * order.
		 * 
		 * Map Products to Names: Create a list of product names for products with a
		 * price greater than a certain threshold.
		 * 
		 * Calculate Total Available Products: Calculate the total number of products
		 * that are currently available (availability = true).
		 */
        
        scenario7();
        
		/*
		 * Scenario-8
		 * 
		 * Suppose we have a list of Transaction objects, each representing a financial
		 * transaction. Each transaction has attributes such as transaction ID, type
		 * (debit or credit), amount, and date. We want to perform the following
		 * operations using Java Lambda/Streams:
		 * 
		 * Filter Transactions by Type: Filter transactions of a specific type (e.g.,
		 * "debit").
		 * 
		 * Group Transactions by Month: Group transactions by the month in which they
		 * occurred and calculate the total amount for each month.
		 * 
		 * Calculate Total Transaction Amount: Calculate the total amount of all
		 * transactions.
		 * 
		 * Find Maximum Transaction Amount: Find the maximum transaction amount among
		 * all transactions.
		 */
        
        scenario8();
    
		/*
		 * Scenario-9
		 * 
		 * Suppose we have a list of Order objects, each representing an order placed by
		 * a customer. Each order contains attributes such as order ID, customer ID,
		 * order date, and a list of OrderItem objects. Each OrderItem represents a
		 * product in the order with attributes such as product ID, quantity, and price.
		 * We want to perform the following operations using Java Lambda/Streams:
		 * 
		 * Filter Orders by Customer: Filter orders placed by a specific customer ID.
		 * 
		 * Group Orders by Year and Month: Group orders by the year and month of the
		 * order date and calculate the total order amount for each group.
		 * 
		 * Calculate Total Order Amount: Calculate the total amount for all orders.
		 * 
		 * Find Maximum Order Amount: Find the maximum order amount among all orders.
		 */
        
       
         scenario9();
         
         
			/*
			 * Scenario-10
			 * 
			 * Suppose we have a list of Employee objects, each representing an employee in
			 * a company. Each employee has attributes such as employee ID, name,
			 * department, salary, and hire date. We want to perform the following
			 * operations using Java Lambda/Streams:
			 * 
			 * Filter Employees by Department: Filter employees belonging to a specific
			 * department (e.g., "Engineering").
			 * 
			 * Sort Employees by Salary: Sort employees based on their salary in descending
			 * order.
			 * 
			 * Group Employees by Department: Group employees by their department and
			 * calculate the average salary for each department.
			 * 
			 * Calculate Total Salary Expense: Calculate the total salary expense for all
			 * employees.
			 */
         scenario10();
         
			/*
			 * Scenario-11
			 * 
			 * Suppose we have a list of Transaction objects, each representing a financial
			 * transaction. Each transaction has attributes such as transaction ID, amount,
			 * type (credit or debit), and timestamp. We want to perform the following
			 * operations using Java Lambda/Streams:
			 * 
			 * Filter Transactions by Type: Filter transactions based on their type (credit
			 * or debit).
			 * 
			 * Map and Calculate Total Credit Amount: Map transactions of type "credit" and
			 * calculate the total credit amount.
			 * 
			 * Calculate Average Transaction Amount: Calculate the average transaction
			 * amount for all transactions.
			 * 
			 * Find Maximum Transaction Amount: Find the maximum transaction amount among
			 * all transactions.
			 */
         scenario11();
     
			/*
			 * Scenario-12
			 * 
			 * Suppose we have a list of Product objects, each representing a product in an
			 * online store. Each product has attributes such as ID, name, category, price,
			 * and availability. We want to perform the following operations using Java
			 * Lambda/Streams:
			 * 
			 * Filter Products by Category: Filter products based on their category (e.g.,
			 * "Electronics").
			 * 
			 * Sort Products by Price: Sort products based on their price in ascending
			 * order.
			 * 
			 * Map and Calculate Total Inventory Value: Map products to their total
			 * inventory value (price * availability) and calculate the sum.
			 * 
			 * Find Maximum Priced Product: Find the product with the maximum price among
			 * all products.
			 */
         
         scenario12();
         
			/*
			 * Scenario-13
			 * 
			 * Suppose we have a list of Employee objects, each representing an employee in
			 * a company. Each employee has attributes such as employee ID, name,
			 * department, salary, and joining date. We want to perform the following
			 * operations using Java Lambda/Streams:
			 * 
			 * Filter Employees by Department: Filter employees based on their department
			 * (e.g., "Engineering").
			 * 
			 * Sort Employees by Salary: Sort employees based on their salary in descending
			 * order.
			 * 
			 * Map and Calculate Total Salary Expense: Map employees to their salaries and
			 * calculate the total salary expense.
			 * 
			 * Group Employees by Department: Group employees by their department and
			 * calculate the average salary for each department.
			 */
      // Sample Employee Data
         scenario13();
    }

	private static void Scenario1() {
		List<SalesTransaction> transactions = Arrays.asList(
                new SalesTransaction("John", "Electronics", new BigDecimal("1200.50")),
                new SalesTransaction("Alice", "Grocery", new BigDecimal("500.75")),
                new SalesTransaction("Bob", "Electronics", new BigDecimal("800.00")),
                new SalesTransaction("Alice", "Electronics", new BigDecimal("1500.25")),
                new SalesTransaction("John", "Grocery", new BigDecimal("300.00"))
        );

        // Average sales amount by product category
        Map<String, Double> avgSalesByCategory = transactions.stream()
                .collect(Collectors.groupingBy(SalesTransaction::getProductCategory,
                        Collectors.averagingDouble(tr -> tr.getAmount().doubleValue())));

        System.out.println("Average Sales Amount by Product Category:");
        avgSalesByCategory.forEach((category, avg) -> System.out.println(category + ": " + avg));

        // Total sales amount by salesperson
        Map<String, BigDecimal> totalSalesBySalesperson = transactions.stream()
                .collect(Collectors.groupingBy(SalesTransaction::getSalesperson,
                        Collectors.reducing(BigDecimal.ZERO, SalesTransaction::getAmount, BigDecimal::add)));

        System.out.println("\nTotal Sales Amount by Salesperson:");
        totalSalesBySalesperson.forEach((salesperson, total) -> System.out.println(salesperson + ": " + total));

        // Group sales transactions by product category
        Map<String, List<SalesTransaction>> transactionsByCategory = transactions.stream()
                .collect(Collectors.groupingBy(SalesTransaction::getProductCategory));

        System.out.println("\nSales Transactions Grouped by Product Category:");
        transactionsByCategory.forEach((category, list) -> {
            System.out.println(category + ": ");
            list.forEach(tr -> System.out.println("\t" + tr.getSalesperson() + " - $" + tr.getAmount()));
        });
	}

	private static void scenario10() {
		List<Employee> employees = Arrays.asList(
                 new Employee(1, "John Doe", "Engineering", new BigDecimal("100000.00"), LocalDate.of(2018, 10, 15)),
                 new Employee(2, "Jane Smith", "Engineering", new BigDecimal("95000.00"), LocalDate.of(2019, 5, 20)),
                 new Employee(3, "Michael Johnson", "Sales", new BigDecimal("80000.00"), LocalDate.of(2020, 2, 8)),
                 new Employee(4, "Emily Davis", "HR", new BigDecimal("75000.00"), LocalDate.of(2017, 12, 12)),
                 new Employee(5, "Robert Wilson", "Engineering", new BigDecimal("110000.00"), LocalDate.of(2016, 8, 25)),
                 new Employee(6, "Lisa Brown", "Sales", new BigDecimal("90000.00"), LocalDate.of(2019, 11, 30))
         );

         // 1. Filter Employees by Department
         String departmentFilter = "Engineering";
         List<Employee> engineeringEmployees = employees.stream()
                 .filter(e -> e.getDepartment().equals(departmentFilter))
                 .collect(Collectors.toList());

         System.out.println("Engineering Employees:");
         engineeringEmployees.forEach(System.out::println);

         // 2. Sort Employees by Salary (Descending)
         List<Employee> employeesSortedBySalary = employees.stream()
                 .sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary()))
                 .collect(Collectors.toList());

         System.out.println("\nEmployees Sorted by Salary (Descending):");
         employeesSortedBySalary.forEach(e -> System.out.println(e.getName() + " - Salary: $" + e.getSalary()));

         // 3. Group Employees by Department and Calculate Average Salary
         Map<String, Double> averageSalaryByDepartment = employees.stream()
                 .collect(Collectors.groupingBy(
                         Employee::getDepartment,
                         Collectors.averagingDouble(e -> e.getSalary().doubleValue())
                 ));

         System.out.println("\nAverage Salary by Department:");
         averageSalaryByDepartment.forEach((dept, avgSalary) ->
                 System.out.println(dept + ": $" + avgSalary));

         // 4. Calculate Total Salary Expense
         BigDecimal totalSalaryExpense = employees.stream()
                 .map(Employee::getSalary)
                 .reduce(BigDecimal.ZERO, BigDecimal::add);

         System.out.println("\nTotal Salary Expense: $" + totalSalaryExpense);
	}

	private static void scenario11() {
		List<Transaction> transactions = Arrays.asList(
                 new Transaction(1, new BigDecimal("100.00"), "debit", LocalDateTime.of(2023, 1, 10, 8, 30)),
                 new Transaction(2, new BigDecimal("150.00"), "credit", LocalDateTime.of(2023, 2, 15, 12, 0)),
                 new Transaction(3, new BigDecimal("75.50"), "credit", LocalDateTime.of(2023, 3, 20, 15, 45)),
                 new Transaction(4, new BigDecimal("200.00"), "debit", LocalDateTime.of(2023, 4, 5, 10, 15)),
                 new Transaction(5, new BigDecimal("50.00"), "credit", LocalDateTime.of(2023, 5, 12, 9, 0))
         );

         // 1. Filter Transactions by Type
         String typeFilter = "credit";
         List<Transaction> creditTransactions = transactions.stream()
                 .filter(t -> t.getType().equals(typeFilter))
                 .collect(Collectors.toList());

         System.out.println("Credit Transactions:");
         creditTransactions.forEach(System.out::println);

         // 2. Map and Calculate Total Credit Amount
         BigDecimal totalCreditAmount = transactions.stream()
                 .filter(t -> t.getType().equals("credit"))
                 .map(Transaction::getAmount)
                 .reduce(BigDecimal.ZERO, BigDecimal::add);

         System.out.println("\nTotal Credit Amount: $" + totalCreditAmount);

         // 3. Calculate Average Transaction Amount
         OptionalDouble averageTransactionAmount = transactions.stream()
                 .mapToDouble(t -> t.getAmount().doubleValue())
                 .average();

         System.out.println("\nAverage Transaction Amount: $" +
                 (averageTransactionAmount.isPresent() ? averageTransactionAmount.getAsDouble() : 0.0));

         // 4. Find Maximum Transaction Amount
         Optional<BigDecimal> maxTransactionAmount = transactions.stream()
                 .map(Transaction::getAmount)
                 .max(BigDecimal::compareTo);

         System.out.println("\nMaximum Transaction Amount: $" +
                 (maxTransactionAmount.isPresent() ? maxTransactionAmount.get() : BigDecimal.ZERO));
	}

	private static void scenario12() {
		List<Product2> products = Arrays.asList(
                 new Product2(1, "Laptop", "Electronics", new BigDecimal("1200.00"), 10),
                 new Product2(2, "Smartphone", "Electronics", new BigDecimal("800.00"), 15),
                 new Product2(3, "Shoes", "Fashion", new BigDecimal("100.00"), 50),
                 new Product2(4, "Headphones", "Electronics", new BigDecimal("150.00"), 20),
                 new Product2(5, "T-shirt", "Fashion", new BigDecimal("20.00"), 100)
         );

         // 1. Filter Products by Category
         String categoryFilter = "Electronics";
         List<Product2> electronicsProducts = products.stream()
                 .filter(p -> p.getCategory().equals(categoryFilter))
                 .collect(Collectors.toList());

         System.out.println("Electronics Products:");
         electronicsProducts.forEach(System.out::println);

         // 2. Sort Products by Price (Ascending)
         List<Product2> productsSortedByPrice = products.stream()
                 .sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
                 .collect(Collectors.toList());

         System.out.println("\nProducts Sorted by Price (Ascending):");
         productsSortedByPrice.forEach(p -> System.out.println(p.getName() + " - Price: $" + p.getPrice()));

         // 3. Map and Calculate Total Inventory Value
         BigDecimal totalInventoryValue = products.stream()
                 .map(p -> p.getPrice().multiply(BigDecimal.valueOf(p.getAvailability())))
                 .reduce(BigDecimal.ZERO, BigDecimal::add);

         System.out.println("\nTotal Inventory Value: $" + totalInventoryValue);

         // 4. Find Maximum Priced Product
         Optional<Product2> maxPricedProduct = products.stream()
                 .max((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));
         

         System.out.println("\nMaximum Priced Product:");
         maxPricedProduct.ifPresent(System.out::println);
	}
   
	private static void scenario13() {
		List<Employee> employees = Arrays.asList(
                 new Employee(1, "John Doe", "Engineering", new BigDecimal("100000.00"), LocalDate.of(2015, 3, 15)),
                 new Employee(2, "Jane Smith", "Finance", new BigDecimal("90000.00"), LocalDate.of(2016, 5, 20)),
                 new Employee(3, "Michael Johnson", "Engineering", new BigDecimal("110000.00"), LocalDate.of(2014, 7, 10)),
                 new Employee(4, "Emily Davis", "HR", new BigDecimal("80000.00"), LocalDate.of(2017, 9, 5)),
                 new Employee(5, "Robert Wilson", "Finance", new BigDecimal("95000.00"), LocalDate.of(2018, 11, 12)),
                 new Employee(6, "Megan Brown", "Engineering", new BigDecimal("105000.00"), LocalDate.of(2019, 2, 28)),
                 new Employee(7, "William Martinez", "HR", new BigDecimal("85000.00"), LocalDate.of(2020, 4, 25))
         );
         

         // 1. Filter Employees by Department
         String departmentFilter = "Engineering";
         List<Employee> filteredEmployees = employees.stream()
                 .filter(e -> e.getDepartment().equals(departmentFilter))
                 .collect(Collectors.toList());

         System.out.println("Employees in " + departmentFilter + " Department:");
         filteredEmployees.forEach(System.out::println);

         // 2. Sort Employees by Salary (Descending)
         List<Employee> sortedEmployees = employees.stream()
                 .sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary()))
                 .collect(Collectors.toList());

         System.out.println("\nEmployees Sorted by Salary (Descending):");
         sortedEmployees.forEach(e -> System.out.println(e.getName() + " - Salary: $" + e.getSalary()));

         // 3. Map and Calculate Total Salary Expense
         BigDecimal totalSalaryExpense = employees.stream()
                 .map(Employee::getSalary)
                 .reduce(BigDecimal.ZERO, BigDecimal::add);

         System.out.println("\nTotal Salary Expense: $" + totalSalaryExpense);

         // 4. Group Employees by Department and Calculate Average Salary
         Map<String, Double> averageSalaryByDepartment = employees.stream()
                 .collect(Collectors.groupingBy(
                         Employee::getDepartment,
                         Collectors.averagingDouble(e -> e.getSalary().doubleValue())
                 ));

         System.out.println("\nAverage Salary by Department:");
         averageSalaryByDepartment.forEach((dept, avgSalary) ->
                 System.out.println(dept + ": $" + avgSalary));
	}

	private static void scenario2() {
		List<Employee> employees = Arrays.asList(
                new Employee("John Doe", "Engineering", new BigDecimal("75000"),
                        new Project("Project A"), new Project("Project B")),
                new Employee("Alice Smith", "HR", new BigDecimal("60000"),
                        new Project("Project C")),
                new Employee("Bob Johnson", "Engineering", new BigDecimal("80000"),
                        new Project("Project B")),
                new Employee("Emily Davis", "Finance", new BigDecimal("70000"),
                        new Project("Project A"), new Project("Project D"))
        );
		
		
        // 1. Filter Employees by Department
        String departmentFilter = "Engineering";
        List<Employee> engineeringEmployees = employees.stream()
                .filter(e -> e.getDepartment().equals(departmentFilter))
                .collect(Collectors.toList());

        System.out.println("Employees in Engineering Department:");
        engineeringEmployees.forEach(e -> System.out.println(e.getName()));

        // 2. Map Employees to Project Names
        List<String> projectNames = employees.stream()
                .flatMap(e -> e.getProjects().stream())
                .map(Project::getName)
                .collect(Collectors.toList());

        System.out.println("\nProject Names:");
        projectNames.forEach(System.out::println);

        // 3. Sort Employees by Salary (Descending)
        List<Employee> sortedBySalary = employees.stream()
                .sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary()))
                .collect(Collectors.toList());

        System.out.println("\nEmployees Sorted by Salary (Descending):");
        sortedBySalary.forEach(e -> System.out.println(e.getName() + " - $" + e.getSalary()));

        // 4. Summarize Employee Statistics
        long totalEmployees = employees.stream().count();
        double averageSalary = employees.stream()
                .mapToDouble(e -> e.getSalary().doubleValue())
                .average()
                .orElse(0.0);
        BigDecimal highestSalary = employees.stream()
                .map(Employee::getSalary)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        System.out.println("\nEmployee Statistics:");
        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("Average Salary: $" + averageSalary);
        System.out.println("Highest Salary: $" + highestSalary);
	}

	private static void scenario3() {
		List<Book> books = Arrays.asList(
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925, 4.2),
                new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, 4.5),
                new Book("1984", "George Orwell", "Fiction", 1949, 4.0),
                new Book("Pride and Prejudice", "Jane Austen", "Classic", 1813, 4.8),
                new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 1951, 4.1),
                new Book("Brave New World", "Aldous Huxley", "Science Fiction", 1932, 4.3),
                new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937, 4.7),
                new Book("Harry Potter", "J.K. Rowling", "Fantasy", 1996, 4.9),
                new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy", 1997, 4.9)
                
        );
		
        // 1. Filter Books by Genre
        String genreFilter = "Fiction";
        List<Book> fictionBooks = books.stream()
                .filter(b -> b.getGenre().equals(genreFilter))
                .collect(Collectors.toList());

        System.out.println("Fiction Books:");
        fictionBooks.forEach(b -> System.out.println(b.getTitle()));

        // 2. Map Books to Titles published after a certain year
        int publicationYearFilter = 1950;
        List<String> titlesAfterYear = books.stream()
                .filter(b -> b.getPublicationYear() > publicationYearFilter)
                .map(Book::getTitle)
                .collect(Collectors.toList());

        System.out.println("\nBook Titles Published After " + publicationYearFilter + ":");
        titlesAfterYear.forEach(System.out::println);

        // 3. Group Books by Author
        Map<String, List<Book>> booksByAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));

        System.out.println("\nBooks Grouped by Author:");
        booksByAuthor.forEach((author, bookList) -> {
            System.out.println(author + ":");
            bookList.forEach(b -> System.out.println("\t" + b.getTitle()));
        });

        // 4. Calculate Average Rating of books published between a range of years
        int startYear = 1900;
        int endYear = 2000;
        double averageRating = books.stream()
                .filter(b -> b.getPublicationYear() >= startYear && b.getPublicationYear() <= endYear)
                .mapToDouble(Book::getRating)
                .average()
                .orElse(0.0);

        System.out.printf("\nAverage Rating of Books published between %d and %d: %.2f\n", startYear, endYear, averageRating);
	}

	private static void scenario4() {
		List<Student> students = Arrays.asList(
                new Student("John Doe", 17, "Male", 12,
                        new Course("Math"), new Course("Physics"), new Course("Chemistry")),
                new Student("Alice Smith", 16, "Female", 11,
                        new Course("History"), new Course("Geography")),
                new Student("Bob Johnson", 18, "Male", 12,
                        new Course("Biology"), new Course("Computer Science")),
                new Student("Emily Davis", 17, "Female", 12,
                        new Course("English"), new Course("Art"))
        );

        // 1. Filter Students by Grade
        int gradeFilter = 12;
        List<Student> grade12Students = students.stream()
                .filter(s -> s.getGrade() == gradeFilter)
                .collect(Collectors.toList());

        System.out.println("Grade 12 Students:");
        grade12Students.forEach(s -> System.out.println(s.getName()));

        // 2. Sort Students by Age
        List<Student> studentsSortedByAge = students.stream()
        		.sorted(Comparator.comparing(Student::getAge))
                //.sorted((s1, s2) -> s1.getAge() - s2.getAge())
                .collect(Collectors.toList());

        System.out.println("\nStudents Sorted by Age:");
        studentsSortedByAge.forEach(s -> System.out.println(s.getName() + " - Age: " + s.getAge()));

        // 3. Map Students to Course Names
        List<List<String>> courseNamesByStudent = students.stream()
                .map(s -> s.getCourses().stream().map(Course::getName).collect(Collectors.toList()))
                .collect(Collectors.toList());

        System.out.println("\nCourse Names by Student:");
        courseNamesByStudent.forEach(System.out::println);

        // 4. Calculate Total Number of Courses
        long totalCourses = students.stream()
                .flatMap(s -> s.getCourses().stream())
                .count();

        System.out.println("\nTotal Number of Courses: " + totalCourses);
	}

	private static void scenario5() {
		List<Order> orders = Arrays.asList(
                new Order("John Doe", LocalDate.of(2022, 5, 12),
                        new OrderItem("Laptop", new BigDecimal("1200.00"), 1),
                        new OrderItem("Mouse", new BigDecimal("20.00"), 2)),
                new Order("Alice Smith", LocalDate.of(2023, 6, 8),
                        new OrderItem("Headphones", new BigDecimal("150.00"), 1)),
                new Order("Bob Johnson", LocalDate.of(2023, 5, 20),
                        new OrderItem("Monitor", new BigDecimal("300.00"), 2),
                        new OrderItem("Keyboard", new BigDecimal("80.00"), 1)),
                new Order("Emily Davis", LocalDate.of(2022, 12, 15),
                        new OrderItem("Tablet", new BigDecimal("500.00"), 1))
        );

        // 1. Filter Orders by Customer
        String customerFilter = "John Doe";
        List<Order> johnsOrders = orders.stream()
                .filter(o -> o.getCustomerName().equals(customerFilter))
                .collect(Collectors.toList());

        System.out.println("Orders placed by " + customerFilter + ":");
        johnsOrders.forEach(System.out::println);

        // 2. Map Orders to Total Order Value
        Map<Order, BigDecimal> orderTotalValueMap = orders.stream()
                .collect(Collectors.toMap(
                        o -> o,
                        o -> o.getItems().stream()
                                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ));

        System.out.println("\nOrder Total Values:");
        orderTotalValueMap.forEach((order, totalValue) ->
                System.out.println(order.getCustomerName() + "'s order on " + order.getOrderDate() + ": $" + totalValue));

        // 3. Group Orders by Year and Calculate Total Order Value
        Map<Integer, BigDecimal> totalSalesByYear = orders.stream()
                .collect(Collectors.groupingBy(
                        o -> o.getOrderDate().getYear(),
                        Collectors.mapping(
                                o -> o.getItems().stream()
                                        .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                                        .reduce(BigDecimal.ZERO, BigDecimal::add),
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));

        System.out.println("\nTotal Sales by Year:");
        totalSalesByYear.forEach((year, totalSales) ->
                System.out.println(year + ": $" + totalSales));

        // 4. Calculate Total Sales
        BigDecimal totalSales = orders.stream()
                .flatMap(o -> o.getItems().stream())
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\nOverall Total Sales: $" + totalSales);
	}

	private static void scenario6() {
		List<Employee> employees = Arrays.asList(
                new Employee("John Doe", "Engineering", 75000,
                        new Skill("Java"), new Skill("Spring"), new Skill("Hibernate")),
                new Employee("Alice Smith", "Engineering", 80000,
                        new Skill("JavaScript"), new Skill("React"), new Skill("Node.js")),
                new Employee("Bob Johnson", "Sales", 60000,
                        new Skill("Sales Management"), new Skill("Negotiation")),
                new Employee("Emily Davis", "Marketing", 70000,
                        new Skill("Digital Marketing"), new Skill("SEO"))
        );

        // 1. Filter Employees by Department
        String departmentFilter = "Engineering";
        List<Employee> engineeringEmployees = employees.stream()
                .filter(e -> e.getDepartment().equals(departmentFilter))
                .collect(Collectors.toList());

        System.out.println("Engineering Employees:");
        engineeringEmployees.forEach(System.out::println);

        // 2. Sort Employees by Salary and  Emply with  Max  salry

		Employee employeesWithMaxSalary = employees.stream()
				.max(Comparator.comparing(Employee::getSalary2))
				.get();
		System.out.println("\nEmployees Swith highest Salary ():" + employeesWithMaxSalary.toString());
		List<Employee> employeesSortedBySalary = employees.stream()
				.sorted((e1, e2) -> Double.compare(e2.getSalary2(), e1.getSalary2()))
				.collect(Collectors.toList());

        System.out.println("\nEmployees Sorted by Salary (Descending):");
        employeesSortedBySalary.forEach(e -> System.out.println(e.getName() + " - Salary: $" + e.getSalary2()));

        // 3. Map Employees to Skills
        Set<Skill> allSkills = employees.stream()
                .flatMap(e -> e.getSkills().stream())
                .collect(Collectors.toSet());

        System.out.println("\nAll Unique Skills:");
        allSkills.forEach(System.out::println);

        // 4. Calculate Average Salary of Employees in a Department
        String department = "Engineering";
        double averageSalary = employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToDouble(Employee::getSalary2)
                .average()
                .orElse(0.0);

        System.out.printf("\nAverage Salary of Employees in %s: $%.2f\n", department, averageSalary);
	}

	private static void scenario7() {
		List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00, true),
                new Product("Mouse", "Electronics", 20.00, false),
                new Product("Shirt", "Fashion", 35.00, true),
                new Product("Mobile Phone", "Electronics", 800.00, true),
                new Product("Book", "Books", 15.00, true),
                new Product("Watch", "Fashion", 250.00, true)
        );

        // 1. Filter Products by Category
        String categoryFilter = "Electronics";
        List<Product> electronicsProducts = products.stream()
                .filter(p -> p.getCategory().equals(categoryFilter))
                .collect(Collectors.toList());

        System.out.println("Electronics Products:");
        electronicsProducts.forEach(System.out::println);

        // 2. Sort Products by Price
        List<Product> productsSortedByPrice = products.stream()
                //.sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
        		.sorted(Comparator.comparing(Product::getPrice))
        		//.sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        System.out.println("\nProducts Sorted by Price (Ascending):");
        productsSortedByPrice.forEach(p -> System.out.println(p.getName() + " - Price: $" + p.getPrice()));

        // 3. Map Products to Names for Products with Price > 100
        double priceThreshold = 100.00;
        List<String> productNamesWithHighPrice = products.stream()
                .filter(p -> p.getPrice() > priceThreshold)
                .map(Product::getName)
                .collect(Collectors.toList());

        System.out.println("\nProduct Names with Price > $" + priceThreshold + ":");
        productNamesWithHighPrice.forEach(System.out::println);

        // 4. Calculate Total Available Products
        long totalAvailableProducts = products.stream()
                .filter(Product::isAvailable)
                .count();

        System.out.println("\nTotal Available Products: " + totalAvailableProducts);
	}

	private static void scenario8() {
		List<Transaction> transactions = Arrays.asList(
                new Transaction(1, "debit", new BigDecimal("500.00"), LocalDate.of(2023, Month.JANUARY, 15)),
                new Transaction(2, "credit", new BigDecimal("1200.00"), LocalDate.of(2023, Month.FEBRUARY, 22)),
                new Transaction(3, "debit", new BigDecimal("300.00"), LocalDate.of(2023, Month.FEBRUARY, 28)),
                new Transaction(4, "debit", new BigDecimal("800.00"), LocalDate.of(2023, Month.MARCH, 10)),
                new Transaction(5, "credit", new BigDecimal("600.00"), LocalDate.of(2023, Month.MARCH, 18)),
                new Transaction(6, "debit", new BigDecimal("1000.00"), LocalDate.of(2023, Month.APRIL, 5)),
                new Transaction(7, "credit", new BigDecimal("400.00"), LocalDate.of(2023, Month.APRIL, 12))
        );

        // 1. Filter Transactions by Type
        String typeFilter = "debit";
        List<Transaction> debitTransactions = transactions.stream()
                .filter(t -> t.getType().equals(typeFilter))
                .collect(Collectors.toList());

        System.out.println("Debit Transactions:");
        debitTransactions.forEach(System.out::println);

        // 2. Group Transactions by Month and Calculate Total Amount
        Map<Month, BigDecimal> totalAmountByMonth = transactions.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getDate().getMonth(),
                        Collectors.mapping(Transaction::getAmount,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));

        System.out.println("\nTotal Amount by Month:");
        totalAmountByMonth.forEach((month, totalAmount) ->
                System.out.println(month + ": $" + totalAmount));

        // 3. Calculate Total Transaction Amount
        BigDecimal totalTransactionAmount = transactions.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\nTotal Transaction Amount: $" + totalTransactionAmount);

        // 4. Find Maximum Transaction Amount
        BigDecimal maxTransactionAmount = transactions.stream()
                .map(Transaction::getAmount)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        System.out.println("\nMaximum Transaction Amount: $" + maxTransactionAmount);
	}
	 private static void scenario9() {
		List<Order> orders = Arrays.asList(
		        new Order(1, 101, LocalDate.of(2023, Month.JANUARY, 10),
		                new OrderItem(1, 2, new BigDecimal("150.00")),
		                new OrderItem(2, 1, new BigDecimal("300.00"))),
		        new Order(2, 102, LocalDate.of(2023, Month.FEBRUARY, 15),
		                new OrderItem(3, 1, new BigDecimal("100.00")),
		                new OrderItem(4, 3, new BigDecimal("50.00"))),
		        new Order(3, 101, LocalDate.of(2023, Month.MARCH, 20),
		                new OrderItem(5, 2, new BigDecimal("200.00"))),
		        new Order(4, 103, LocalDate.of(2023, Month.MARCH, 25),
		                new OrderItem(6, 1, new BigDecimal("120.00")),
		                new OrderItem(7, 2, new BigDecimal("80.00"))),
		        new Order(5, 102, LocalDate.of(2023, Month.APRIL, 5),
		                new OrderItem(8, 1, new BigDecimal("400.00")))
		);
		
		

		// 1. Filter Orders by Customer ID
		int customerIdFilter = 101;
		List<Order> ordersByCustomer = orders.stream()
		        .filter(o -> o.getCustomerId() == customerIdFilter)
		        .collect(Collectors.toList());

		System.out.println("Orders Placed by Customer ID " + customerIdFilter + ":");
		ordersByCustomer.forEach(System.out::println);

		// 2. Group Orders by Year and Month and Calculate Total Order Amount
		Map<YearMonthKey, BigDecimal> totalAmountByYearMonth = orders.stream()
		        .collect(Collectors.groupingBy(
		                o -> new YearMonthKey(o.getOrderDate().getYear(), o.getOrderDate().getMonth()),
		                Collectors.mapping(o -> o.getItems().stream()
		                        .map(oi -> oi.getPrice().multiply(BigDecimal.valueOf(oi.getQuantity())))
		                        .reduce(BigDecimal.ZERO, BigDecimal::add),
		                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
		        ));

		System.out.println("\nTotal Order Amount by Year and Month:");
		totalAmountByYearMonth.forEach((ym, totalAmount) ->
		        System.out.println(ym.getYear() + "-" + ym.getMonth() + ": $" + totalAmount));

		// 3. Calculate Total Order Amount
		BigDecimal totalOrderAmount = orders.stream()
		        .flatMap(o -> o.getItems().stream())
		        .map(oi -> oi.getPrice().multiply(BigDecimal.valueOf(oi.getQuantity())))
		        .reduce(BigDecimal.ZERO, BigDecimal::add);

		System.out.println("\nTotal Order Amount: $" + totalOrderAmount);

		// 4. Find Maximum Order Amount
		BigDecimal maxOrderAmount = orders.stream()
		        .flatMap(o -> o.getItems().stream())
		        .map(oi -> oi.getPrice().multiply(BigDecimal.valueOf(oi.getQuantity())))
		        .max(BigDecimal::compareTo)
		        .orElse(BigDecimal.ZERO);

		System.out.println("\nMaximum Order Amount: $" + maxOrderAmount);
	}

}
