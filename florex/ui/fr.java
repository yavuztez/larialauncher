/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URI;
import java.net.URL;
import xyz.florex.ui.pq;

public class fr
extends pq
implements MouseListener,
MouseMotionListener {
    private static final long kb = 2456452401990681139L;
    private String kt;
    private String ku;
    private Font ks;
    private Font kw;
    private Rectangle kn;
    private URI kj;
    private static Cursor kv = new Cursor(12);

    public fr(String string, String string2) {
        this.kt = string;
        this.ku = string2;
        this.kn = new Rectangle(0, 0, 0, 0);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void x(Font font, Font font2) {
        this.ks = font;
        this.kw = font2;
    }

    public void x(String string) {
        if (string == null || string.isEmpty()) {
            return;
        }
        try {
            this.kj = new URL(string).toURI();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    protected void x(Graphics2D graphics2D) {
        double d;
        double d2 = (double)this.getHeight() / this.getPreferredSize().getHeight();
        double d3 = d = d2 * 1.5 > 1.0 ? 1.0 : d2 * 1.5;
        if (d2 <= 0.6) {
            d = d2 * 2.5;
        }
        Font font = d == 1.0 ? this.ks : this.ks.deriveFont((float)((double)this.ks.getSize() * d));
        Font font2 = d == 1.0 ? this.kw : this.kw.deriveFont((float)((double)this.kw.getSize() * d));
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        FontMetrics fontMetrics2 = graphics2D.getFontMetrics(font2);
        int n = fontMetrics2.stringWidth(this.kt) + fontMetrics.stringWidth(this.ku);
        int n2 = (this.getWidth() - n) / 2;
        this.kn.setBounds(n2, 0, n, Math.max(fontMetrics.getHeight(), fontMetrics2.getHeight()));
        graphics2D.setFont(font2);
        graphics2D.setColor(this.getForeground());
        graphics2D.drawString(this.kt, n2, fontMetrics2.getAscent());
        graphics2D.setFont(font);
        graphics2D.setColor(this.getForeground());
        graphics2D.drawString(this.ku, n2 += fontMetrics2.stringWidth(this.kt), fontMetrics.getAscent());
        graphics2D.dispose();
    }

    private void x(Cursor cursor) {
        if (this.getCursor().getType() == cursor.getType()) {
            return;
        }
        this.setCursor(cursor);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        if (this.kn.contains(mouseEvent.getX(), mouseEvent.getY())) {
            this.x(kv);
            return;
        }
        this.x(Cursor.getDefaultCursor());
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (this.kn.contains(mouseEvent.getX(), mouseEvent.getY()) && this.kj != null) {
            try {
                Desktop.getDesktop().browse(this.kj);
            } catch (Exception exception) {
                // empty catch block
            }
            return;
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}

