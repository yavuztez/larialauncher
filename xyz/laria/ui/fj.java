package xyz.laria.ui;

public class fj
        extends ButtonActionListener {
    private final FU ch;

    public fj(FU fU) {
        this.ch = fU;
    }

    @Override
    public void x() {
        FU.x(this.ch, 0);
        this.ch.dispose();
    }
}