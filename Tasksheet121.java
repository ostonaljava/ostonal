import java.util.Scanner;
import static java.lang.Math.*;

public class Tasksheet121 {
	
	public static int add(int a, int b) {
		return addExact(a, b);
	}
	
	public static int subtract(int a, int b) {
		return subtractExact(a, b);
	}
	
	public static int multiply(int a, int b) {
		return multiplyExact(a, b);
	}
	
	public static float divide(int a, int b) {
		return floorDiv(a, b);
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the first number: ");
		int num1 = scan.nextInt();
		System.out.println("Enter the secont number: ");
		int num2 = scan.nextInt();
		
		System.out.println("Addition: " + add(num1, num2));
		System.out.println("Subtraction: " + subtract(num1, num2));
		System.out.println("Mutiplication: " + multiply(num1, num2));
		System.out.println("Division: " + divide(num1, num2));
		
		scan.close();
	}
