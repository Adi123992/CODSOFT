import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner s;

    public ATM(BankAccount acc) {
        account = acc;
        s = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + account.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depAmt = s.nextDouble();
                    account.deposit(depAmt);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withAmt = s.nextDouble();
                    account.withdraw(withAmt);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 4);
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000); // starting balance
        ATM atm = new ATM(myAccount);
        atm.showMenu();
    }
}
  
