import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Pengguna;

public class Login extends JFrame {
    private static final long serialVersionUID = 1L;

    public Login() {
        setTitle("Login");
        setSize(600, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new log(this));

        setVisible(true);
    }
}

class log extends JPanel {
    private static final long serialVersionUID = 1L;
    static JTextField mail = new JTextField();
    static JPasswordField pass = new JPasswordField();
    JFrame rootFrame;

    log(JFrame rootFrame) {
        setLayout(new GridLayout(3, 2));
        add(new JLabel("email"));
        add(mail);
        add(new JLabel("password"));
        add(pass);
        add(new JLabel(" "));
        add(new ButtonPanel(rootFrame));

        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "login");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));
        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorder));

        this.rootFrame = rootFrame;
    }

    class ButtonPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        JButton btnSubmit = new JButton("Submit");
        JButton btnClose = new JButton("Close");
        JFrame rootFrame;
        ButtonPanel(JFrame rootFrame) {
            add(btnSubmit);
            add(btnClose);
            this.rootFrame = rootFrame;
            btnSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // create new Pengguna Class
                        Pengguna p = new Pengguna( mail.getText(), new String(pass.getPassword()));
                        // Try to login
                        boolean loginStatus = p.Login();

                        if (loginStatus) {
                            JOptionPane.showMessageDialog(null, "berhasil login");
                            new TampilinDaftar().setVisible(true);
                            ButtonPanel.this.rootFrame.dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "email atau password salah");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }

            });

            btnClose.addActionListener(new ActionListener() {
                @Override
                
                public void actionPerformed(ActionEvent e) {
                    ButtonPanel.this.rootFrame.dispose();
                }
            });
        }
    }}


