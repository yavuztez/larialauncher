package xyz.laria.ui;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Console
        extends JFrame {
    private JTextArea textArea;
    private static Console instance;

    public void logEkle(String string) {
        this.textArea.append(string + "\n");
    }

    private Console() {
        this.setTitle("Launcher Konsolu");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(2);
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(this.textArea);
        this.add((Component)jScrollPane, "Center");
        this.setVisible(true);
    }

    public static Console getInstance() {
        if (instance == null) {
            instance = new Console();
        }
        return instance;
    }
}