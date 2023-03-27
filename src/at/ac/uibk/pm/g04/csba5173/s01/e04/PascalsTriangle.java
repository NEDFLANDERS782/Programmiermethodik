package at.ac.uibk.pm.g04.csba5173.s01.e04;

import java.util.Arrays;

public class PascalsTriangle {
    public static int[][] pascalsTriangle(int height) {
        int[][] triangle = new int[height][];
        for (int i = 0; i < height; i++) {
            triangle[i] = new int[i+1];
            triangle[i][0] = 1;
            triangle[i][triangle[i].length-1] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(pascalsTriangle(Integer.parseInt(args[0]))));
    }
}
