/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import xyz.florex.ui.BackButtonAction;
import xyz.florex.ui.pq;
import xyz.florex.ui.tg;

public class ml
extends pq
implements MouseListener,
MouseMotionListener {
    private static final long kh = 3437916655247848351L;
    private BufferedImage kf;
    private String ki;
    private boolean ly = false;
    private boolean lr = false;
    private BackButtonAction le;
    private Rectangle lc;
    private static Cursor lx = new Cursor(12);

    public ml(BufferedImage bufferedImage, String string, BackButtonAction fa2) {
        this.kf = bufferedImage;
        this.ki = string;
        this.le = fa2;
        this.lc = new Rectangle(0, 0, 0, 0);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void x(boolean bl) {
        this.ly = bl;
        this.repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        double d = (double)this.getTopLevelAncestor().getHeight() / 1080.0;
        return new Dimension(this.getTopLevelAncestor().getWidth(), (int)(406.0 * d));
    }

    @Override
    protected void x(Graphics2D graphics2D) {
        int n;
        graphics2D.setColor(this.getBackground());
        graphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());
        double d = Math.min((double)this.getWidth() / 1920.0, (double)this.getHeight() / 406.0);
        if (this.ly) {
            graphics2D.setColor(this.lr ? this.getForeground().brighter().brighter() : this.getForeground());
            graphics2D.setFont(this.getFont());
            FontMetrics fontMetrics = graphics2D.getFontMetrics(graphics2D.getFont());
            n = (int)(30.0 * d);
            graphics2D.drawString(this.ki, n, fontMetrics.getAscent());
            this.lc.setBounds(n, 0, fontMetrics.stringWidth(this.ki), fontMetrics.getHeight());
        }
        int n2 = (int)((double)this.kf.getWidth() * d);
        n = (int)((double)this.kf.getHeight() * d);
        int n3 = (this.getWidth() - n2) / 2;
        int n4 = this.getHeight() - n;
        graphics2D.drawImage((Image)tg.x(this.kf, n2, n), n3, n4, null);
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
        if (this.lc.contains(mouseEvent.getX(), mouseEvent.getY()) && this.ly) {
            if (!this.lr) {
                this.x(lx);
                this.lr = true;
                this.repaint();
            }
            return;
        }
        if (this.lr) {
            this.x(Cursor.getDefaultCursor());
            this.lr = false;
            this.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (this.ly && this.lc.contains(mouseEvent.getX(), mouseEvent.getY()) && this.le != null) {
            this.le.x();
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

