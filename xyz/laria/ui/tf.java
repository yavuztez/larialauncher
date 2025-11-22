// =============================================== //
// Recompile disabled. Please run Recaf with a JDK //
// =============================================== //

// Decompiled with: CFR 0.152
// Class Version: 8
package xyz.laria.ui;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

public class tf {
    private static GraphicsConfiguration x() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    }

    private static boolean h() {
        return GraphicsEnvironment.isHeadless();
    }

    public static BufferedImage x(int n, int n2) {
        return tf.h() ? new BufferedImage(n, n2, 2) : tf.x().createCompatibleImage(n, n2, 3);
    }
}
 