/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import xyz.florex.ui.zu;

public class zi
extends JTextField {
    private static final long rwv = -2136168594976837191L;

    public zi(Color color) {
        this.setOpaque(false);
        this.setBorder(new zu(color));
    }

    public zi(Color color, Font font, Color color2, Dimension dimension, int n, int n2) {
        this.setOpaque(false);
        this.setBorder(new zu(color));
        this.setFont(font);
        this.setForeground(color2);
        this.setMinimumSize(dimension);
        this.setColumns(n);
        ((zu)this.getBorder()).x(n2);
        ((zu)this.getBorder()).x(true);
    }

    public void x(Image image, int n, int n2) {
        ((zu)this.getBorder()).x(image, n, n2);
    }

    public void x(boolean bl) {
        ((zu)this.getBorder()).x(bl);
    }
}

