import model.Kuis;
import model.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TampilinDaftar extends JFrame {
    TampilinDaftar(){
        setTitle("My Kuisis");
        setSize(700, 800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new listDaftar());
        setVisible(true);

    }
}
class listDaftar extends JPanel {
    static JTextField daftar = new JTextField();
    JTextField hapusTextField = new JTextField();
    JButton btnDelete = new JButton("Hapus");
    int kuisId;
    listDaftar() {
        setLayout(new GridLayout(6,1));
        this.kuisId = kuisId;
        add(new JLabel("My Kuisis"));
        add(new DaftarGame());
        add(new ButtonPanel());
        add(new JLabel("kuis ID :"));
        add(hapusTextField);
        add(btnDelete);

    }
    class ButtonPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        JTextField hapusTextField = new JTextField();
        JButton btnAdd = new JButton("Tambah");
        JButton btnClose = new JButton("Batal");
        JButton btnDelete = new JButton("Hapus");

        ButtonPanel() {
            add(btnAdd);
            add(btnClose);
            //add(btnSubmit);
            //            add(btnEdit);
            //            add(btnClose);
            //            add(btnDelete);
            btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Title().setVisible(true);
                }
            });

            btnClose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });



            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Kuis K= new Kuis();
                    K.idKuis= Integer.parseInt(ButtonPanel.this.hapusTextField.getText());
                    K.delete();
                }
            });
        }
    }


}