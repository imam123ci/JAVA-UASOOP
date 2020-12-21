import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Kuis;
import model.Session;

public class Title extends JFrame {
    private static final long serialVersionUID = 1L;
    public Title(){
        setTitle("Kuisis");
        setSize(600, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        add(new kuis());
        setVisible(true);
    }
}
class kuis extends JPanel {
    private static final long serialVersionUID = 1L;
    static JTextField judul = new JTextField();
    static JTextField kode = new JTextField();


    kuis() {
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Judul Kuis :"));
        add(judul);
        add(new JLabel("Kode Kuis :"));
        add(kode);
        add(new JLabel(" "));
        add(new ButtonPanel());


        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Kuisis");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));
        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorder));
    }

    class ButtonPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        JButton btnSubmit = new JButton("Buat");
        JButton btnEdit = new JButton("Edit");
        JButton btnClose = new JButton("Batal");

        ButtonPanel() {
            add(btnSubmit);
            add(btnEdit);
            add(btnClose);
            btnSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Kuis k = new Kuis(judul.getText(),kode.getText(), Session.idPengguna);
                    k.save();
                    //boolean kuisStatus = k.save() != -1 ? true : false;
                    new buatGame().setVisible(true);

                }
            });
            btnEdit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    new EditGame().setVisible(true);

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