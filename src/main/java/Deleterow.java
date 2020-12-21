import model.Kuis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deleterow extends JFrame {
    final JTextField hapusTextField;
    public Deleterow(final int kuisId) {
        setTitle("Delete");
        setSize(530, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        JLabel tanyaLabel = new JLabel("ID Kuis");
        tanyaLabel.setBounds(50, 10, 200, 30);
        tanyaLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(tanyaLabel);
        hapusTextField = new JTextField();
        hapusTextField.setBounds(50, 50, 200, 30);
        add(hapusTextField);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(50, 100, 100, 30);
        btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnDelete);
        JButton btnClose = new JButton("Close");
        btnClose.setBounds(150, 100, 100, 30);
        btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnClose);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kuis K= new Kuis();
                K.idKuis= Integer.parseInt(Deleterow.this.hapusTextField.getText());
                K.delete();

            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}


