package at.ac.uibk.pm.g04.csba5173.s01.e05;

import codedraw.CodeDraw;
import codedraw.Palette;

public class Circles {
    private static final int WIDTH = 650;
    private static final int HEIGHT = 600;
    private static final double RADIUS = 150;

    public static void main(String[] args) {
        CodeDraw cd = new CodeDraw(WIDTH, HEIGHT);
        cd.setLineWidth(2);
        cd.setColor(Palette.BLACK);
        cd.drawCircle((WIDTH/2),(HEIGHT/2), RADIUS);

        cd.setColor(Palette.GREEN);
        for (int angle = 0; angle < 360; angle += 60) {
            cd.drawCircle(WIDTH/2 + Math.cos(Math.toRadians(angle)) * RADIUS,HEIGHT/2 + Math.sin(Math.toRadians(angle)) * RADIUS, RADIUS);
        }
        cd.show();
    }
}
