import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(); // Create an instance of the ATM class

        // Welcome message
        System.out.println("Welcome to the ATM!");

        // Login prompt
        System.out.print("Enter your account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        // Perform login
        boolean loginSuccess = atm.login(accountNumber, pin);
        if (!loginSuccess) {
            System.out.println("Invalid account number or PIN. Exiting...");
            return;
        }

        // Main menu
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Check balance
                    double balance = atm.checkBalance();
                    System.out.println("Your balance is: $" + balance);
                    break;
                case 2:
                    // Withdraw
                    System.out.print("Enter the amount to withdraw: $");
                    double amountToWithdraw = scanner.nextDouble();
                    boolean withdrawalSuccess = atm.withdraw(amountToWithdraw);
                    if (withdrawalSuccess) {
                        System.out.println("Withdrawal successful. Please take your cash.");
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                    break;
                case 3:
                    // Deposit
                    System.out.print("Enter the amount to deposit: $");
                    double amountToDeposit = scanner.nextDouble();
                    atm.deposit(amountToDeposit);
                    System.out.println("Deposit successful.");
                    break;
                case 4:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

class ATM {
    private int accountNumber;
    private int pin;
    private double balance;

    // Sample account details
    private final int SAMPLE_ACCOUNT_NUMBER = 123456;
    private final int SAMPLE_PIN = 1234;
    private final double SAMPLE_BALANCE = 1000.0;

    public boolean login(int accountNumber, int pin) {
        if (accountNumber == SAMPLE_ACCOUNT_NUMBER && pin == SAMPLE_PIN) {
            this.accountNumber = accountNumber;
            this.pin = pin;
            this.balance = SAMPLE_BALANCE;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}