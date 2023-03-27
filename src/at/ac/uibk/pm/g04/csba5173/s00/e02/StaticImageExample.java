package at.ac.uibk.pm.g04.csba5173.s00.e02;

import codedraw.*;

public class StaticImageExample {
    public static void main(String[] args) {
        // Creates a new CodeDraw window with the size of 400x400 pixel
        CodeDraw cd = new CodeDraw(400, 400);

        // Sets the drawing color to red
        cd.setColor(Palette.RED);
        // Draws the outline of a rectangle
        cd.drawRectangle(100, 100, 200, 100);
        // Draws a filled Square
        cd.fillSquare(180, 150, 80);

        // Changes the color to light blue
        cd.setColor(Palette.LIGHT_BLUE);
        cd.fillCircle(300, 200, 50);

        // Finally, the method show must be called
        // to display the drawn shapes in the CodeDraw window.
        cd.show();
    }
}