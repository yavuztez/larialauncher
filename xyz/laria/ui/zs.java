// =============================================== //
// Recompile disabled. Please run Recaf with a JDK //
// =============================================== //

// Decompiled with: CFR 0.152
// Class Version: 8
package xyz.laria.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class zs
extends pq
implements MouseListener,
MouseMotionListener {
    private static final long rsg = -4642346095449742765L;
    private JFrame rsd;
    private Color rsz;
    private Color rsm;
    private BufferedImage rsb;
    private BufferedImage rst;
    private BufferedImage rsu;
    private Rectangle rss;
    private Rectangle rsw;
    private Rectangle rsn;
    private boolean rsj;
    private boolean rsv;
    private boolean rsh;
    private int rsf;
    private CustomButtonEventHandler rsi;
    private int rwy;
    private int rwr;

    public zs(JFrame jFrame) {
        this.rsd = jFrame;
        this.setFocusable(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void x(BufferedImage bufferedImage, BufferedImage bufferedImage2, BufferedImage bufferedImage3, int n) {
        this.rsb = bufferedImage;
        this.rst = bufferedImage2;
        this.rsu = bufferedImage3;
        this.rss = new Rectangle(0, 0, 0, 0);
        this.rsw = new Rectangle(0, 0, 0, 0);
        this.rsn = new Rectangle(0, 0, 0, 0);
        this.rsf = n;
    }

    public Color h() {
        return this.rsz;
    }

    public void x(Color color) {
        this.x(color, color.brighter().brighter());
    }

    public void x(Color color, Color color2) {
        this.rsz = color;
        this.rsm = color2;
    }

    public void x(CustomButtonEventHandler CustomButtonEventHandler2) {
        this.rsi = CustomButtonEventHandler2;
    }

    @Override
    protected void x(Graphics2D graphics2D) {
        int n;
        graphics2D.setColor(this.getBackground());
        graphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());
        int n2 = this.getWidth() - 10;
        if (this.rsb != null) {
            n = (this.getHeight() - this.rsb.getHeight()) / 2;
            tg.x(this.rsb, this.rsj ? this.rsm : this.rsz);
            graphics2D.drawImage((Image)this.rsb, n2 -= this.rsb.getWidth(), n, null);
            this.rss.setBounds(n2, n, this.rsb.getWidth(), this.rsb.getHeight());
            n2 -= 10 + this.rsf;
        }
        if (this.rst != null) {
            n = (this.getHeight() - this.rst.getHeight()) / 2;
            tg.x(this.rst, this.rsv ? this.rsm : this.rsz);
            graphics2D.drawImage((Image)this.rst, n2 -= this.rst.getWidth(), n, null);
            this.rsw.setBounds(n2, n, this.rst.getWidth(), this.rst.getHeight());
            n2 -= 10 + this.rsf;
        }
        if (this.rsu != null) {
            n = (this.getHeight() - this.rsu.getHeight()) / 2;
            tg.x(this.rsu, this.rsh ? this.rsm : this.rsz);
            graphics2D.drawImage((Image)this.rsu, n2 -= this.rsu.getWidth(), n, null);
            this.rsn.setBounds(n2, n - 10, this.rsu.getWidth(), this.rsu.getHeight() + 20);
            n2 -= 10 + this.rsf;
        }
        graphics2D.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (this.rss.contains(mouseEvent.getX(), mouseEvent.getY())) {
            System.exit(0);
            return;
        }
        if (this.rsw.contains(mouseEvent.getX(), mouseEvent.getY())) {
            if (this.rsi != null) {
                this.rsi.x(this);
                return;
            }
            if ((this.rsd.getExtendedState() & 6) == 6) {
                this.rsd.setExtendedState(0);
            } else {
                this.rsd.setExtendedState(6);
            }
            return;
        }
        if (this.rsn.contains(mouseEvent.getX(), mouseEvent.getY())) {
            this.rsd.setState(1);
            return;
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (this.rss.contains(mouseEvent.getX(), mouseEvent.getY()) || this.rsw.contains(mouseEvent.getX(), mouseEvent.getY()) || this.rsn.contains(mouseEvent.getX(), mouseEvent.getY())) {
            this.rwy = -1;
            this.rwr = -1;
            return;
        }
        this.rwy = mouseEvent.getX();
        this.rwr = mouseEvent.getY();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        if (this.rss.contains(mouseEvent.getX(), mouseEvent.getY())) {
            this.rsj = true;
            this.repaint();
            return;
        }
        if (this.rsw.contains(mouseEvent.getX(), mouseEvent.getY())) {
            this.rsv = true;
            this.repaint();
            return;
        }
        if (this.rsn.contains(mouseEvent.getX(), mouseEvent.getY())) {
            this.rsh = true;
            this.repaint();
            return;
        }
        if (this.rsj || this.rsv || this.rsh) {
            this.rsj = false;
            this.rsv = false;
            this.rsh = false;
            this.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (this.rwy == -1 || this.rwr == -1) {
            return;
        }
        this.rsd.setLocation(this.rsd.getLocation().x + mouseEvent.getX() - this.rwy, this.rsd.getLocation().y + mouseEvent.getY() - this.rwr);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }
}
 