package xyz.laria.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import xyz.laria.utils.FontLoader;
import xyz.laria.utils.ImageUtils;

public class Sivas extends JFrame {

    Point initialClick;
    JLabel logo;
    boolean devMode = false;
    int haberlerClickCount = 0;

    private MainScreen mainScreen;
    private String username;
    static FontLoader fontLoader;

    void openNews() {
    }

    // Yardımcı metodlar buraya taşındı ve isimleri düzeltildi
    private static void monitorOutput(Process process) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("[OUT] " + line);
            }
            bufferedReader.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void monitorError(Process process) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.err.println("[ERR] " + line);
            }
            bufferedReader.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private JPanel createTopPanel() {
        JPanel jPanel = new JPanel(null);
        jPanel.setBounds(0, 0, this.getWidth(), 110);
        jPanel.setBackground(Color.BLACK);

        final Sivas outer = this;

        jPanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                outer.initialClick = mouseEvent.getPoint();
            }
        });

        jPanel.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                int n = outer.getLocation().x;
                int n2 = outer.getLocation().y;
                int n3 = mouseEvent.getX() - outer.initialClick.x;
                int n4 = mouseEvent.getY() - outer.initialClick.y;
                int n5 = n + n3;
                int n6 = n2 + n4;
                outer.setLocation(n5, n6);
            }
        });

        int n = 128;
        int n2 = (this.getWidth() - n) / 2;
        JLabel jLabel = new JLabel("H A B E R L E R");
        JLabel jLabel2 = new JLabel("A Y A R L A R");

        jLabel.setFont(fontLoader.x("AmsiPro-Bold", 0, 23));
        jLabel.setForeground(Color.WHITE);
        jLabel2.setFont(fontLoader.x("AmsiPro-Light", 0, 23));
        jLabel2.setForeground(Color.GRAY);

        int n3 = 162;
        int n4 = jLabel.getPreferredSize().width;
        int n5 = jLabel2.getPreferredSize().width;
        jLabel.setBounds(n2 - n4 - n3, 70, n4, 30);
        jLabel2.setBounds(n2 + n + n3, 70, n5, 30);

        ZAW zAW = new ZAW(this);
        zAW.x(ImageUtils.getImage("icons/window/close.png"), null, ImageUtils.getImage("icons/window/hide.png"), 10);
        zAW.x(Colors.ey);
        zAW.setBackground(Color.BLACK);
        zAW.setBounds(this.getWidth() - 80, 0, 80, 29);
        jPanel.add(zAW);
        jPanel.add(jLabel);
        jPanel.add(jLabel2);

        final Color color = Color.WHITE;
        final Color color2 = Color.GRAY;
        final Color color3 = new Color(180, 180, 180);
        final String[] activeTab = new String[]{"H A B E R L E R"};

        Runnable runnable = () -> Sivas.lambda$createTopPanel$1(activeTab, jLabel, color, jLabel2, color2);
        runnable.run();

        jLabel.addMouseListener(new MouseAdapter(){
            final JPanel val$panel = jPanel;
            final Runnable val$updateTabs = runnable;

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                if (!activeTab[0].equals("H A B E R L E R")) {
                    jLabel.setForeground(color);
                }
            }

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                outer.haberlerClickCount++;

                if (outer.haberlerClickCount >= 10 && !outer.devMode) {
                    outer.devMode = true;
                    JButton jButton = new JButton("Konsol");
                    jButton.setFont(fontLoader.x("AmsiPro-Bold", 0, 14));
                    jButton.setForeground(Color.WHITE);
                    jButton.setBackground(new Color(50, 50, 50));
                    jButton.setBounds(outer.getWidth() - 100, 10, 80, 30);

                    jButton.addActionListener(actionEvent -> Console.getInstance().setVisible(true));

                    this.val$panel.add(jButton);
                    this.val$panel.revalidate();
                    this.val$panel.repaint();

                    outer.log("Geliştirici modu aktif edildi.");
                    FU.x(fontLoader, "Laria Minecraft Launcher", "Geliştirici modu aktif edildi. Artık client masaüstünden çağırılacak");
                    return;
                }
                if (!activeTab[0].equals("H A B E R L E R")) {
                    activeTab[0] = "H A B E R L E R";
                    this.val$updateTabs.run();
                    outer.openNews();
                }
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                if (!activeTab[0].equals("H A B E R L E R")) {
                    jLabel.setForeground(color2);
                }
            }
        });

        jLabel2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                if (!activeTab[0].equals("A Y A R L A R")) {
                    jLabel2.setForeground(color3);
                }
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                if (!activeTab[0].equals("A Y A R L A R")) {
                    jLabel2.setForeground(color2);
                }
            }

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (!activeTab[0].equals("A Y A R L A R")) {
                    outer.openSettings();
                }
            }
        });

        return jPanel;
    }

    private ImageIcon loadImage(String string) {
        try {
            URL uRL = this.getClass().getResource(string);
            if (uRL == null) {
                throw new Exception("Asset not found: " + string);
            }
            return new ImageIcon(uRL);
        } catch (Exception exception) {
            return new ImageIcon(new BufferedImage(50, 50, 2));
        }
    }

    private JPanel createBottomPanel(String string) {
        JLabel jLabel;
        Object object;
        int n = 80;
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBackground(new Color(255, 255, 255));
        jPanel.setBounds(0, this.getHeight() - n, this.getWidth(), n);
        try {
            object = "https://minotar.net/avatar/" + URLEncoder.encode(string, "UTF-8") + "/40";
            jLabel = new JLabel(new ImageIcon(new URL((String)object)));
        } catch (Exception exception) {
            jLabel = new JLabel(this.loadImage("/assets/default_avatar.png"));
        }
        jLabel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        object = new JLabel(string);
        ((JComponent)object).setFont(fontLoader.x("AmsiPro-Light", 0, 18));
        ((JComponent)object).setForeground(Color.BLACK);
        JPanel jPanel2 = new JPanel(new FlowLayout(0, 10, 20));
        jPanel2.setOpaque(false);
        jPanel2.add(jLabel);
        jPanel2.add((Component)object);
        jPanel.add((Component)jPanel2, "West");
        return jPanel;
    }

    public Sivas(MainScreen mainScreen, String string) {
        this.username = string;

        fontLoader = new FontLoader();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exception) {
            // empty catch block
        }
        this.setIconImage(new ImageIcon(this.getClass().getClassLoader().getResource("assets/icons/logo/512x512.png")).getImage());
        this.setTitle("Laria Client");
        this.setSize(ImageUtils.v());
        this.setDefaultCloseOperation(3);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        final Sivas outer = this;

        a a2 = new a(this, string);
        a2.setLayout(null);
        this.setContentPane(a2);
        JPanel jPanel = this.createTopPanel();
        a2.add(jPanel);
        JPanel jPanel2 = this.createBottomPanel(string);
        a2.add(jPanel2);
        JPanel jPanel3 = new JPanel(null);
        jPanel3.setOpaque(false);
        this.setGlassPane(jPanel3);
        jPanel3.setVisible(true);
        JPanel jPanel4 = this.createHeaderTextPanel();
        jPanel3.add(jPanel4);
        this.logo = new JLabel(this.loadImage("/assets/icons/logo/128x128.png"));
        jPanel3.add(this.logo);

        this.addComponentListener(new ComponentAdapter(){
            final JPanel val$topPanel = jPanel;
            final JPanel val$bottomPanel = jPanel2;
            final JPanel val$headerTextPanel = jPanel4;
            final a val$backgroundPanel = a2;
            final JPanel val$glassPane = jPanel3;

            @Override
            public void componentResized(ComponentEvent componentEvent) {
                int n = outer.getWidth();
                int n2 = outer.getHeight();
                this.val$backgroundPanel.setBounds(0, 0, n, n2);
                this.val$topPanel.setBounds(0, 0, n, 110);
                this.val$bottomPanel.setBounds(0, n2 - 80, n, 80);
                int n3 = 128;
                int n4 = 128;
                int n5 = (n - n3) / 2;
                int n6 = 20;
                outer.logo.setBounds(n5, n6, n3, n4);
                Dimension dimension = CV.getHeaderSize(new Dimension(n, n2));
                int n7 = dimension.width;
                int n8 = dimension.height;
                int n9 = (n - n7) / 2;
                int n10 = n2 - this.val$bottomPanel.getHeight() - n8 - 10;
                this.val$headerTextPanel.setBounds(n9, n10, n7, n8);
                this.val$glassPane.setSize(outer.getSize());
                System.out.println("Window: " + n + "x" + n2 + " | Header: " + n7 + "x" + n8);
            }
        });

        SwingUtilities.invokeLater(() -> this.lambda$new$0(jPanel, jPanel2, jPanel4, jPanel3));
        this.setVisible(true);
    }

    void log(String string) {
        if (this.devMode) {
            Console.getInstance().logEkle("[Laria] " + string);
        }
    }

    private static void lambda$createTopPanel$1(String[] stringArray, JLabel jLabel, Color color, JLabel jLabel2, Color color2) {
        if (stringArray[0].equals("H A B E R L E R")) {
            jLabel.setFont(fontLoader.x("AmsiPro-Bold", 0, 23));
            jLabel.setForeground(color);
            jLabel2.setFont(fontLoader.x("AmsiPro-Light", 0, 23));
            jLabel2.setForeground(color2);
        } else {
            jLabel.setFont(fontLoader.x("AmsiPro-Light", 0, 23));
            jLabel.setForeground(color2);
            jLabel2.setFont(fontLoader.x("AmsiPro-Bold", 0, 23));
            jLabel2.setForeground(Color.red);
        }
    }

    private void lambda$new$0(JPanel jPanel, JPanel jPanel2, JPanel jPanel3, JPanel jPanel4) {
        int n = this.getWidth();
        int n2 = this.getHeight();
        int n3 = 128;
        int n4 = 128;
        this.logo.setBounds((n - n3) / 2, 10, n3, n4);
        jPanel.setBounds(0, 0, n, 110);
        jPanel2.setBounds(0, n2 - 80, n, 80);
        int n5 = 80;
        jPanel3.setBounds(50, n2 - 80 - n5 - 10, 600, n5);
        jPanel4.setSize(this.getSize());
    }

    private JPanel createHeaderTextPanel() {
        JPanel jPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics graphics) {
                Graphics2D graphics2D = (Graphics2D)graphics.create();
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, new Color(23, 23, 23, 200), 0.0f, this.getHeight(), new Color(23, 23, 23, 20));
                graphics2D.setPaint(gradientPaint);
                graphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());
                graphics2D.dispose();
                super.paintComponent(graphics);
            }
        };
        jPanel.setLayout(new BoxLayout(jPanel, 1));
        jPanel.setOpaque(false);
        jPanel.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

        JLabel jLabel = new JLabel("Laria'de oynamak");
        jLabel.setFont(fontLoader.x("AmsiPro-Ultra", 0, 36));
        jLabel.setForeground(Color.WHITE);
        jLabel.setAlignmentX(0.0f);
        JLabel jLabel2 = new JLabel("Laria'de yapılacak çok şey var. Şimdi keşfet!");
        jLabel2.setFont(fontLoader.x("AmsiPro-Light", 0, 19));
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setAlignmentX(0.0f);

        jPanel.add(Box.createVerticalStrut(30));
        jPanel.add(jLabel);
        jPanel.add(Box.createVerticalStrut(0));
        jPanel.add(jLabel2);
        return jPanel;
    }

    void openSettings() {
    }

    class a extends JPanel {
        private final Image backgroundImage;
        final JButton playButton;
        private final String username;

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            if (this.backgroundImage != null) {
                int n;
                int n2;
                int n3;
                int n4;
                int n5;
                int n6;
                double d;
                int n7;
                int n8 = this.getWidth();
                double d2 = (double)n8 / (double)(n7 = this.getHeight());
                if (d2 > (d = (double)(n6 = this.backgroundImage.getWidth(this)) / (double)(n5 = this.backgroundImage.getHeight(this)))) {
                    n4 = n7;
                    n3 = (int)((double)n7 * d);
                    n2 = (n8 - n3) / 2;
                    n = 0;
                } else {
                    n3 = n8;
                    n4 = (int)((double)n8 / d);
                    n2 = 0;
                    n = (n7 - n4) / 2;
                }
                graphics.drawImage(this.backgroundImage, n2, n, n3, n4, this);
            }
        }

        @Override
        public void doLayout() {
            super.doLayout();
            int n = (this.getWidth() - this.playButton.getWidth()) / 2;
            int n2 = this.getHeight() - 130;
            this.playButton.setLocation(n, n2);
        }

        public a(JFrame jFrame, String string) {
            this.username = string;
            URL uRL = this.getClass().getResource("/assets/background/news_1.jpg");
            this.backgroundImage = uRL != null ? new ImageIcon(uRL).getImage() : null;
            this.setLayout(null);

            final JButton outerPlayButton = new JButton("O Y N A"){
                @Override
                protected void paintComponent(Graphics graphics) {
                    Graphics2D graphics2D = (Graphics2D)graphics.create();
                    graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    graphics2D.setColor(this.getBackground());
                    graphics2D.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 60, 60);
                    super.paintComponent(graphics);
                    graphics2D.dispose();
                }
            };
            this.playButton = outerPlayButton;

            this.playButton.setFont(fontLoader.x("AmsiPro-Bold", 0, 24));
            this.playButton.setForeground(Color.WHITE);
            this.playButton.setBackground(new Color(0xFF9900));
            this.playButton.setCursor(Cursor.getPredefinedCursor(12));
            this.playButton.setSize(140, 60);

            this.playButton.addActionListener(new ActionListener(){
                final String val$username = string;

                private void lambda$actionPerformed$2() {
                    try {
                        Thread.sleep(2000L);
                        SwingUtilities.getWindowAncestor(outerPlayButton).dispose();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }

                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        outerPlayButton.setEnabled(false);
                        outerPlayButton.setText("\u0130 P T A L");
                        outerPlayButton.setBackground(Color.GRAY);

                        String LariaAppData = System.getenv("APPDATA");
                        String LariaFolder = LariaAppData + File.separator + ".laria";

                        String LariaJrePath = LariaFolder + File.separator + "java" + File.separator + "bin" + File.separator + "javaw.exe";
                        String LariaNativesDir = LariaFolder + File.separator + "libraries" + File.separator + "natives";
                        String LariaClientJar = "vers" + File.separator + "1.8.9-Optifine-Ultra_.jar";

                        int n = 1024;
                        System.out.println("Kullanıcı adı: " + this.val$username);
                        System.out.println("Process başlatılıyor...");

                        ProcessBuilder processBuilder = new ProcessBuilder(
                                LariaJrePath,
                                "-Xmx" + n + "M",
                                "-noverify",
                                "-Djava.library.path=" + LariaNativesDir,
                                "-cp",
                                LariaFolder + File.separator + "libraries" + File.separator + "*;" + LariaFolder + File.separator + LariaClientJar,
                                "net.minecraft.client.main.Main",
                                "--username", this.val$username,
                                "--version", "1.8.9-Optifine-Ultra_",
                                "--gameDir", LariaFolder + File.separator + "game-directories" + File.separator + "public",
                                "--assetsDir", LariaFolder + File.separator + "assets",
                                "--assetIndex", "1.8",
                                "--uuid", "e4aebf37-6acc-309d-9235-bf5f",
                                "--accessToken", "00000000000000000000000000000000",
                                "--userProperties", "{}",
                                "--userType", "mojang"
                        );

                        processBuilder.directory(new File(LariaFolder));
                        Process process = processBuilder.start();

                        // ARTIK STATİK OLMAYAN METODLARI ÇAĞIRIYORUZ (Sivas Sınıfından)
                        new Thread(() -> Sivas.monitorOutput(process)).start();
                        new Thread(() -> Sivas.monitorError(process)).start();

                        System.out.println("Process baslatildi.");
                        new Thread(this::lambda$actionPerformed$2).start();

                    } catch (Exception exception) {
                        exception.printStackTrace();
                        JOptionPane.showMessageDialog(null, "İstemci başlatılamadı:\n" + exception.getMessage(), "Hata", 0);
                    }
                }
            });

            this.playButton.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
                    if (outerPlayButton.isEnabled()) {
                        outerPlayButton.setBackground(new Color(16758605));
                    }
                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    if (outerPlayButton.isEnabled()) {
                        outerPlayButton.setBackground(new Color(0xFF9900));
                    }
                }
            });
            this.add(this.playButton);
        }
    }
}