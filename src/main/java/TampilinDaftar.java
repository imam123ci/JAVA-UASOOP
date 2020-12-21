import model.Kuis;
import model.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TampilinDaftar extends JFrame {
    TampilinDaftar(){
        setTitle("Login");
        setSize(1000, 1000);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new DaftarGame());
        setVisible(true);

    }
}
class listDaftar extends JPanel {
    static JTextField daftar = new JTextField();

    listDaftar() {
        add(new JLabel("My Kuisis"));


    }

    class ButtonPanel extends JPanel {
        private static final long serialVersionUID = 1L;

        JButton btnEdit = new JButton("Edit");
        JButton btnClose = new JButton("Batal");
        JButton btnDelete = new JButton("Hapus");

        ButtonPanel() {
            //add(btnSubmit);
            //            add(btnEdit);
            //            add(btnClose);
            //            add(btnDelete);

            btnEdit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    new EditGame().setVisible(true);

                }
            });
            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Kuis K= new Kuis();
                    K.idKuis= 1;
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


}
