import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Employee class to store employee details
class Employee {
    int id;
    String name;
    String department;
    double salary;

    // Constructor
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Method to display employee details
    void display() {
        System.out.println("--------------------------------");
        System.out.println("Employee ID   : " + id);
        System.out.println("Name          : " + name);
        System.out.println("Department    : " + department);
        System.out.println("Salary        : " + salary);
        System.out.println("--------------------------------");
    }
}

public class EmployeeManagement {

    // HashMap to store employee records (ID -> Employee Object)
    static HashMap<Integer, Employee> employeeMap = new HashMap<>();

    // Scanner object for user input
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===================================");
        System.out.println(" Welcome to Employee Management App ");
        System.out.println("===================================");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Search Employee by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Add Employee ---");
                    addEmployee();
                    break;

                case 2:
                    System.out.println("\n--- Update Employee ---");
                    updateEmployee();
                    break;

                case 3:
                    System.out.println("\n--- Delete Employee ---");
                    deleteEmployee();
                    break;

                case 4:
                    System.out.println("\n--- Employee List ---");
                    viewEmployees();
                    break;

                case 5:
                    System.out.println("\n--- Search Employee ---");
                    searchEmployee();
                    break;

                case 6:
                    System.out.println("\nThank you for using Employee Management System!");
                    System.out.println("Program terminated successfully.");
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    // Method to add a new employee
    static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        if (employeeMap.containsKey(id)) {
            System.out.println("Employee with this ID already exists!");
            return;
        }

        sc.nextLine(); // clear buffer
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employeeMap.put(id, new Employee(id, name, department, salary));
        System.out.println("Employee added successfully!");
    }

    // Method to update employee details
    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();

        if (!employeeMap.containsKey(id)) {
            System.out.println("Employee not found!");
            return;
        }

        sc.nextLine(); // clear buffer
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Department: ");
        String department = sc.nextLine();

        System.out.print("Enter New Salary: ");
        double salary = sc.nextDouble();

        employeeMap.put(id, new Employee(id, name, department, salary));
        System.out.println("Employee details updated successfully!");
    }

    // Method to delete an employee
    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        if (employeeMap.remove(id) != null) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Method to view all employees
    static void viewEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employee records available.");
            return;
        }

        for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
            entry.getValue().display();
        }
    }

    // Method to search employee by ID
    static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        Employee emp = employeeMap.get(id);
        if (emp != null) {
            emp.display();
        } else {
            System.out.println("Employee not found!");
        }
    }
}
