import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Hasil extends JFrame {
    private static final long serialVersionUID = 1L;
    public Hasil(){
        setTitle("Total Score");
        setSize(320, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel hasilLabel = new JLabel("Total Score");
        hasilLabel.setBounds(50, 10, 200, 30);
        hasilLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        add(hasilLabel);
        JLabel scoreLabel = new JLabel();
        scoreLabel.setBounds(50, 50, 200, 45);
        add(scoreLabel);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(50, 125, 200, 30);
        closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(closeButton);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);

    }
}
