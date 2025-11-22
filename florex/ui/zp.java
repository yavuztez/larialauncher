/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Insets;
import xyz.florex.ui.pq;

public class zp
extends pq {
    private static final long rwp = -9033229351710961636L;
    private String rwk;
    private TextAlignment rwl = TextAlignment.rwc;
    private Insets rwa;
    private boolean rwo = false;

    public zp(String rwk) {
        this.rwk = rwk;
    }

    public zp(String s, Font font, Color color, TextAlignment textAlignment) {
        this(s, font, color, textAlignment, new Insets(0, 0, 0, 0));
    }

    public zp(String rwk, Font font, Color foreground, TextAlignment rwl, Insets rwa) {
        this.rwk = rwk;
        this.setFont(font);
        this.setForeground(foreground);
        this.rwl = rwl;
        this.rwa = rwa;
    }

    public void x(String rwk) {
        this.rwk = rwk;
        this.repaint();
    }

    public void x(TextAlignment rwl) {
        this.rwl = rwl;
    }

    public void x(Insets rwa) {
        this.rwa = rwa;
    }

    public void h(boolean rwo) {
        this.rwo = rwo;
    }

    @Override
    protected void x(Graphics2D graphics2D) {
        double n = this.rwo ? (double)this.getHeight() / this.getPreferredSize().getHeight() : 1.0;
        graphics2D.setColor(this.getForeground());
        double n2 = this.rwo ? (n * 1.3 > 1.0 ? 1.0 : n * 1.3) : 1.0;
        graphics2D.setFont(this.rwo ? this.getFont().deriveFont((float)((double)this.getFont().getSize() * n2)) : this.getFont());
        FontMetrics fontMetrics = graphics2D.getFontMetrics(graphics2D.getFont());
        if (this.rwl == TextAlignment.rwe) {
            graphics2D.drawString(this.rwk, this.rwa.left, (this.getHeight() - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent() - this.rwa.bottom);
        } else if (this.rwl == TextAlignment.rwc) {
            graphics2D.drawString(this.rwk, (this.getWidth() - fontMetrics.stringWidth(this.rwk)) / 2, (this.getHeight() - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent());
        } else if (this.rwl == TextAlignment.rwx) {
            graphics2D.drawString(this.rwk, this.getWidth() - fontMetrics.stringWidth(this.rwk) - this.rwa.right, (this.getHeight() - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent());
        }
        graphics2D.dispose();
    }

    public static enum TextAlignment {
        rwe("LEFT", 0),
        rwc("CENTER", 1),
        rwx("RIGHT", 2);

        private static final TextAlignment[] rwq;

        private TextAlignment(String name, int ordinal) {
        }

        static {
            rwq = new TextAlignment[]{rwe, rwc, rwx};
        }
    }
}

