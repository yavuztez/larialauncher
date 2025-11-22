/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import javax.swing.JTextPane;
import javax.swing.text.BoxView;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.LabelView;
import javax.swing.text.ParagraphView;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

public class zq
extends JTextPane {
    private static final long rwb = 4198776603971711041L;

    public zq(double n) {
        this.setEditorKit(new CenterEditorKit(n));
    }

    public zq() {
        this(2.5);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        StyledDocument styledDocument = this.getStyledDocument();
        SimpleAttributeSet a = new SimpleAttributeSet();
        StyleConstants.setAlignment(a, 1);
        styledDocument.setParagraphAttributes(0, styledDocument.getLength(), a, false);
    }

    public static class CenterEditorKit
    extends StyledEditorKit {
        private static final long rwg = -1494767865811574522L;
        private double rwd;

        public CenterEditorKit(double rwd) {
            this.rwd = rwd;
        }

        @Override
        public ViewFactory getViewFactory() {
            return new CenterStyledViewFactory(this.rwd);
        }
    }

    public static class CenterStyledViewFactory
    implements ViewFactory {
        private double rwz;

        public CenterStyledViewFactory(double rwz) {
            this.rwz = rwz;
        }

        @Override
        public View create(Element elem) {
            String name = elem.getName();
            if (name != null) {
                if (name.equals("content")) {
                    return new LabelView(elem);
                }
                if (name.equals("paragraph")) {
                    return new ParagraphView(elem);
                }
                if (name.equals("section")) {
                    return new CenteredBoxView(elem, 1, this.rwz);
                }
                if (name.equals("component")) {
                    return new ComponentView(elem);
                }
                if (name.equals("icon")) {
                    return new IconView(elem);
                }
            }
            return new LabelView(elem);
        }
    }

    public static class CenteredBoxView
    extends BoxView {
        private double rwm;

        public CenteredBoxView(Element elem, int axis, double rwm) {
            super(elem, axis);
            this.rwm = rwm;
        }

        @Override
        protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets, int[] spans) {
            super.layoutMajorAxis(targetSpan, axis, offsets, spans);
            int n = 0;
            for (int i2 = 0; i2 < spans.length; ++i2) {
                n = spans[i2];
            }
            int n2 = (int)((double)(targetSpan - n) / this.rwm);
            int j = 0;
            while (j < offsets.length) {
                int n3 = j++;
                int n4 = n3;
                offsets[n4] = offsets[n4] + n2;
            }
        }
    }
}

