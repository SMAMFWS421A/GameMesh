package Chess.Game;

import javax.swing.*;
import java.awt.*;

public class Gui {

    static JFrame jf;

    static Label jlb;

    static JButton btnreturn,btnreset;

    public static final int Width = 1900, Height = 1030, xfeld = 500, yfeld = 100, feldsize = 800;

    public void create(){
        jf = new JFrame("Schach");
        jf.setSize(Width,Height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);

        btnreset = new JButton("Reset");
        btnreset.addActionListener(e -> reset());

        btnreset.setBounds(1500,900,100,50);
        btnreset.setVisible(true);
        btnreset.setFocusPainted(true);
        btnreset.setBackground(new Color(51, 102, 153));
        btnreset.setForeground(Color.WHITE);
        jf.add(btnreset);

        jlb = new Label();
        jlb.setBounds(0,0,Width,Height);
        jlb.setVisible(true);
        jf.addMouseListener(new Chess.Game.Feld(8,8));
        jf.addMouseMotionListener(new MouseMotionHandler());
        jf.add(jlb);

        jf.setVisible(true);
    }
    public static void reset(){
        Chess.Game.Feld x = new Feld(8,8);
        x.reset();
    }
}
