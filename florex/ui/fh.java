/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import xyz.florex.ui.LayoutCalculationHelper;

public class fh
implements LayoutManager {
    private int kl;
    private int ka;
    private int ko;
    private int[] kg;
    private int kd = 0;
    private double kz = 1.0;
    private LayoutCalculationHelper km;

    public fh(int n, int n2, int n3, int n4) {
        this(n, n2, n3, new int[]{n4});
    }

    public fh(int n, int n2, int n3, int[] nArray, double d) {
        this(n, n2, n3, nArray);
        this.x(d);
    }

    public fh(int n, int n2, int n3, int[] nArray, double d, LayoutCalculationHelper fy2) {
        this(n, n2, n3, nArray);
        this.x(d);
        this.x(fy2);
    }

    public fh(int n, int n2, int n3, int[] nArray) {
        this.kl = n;
        this.ka = n2;
        this.ko = n3;
        this.kg = nArray;
    }

    public void x(double d) {
        this.kz = d;
    }

    public void x(LayoutCalculationHelper fy2) {
        this.km = fy2;
    }

    @Override
    public void layoutContainer(Container container) {
        this.kd = 0;
        double d = (double)container.getWidth() / 1920.0;
        double d2 = (double)container.getHeight() / (double)this.kl;
        int n = this.km == null ? (int)((double)this.ka * d * this.kz) : this.km.x(container, d, this.ka, this.kz);
        int n2 = (int)((double)this.ko * d2);
        int n3 = container.getWidth() - 2 * n;
        int n4 = (int)((double)this.kg[0] * d2);
        for (Component component : container.getComponents()) {
            int n7 = component.getPreferredSize().width == -999 ? component.getPreferredSize().height : (int)(component.getPreferredSize().getHeight() * d2 * 1.25);
            component.setBounds(n, n2, n3, n7);
            n2 += n7 + n4;
            n4 = this.x(n4, d2);
        }
    }

    private int x(int n, double d) {
        if (this.kg.length == 1) {
            return n;
        }
        if (this.kd + 1 >= this.kg.length) {
            return n;
        }
        ++this.kd;
        return (int)((double)this.kg[this.kd] * d);
    }

    @Override
    public Dimension preferredLayoutSize(Container container) {
        int n = 0;
        int n2 = 0;
        for (Component component : container.getComponents()) {
            n += component.getPreferredSize().width;
            n2 += component.getPreferredSize().height;
        }
        return new Dimension(n, n2);
    }

    @Override
    public Dimension minimumLayoutSize(Container container) {
        int n = 0;
        int n2 = 0;
        for (Component component : container.getComponents()) {
            n += component.getMaximumSize().width;
            n2 += component.getMaximumSize().height;
        }
        return new Dimension(n, n2);
    }

    @Override
    public void addLayoutComponent(String string, Component component) {
    }

    @Override
    public void removeLayoutComponent(Component component) {
    }
}

