/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import xyz.florex.ui.Colors;
import xyz.florex.ui.MainScreen;
import xyz.florex.ui.fj;
import xyz.florex.ui.ft;
import xyz.florex.ui.fz;
import xyz.florex.ui.ze;
import xyz.florex.ui.zf;
import xyz.florex.ui.zp;
import xyz.florex.ui.zq;
import xyz.florex.utils.FontLoader;
import xyz.florex.utils.ImageUtils;

public class fu
extends JDialog {
    private static final long pk = -2540969521516345869L;
    private static final Color pl = new Color(255, 255, 255, 0);
    public static final int pa = 1;
    public static final int po = 10;
    public static final int pg = 11;
    private JFrame pd;
    private FontLoader pz;
    private DialogType pm;
    private String pb;
    private String pt;
    private int pu = -1;
    private JPanel ps;

    public fu(FontLoader pz, DialogType pm, String pb, String pt) {
        super((Dialog)null);
        this.pd = null;
        this.pz = pz;
        this.pm = pm;
        this.pb = pb;
        this.pt = pt;
        this.x();
    }

    public fu(MainScreen mainScreen, DialogType pm, String pb, String pt) {
        super(mainScreen);
        if (mainScreen == null) {
            throw new RuntimeException("Frame can not be null!");
        }
        this.pd = mainScreen;
        this.pz = mainScreen.n();
        this.pm = pm;
        this.pb = pb;
        this.pt = pt;
        this.x();
    }

    private void x() {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("FlorexMC Minecraft Launcher - " + this.pb);
        this.setIconImages(ImageUtils.getIconList());
        this.setDefaultCloseOperation(0);
        this.setBounds(100, 100, this.pd == null ? 700 : this.pd.getWidth(), this.pd == null ? 250 : this.pd.getHeight());
        this.setLocationRelativeTo(this.pd);
        this.setBackground(pl);
        this.setModal(this.pd != null);
        this.ps = new JPanel();
        this.ps.setOpaque(this.pd != null);
        if (this.pd != null) {
            this.ps.setBackground(Colors.cd);
        }
        this.ps.setBorder(null);
        this.setContentPane(this.ps);
        this.ps.setLayout(null);
        JPanel h = this.h();
        h.setBounds((this.getWidth() - 700) / 2, (this.getHeight() - 250) / 2, h.getWidth(), h.getHeight());
        this.ps.add(h);
    }

    private JPanel h() {
        JPanel panel = new JPanel(null);
        panel.setOpaque(false);
        panel.setSize(700, 250);
        zp comp = new zp(this.pb, this.pz.x("AmsiPro-SemiBold", 0, 22), Colors.cm, zp.TextAlignment.rwc);
        comp.setBounds(0, 20, panel.getWidth(), 25);
        panel.add(comp);
        zq comp2 = new zq(3.0 + (double)((this.pt.contains("\n") ? this.pt.split("\n").length : 1) - 1));
        comp2.setBorder(null);
        comp2.setEditable(false);
        comp2.setOpaque(false);
        comp2.setFont(this.pz.x("AmsiPro-Light", 0, 18));
        comp2.setForeground(Colors.cb);
        comp2.setText(this.pt);
        comp2.setBounds(0, comp.getBounds().y + comp.getBounds().height, panel.getWidth(), 141);
        panel.add(comp2);
        JPanel comp3 = new JPanel(new FlowLayout(1, 0, 0));
        comp3.setBorder(null);
        comp3.setOpaque(false);
        comp3.setBounds(0, comp2.getBounds().y + comp2.getBounds().height, panel.getWidth(), 42);
        panel.add(comp3);
        if (this.pm == DialogType.px) {
            ze comp4 = new ze("Tamam", 41, this.pz.x("AmsiPro-Light", 0, 18), Colors.ct, Colors.cu, new fz(this));
            comp4.setPreferredSize(new Dimension(120, 42));
            comp3.add(comp4);
        } else if (this.pm == DialogType.pq) {
            ze comp5 = new ze("Evet", 41, this.pz.x("AmsiPro-Light", 0, 18), Colors.ct, Colors.cu, new ft(this));
            comp5.setPreferredSize(new Dimension(120, 42));
            comp3.add(comp5);
            comp3.add(Box.createRigidArea(new Dimension(25, 0)));
            ze comp6 = new ze("Hay\u0131r", 41, this.pz.x("AmsiPro-Light", 0, 18), Colors.ct, Colors.cu, new fj(this));
            comp6.setPreferredSize(new Dimension(120, 42));
            comp3.add(comp6);
        }
        zf comp7 = new zf(78);
        comp7.setBackground(Colors.cz);
        comp7.setBounds(0, 0, panel.getWidth(), panel.getHeight());
        panel.add(comp7);
        return panel;
    }

    public int v() {
        return this.pu;
    }

    public static int x(MainScreen MainScreen2, String s, String s2) {
        fu fu2 = new fu(MainScreen2, DialogType.px, s, s2);
        fu2.setVisible(true);
        return fu2.v();
    }

    public static int h(MainScreen MainScreen2, String s, String s2) {
        fu fu2 = new fu(MainScreen2, DialogType.pq, s, s2);
        fu2.setVisible(true);
        return fu2.v();
    }

    public static void x(FontLoader FontLoader2, String s, String s2) {
        new fu(FontLoader2, DialogType.px, s, s2).setVisible(true);
    }

    public static void x(fu fu2, int pu) {
        fu2.pu = pu;
    }

    public static enum DialogType {
        px("MESSAGE", 0),
        pq("QUESTION", 1);

        private static final DialogType[] pp;

        private DialogType(String name, int ordinal) {
        }

        static {
            pp = new DialogType[]{px, pq};
        }
    }
}

