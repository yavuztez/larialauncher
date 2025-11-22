/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;
import xyz.florex.ui.tg;

public class zu
extends AbstractBorder {
    private static final long rwt = 3109779564489666906L;
    private Color rwu;
    private Image rws;
    private int rww = 0;
    private int rwn = 0;
    private boolean rwj = false;

    public zu(Color color) {
        this.rwu = color;
    }

    public void x(Image image, int n, int n2) {
        this.rws = image;
        this.rww = n;
        this.rwn = n2;
    }

    public void x(int n) {
        this.rww = n;
    }

    public void h(int n) {
        this.rwn = n;
    }

    public void x(boolean bl) {
        this.rwj = bl;
    }

    @Override
    public Insets getBorderInsets(Component component) {
        if (this.rws != null) {
            return new Insets(0, this.rww + this.rws.getWidth(null) + this.rwn, 0, 0);
        }
        if (this.rwj) {
            return new Insets(0, this.rww, 0, this.rwn);
        }
        return super.getBorderInsets(component);
    }

    @Override
    public void paintBorder(Component component, Graphics graphics, int n, int n2, int n3, int n4) {
        if (!(graphics instanceof Graphics2D)) {
            return;
        }
        Graphics2D graphics2D = (Graphics2D)graphics;
        tg.x(graphics2D);
        graphics2D.setColor(this.rwu);
        if (!this.rwj) {
            graphics2D.fillRect(0, component.getHeight() - 1, component.getWidth(), 1);
        } else {
            graphics2D.fillRect(this.rww, component.getHeight() - 1, component.getWidth() - this.rwn, 1);
        }
        if (this.rws != null) {
            graphics2D.drawImage(this.rws, this.rww, (component.getHeight() - this.rws.getHeight(null)) / 2, null);
        }
        graphics2D.dispose();
    }
}

