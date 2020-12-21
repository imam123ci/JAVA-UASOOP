import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kuisis extends JFrame {
    private static final long serialVersionUID = 1L;
    public Kuisis() {
        setTitle("Kuisis");
        setSize(400, 365);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        JLabel pinLabel = new JLabel("Game Pin :");
        pinLabel.setBounds(20, 10, 200, 30);
        pinLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        add(pinLabel);
        JTextField pinTextField = new JTextField();
        pinTextField.setBounds(110, 10, 250, 30);
        add(pinTextField);

        JButton enterButton = new JButton("Enter");
        enterButton.setBounds(160, 45, 150, 30);
        enterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(enterButton);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(20, 115, 340, 30);
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnLogin);

        JLabel akunLabel = new JLabel("Don't have account ?");
        akunLabel.setBounds(20, 155, 350, 30);
        akunLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        add(akunLabel);
        JButton btnRegis = new JButton("Register");
        btnRegis.setBounds(20, 185, 340, 30);
        btnRegis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnRegis);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(185, 255, 150, 30);
        btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnClose);

        add(btnClose);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                new Kuisis().dispose();
            }
        });
        btnRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register().setVisible(true);
                new Kuisis().dispose();
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getjawab
                new Jawab().setVisible(true);
            }
        });

        setVisible(true);
    }

}