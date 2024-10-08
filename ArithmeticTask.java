class ArithmeticTask {

    public static void main(String[] args) {
      
        // Standard assignment
        int result = 1 + 2;                // result is now 3
        System.out.println(result);
      
        // The result = result - 1; was changed to result -= 1;
        result -= 1;                       // result is now 2
        System.out.println(result);
      
        // The result = result * 2; was changed to result *= 2;
        result *= 2;                       // result is now 4
        System.out.println(result);
      
        // The result = result / 2; was changed to result /= 2;
        result /= 2;                       // result is now 2
        System.out.println(result);
      
        // The result = result + 8; was changed to result += 8;
        result += 8;                       // result is now 10

        // The result = result % 7; was changed to result %= 7;
        result %= 7;                       // result is now 3
        System.out.println(result);
    }
}
