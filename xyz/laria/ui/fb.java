// =============================================== //
// Recompile disabled. Please run Recaf with a JDK //
// =============================================== //

// Decompiled with: CFR 0.152
// Class Version: 8
package xyz.laria.ui;

import java.awt.Container;

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
 