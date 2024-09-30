// Histogram. Suppose that the standard input stream is a sequence of double
// values. Write a program that takes an integer N and two double values l and r from the 
// command line and uses StdDraw to plot a histogram of the count of the numbers in the 
// standard input stream that fall in each of the N intervals defined by dividing (l , r) into 
// N equal-sized intervals

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        // Check for correct number of arguments
        if (args.length != 3) {
            System.out.println("Usage: java Histogram <N> <l> <r>");
            return;
        }

        int N = Integer.parseInt(args[0]); // Number of intervals
        double l = Double.parseDouble(args[1]); // Lower bound
        double r = Double.parseDouble(args[2]); // Upper bound

        // Calculate the width of each interval
        double width = (r - l) / N;
        int[] counts = new int[N]; // Array to hold counts for each interval

        // Read numbers from standard input
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            // Determine which interval the number falls into
            if (number >= l && number < r) {
                int index = (int) ((number - l) / width); // Calculate the index
                if (index >= N) {
                    index = N - 1; // Handle case where number is exactly r
                }
                counts[index]++;
            }
        }
        scanner.close();

        // Print the histogram
        System.out.println("Histogram:");
        for (int i = 0; i < N; i++) {
            double intervalStart = l + i * width;
            double intervalEnd = intervalStart + width;
            System.out.printf("[%1$.2f, %2$.2f): %d%n", intervalStart, intervalEnd, counts[i]);
        }
    }
}
