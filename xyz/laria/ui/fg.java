// =============================================== //
// Recompile disabled. Please run Recaf with a JDK //
// =============================================== //

// Decompiled with: CFR 0.152
// Class Version: 8
package xyz.laria.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        if (this.xa.username.getText().equalsIgnoreCase("Kullanıcı Adı")) {
            this.xa.username.setText("");
        }
    }
}
 