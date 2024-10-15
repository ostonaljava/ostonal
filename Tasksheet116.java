import java.util.Scanner;

public class Tasksheet116 {
  
    public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       String name = scan.nextLine();

       StringBuilder rev = new StringBuilder(name).reverse();
       String newName = rev.toString();

       if (name.equals(newName)) {
            
        System.out.println("The input string is a palindrome.");

       } else {
        
        System.out.println("The input string is not a palindrome.");
       
    }
}
}
