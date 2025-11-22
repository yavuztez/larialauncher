/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import xyz.florex.ui.ButtonActionListener;
import xyz.florex.ui.fu;

public class fj
extends ButtonActionListener {
    public final fu pc;

    public fj(fu pc) {
        this.pc = pc;
    }

    @Override
    public void x() {
        fu.x(this.pc, 11);
        this.pc.dispose();
    }
}

