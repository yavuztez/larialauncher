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

public class ZAW
        extends pq
        implements MouseListener,
        MouseMotionListener {
    private int rwy;
    private int rsf;
    private BufferedImage rsb;
    private boolean rsh;
    private Color rsz;
    private BufferedImage rst;
    private static final long rsg = -4642346095449742765L;
    private JFrame rsd;
    private Rectangle rsw;
    private boolean rsv;
    private boolean rsj;
    private int rwr;
    private CBH2 rsi;
    private Color rsm;
    private Rectangle rsn;
    private Rectangle rss;
    private BufferedImage rsu;

    public void x(Color color, Color color2) {
        this.rsz = color;
        this.rsm = color2;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void x(CBH2 cBH) {
        this.rsi = cBH;
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
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
        }
        graphics2D.dispose();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        boolean bl = false;
        if (this.rss.contains(mouseEvent.getX(), mouseEvent.getY())) {
            if (!this.rsj) {
                this.rsj = true;
                bl = true;
            }
        } else if (this.rsj) {
            this.rsj = false;
            bl = true;
        }
        if (this.rsw.contains(mouseEvent.getX(), mouseEvent.getY())) {
            if (!this.rsv) {
                this.rsv = true;
                bl = true;
            }
        } else if (this.rsv) {
            this.rsv = false;
            bl = true;
        }
        if (this.rsn.contains(mouseEvent.getX(), mouseEvent.getY())) {
            if (!this.rsh) {
                this.rsh = true;
                bl = true;
            }
        } else if (this.rsh) {
            this.rsh = false;
            bl = true;
        }
        if (bl) {
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
    public void mousePressed(MouseEvent mouseEvent) {
        if (this.rss.contains(mouseEvent.getX(), mouseEvent.getY()) || this.rsw.contains(mouseEvent.getX(), mouseEvent.getY()) || this.rsn.contains(mouseEvent.getX(), mouseEvent.getY())) {
            this.rwy = -1;
            this.rwr = -1;
            return;
        }
        this.rwy = mouseEvent.getX();
        this.rwr = mouseEvent.getY();
    }

    public Color h() {
        return this.rsz;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (this.rss.contains(mouseEvent.getX(), mouseEvent.getY())) {
            System.exit(0);
        }
        if (this.rsw.contains(mouseEvent.getX(), mouseEvent.getY())) {
            if (this.rsi != null) {
                this.rsi.x(this);
            } else if ((this.rsd.getExtendedState() & 6) == 6) {
                this.rsd.setExtendedState(0);
            } else {
                this.rsd.setExtendedState(6);
            }
            return;
        }
        if (this.rsn.contains(mouseEvent.getX(), mouseEvent.getY())) {
            this.rsd.setState(1);
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void x(Color color) {
        this.x(color, Color.WHITE);
    }

    public ZAW(JFrame jFrame) {
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
}