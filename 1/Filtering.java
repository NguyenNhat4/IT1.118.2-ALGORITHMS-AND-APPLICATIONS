import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FilteringExample {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Reading numbers from input
        System.out.println("Enter numbers (non-number to end):");
        while (scanner.hasNextDouble()) {
            numbers.add(scanner.nextDouble());
        }
        scanner.close();

        // Print max
        double max = Collections.max(numbers);
        System.out.println("Maximum: " + max);

        // Print min
        double min = Collections.min(numbers);
        System.out.println("Minimum: " + min);

        // Print sum of squares
        double sumOfSquares = 0;
        for (double num : numbers) {
            sumOfSquares += num * num;
        }
        System.out.println("Sum of Squares: " + sumOfSquares);

        // Print average
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        double average = sum / numbers.size();
        System.out.println("Average: " + average);

        // Print numbers greater than average
        long countGreater = numbers.stream().filter(n -> n > average).count();
        System.out.println("Count of numbers greater than average: " + countGreater);

        // Print median
        Collections.sort(numbers);
        double median;
        int size = numbers.size();
        if (size % 2 == 0) {
            median = (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2.0;
        } else {
            median = numbers.get(size / 2);
        }
        System.out.println("Median: " + median);
    }
}










