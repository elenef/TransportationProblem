package Helpers;

public class ArrayHelpers {

    public static void print(int[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i] + "\t");
        }
        System.out.println("\n------------------");
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int[] createArray(int size) {
        int[] result = new int[size];

        for (int j = 0; j < size; j++) {
            result[j] = 0;
        }

        return result;
    }

    public static int[] push(int[] array, int value) {
        int[] result = ArrayHelpers.createArray(array.length + 1);

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }

        result[result.length - 1] = value;

        return result;
    }

    public static int[] del(int[] array, int position) {
        int[] result = ArrayHelpers.createArray(array.length - 1);

        for (int i = 0; i < position; i++) {
            result[i] = array[i];
        }

        for (int j = position; j < result.length; j++) {
            result[j] = array[j + 1];
        }


        return result;
    }

}
