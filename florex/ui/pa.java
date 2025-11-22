/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import xyz.florex.ui.pq;

public class pa
extends pq
implements MouseListener,
MouseMotionListener {
    private static final long rtl = -2755803724892677140L;
    private String rta;
    private boolean rto = false;
    private Image rtg;
    private Image rtd;
    private int rtz = 10;
    private Rectangle rtm;
    private List rtb;
    private static Cursor rtt = new Cursor(12);

    public pa(String string, boolean bl, Image image, Image image2) {
        this(string, bl, image, image2, 10);
    }

    public pa(String string, Font font, Color color, boolean bl, Image image, Image image2, int n) {
        this(string, bl, image, image2, n);
        this.setFont(font);
        this.setForeground(color);
    }

    public pa(String string, boolean bl, Image image, Image image2, int n) {
        this.rta = string;
        this.rto = bl;
        this.rtg = image;
        this.rtd = image2;
        this.rtz = n;
        this.rtm = new Rectangle(0, 0, image.getWidth(null), image.getHeight(null));
        this.rtb = new ArrayList();
        this.setFocusable(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void x(ActionListener actionListener) {
        this.rtb.add(actionListener);
    }

    private void h() {
        for (int n = 0; n < this.rtb.size(); ++n) {
            ActionListener actionListener = (ActionListener)this.rtb.get(n);
            actionListener.actionPerformed(new ActionEvent(this, 1, "stateChanged"));
        }
    }

    public void h(boolean bl) {
        this.rto = bl;
        this.repaint();
    }

    public boolean v() {
        return this.rto;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(super.getPreferredSize().width, this.rtm.height);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(super.getMaximumSize().width, this.rtm.height);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(super.getMinimumSize().width, this.rtm.height);
    }

    @Override
    protected void x(Graphics2D graphics2D) {
        this.rtm.setBounds(0, (this.getHeight() - this.rtg.getHeight(null)) / 2, this.rtg.getWidth(null), this.rtg.getHeight(null));
        graphics2D.drawImage(this.rtg, this.rtm.x, this.rtm.y, null);
        if (this.rto) {
            int n = this.rtm.x + (this.rtm.width - this.rtd.getWidth(null)) / 2;
            int n2 = this.rtm.y + (this.rtm.height - this.rtd.getHeight(null)) / 2;
            graphics2D.drawImage(this.rtd, n, n2, null);
        }
        graphics2D.setColor(this.getForeground());
        graphics2D.setFont(this.getFont());
        FontMetrics fontMetrics = graphics2D.getFontMetrics(this.getFont());
        graphics2D.drawString(this.rta, this.rtm.width + this.rtz, (this.getHeight() - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent());
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
        if (this.rtm.contains(mouseEvent.getX(), mouseEvent.getY())) {
            this.x(rtt);
            return;
        }
        this.x(Cursor.getDefaultCursor());
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (this.rtm.contains(mouseEvent.getX(), mouseEvent.getY())) {
            this.rto = !this.rto;
            this.repaint();
            this.h();
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

