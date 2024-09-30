// Random connections. Write a program that takes as command-line arguments 
// an integer N and a double value p (between 0 and 1), plots N equally spaced dots of size 
// .05 on the circumference of a circle, and then, with probability p for each pair of points, 
// draws a gray line connecting them


import java.util.Random;

public class RandomConnections {

    public static void main(String[] args) {
        int N = 10; 
        double p = 0.3;

        double[][] dots = new double[N][2];

        // Calculate coordinates for the dots
        for (int k = 0; k < N; k++) {
            double angle = 2 * Math.PI * k / N;
            dots[k][0] = Math.cos(angle); // x-coordinate
            dots[k][1] = Math.sin(angle); // y-coordinate
        }

        // Randomly connect dots based on probability p 
        // if the number gennerated is less than p, draw a line between the two dots
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (random.nextDouble() < p) {
                    // Draw a line from dot i to dot j
                    drawLine(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);
                }
            }
        }
    }

    // Placeholder method to represent drawing a line
    private static void drawLine(double x1, double y1, double x2, double y2) {
        System.out.printf("Draw line from (%.2f, %.2f) to (%.2f, %.2f)%n", x1, y1, x2, y2);
    }
}
