public class Matrix {

    // Computes the dot product of two vectors
    public static double dot(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Vectors must be of the same length");
        }
        double product = 0;
        for (int i = 0; i < x.length; i++) {
            product += x[i] * y[i];
        }
        return product;
    }

    // Multiplies two matrices
    public static double[][] mult(double[][] a, double[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix A's columns must equal Matrix B's rows");
        }

        double[][] product = new double[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                product[i][j] = dot(a[i], getColumn(b, j));
            }
        }
        return product;
    }

    // Returns a specific column of a matrix
    private static double[] getColumn(double[][] matrix, int colIndex) {
        double[] column = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }

    // Transposes a matrix
    public static double[][] transpose(double[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        double[][] transposed = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = a[i][j];
            }
        }
        return transposed;
    }

    // Multiplies a matrix by a vector
    public static double[] mult(double[][] a, double[] x) {
        int rows = a.length;
        int cols = a[0].length;
        if (cols != x.length) {
            throw new IllegalArgumentException("Matrix columns must equal vector length");
        }
        double[] result = new double[rows];
        for (int i = 0; i < rows; i++) {
            result[i] = dot(a[i], x);
        }
        return result;
    }

    // Multiplies a vector by a matrix
    public static double[] mult(double[] y, double[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        if (y.length != rows) {
            throw new IllegalArgumentException("Vector length must equal matrix rows");
        }
        double[] result = new double[cols];
        for (int j = 0; j < cols; j++) {
            result[j] = dot(y, getColumn(a, j));
        }
        return result;
    }
}
