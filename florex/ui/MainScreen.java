/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import com.google.common.io.Files;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import xyz.florex.FlorexLauncher;
import xyz.florex.json.models.JsonMembership;
import xyz.florex.ui.Colors;
import xyz.florex.ui.fb;
import xyz.florex.ui.fc;
import xyz.florex.ui.fg;
import xyz.florex.ui.fh;
import xyz.florex.ui.fo;
import xyz.florex.ui.fr;
import xyz.florex.ui.i;
import xyz.florex.ui.ml;
import xyz.florex.ui.pa;
import xyz.florex.ui.tb;
import xyz.florex.ui.te;
import xyz.florex.ui.y;
import xyz.florex.ui.ze;
import xyz.florex.ui.zi;
import xyz.florex.ui.zs;
import xyz.florex.utils.FontLoader;
import xyz.florex.utils.ImageUtils;

public class MainScreen
extends JFrame {
    private JPanel xt;
    private JPanel xs;
    private JPanel xw;
    private JPanel xv;
    private JPanel xj;
    private zs xu;
    private ml xn;
    public fr qp;
    public zi username;
    private FontLoader fontLoader;
    private JPanel xh;
    public ze qc;
    public pa qr;

    public MainScreen(FontLoader fontLoader) {
        this.fontLoader = fontLoader;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("FlorexMC Minecraft Launcher");
        this.setIconImages(ImageUtils.getIconList());
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 1920, 1080);
        this.setLocationRelativeTo(null);
        this.setBackground(Colors.rv);
        this.xt = new JPanel();
        this.xt.setOpaque(false);
        this.xt.setBorder(MainScreen.h());
        this.setContentPane(this.xt);
        this.xt.setLayout(new BorderLayout(0, 0));
        this.xu = new zs(this);
        this.xu.x(ImageUtils.getImage("icons/window/close.png"), ImageUtils.getImage("icons/window/fullscreen.png"), ImageUtils.getImage("icons/window/hide.png"), 10);
        this.xu.x(Colors.ey);
        this.xu.setBackground(Colors.rf);
        this.xu.setPreferredSize(new Dimension(1920, 29));
        this.xu.x(new i(this));
        this.xt.add((Component)this.xu, "North");
        this.xs = new JPanel();
        this.xs.setDoubleBuffered(true);
        this.xt.add((Component)this.xs, "Center");
        this.xs.setLayout(new CardLayout(0, 0));
        this.xw = this.getPanel();
        this.xs.add((Component)this.xw, "login");
        this.xj = new JPanel(new CardLayout(0, 0), true);
        this.xj.setOpaque(false);
        this.xw.add(this.xj);
        this.xv = new JPanel();
        this.xv.setDoubleBuffered(true);
        this.xv.setOpaque(false);
        this.xv.setLayout(new fh(645, 741, 128, 36));
        this.xh = this.getLoginPanel();
        this.xj.add(this.xh);
        this.setSize(ImageUtils.v());
        this.setLocationRelativeTo(null);
    }

    private JPanel getLoginPanel() {
        JPanel jPanel = new JPanel(new fh(473, 815, 39, new int[]{14, 34, 34, 26, 47}, 0.97, new fb(this)), true);
        jPanel.setOpaque(false);
        this.username = new zi(Colors.ef, this.fontLoader.x("AmsiPro-Light", 0, 18), Colors.eg, new Dimension(0, 37), 10, 0);
        this.username.setPreferredSize(new Dimension(0, 37));
        this.username.x(ImageUtils.getImage("icons/login_username.png"), 5, 18);
        this.username.x(false);
        this.username.setText("Kullan\u0131c\u0131 Ad\u0131");
        this.username.addMouseListener(new fg(this));
        jPanel.add(this.username);
        this.qc = new ze("Giri\u015f Yap", 78, this.fontLoader.x("AmsiPro-Light", 0, 24), Colors.ed, Colors.ez, new y(this));
        this.qc.setPreferredSize(new Dimension(191, 78));
        this.qc.setMinimumSize(new Dimension(191, 78));
        this.qc.setMaximumSize(new Dimension(191, 78));
        this.qc.h(true);
        JPanel jPanel2 = new JPanel(new BorderLayout(0, 0), true);
        Dimension dimension = new Dimension(-999, 22);
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(dimension);
        jPanel.add(jPanel2);
        this.qr = new pa("Beni Hat\u0131rla", this.fontLoader.x("AmsiPro-Light", 0, 15), Colors.eo, false, ImageUtils.getImage("icons/checkbox_box.png"), ImageUtils.getImage("icons/checkbox_tick.png"), 10);
        Dimension dimension2 = new Dimension(115, dimension.height);
        this.qr.setPreferredSize(dimension2);
        this.qr.setMinimumSize(dimension2);
        this.qr.setMaximumSize(dimension2);
        jPanel2.add((Component)this.qr, "West");
        jPanel.add(tb.h(this.qc));
        return jPanel;
    }

    public void readLogin() {
        File file = FlorexLauncher.memberShipFile;
        try {
            JsonMembership memberShip = JsonMembership.fromJsonElement(FlorexLauncher.parser.parse(Files.newReader(file, StandardCharsets.UTF_8)));
            if (memberShip == null) {
                return;
            }
            if (memberShip.getUsername() != null) {
                this.username.setText(memberShip.getUsername());
            }
            if (memberShip.getUsername() != null && !memberShip.getUsername().isEmpty()) {
                this.qr.h(true);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setLogin(String username, boolean remember) {
        if (!remember) {
            return;
        }
        JsonMembership memberShip = new JsonMembership(username);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FlorexLauncher.memberShipFile);
            fileOutputStream.write(memberShip.toJsonObject().toString().getBytes(StandardCharsets.UTF_8));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public FontLoader n() {
        return this.fontLoader;
    }

    public static te h() {
        te te2 = new te();
        te2.x(Colors.rh);
        te2.x(true);
        te2.r(true);
        te2.h(true);
        te2.v(true);
        te2.x(5);
        te2.x(0.3f);
        return te2;
    }

    private JPanel getPanel() {
        JPanel jPanel = new JPanel(new fc(), true);
        jPanel.setOpaque(true);
        jPanel.setBackground(Colors.ec);
        this.xn = new ml(ImageUtils.getImage("logo/launcher_1.png"), "< GER\u0130 D\u00d6N", new fo(this));
        this.xn.setBackground(Colors.ec);
        this.xn.setForeground(Colors.ex);
        this.xn.setFont(this.fontLoader.x("AmsiPro-Bold", 0, 17));
        this.xn.setPreferredSize(new Dimension(1920, 406));
        jPanel.add(this.xn);
        this.qp = new fr("Hesab\u0131n yok mu? ", "Hemen olu\u015ftur!");
        this.qp.x(this.fontLoader.x("AmsiPro-Light", 0, 21), this.fontLoader.x("AmsiPro-Bold", 0, 21));
        this.qp.setForeground(Colors.em);
        this.qp.setPreferredSize(new Dimension(1920, 172));
        this.qp.setVisible(false);
        jPanel.add(this.qp);
        return jPanel;
    }

    public static JPanel x(MainScreen fs2) {
        return fs2.xt;
    }

    public void x(int n2) {
        ((CardLayout)this.xj.getLayout()).show(this.xj, "Bilinmeyen" + n2);
        if (n2 == 2) {
            this.qp.setVisible(true);
            this.xn.x(true);
        } else {
            this.qp.setVisible(false);
            this.xn.x(false);
        }
    }
}

