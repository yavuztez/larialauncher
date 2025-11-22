/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import xyz.florex.ui.ButtonActionListener;
import xyz.florex.ui.fu;

public class ft
extends ButtonActionListener {
    public final fu pe;

    public ft(fu pe) {
        this.pe = pe;
    }

    @Override
    public void x() {
        fu.x(this.pe, 10);
        this.pe.dispose();
    }
}

