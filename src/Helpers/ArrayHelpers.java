package Helpers;

public class ArrayHelpers {
    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int[] createArray(int size) {
        int[] result = new int[size];

        for (int j = 0; j < 3; j++) {
            result[j] = 0;
        }

        return result;
    }

    public static int[] push(int[] array, int value){
        int[] result = ArrayHelpers.createArray(array.length + 1);

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }

        result[result.length-1] = value;

        return result;
    }

}
