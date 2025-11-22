package xyz.laria.ui;

public class fz
        extends ButtonActionListener {
    private final FU ch;

    public fz(FU fU) {
        this.ch = fU;
    }

    @Override
    public void x() {
        FU.x(this.ch, 1);
        this.ch.dispose();
    }
}