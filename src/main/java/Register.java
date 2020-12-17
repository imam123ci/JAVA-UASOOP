import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Pengguna;

public class Register extends JFrame {

    public Register(){
        setTitle("Register");
        setSize(500,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        add(new regis());
        setVisible(true);
    }
}
class regis extends JPanel{

    static JTextField FullName = new JTextField();
    static JTextField Email = new JTextField();
    static JPasswordField Passw = new JPasswordField();


    regis() {
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Full Name"));
        add(FullName);
        add(new JLabel("Email"));
        add(Email);
        add(new JLabel("Password"));
        add(Passw);
        add(new JLabel(" "));
        add(new ButtonPanel());
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "login");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));
        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorder));
        }

        class ButtonPanel extends JPanel{
            JButton btnDaftar = new JButton("Submit");
            JButton btnClose = new JButton("Close");
        ButtonPanel(){
            add(btnDaftar);
            add(btnClose);
        btnClose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        btnDaftar.addActionListener(new regis.bRegis());

        }}

    static class bRegis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                // create new Pengguna Class
                Pengguna p = new Pengguna(FullName.getText(), Email.getText(), new String(Passw.getPassword()), false);
                // if register not return -1 , register is success
                boolean registerStatus = p.Register() != -1 ? true : false;

                if(registerStatus){
                    JOptionPane.showMessageDialog(null, "Register Succeded!");
                    new Login().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Email is exist!");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }

    }

}