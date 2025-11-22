/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import xyz.florex.ui.CustomButtonEventHandler;
import xyz.florex.ui.MainScreen;
import xyz.florex.ui.zs;
import xyz.florex.utils.ImageUtils;

public class i
implements CustomButtonEventHandler {
    private boolean cs;
    public final MainScreen cw;

    public i(MainScreen cw) {
        this.cw = cw;
        this.cs = false;
    }

    @Override
    public void x(zs zs2) {
        if (this.cs) {
            this.cw.setSize(ImageUtils.v());
            MainScreen.x(this.cw).setBorder(MainScreen.h());
            this.cw.setLocationRelativeTo(null);
            this.cs = false;
        } else {
            this.cw.setSize(ImageUtils.x(this.cw.getGraphicsConfiguration()));
            MainScreen.x(this.cw).setBorder(null);
            this.cw.setLocationRelativeTo(null);
            this.cs = true;
        }
    }
}

