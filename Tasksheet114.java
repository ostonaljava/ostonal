public class Tasksheet114 {
    public static void main(String[] args) {

        // Initial value
        int check = 10;
        String message;
    
        for (int i = 1; i <= check; i++) {

            if (i % 2 == 0) {
                message = i + " is an even number"; // Message for even numbers
            } else {
                message = i + " is an odd number";  // Message for odd numbers
            }
            System.out.println(message);
        }
    }
}
