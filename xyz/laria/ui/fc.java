// =============================================== //
// Recompile disabled. Please run Recaf with a JDK //
// =============================================== //

package xyz.laria.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class fc
implements LayoutManager {
    @Override
    public void layoutContainer(Container container) {
        double d = (double)container.getHeight() / 1051.0;
        int n = (int)(406.0 * d * 0.9);
        int n2 = (int)(172.0 * d * 0.9);
        if (d <= 0.6) {
            n2 = (int)((double)n2 * 0.4);
        }
        for (Component component : container.getComponents()) {
            if (component instanceof ml) {
                component.setBounds(0, 0, container.getWidth(), n);
                continue;
            }
            if (component instanceof fr) {
                component.setBounds(0, container.getHeight() - n2, container.getWidth(), n2);
                continue;
            }
            component.setBounds(0, n, container.getWidth(), container.getHeight() - (n + n2));
        }
    }

    @Override
    public Dimension preferredLayoutSize(Container container) {
        double d = (double)container.getHeight() / 172.0;
        int n = 0;
        for (Component component : container.getComponents()) {
            n += component.getPreferredSize().height;
        }
        return new Dimension(container.getWidth(), (int)((double)n * d));
    }

    @Override
    public Dimension minimumLayoutSize(Container container) {
        int n = 0;
        int n2 = 0;
        for (Component component : container.getComponents()) {
            n += component.getMinimumSize().width;
            n2 += component.getMinimumSize().height;
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
 