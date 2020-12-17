import model.Jawaban;
import org.sql2o.Connection;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Jawab extends JFrame{

    public Jawab() {

        setTitle("Kuisis");
        setSize(530, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);



        JLabel tanyaLabel = new JLabel("Pertanyaan");
        tanyaLabel.setBounds(50, 10, 200, 30);
        tanyaLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(tanyaLabel);
        JTextField soalTextField = new JTextField();
        soalTextField.setBounds(170, 10, 280, 30);
        add(soalTextField);

        JLabel pilLabel = new JLabel("Pilihan (A/B/C/D) :");
        pilLabel.setBounds(50, 60, 400, 30);
        pilLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(pilLabel);

        JLabel pilALabel = new JLabel("A.");
        pilALabel.setBounds(50, 110, 70, 30);
        pilALabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(pilALabel);
        JTextField pilATextField = new JTextField();
        pilATextField.setBounds(80, 110, 370, 30);
        add(pilATextField);

        JLabel pilBLabel = new JLabel("B.");
        pilBLabel.setBounds(50, 160, 70, 30);
        pilBLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(pilBLabel);
        JTextField pilBTextField = new JTextField();
        pilBTextField.setBounds(80, 160, 370, 30);
        add(pilBTextField);

        JLabel pilCLabel = new JLabel("C.");
        pilCLabel.setBounds(50, 210, 70, 30);
        pilCLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(pilCLabel);
        JTextField pilCTextField = new JTextField();
        pilCTextField.setBounds(80, 210, 370, 30);
        add(pilCTextField);

        JLabel pilDLabel = new JLabel("D.");
        pilDLabel.setBounds(50, 260, 70, 30);
        pilDLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(pilDLabel);
        JTextField pilDTextField = new JTextField();
        pilDTextField.setBounds(80, 260, 370, 30);
        add(pilDTextField);

        JLabel dijawabLabel = new JLabel("Jawaban (A/B/C/D) :");
        dijawabLabel.setBounds(50, 310, 300, 30);
        dijawabLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(dijawabLabel);
        JTextField dijawabTextField = new JTextField();
        dijawabTextField.setBounds(250, 310, 200, 30);
        add(dijawabTextField);

        JButton nextButton = new JButton("NEXT");
        nextButton.setBounds(250, 385, 200, 30);
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditGame().setVisible(true);

            }
        });
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(250, 450, 200, 30);
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
