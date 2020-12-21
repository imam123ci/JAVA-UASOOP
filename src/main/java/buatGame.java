import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class buatGame extends JFrame {
    private static final long serialVersionUID = 1L;
    public buatGame(final int kuisId){
        setTitle("Kuisis");
        setSize(530,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        JLabel tanyaLabel = new JLabel("Pertanyaan");
        tanyaLabel.setBounds(50, 10, 200, 30);
        tanyaLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(tanyaLabel);
        final JTextField soalTextField = new JTextField();
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
        final JTextField pilATextField = new JTextField();
        pilATextField.setBounds(80, 110, 370, 30);
        add(pilATextField);

        JLabel pilBLabel = new JLabel("B.");
        pilBLabel.setBounds(50, 160, 70, 30);
        pilBLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(pilBLabel);
        final JTextField pilBTextField = new JTextField();
        pilBTextField.setBounds(80, 160, 370, 30);
        add(pilBTextField);

        JLabel pilCLabel = new JLabel("C.");
        pilCLabel.setBounds(50, 210, 70, 30);
        pilCLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(pilCLabel);
        final JTextField pilCTextField = new JTextField();
        pilCTextField.setBounds(80, 210, 370, 30);
        add(pilCTextField);

        JLabel pilDLabel = new JLabel("D.");
        pilDLabel.setBounds(50, 260, 70, 30);
        pilDLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(pilDLabel);
        final JTextField pilDTextField = new JTextField();
        pilDTextField.setBounds(80, 260, 370, 30);
        add(pilDTextField);

        JLabel dijawabLabel = new JLabel("Jawaban (A/B/C/D) :");
        dijawabLabel.setBounds(50, 310, 300, 30);
        dijawabLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(dijawabLabel);
        final JTextField dijawabTextField = new JTextField();
        dijawabTextField.setBounds(250, 310, 200, 30);
        add(dijawabTextField);


        JButton addButton = new JButton("Tambah Soal");
        addButton.setBounds(250, 385, 200, 30);
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //formClear();
                //Kuis k = Kuis(kodeKuis)
                // int idKuis = k.idKuis
//                Kuis kuis = new Kuis("judul", "" ,Session.idPengguna );
//                kuis.judul =
//                int idKuis = kuis.save();
                //Pertanyaan p = new Pertanyaan(soalTextField.getText(), kuis.idKuis);

                new buatGame(kuisId).setVisible(true);
                Pertanyaan p = new Pertanyaan();
                p.pertanyaan = soalTextField.getText();
                p.idKuis = kuisId;
                int idPertayaan = p.save();

                Jawaban a = new Jawaban();
                a.jawaban = pilATextField.getText();
                a.isAnswer = false;
                a.idPertanyaan = idPertayaan;


                Jawaban b = new Jawaban();
                b.jawaban = pilBTextField.getText();
                b.isAnswer = false;
                b.idPertanyaan = idPertayaan;


                Jawaban c = new Jawaban();
                c.jawaban = pilCTextField.getText();
                c.isAnswer = false;
                c.idPertanyaan = idPertayaan;

                Jawaban d = new Jawaban();
                d.jawaban = pilDTextField.getText();
                d.isAnswer = false;
                d.idPertanyaan = idPertayaan;

                switch (dijawabTextField.getText().toUpperCase()){
                    case "A" : a.isAnswer = true;
                        break;
                    case "B" : b.isAnswer = true;
                        break;
                    case "C" : c.isAnswer = true;
                        break;
                    case "D" : d.isAnswer = true;
                        break;
                    default :
                        return ;
                }

                a.save();
                b.save();
                c.save();
                d.save();
                //Jawaban j = new Jawaban(new String(pilBTextField.getText()),new boolean[0],);
                //Jawaban j = new Jawaban(new String(pilATextField.getText()),new boolean[0],);
                //Jawaban j = new Jawaban(new String(pilATextField.getText()),new boolean[0],)
                //if(dijawabTextField=="A")
                //    Jawaban j = new Jawaban(new String(pilATextField.getText()),new)

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


        //private void formClear() {
        //        Pertanyaan.soalTextField.setText("");
        //        Pertanyaan.a.setText("");
        //        Pertanyaan.b.setText("");
        //        Pertanyaan.c.setText("");
        //        Pertanyaan.d.setText("");
        //        Pertanyaan.answer.setText("");
        //    }

        setVisible(true);
    }


}

