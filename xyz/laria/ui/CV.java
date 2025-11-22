package xyz.laria.ui;

import java.awt.Dimension;

public class CV {
    public static int calculateHeaderY(int n, int n2) {
        return n - n2 - 155 - 10;
    }

    public static Dimension getHeaderSize(Dimension dimension) {
        return new Dimension(dimension.width, 155);
    }
}