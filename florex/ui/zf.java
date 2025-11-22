/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.Graphics2D;
import xyz.florex.ui.pq;

public class zf
extends pq {
    private static final long rtj = 6346986931819191015L;
    private int rtv;

    public zf(int rtv) {
        this.rtv = rtv;
    }

    @Override
    protected void x(Graphics2D graphics2D) {
        graphics2D.setColor(this.getBackground());
        graphics2D.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), this.rtv, this.rtv);
        graphics2D.dispose();
    }
}

