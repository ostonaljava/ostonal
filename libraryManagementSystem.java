import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private int stock;

    public Book(int bookID, String title, String author, int stock) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

abstract class User {
    private int userID;
    private int pin;

    public User(int userID, int pin) {
        this.userID = userID;
        this.pin = pin;
    }

    public int getUserID() {
        return userID;
    }

    public int getPin() {
        return pin;
    }

    public abstract void menu(Scanner scanner, ArrayList<Book> books);
}

class Member extends User {
    public Member(int userID, int pin) {
        super(userID, pin);
    }

    @Override
    public void menu(Scanner scanner, ArrayList<Book> books) {
        boolean exit = false;

        while(!exit) {
            System.out.println("\nMember Menu:");
            System.out.println("1. View Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Logout");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1: {
                    viewBooks(books);
                    break;
                }
                case 2: {
                    borrowBook(scanner, books);
                    break;
                }
                case 3: {
                    returnBook(scanner, books);
                    break;
                }
                case 4: {
                    exit = true;
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

    private void viewBooks(ArrayList<Book> books) {
        System.out.println("\nAvailable Books:");

        for(Book book : books) {
            if(book.getStock() > 0) {
                System.out.println("ID: " + book.getBookID() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Stock: " + book.getStock());
            }
        }
    }

    private void borrowBook(Scanner scanner, ArrayList<Book> books) {
        System.out.println("\nEnter Book ID to borrow: ");
        int bookID = scanner.nextInt();

        for(Book book : books) {
            if(book.getBookID() == bookID) {
                if(book.getStock() > 0) {
                    book.setStock(book.getStock() - 1);
                    System.out.println("You have successfully borrowed \"" + book.getTitle() + "\".");
                } else {
                    System.out.println("Sorry, \"" + book.getTitle() + "\" is out of stock.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void returnBook(Scanner scanner, ArrayList<Book> books) {
        System.out.println("\nEnter Book ID to return: ");
        int bookID = scanner.nextInt();

        for(Book book : books) {
            if(book.getBookID() == bookID) {
                book.setStock(book.getStock() + 1);
                System.out.println("You have successfully returned \"" + book.getTitle() + "\".");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

class Librarian extends User {
    public Librarian(int userID, int pin) {
        super(userID, pin);
    }

    @Override
    public void menu(Scanner scanner, ArrayList<Book> books) {
        boolean exit = false;

        while(!exit) {
            System.out.println("\nLibrarian Menu:");
            System.out.println("1. View All Books");
            System.out.println("2. Add a Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Logout");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1: {
                    viewBooks(books);
                    break;
                }
                case 2: {
                    addBook(scanner, books);
                    break;
                }
                case 3: {
                    removeBook(scanner, books);
                    break;
                }
                case 4: {
                    exit = true;
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

    private void viewBooks(ArrayList<Book> books) {
        System.out.println("\nAll Books:");
        for(Book book : books) {
            System.out.println("ID: " + book.getBookID() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Stock: " + book.getStock());
        }
    }

    private void addBook(Scanner scanner, ArrayList<Book> books) {
        System.out.println("\nEnter Book ID: ");
        int bookID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter Author: ");
        String author = scanner.nextLine();
        System.out.println("Enter Stock: ");
        int stock = scanner.nextInt();

        books.add(new Book(bookID, title, author, stock));
        System.out.println("Book added successfully.");
    }

    private void removeBook(Scanner scanner, ArrayList<Book> books) {
        System.out.println("\nEnter Book ID to remove: ");
        int bookID = scanner.nextInt();

        for(Book book : books) {
            if(book.getBookID() == bookID) {
                books.remove(book);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

public class libraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(101, "The Great Gatsby", "F. Scott Fitzgerald", 5));
        books.add(new Book(102, "1984", "George Orwell", 3));
        books.add(new Book(103, "To Kill a Mockingbird", "Harper Lee", 4));

        User[] users = {
            new Member(1001, 1234),
            new Librarian(2001, 5678)
        };

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {
            System.out.println("\nLibrary Management System");
            System.out.println("Enter User ID: ");
            int userID = scanner.nextInt();
            System.out.println("Enter PIN: ");
            int pin = scanner.nextInt();

            User loggedInUser = null;
            for(User user : users) {
                if(user.getUserID() == userID && user.getPin() == pin) {
                    loggedInUser = user;
                    break;
                }
            }

            if(loggedInUser != null) {
                loggedInUser.menu(scanner, books);
            } else {
                System.out.println("Invalid User ID or PIN. Please try again.");
            }
        }

        scanner.close();
    }

}
