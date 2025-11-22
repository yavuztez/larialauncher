package xyz.laria.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class zf extends pq {
    private final int rwj;

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setColor(this.getBackground());
        graphics2D.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), this.rwj, this.rwj);
        graphics2D.dispose();
    }

    // pq abstract metodunu implemente etmemiz gerek (boş olabilir)
    @Override
    protected void x(Graphics2D var1) {
    }

    public zf(int n) {
        this.rwj = n;
        this.setOpaque(false);
        this.setBackground(Color.WHITE);
    }
}