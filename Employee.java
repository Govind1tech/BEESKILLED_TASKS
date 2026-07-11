public class Employee {

    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String toFileString() {
        return id + "," + name + "," + department + "," + salary;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Department: " + department +
                " | Salary: ₹" + salary;
    }
}