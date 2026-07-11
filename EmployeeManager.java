import java.io.*;
import java.util.*;

public class EmployeeManager {

    ArrayList<Employee> employees = new ArrayList<>();

    // Add Employee
    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee Added Successfully!");
    }

    // Display Employees
    public void displayEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No Employees Found.");
            return;
        }

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    // Save to File
    public void saveToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"))) {

            for (Employee emp : employees) {
                writer.write(emp.toFileString());
                writer.newLine();
            }

            System.out.println("Data Saved Successfully!");

        } catch (IOException e) {

            System.out.println("Error Saving File.");

        }
    }

    // Load from File
    public void loadFromFile() {

        employees.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                employees.add(new Employee(id, name, department, salary));
            }

            System.out.println("Data Loaded Successfully!");

        } catch (FileNotFoundException e) {

            System.out.println("No File Found.");

        } catch (IOException e) {

            System.out.println("Error Reading File.");

        }
    }
}