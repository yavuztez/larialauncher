package xyz.laria.ui;

import java.awt.Color;
import javax.swing.JTextArea;

public class zq
        extends JTextArea {
    private final double rwu;
    private static final long rws = 1481747805214088012L;

    public zq(double d) {
        this.rwu = d;
        this.setCaretColor(new Color(60, 60, 60));
        this.setSelectionColor(new Color(60, 60, 60, 50));
        this.setDisabledTextColor(new Color(150, 150, 150));
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setOpaque(false);
    }

    public double v() {
        return this.rwu;
    }
}