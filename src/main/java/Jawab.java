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

        JCheckBox checkboxA = new JCheckBox();
        checkboxA.setBounds(50, 110, 20, 20);
        add(checkboxA);
        JTextField pilATextField = new JTextField();
        pilATextField.setBounds(80, 110, 370, 30);
        add(pilATextField);

        JCheckBox checkboxB = new JCheckBox();
        checkboxB.setBounds(50, 160, 20, 20);
        add(checkboxB);
        JTextField pilBTextField = new JTextField();
        pilBTextField.setBounds(80, 160, 370, 30);
        add(pilBTextField);

        JCheckBox checkboxC = new JCheckBox();
        checkboxC.setBounds(50, 210, 20, 20);
        add(checkboxC);
        JTextField pilCTextField = new JTextField();
        pilCTextField.setBounds(80, 210, 370, 30);
        add(pilCTextField);

        JCheckBox checkboxD = new JCheckBox();
        checkboxD.setBounds(50, 260, 20, 20);
        add(checkboxD);
        JTextField pilDTextField = new JTextField();
        pilDTextField.setBounds(80, 260, 370, 30);
        add(pilDTextField);


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
