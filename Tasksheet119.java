import java.util.Scanner;

public class Tasksheet119 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.println("Enter secont number: ");
        int num2 = scanner.nextInt();

        System.out.println("Addition: " + add(num1, num2));

        System.out.println("Subtraction: " + minus(num1, num2));

        System.out.println("Multiplication: " + multiply(num1, num2));

        System.out.println("Division: " + divide(num1, num2));

        scanner.close();
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
