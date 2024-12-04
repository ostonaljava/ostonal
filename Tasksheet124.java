import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Tasksheet124 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -2, 10, 15, -7, 8, 0, 21, -3, 5);

        Predicate<Integer> isPositive = num -> num >= 0;
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isGreaterThan10 = num -> num > 10;

        List<Integer> positiveNumbers = numbers.stream()
        .filter(isPositive)
        .collect(Collectors.toList());

        List<Integer> evenNumbers = numbers.stream()
        .filter(isEven)
        .collect(Collectors.toList());

        List<Integer> numbersGreaterThan10 = numbers.stream()
        .filter(isGreaterThan10)
        .collect(Collectors.toList());

        System.out.println("Original List: " + numbers);
        System.out.println("Positive Numbers: " + positiveNumbers);
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Numbers Greater Than 10: " + numbersGreaterThan10);
    }
}
