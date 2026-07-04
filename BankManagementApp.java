import java.util.Scanner;

public class BankManagementApp {
    public static void main(String[] args) {
        // Initialize the Scanner and starting balance
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0;
        boolean isRunning = true;

        System.out.println("Welcome to the Simple Bank Management System!");

        // Loop to keep showing the menu until the user decides to exit
        while (isRunning) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice (1-4): ");

            int choice = scanner.nextInt();

            // Handle the user's choice using a switch statement
            switch (choice) {
                case 1:
                    // Option 1: Check Balance
                    System.out.println("Current Balance: $" + balance);
                    break;

                case 2:
                    // Option 2: Deposit Money
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    
                    // Validate that the deposit is positive
                    if (depositAmount > 0) {
                        balance += depositAmount; // Add to balance
                        System.out.println("Successfully deposited $" + depositAmount);
                    } else {
                        System.out.println("Error: Deposit amount must be greater than zero.");
                    }
                    break;

                case 3:
                    // Option 3: Withdraw Money
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    
                    // Check for valid withdrawal conditions
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount; // Subtract from balance
                        System.out.println("Successfully withdrew $" + withdrawAmount);
                    } else if (withdrawAmount > balance) {
                        System.out.println("Error: Insufficient funds! Your current balance is $" + balance);
                    } else {
                        System.out.println("Error: Withdrawal amount must be greater than zero.");
                    }
                    break;

                case 4:
                    // Option 4: Exit the program
                    System.out.println("Thank you for using our Bank Management System. Goodbye!");
                    isRunning = false; // This stops the while loop
                    break;

                default:
                    // Handle invalid menu choices
                    System.out.println("Error: Invalid choice! Please enter a number between 1 and 4.");
            }
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}