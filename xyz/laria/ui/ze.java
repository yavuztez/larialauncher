// =============================================== //
// Recompile disabled. Please run Recaf with a JDK //
// =============================================== //

// Decompiled with: CFR 0.152
// Class Version: 8
package xyz.laria.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;

public class ze
extends pq
implements MouseListener {
    private static final long rth = -5845593520614757936L;
    private ButtonActionListener rtf;
    private int rti;
    private String ruy;
    private Color rur;
    private boolean rue = false;
    private boolean ruc = false;
    private static Cursor rux = new Cursor(12);

    public ze(String string, ButtonActionListener zm2) {
        this(string, -1, zm2);
    }

    public ze(String string, int n, Font font, Color color, Color color2, ButtonActionListener zm2) {
        this(string, n, zm2);
        this.setFont(font);
        this.setBackground(color);
        this.setForeground(color2);
    }

    public ze(String string, int n, ButtonActionListener zm2) {
        this.ruy = string;
        this.rti = n;
        this.setForeground(Color.WHITE);
        this.setBackground(Color.BLACK);
        this.rur = this.getBackground().brighter();
        this.rtf = zm2;
        this.setCursor(rux);
        this.setFocusable(true);
        this.addMouseListener(this);
    }

    private void x(Cursor cursor) {
        if (this.getCursor().getType() == cursor.getType()) {
            return;
        }
        this.setCursor(cursor);
    }

    @Override
    public void setEnabled(boolean bl) {
        this.rue = false;
        super.setEnabled(bl);
        this.x(bl ? rux : Cursor.getDefaultCursor());
    }

    public void h(boolean bl) {
        this.ruc = bl;
    }

    public void x(String string) {
        if (this.ruy.equals(string)) {
            return;
        }
        this.ruy = string;
        this.repaint();
    }

    public void x(int n) {
        this.rti = n;
    }

    public void x(float f) {
        this.setFont(this.getFont().deriveFont(this.getFont().getStyle(), f));
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        this.rur = color.brighter();
    }

    @Override
    public Color getBackground() {
        if (!this.isEnabled()) {
            return Color.GRAY;
        }
        return super.getBackground();
    }

    public void x(Color color) {
        this.rur = color;
    }

    public void h() {
        if (this.rtf != null) {
            this.rtf.x();
        }
    }

    @Override
    protected void x(Graphics2D graphics2D) {
        double d = this.ruc ? (double)this.getHeight() / this.getPreferredSize().getHeight() : 1.0;
        double d2 = this.ruc ? (double)this.getWidth() / this.getPreferredSize().getWidth() : 1.0;
        graphics2D.setColor(this.rue ? this.rur : this.getBackground());
        if (this.rti > 0) {
            int n = (int)((double)this.rti * d);
            graphics2D.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), n, n);
        } else {
            graphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
        double d3 = this.ruc ? (d2 * 1.1 > 1.0 ? 1.0 : d2 * 1.1) : 1.0;
        graphics2D.setFont(this.ruc ? this.getFont().deriveFont((float)((double)this.getFont().getSize() * d3)) : this.getFont());
        graphics2D.setColor(this.getForeground());
        FontMetrics fontMetrics = graphics2D.getFontMetrics(graphics2D.getFont());
        int n = fontMetrics.stringWidth(this.ruy);
        int n2 = (this.getWidth() - n) / 2 + this.x(graphics2D.getFont());
        int n3 = (this.getHeight() - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        graphics2D.drawString(this.ruy, n2, n3);
        graphics2D.dispose();
    }

    private int x(Font font) {
        if (font.getAttributes() == null || !font.getAttributes().containsKey(TextAttribute.TRACKING) || font.getAttributes().get(TextAttribute.TRACKING) == null) {
            return 0;
        }
        return (int)(((Float)font.getAttributes().get(TextAttribute.TRACKING)).floatValue() * 10.0f) + 1;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (!this.isEnabled()) {
            return;
        }
        this.h();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        if (!this.isEnabled()) {
            return;
        }
        this.rue = true;
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        if (!this.isEnabled()) {
            return;
        }
        this.rue = false;
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }
}
 