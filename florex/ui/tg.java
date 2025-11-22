/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import net.coobird.thumbnailator.Thumbnails;

public class tg {
    public static BufferedImage x(BufferedImage bufferedImage, int n, int n2) {
        if (bufferedImage == null) {
            return null;
        }
        try {
            return Thumbnails.of(bufferedImage).size(n, n2).asBufferedImage();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static BufferedImage h(BufferedImage bufferedImage, int n, int n2) {
        if (bufferedImage == null) {
            return null;
        }
        try {
            return Thumbnails.of(bufferedImage).forceSize(n, n2).asBufferedImage();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static BufferedImage x(BufferedImage bufferedImage) {
        ColorModel colorModel = bufferedImage.getColorModel();
        boolean bl = colorModel.isAlphaPremultiplied();
        WritableRaster writableRaster = bufferedImage.copyData(null);
        return new BufferedImage(colorModel, writableRaster, bl, null);
    }

    public static BufferedImage x(BufferedImage bufferedImage, Color color) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        WritableRaster writableRaster = bufferedImage.getRaster();
        for (int n3 = 0; n3 < n; ++n3) {
            for (int n4 = 0; n4 < n2; ++n4) {
                int[] nArray = writableRaster.getPixel(n3, n4, (int[])null);
                nArray[0] = color.getRed();
                nArray[1] = color.getGreen();
                nArray[2] = color.getBlue();
                writableRaster.setPixel(n3, n4, nArray);
            }
        }
        return bufferedImage;
    }

    public static BufferedImage x(BufferedImage bufferedImage, double d) {
        double d2 = Math.toRadians(d);
        double d3 = bufferedImage.getWidth(null) / 2;
        double d4 = bufferedImage.getHeight(null) / 2;
        AffineTransform affineTransform = AffineTransform.getRotateInstance(d2, d3, d4);
        AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, 2);
        return affineTransformOp.filter(bufferedImage, null);
    }

    public static BufferedImage h(BufferedImage bufferedImage, double d) {
        double d2 = Math.abs(Math.sin(Math.toRadians(d)));
        double d3 = Math.abs(Math.cos(Math.toRadians(d)));
        int n = bufferedImage.getWidth(null);
        int n2 = bufferedImage.getHeight(null);
        int n3 = (int)Math.floor((double)n * d3 + (double)n2 * d2);
        int n4 = (int)Math.floor((double)n2 * d3 + (double)n * d2);
        BufferedImage bufferedImage2 = new BufferedImage(n3, n4, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.translate((n3 - n) / 2, (n4 - n2) / 2);
        graphics2D.rotate(Math.toRadians(d), n / 2, n2 / 2);
        graphics2D.drawRenderedImage(bufferedImage, null);
        graphics2D.dispose();
        return bufferedImage2;
    }

    public static BufferedImage h(BufferedImage bufferedImage, Color color) {
        return tg.x(tg.x(bufferedImage), color);
    }

    public static BufferedImage x(int n, int n2) {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(n, n2, 3);
    }

    public static Graphics2D x(Graphics2D graphics2D) {
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        return graphics2D;
    }

    public static void x(Graphics2D graphics2D, String string, int n, int n2) {
        Font font = graphics2D.getFont();
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        Font font2 = font.deriveFont(font.getStyle(), (float)font.getSize() + 0.5f);
        FontMetrics fontMetrics2 = graphics2D.getFontMetrics(font2);
        while (fontMetrics2.getHeight() < fontMetrics.getHeight() * 2) {
            font2 = font2.deriveFont(font2.getStyle(), (float)font2.getSize() + 0.5f);
            fontMetrics2 = graphics2D.getFontMetrics(font2);
        }
        int n3 = fontMetrics2.stringWidth(string);
        int n4 = fontMetrics2.getHeight();
        BufferedImage bufferedImage = tg.x(n3, n4);
        Graphics2D graphics2D2 = tg.x(bufferedImage.createGraphics());
        graphics2D2.setFont(font2);
        graphics2D2.setColor(graphics2D.getColor());
        graphics2D2.drawString(string, 0, 0);
        graphics2D2.dispose();
        graphics2D.drawImage(bufferedImage, n, n2, n3 / 2, n4 / 2, null);
    }

    public static void h(Graphics2D graphics2D, String string, int n, int n2) {
        Font font = graphics2D.getFont();
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        Font font2 = font.deriveFont(font.getStyle(), (float)font.getSize() + 0.5f);
        FontMetrics fontMetrics2 = graphics2D.getFontMetrics(font2);
        while (fontMetrics2.getHeight() < fontMetrics.getHeight() * 2) {
            font2 = font2.deriveFont(font2.getStyle(), (float)font2.getSize() + 0.5f);
            fontMetrics2 = graphics2D.getFontMetrics(font2);
        }
        int n3 = fontMetrics2.stringWidth(string);
        int n4 = fontMetrics2.getHeight();
        BufferedImage bufferedImage = tg.x(n3, n4);
        Graphics2D graphics2D2 = tg.x(bufferedImage.createGraphics());
        graphics2D2.setFont(font2);
        graphics2D2.setColor(graphics2D.getColor());
        graphics2D2.drawString(string, 0, fontMetrics2.getAscent());
        graphics2D2.dispose();
        int n5 = n3 / 2;
        int n6 = n4 / 2;
        int n7 = (n - n5) / 2;
        int n8 = (n2 - n6) / 2;
        graphics2D.drawImage(bufferedImage, n7, n8, n5, n6, null);
    }
}

