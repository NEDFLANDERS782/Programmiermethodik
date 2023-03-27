package at.ac.uibk.pm.g04.csba5173.s01.e02;

public class PrintArray {

    public static void printArray(int[][] array, String divider) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + divider);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        printArray(array, " | ");
    }
}
