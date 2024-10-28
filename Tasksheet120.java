public class Tasksheet120 {
  
	// Method to calculate the cunulative sums and the total sum  
	public static int cumulativeSum(int... numbers) {

    // Store the total sum of all the parameters
		int totalSum = 0;

    // Loop through each number
		for (int num : numbers) {
			int cumulative = 0;

      // Calculate the sum of the current number
			for (int i = 1; i <= num; i++) {
				cumulative += i;
			}
      // Print the cumulative sum for the current number
			System.out.println("Cumulative sum for " + num + " is: " + cumulative);

      // Add the cumulative sum to the total sum
			totalSum += cumulative;
		}
    // Return the total sum of all numbers
		return totalSum;
	}

	public static void main(String[] args) {
		
		int total = cumulativeSum(4, 5, 10);
		
		System.out.println("The total sum of the cumulative sums is " + total);
	}
}
