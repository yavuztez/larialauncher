/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import xyz.florex.ui.BackButtonAction;
import xyz.florex.ui.MainScreen;

public class fo
implements BackButtonAction {
    public final MainScreen xk;

    public fo(MainScreen xk) {
        this.xk = xk;
    }

    @Override
    public void x() {
        this.xk.x(1);
    }
}

