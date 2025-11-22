/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class tb {
    public static JPanel x(Component ... componentArray) {
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(false);
        jPanel.setLayout(new BoxLayout(jPanel, 0));
        for (int n = 0; n < componentArray.length; ++n) {
            jPanel.add(componentArray[n]);
        }
        return jPanel;
    }

    public static JPanel x(Component component) {
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(false);
        jPanel.setLayout(new BoxLayout(jPanel, 1));
        if (component instanceof JComponent) {
            ((JComponent)component).setAlignmentX(0.5f);
        }
        jPanel.add(Box.createHorizontalGlue());
        jPanel.add(component);
        jPanel.add(Box.createHorizontalGlue());
        return jPanel;
    }

    public static JPanel h(Component component) {
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(false);
        jPanel.setLayout(new BoxLayout(jPanel, 0));
        if (component instanceof JComponent) {
            ((JComponent)component).setAlignmentX(0.5f);
        }
        jPanel.add(Box.createHorizontalGlue());
        jPanel.add(component);
        jPanel.add(Box.createHorizontalGlue());
        return jPanel;
    }

    public static JPanel x(int n, Component ... componentArray) {
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(false);
        jPanel.setLayout(new BoxLayout(jPanel, n));
        for (int n2 = 0; n2 < componentArray.length; ++n2) {
            jPanel.add(componentArray[n2]);
        }
        return jPanel;
    }

    public static JPanel x(Component component, Component component2, Component component3, Component component4, Component component5) {
        JPanel jPanel = new JPanel(new BorderLayout(0, 0));
        jPanel.setOpaque(false);
        if (component != null) {
            jPanel.add(component, "Center");
        }
        if (component2 != null) {
            jPanel.add(component2, "North");
        }
        if (component3 != null) {
            jPanel.add(component3, "East");
        }
        if (component4 != null) {
            jPanel.add(component4, "South");
        }
        if (component5 != null) {
            jPanel.add(component5, "West");
        }
        return jPanel;
    }

    public static JPanel h(int n, Component ... componentArray) {
        JPanel jPanel = new JPanel(new FlowLayout(n), true);
        jPanel.setOpaque(true);
        for (int n2 = 0; n2 < componentArray.length; ++n2) {
            jPanel.add(componentArray[n2]);
        }
        return jPanel;
    }

    public static JPanel v(Component component) {
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(false);
        jPanel.setLayout(new BorderLayout());
        jPanel.add(component, "Center");
        return jPanel;
    }

    public static JPanel r(Component component) {
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(false);
        jPanel.setLayout(new GridBagLayout());
        jPanel.add(component, new GridBagConstraints());
        return jPanel;
    }

    public static JPanel y(Component component) {
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(true);
        jPanel.setLayout(new FlowLayout(1));
        jPanel.add(component);
        return jPanel;
    }

    public static JPanel x(JComponent jComponent, Dimension dimension) {
        JPanel jPanel = new JPanel(new BorderLayout(0, 0), true);
        jPanel.setOpaque(false);
        jPanel.add((Component)jComponent, "Center");
        jPanel.setPreferredSize(dimension);
        return jPanel;
    }
}

