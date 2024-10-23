import java.util.Scanner;

public class Tasksheet117 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        // Create an array to store 3 numbers
        int numbers[] = new int[3];
        
        // Get input from the user
        System.out.println("Enter three numbers: ");

        for (int i = 0; i < 3; i++) {
            numbers[i] = scan.nextInt();
        }

        // Checks if all the numbers are equal
        if (numbers[0] == numbers[1] && numbers[1] == numbers[2]) {
            System.out.println("All numbers are equal.");

        } else {

            // Find the largest number
            int largest = numbers[0];
            for (int i = 1; i < 3; i++) {
                if (numbers[i] > largest) {
                    largest = numbers[i];
                }
            }
            System.out.println("The largest number is: "+ largest);
        }
        scan.close();
    }
}
