package com.edu.metrostate.ics340.j_czech;

/**
 * @author Jamison Czech <A HREF="mailto:main@jamisonczech@gmail.com">
 * (jamisonczech@gmail.com) </A>
 */

/**
 * Class representing square matrix of given size.
 * It has methods to print matrix.
 * And also to transpose matrix.
 * <p>
 */
class MatrixHelper {
    private int[][] matrix;

    /** <p>
     * Factorial function used to calculate the number of solutions
     * </p>
     *
     * <b>Precondition:</b>
     *  <CODE>n</CODE> is nonnegative.
     * @param n
     *  number to become factorialised
     * <b>PostCondition:</b>
     *  Returns the factorial value for the argument
     *  when method is activated.
     * @return
     *  returns the factorial value of the argument that
     *  was passed into the method.
     */
    public static int factorial(int n) {

        if (n <= 1) return 1;
        else return (n * factorial(n - 1));
    }


    /**
     *
     * @param matrix
     * @return
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transposeMatrix = new int[n][m];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                transposeMatrix[x][y] = matrix[y][x];
            }
        }

        return transposeMatrix;
    }

    /**
     *
     * @param m
     */
    public void printMatrix(int[][] m) {
        try {
            int rows = m.length;
            int columns = m[0].length;
            String str = "|\t";

            System.out.println("\n2D Adjacency Matrix : ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    str += m[i][j] + "\t";
                }

                System.out.println(str + "|");
                str = "|\t";
            }

        } catch (Exception e) {
            System.out.println("Matrix is empty!!");
        }
    }

    long totalRuntime = 0;

}