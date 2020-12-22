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
        setSize(700, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new DaftarGame());
        add(new listDaftar());
        setVisible(true);

    }
}
class listDaftar extends JPanel {

    JTextField hapusTextField = new JTextField();
    JButton btnAdd = new JButton("Tambah");
    JButton btnClose = new JButton("Batal");
    int kuisId;
    listDaftar() {
        setLayout(new GridLayout(5,2));
        this.kuisId = kuisId;


        add(new JLabel("kuis ID :"));
        add(hapusTextField);
        add(new JLabel(" "));
        add(new ButtonPanel());
        add(new JLabel(" "));
        add(new JLabel(" "));
        add(btnAdd);
        add(btnClose);
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
    }
    class ButtonPanel extends JPanel {
        private static final long serialVersionUID = 1L;


        JButton btnDelete = new JButton("Hapus");

        ButtonPanel() {

            add(btnDelete);
             btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Kuis K= new Kuis();
                    String idKuis = listDaftar.this.hapusTextField.getText();
                    K.idKuis= Integer.parseInt(idKuis);
                    System.out.println(K.idKuis);
                    K.delete();
                }
            });
        }
    }


}