/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.Container;
import xyz.florex.ui.LayoutCalculationHelper;
import xyz.florex.ui.MainScreen;

public class fb
implements LayoutCalculationHelper {
    public final MainScreen xl;

    public fb(MainScreen xl) {
        this.xl = xl;
    }

    @Override
    public int x(Container container, double n, int n2, double n3) {
        if (n <= 0.6) {
            return (int)((double)n2 * n * n3 * 0.87);
        }
        return (int)((double)n2 * n * n3);
    }
}

