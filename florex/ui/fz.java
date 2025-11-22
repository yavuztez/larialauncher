/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import xyz.florex.ui.ButtonActionListener;
import xyz.florex.ui.fu;

public class fz
extends ButtonActionListener {
    public final fu pr;

    public fz(fu pr) {
        this.pr = pr;
    }

    @Override
    public void x() {
        fu.x(this.pr, 1);
        this.pr.dispose();
    }
}

