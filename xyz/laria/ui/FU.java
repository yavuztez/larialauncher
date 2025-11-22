package xyz.laria.ui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import xyz.laria.utils.FontLoader;
import xyz.laria.utils.ImageUtils;

public class FU extends JDialog {
    private static final Color pl;
    public static final int po;
    private DialogType pm;
    private String pt;
    private int pu = -1;
    private String pb;
    private FontLoader pz;
    public static final int pg;
    public static final int pa;
    private JPanel ps;
    private static final long pk = -2540969521516345869L;
    private JFrame pd;

    private void x() {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("Laria Minecraft Launcher - " + this.pb);
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
        JPanel jPanel = this.h();
        jPanel.setBounds((this.getWidth() - 700) / 2, (this.getHeight() - 250) / 2, jPanel.getWidth(), jPanel.getHeight());
        this.ps.add(jPanel);
    }

    public static void x(FontLoader fontLoader, String string, String string2) {
        new FU(fontLoader, DialogType.px, string, string2).setVisible(true);
    }

    private JPanel h() {
        pq pQ;
        JPanel jPanel = new JPanel(null);
        jPanel.setOpaque(false);
        jPanel.setSize(700, 250);
        zp zP = new zp(this.pb, this.pz.x("AmsiPro-SemiBold", 0, 22), Colors.cm, zp.TextAlignment.rwc);
        zP.setBounds(0, 20, jPanel.getWidth(), 25);
        jPanel.add(zP);
        zq zQ = new zq(3.0 + (double)((this.pt.contains("\n") ? this.pt.split("\n").length : 1) - 1));
        zQ.setBorder(null);
        zQ.setEditable(false);
        zQ.setOpaque(false);
        zQ.setFont(this.pz.x("AmsiPro-Light", 0, 18));
        zQ.setForeground(Colors.cb);
        zQ.setText(this.pt);
        zQ.setBounds(0, zP.getBounds().y + zP.getBounds().height, jPanel.getWidth(), 141);
        jPanel.add(zQ);
        JPanel jPanel2 = new JPanel(new FlowLayout(1, 0, 0));
        jPanel2.setBorder(null);
        jPanel2.setOpaque(false);
        jPanel2.setBounds(0, zQ.getBounds().y + zQ.getBounds().height, jPanel.getWidth(), 42);
        jPanel.add(jPanel2);
        if (this.pm == DialogType.px) {
            pQ = new ze("Tamam", 41, this.pz.x("AmsiPro-Light", 0, 18), Colors.ct, Colors.cu, new fz(this));
            pQ.setPreferredSize(new Dimension(120, 42));
            jPanel2.add(pQ);
        } else if (this.pm == DialogType.pq) {
            pQ = new ze("Evet", 41, this.pz.x("AmsiPro-Light", 0, 18), Colors.ct, Colors.cu, new ft(this));
            pQ.setPreferredSize(new Dimension(120, 42));
            jPanel2.add(pQ);
            jPanel2.add(Box.createRigidArea(new Dimension(25, 0)));
            ze zE = new ze("Hayır", 41, this.pz.x("AmsiPro-Light", 0, 18), Colors.ct, Colors.cu, new fj(this));
            zE.setPreferredSize(new Dimension(120, 42));
            jPanel2.add(zE);
        }
        pQ = new zf(78);
        pQ.setBackground(Colors.cz);
        pQ.setBounds(0, 0, jPanel.getWidth(), jPanel.getHeight());
        jPanel.add(pQ);
        return jPanel;
    }

    public static void x(FU fU, int n) {
        fU.pu = n;
    }

    public FU(MainScreen mainScreen, DialogType dialogType, String string, String string2) {
        super(mainScreen);
        if (mainScreen == null) {
            throw new RuntimeException("Frame can not be null!");
        }
        this.pd = mainScreen;
        this.pz = mainScreen.n();
        this.pm = dialogType;
        this.pb = string;
        this.pt = string2;
        this.x();
    }

    public int v() {
        return this.pu;
    }

    public FU(FontLoader fontLoader, DialogType dialogType, String string, String string2) {
        super((Dialog)null);
        this.pd = null;
        this.pz = fontLoader;
        this.pm = dialogType;
        this.pb = string;
        this.pt = string2;
        this.x();
    }

    public static int h(MainScreen mainScreen, String string, String string2) {
        FU fU = new FU(mainScreen, DialogType.pq, string, string2);
        fU.setVisible(true);
        return fU.v();
    }

    static {
        pg = 11;
        pa = 1;
        po = 10;
        pl = new Color(255, 255, 255, 0);
    }

    public static int x(MainScreen mainScreen, String string, String string2) {
        FU fU = new FU(mainScreen, DialogType.px, string, string2);
        fU.setVisible(true);
        return fU.v();
    }

    public static enum DialogType {
        px("MESSAGE", 0),
        pq("QUESTION", 1);

        // FIX: Constructor eklendi
        private DialogType(String s, int i) {}
    }
}