import java.util.Scanner;

class User {
    private int userID;
    private int pin;
    private String name;
    private double balance;

    public User(int userID, int pin, String name, double balance) {
        this.userID = userID;
        this.pin = pin;
        this.name = name;
        this.balance = balance;
    }

    public int getUserID() {
        return userID;
    }

    public int getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class bankingApplication {
    private static User[] users = {
        new User(412435, 7452, "Chris Sandoval", 32000),
        new User(264863, 1349, "Marc Yim", 1000)
    };

    private static User loggedInUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {
            System.out.println("Welcome to the Banking Application!");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1: {
                    login(scanner);
                    break;
                }
                case 2: {
                    exit = true;
                    System.out.println("Thank you for using the Banking Application");
                    break;
                }
                default: {
                    System.out.println("Invalid option. Please try again.");
                    break;
                }
            }
        }
        scanner.close();
    }

    private static void login(Scanner scanner) {
        System.out.println("Enter User ID: ");
        int userID = scanner.nextInt();
        System.out.println("Enter 4-digit PIN: ");
        int pin = scanner.nextInt();

        for(User user : users) {
            if(user.getUserID() == userID && user.getPin() == pin) {
                loggedInUser = user;
                System.out.println("Login successful! Welcome, " + loggedInUser.getName() + "!");
                userMenu(scanner);
                return;
            }
        }
        System.out.println("Invalid User ID or PIN. Please try again.");
    }

    private static void userMenu(Scanner scanner) {
        boolean logout = false;

        while(!logout) {
            System.out.println("User Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Cash-In");
            System.out.println("3. Money Transfer");
            System.out.println("4. Logout");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    checkBalance();
                    break;
                }
                case 2: {
                    cashIn(scanner);
                    break;
                }
                case 3: {
                    moneyTransfer(scanner);
                    break;
                }
                case 4: {
                    logout = true;
                    System.out.println("Logged out successfully!");
                    break;
                }
                default: {
                    System.out.println("Invalid option. Please try again.");
                    break;
                }
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: " + loggedInUser.getBalance());
    }

    private static void cashIn(Scanner scanner) {
        System.out.println("Enter the amount to cash in: ");
        double amount = scanner.nextDouble();

        if(amount > 0) {
            loggedInUser.setBalance(loggedInUser.getBalance() + amount);
            System.out.println("Cash-in successful! Your new balance is: " + loggedInUser.getBalance()); 
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    private static void moneyTransfer(Scanner scanner) {
        System.out.println("Enter the recipient's User ID: ");
        int recipientID = scanner.nextInt();
        System.out.println("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        if(amount <= 0 || amount > loggedInUser.getBalance()) {
            System.out.println("Invalid amount. Transfer failed");
            return;
        }

        for(User user : users) {
            if(user.getUserID() == recipientID) {
                loggedInUser.setBalance(loggedInUser.getBalance() - amount);
                user.setBalance(user.getBalance() + amount);
                System.out.println("Transfer successful! You sent " + amount + " to " + user.getName());
                System.out.println("Your new balance is: " + loggedInUser.getBalance());
                return;
            }
        }
        System.out.println("Recipient not found. Transfer failed.");
    }
}
