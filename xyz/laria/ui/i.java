// =============================================== //
// Recompile disabled. Please run Recaf with a JDK //
// =============================================== //

package xyz.laria.ui;

import xyz.laria.utils.ImageUtils;

public class i
implements CustomButtonEventHandler {
    private boolean cs;
    public final MainScreen cw;

    public i(MainScreen cw) {
        this.cw = cw;
        this.cs = false;
    }

    @Override
    public void x(zs zs2) {
        if (this.cs) {
            this.cw.setSize(ImageUtils.v());
            MainScreen.x(this.cw).setBorder(MainScreen.h());
            this.cw.setLocationRelativeTo(null);
            this.cs = false;
        } else {
            this.cw.setSize(ImageUtils.x(this.cw.getGraphicsConfiguration()));
            MainScreen.x(this.cw).setBorder(null);
            this.cw.setLocationRelativeTo(null);
            this.cs = true;
        }
    }
}
 