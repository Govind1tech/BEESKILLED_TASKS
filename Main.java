import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager();

        try (Scanner sc = new Scanner(System.in)) {

            int choice;

            do {

                System.out.println("\n====== Employee Management System ======");

                System.out.println("1. Add Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Save to File");
                System.out.println("4. Load from File");
                System.out.println("5. Exit");

                System.out.print("Enter Choice: ");

                try {

                    choice = sc.nextInt();

                    switch (choice) {
                        case 1 -> {
                            System.out.print("Enter Employee ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Department: ");
                            String dept = sc.nextLine();

                            System.out.print("Enter Salary: ");
                            double salary = sc.nextDouble();

                            manager.addEmployee(new Employee(id, name, dept, salary));
                        }
                        case 2 -> manager.displayEmployees();
                        case 3 -> manager.saveToFile();
                        case 4 -> manager.loadFromFile();
                        case 5 -> System.out.println("Thank You!");
                        default -> System.out.println("Invalid Choice!");
                    }

                } catch (InputMismatchException e) {

                    System.out.println("Invalid Input! Please Enter Correct Data.");

                    sc.nextLine();

                    choice = 0;
                }

            } while (choice != 5);
        }
    }
}
