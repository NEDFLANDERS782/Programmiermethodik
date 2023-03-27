package at.ac.uibk.pm.g04.csba5173.s01.e06;

import codedraw.CodeDraw;
import codedraw.Image;
import codedraw.Palette;

import java.awt.*;
import java.util.Arrays;

public class WhereIsWaldo {

    // converts RGB image into a grayscale array
    public static int[][] convertImage2Array(Image image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] array = new int[height][width];
        Color color;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                color = image.getPixel(col, row);
                array[row][col] = (int) (color.getRed() * 0.3 + color.getGreen() * 0.59 + color.getBlue() * 0.11);
            }
        }
        return array;
    }


    public static int sumAbsoluteDifferences(int[][] subImageArray, int[][] waldoArray) {
        int sum = 0;
        for (int i = 0; i < subImageArray.length; i++) {
            for (int j = 0; j < subImageArray[i].length; j++) {
                sum += Math.abs(subImageArray[i][j] - waldoArray[i][j]);
            }
        }
        return sum;
    }

    public static void drawRectangle(int xPos, int yPos, int width, int height, CodeDraw myDrawObj, Image image) {
        myDrawObj.clear();
        myDrawObj.drawImage(0, 0, image);
        myDrawObj.setColor(Color.RED);
        myDrawObj.setLineWidth(3);
        myDrawObj.drawRectangle(xPos, yPos, width, height);
        myDrawObj.show();
    }

    // detect Waldo by template matching
    public static void detectWaldo(CodeDraw myDrawObj, Image image, Image waldo) {
        int[][] imageArray = convertImage2Array(image);
        int[][] waldoArray = convertImage2Array(waldo);
        int[][] subImageArray = new int[waldoArray.length][waldoArray[0].length];
        int minSum;
        int currentSum;

        for (int k = 0; k < waldoArray.length; k++) {
            subImageArray[k] = Arrays.copyOfRange(imageArray[k], 0, waldoArray[k].length - 1);
        }

        minSum = sumAbsoluteDifferences(subImageArray, waldoArray);
        drawRectangle(0, 0, waldoArray[0].length, waldoArray.length, myDrawObj, image);

        for (int i = 0; i <= imageArray.length - waldoArray.length; i++) {
            for (int j = 0; j <= imageArray[i].length - waldoArray[0].length; j++) {
                for (int k = 0; k < waldoArray.length; k++) {
                    subImageArray[k] = Arrays.copyOfRange(imageArray[i + k], j, j + waldoArray[k].length - 1);
                }
                currentSum = sumAbsoluteDifferences(subImageArray, waldoArray);
                if (currentSum < minSum) {
                    minSum = currentSum;
                    drawRectangle(j, i, waldoArray[0].length, waldoArray.length, myDrawObj, image);
                }
            }
        }
    }


    public static void main(String[] args) {

        // waldo1
        //String linkImage = "https://fileshare.uibk.ac.at/f/281e89b8ab6941a2a6f8/?dl=1"; // image1.png
        //String linkWaldo = "https://fileshare.uibk.ac.at/f/9c3f1c26dce649929411/?dl=1"; // waldo1.png

        // waldo2
        //String linkImage = "https://fileshare.uibk.ac.at/f/0f9894d1aa834fb581d8/?dl=1"; // image2.png
        //String linkWaldo = "https://fileshare.uibk.ac.at/f/80e1d0e93538489791c3/?dl=1"; // waldo2.png

        // waldo3
        String linkImage = "https://fileshare.uibk.ac.at/f/778ed5cbf99a4d5ab450/?dl=1"; // image3.png
        String linkWaldo = "https://fileshare.uibk.ac.at/f/201a5747f8aa40bb9214/?dl=1"; // waldo3.png

        // Load images
        Image image = Image.fromUrl(linkImage);
        Image waldo = Image.fromUrl(linkWaldo);

        // set window size based on the image size
        int width = image.getWidth();
        int height = image.getHeight();
        CodeDraw cd = new CodeDraw(width, height);

        //draw image
        cd.drawImage(0, 0, image);
        cd.show();

        // detect Waldo and show result
        detectWaldo(cd, image, waldo);
    }
}
