// =============================================== //
// Recompile disabled. Please run Recaf with a JDK //
// =============================================== //

// Decompiled with: CFR 0.152
// Class Version: 8
package xyz.laria.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.Border;

public class te
implements Border,
Serializable {
    private static final long rjl = 715287754750604058L;
    private static final Map rja = new HashMap();
    private Color rjo;
    private int rjg;
    private float rjd;
    private int rjz;
    private boolean rjm;
    private boolean rjb;
    private boolean rjt;
    private boolean rju;

    public te() {
        this(Color.BLACK, 5);
    }

    public te(Color color, int n) {
        this(color, n, 0.5f, 12, false, false, true, true);
    }

    public te(boolean bl) {
        this(Color.BLACK, 5, 0.5f, 12, false, bl, true, true);
    }

    public te(Color color, int n, float f, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.rjo = color;
        this.rjg = n;
        this.rjd = f;
        this.rjz = n2;
        this.rjm = bl;
        this.rjb = bl2;
        this.rjt = bl3;
        this.rju = bl4;
    }

    @Override
    public void paintBorder(Component component, Graphics graphics, int n, int n2, int n3, int n4) {
        Rectangle rectangle;
        Map map = this.x((Graphics2D)graphics);
        Graphics2D graphics2D = (Graphics2D)graphics.create();
        int n5 = 2;
        Point point = null;
        if (this.rjb || this.rjm) {
            point = new Point();
            if (this.rjb && !this.rjm) {
                point.setLocation(n, n2 + n5);
            } else if (this.rjb && this.rjm) {
                point.setLocation(n, n2);
            } else if (!this.rjb && this.rjm) {
                point.setLocation(n + this.rjg, n2);
            }
        }
        Point point2 = null;
        if (this.rjb || this.rjt) {
            point2 = new Point();
            if (this.rjb && !this.rjt) {
                point2.setLocation(n, n2 + n4 - this.rjg - this.rjg);
            } else if (this.rjb && this.rjt) {
                point2.setLocation(n, n2 + n4 - this.rjg);
            } else if (!this.rjb && this.rjt) {
                point2.setLocation(n + this.rjg, n2 + n4 - this.rjg);
            }
        }
        Point point3 = null;
        if (this.rju || this.rjt) {
            point3 = new Point();
            if (this.rju && !this.rjt) {
                point3.setLocation(n + n3 - this.rjg, n2 + n4 - this.rjg - this.rjg);
            } else if (this.rju && this.rjt) {
                point3.setLocation(n + n3 - this.rjg, n2 + n4 - this.rjg);
            } else if (!this.rju && this.rjt) {
                point3.setLocation(n + n3 - this.rjg - this.rjg, n2 + n4 - this.rjg);
            }
        }
        Point point4 = null;
        if (this.rju || this.rjm) {
            point4 = new Point();
            if (this.rju && !this.rjm) {
                point4.setLocation(n + n3 - this.rjg, n2 + n5);
            } else if (this.rju && this.rjm) {
                point4.setLocation(n + n3 - this.rjg, n2);
            } else if (!this.rju && this.rjm) {
                point4.setLocation(n + n3 - this.rjg - this.rjg, n2);
            }
        }
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        if (this.rjb) {
            rectangle = new Rectangle(n, point.y + this.rjg, this.rjg, point2.y - point.y - this.rjg);
            graphics2D.drawImage((Image)map.get((Object)tm.rjr), rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
        }
        if (this.rjt) {
            rectangle = new Rectangle(point2.x + this.rjg, n2 + n4 - this.rjg, point3.x - point2.x - this.rjg, this.rjg);
            graphics2D.drawImage((Image)map.get((Object)tm.rjc), rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
        }
        if (this.rju) {
            rectangle = new Rectangle(n + n3 - this.rjg, point4.y + this.rjg, this.rjg, point3.y - point4.y - this.rjg);
            graphics2D.drawImage((Image)map.get((Object)tm.rjq), rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
        }
        if (this.rjm) {
            rectangle = new Rectangle(point.x + this.rjg, n2, point4.x - point.x - this.rjg, this.rjg);
            graphics2D.drawImage((Image)map.get((Object)tm.rni), rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
        }
        if (this.rjb || this.rjm) {
            graphics2D.drawImage((Image)map.get((Object)tm.rjy), point.x, point.y, null);
        }
        if (this.rjb || this.rjt) {
            graphics2D.drawImage((Image)map.get((Object)tm.rje), point2.x, point2.y, null);
        }
        if (this.rju || this.rjt) {
            graphics2D.drawImage((Image)map.get((Object)tm.rjx), point3.x, point3.y, null);
        }
        if (this.rju || this.rjm) {
            graphics2D.drawImage((Image)map.get((Object)tm.rjp), point4.x, point4.y, null);
        }
        graphics2D.dispose();
    }

    private Map x(Graphics2D graphics2D) {
        HashMap<tm, BufferedImage> hashMap = (HashMap<tm, BufferedImage>)rja.get((double)this.rjg + (double)this.rjo.hashCode() * 0.3 + (double)this.rjd * 0.12);
        if (hashMap == null) {
            hashMap = new HashMap<tm, BufferedImage>();
            int n = this.rjz + 1;
            RoundRectangle2D.Double double_ = new RoundRectangle2D.Double(0.0, 0.0, n, n, this.rjz, this.rjz);
            int n2 = n + this.rjg * 2;
            BufferedImage bufferedImage = tf.x(n2, n2);
            Graphics2D graphics2D2 = (Graphics2D)bufferedImage.getGraphics();
            graphics2D2.setPaint(new Color(this.rjo.getRed(), this.rjo.getGreen(), this.rjo.getBlue(), (int)(this.rjd * 255.0f)));
            graphics2D2.translate(this.rjg, this.rjg);
            graphics2D2.fill(double_);
            graphics2D2.dispose();
            float f = 1.0f / (float)(this.rjg * this.rjg);
            float[] fArray = new float[this.rjg * this.rjg];
            for (int n3 = 0; n3 < fArray.length; ++n3) {
                fArray[n3] = f;
            }
            ConvolveOp convolveOp = new ConvolveOp(new Kernel(this.rjg, this.rjg, fArray));
            BufferedImage bufferedImage2 = tf.x(n2, n2);
            ((Graphics2D)bufferedImage2.getGraphics()).drawImage(bufferedImage, convolveOp, -(this.rjg / 2), -(this.rjg / 2));
            int n4 = 1;
            int n5 = 1;
            int n6 = this.rjg;
            int n7 = this.rjg;
            hashMap.put(tm.rjy, this.x(bufferedImage2, n4, n5, n6, n7));
            n4 = 1;
            n5 = n7;
            n6 = this.rjg;
            n7 = 1;
            hashMap.put(tm.rjr, this.x(bufferedImage2, n4, n5, n6, n7));
            n4 = 1;
            n5 = n;
            n6 = this.rjg;
            n7 = this.rjg;
            hashMap.put(tm.rje, this.x(bufferedImage2, n4, n5, n6, n7));
            n4 = this.rjz + 1;
            n5 = n;
            n6 = 1;
            n7 = this.rjg;
            hashMap.put(tm.rjc, this.x(bufferedImage2, n4, n5, n6, n7));
            n5 = n4 = n;
            n6 = this.rjg;
            n7 = this.rjg;
            hashMap.put(tm.rjx, this.x(bufferedImage2, n4, n5, n6, n7));
            n4 = n;
            n5 = this.rjz + 1;
            n6 = this.rjg;
            n7 = 1;
            hashMap.put(tm.rjq, this.x(bufferedImage2, n4, n5, n6, n7));
            n4 = n;
            n5 = 1;
            n6 = this.rjg;
            n7 = this.rjg;
            hashMap.put(tm.rjp, this.x(bufferedImage2, n4, n5, n6, n7));
            n4 = this.rjg;
            n5 = 1;
            n6 = 1;
            n7 = this.rjg;
            hashMap.put(tm.rni, this.x(bufferedImage2, n4, n5, n6, n7));
            bufferedImage.flush();
            rja.put((double)this.rjg + (double)this.rjo.hashCode() * 0.3 + (double)this.rjd * 0.12, hashMap);
        }
        return hashMap;
    }

    private BufferedImage x(BufferedImage bufferedImage, int n, int n2, int n3, int n4) {
        BufferedImage bufferedImage2 = tf.x(n3, n4);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.drawImage(bufferedImage, 0, 0, n3, n4, n, n2, n + n3, n2 + n4, null);
        graphics2D.dispose();
        return bufferedImage2;
    }

    @Override
    public Insets getBorderInsets(Component component) {
        int n = this.rjm ? this.rjg : 0;
        int n2 = this.rjb ? this.rjg : 0;
        int n3 = this.rjt ? this.rjg : 0;
        int n4 = this.rju ? this.rjg : 0;
        return new Insets(n, n2, n3, n4);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    public boolean x() {
        return this.rjm;
    }

    public boolean h() {
        return this.rjb;
    }

    public boolean v() {
        return this.rju;
    }

    public boolean r() {
        return this.rjt;
    }

    public int y() {
        return this.rjg;
    }

    public Color p() {
        return this.rjo;
    }

    public float l() {
        return this.rjd;
    }

    public int b() {
        return this.rjz;
    }

    public void x(Color color) {
        this.rjo = color;
    }

    public void x(int n) {
        this.rjg = n;
    }

    public void x(float f) {
        this.rjd = f;
    }

    public void h(int n) {
        this.rjz = n;
    }

    public void x(boolean bl) {
        this.rjm = bl;
    }

    public void h(boolean bl) {
        this.rjb = bl;
    }

    public void v(boolean bl) {
        this.rjt = bl;
    }

    public void r(boolean bl) {
        this.rju = bl;
    }
}
 