package xyz.laria.ui;

public class ft
        extends ButtonActionListener {
    private final FU ch;

    public ft(FU fU) {
        this.ch = fU;
    }

    @Override
    public void x() {
        FU.x(this.ch, 1);
        this.ch.dispose();
    }
}