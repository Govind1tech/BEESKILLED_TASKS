import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Basic Calculator ---");

        // Get the first number
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        // Get the operator
        System.out.print("Enter the operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        // Get the second number
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result = 0;
        boolean validOperation = true;

        // Perform the calculation based on the operator
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // Check for division by zero to avoid program crash
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Error: Invalid operator! Please use +, -, *, or /.");
                validOperation = false;
        }

        // Display the result if the operation was valid
        if (validOperation) {
            System.out.println("\nResult:");
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}