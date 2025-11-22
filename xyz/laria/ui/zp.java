package xyz.laria.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class zp extends pq {
    private String rwg;
    private Color rwi;
    private Font rwa;
    private TextAlignment rwe = TextAlignment.rwc;
    private static final long rwc = 7183359654153093120L;

    public zp(String string, Font font, Color color, TextAlignment textAlignment) {
        this.rwg = string;
        this.rwa = font;
        this.rwi = color;
        this.rwe = textAlignment;
        this.setBackground(Color.WHITE);
        this.setOpaque(false);
    }

    public zp(String string, Font font, Color color) {
        this(string, font, color, TextAlignment.rwc);
    }

    @Override
    protected void x(Graphics2D graphics2D) {
        int n;
        graphics2D.setFont(this.rwa);
        graphics2D.setColor(this.rwi);
        FontMetrics fontMetrics = graphics2D.getFontMetrics(this.rwa);
        int n2 = fontMetrics.getHeight() / 2 + fontMetrics.getAscent() / 2;
        if (this.rwe == TextAlignment.rwc) {
            n = (this.getWidth() - fontMetrics.stringWidth(this.rwg)) / 2;
        } else if (this.rwe == TextAlignment.rwd) {
            n = 0;
        } else {
            n = this.getWidth() - fontMetrics.stringWidth(this.rwg);
        }
        graphics2D.drawString(this.rwg, n, n2);
        graphics2D.dispose();
    }

    public static enum TextAlignment {
        rwc("CENTER", 0),
        rwd("LEFT", 1),
        rwb("RIGHT", 2);

        // FIX: Constructor eklendi
        private TextAlignment(String s, int i) {}
    }
}