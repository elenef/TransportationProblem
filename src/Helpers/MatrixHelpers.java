package Helpers;


public class MatrixHelpers {

    public static int[][] create(int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0;
            }
        }
        return result;
    }

    public static void fillRandomly(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }


    public static int[][] expand(int[][] matrix, boolean rows) {
        int[][] result;

        if (rows) {
            result = create(matrix.length, matrix[0].length + 1);
        } else {
            result = create(matrix.length + 1, matrix[0].length);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }


}
