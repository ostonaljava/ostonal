import java.util.InputMismatchException;
import java.util.Scanner;

public class Taskshett130 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the first number: ");
            int firstNumber = scanner.nextInt();

            System.out.println("Enter the second number: ");
            int secondNumber = scanner.nextInt();

            int result = firstNumber / secondNumber;
            System.out.println("Result: " + result);

        } catch(ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } catch(InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer.");
        } catch(Exception e) {
            System.out.println("Error: An unexpected error occurred.");
        } finally {
            scanner.close();
        }
    }
}
