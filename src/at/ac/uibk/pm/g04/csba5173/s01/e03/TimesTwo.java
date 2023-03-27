package at.ac.uibk.pm.g04.csba5173.s01.e03;
import java.util.Arrays;

public class TimesTwo {
    public static int timesTwo(int value) {
        value = value * 2;
        return value;
    }

    public static int[] timesTwo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 2 * array[i];
        }
        return array;
    }

    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4};
        int testValue = 4;
        System.out.println(timesTwo(testValue));
        System.out.println(Arrays.toString(timesTwo(testArray)));
        System.out.println(testValue);
        System.out.println(Arrays.toString(testArray));
    }
}
