/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.florex.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import xyz.florex.ui.MainScreen;

public class fg
implements MouseListener {
    public final MainScreen xa;

    public fg(MainScreen MainScreen2) {
        this.xa = MainScreen2;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (this.xa.username.getText().equalsIgnoreCase("Kullan\u0131c\u0131 Ad\u0131")) {
            this.xa.username.setText("");
        }
    }
}

