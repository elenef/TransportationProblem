package Helpers;


public class MatrixHelpers {

    public static int[][] createMatrix(int line, int columns){
        int[][] result = new int[line][columns];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = 0;
            }
        }
        return result;
    }

    public static int[][] RandomMatrix(int line, int columns){
        int[][] result = new int[line][columns];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = (int)(Math.random()*10);
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix,int line, int columns){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

}
