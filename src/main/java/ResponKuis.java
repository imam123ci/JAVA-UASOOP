
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;

import java.util.List;
import java.util.ArrayList;

public class ResponKuis extends JFrame{
    private static final long serialVersionUID = 1L;
    private Kuis kuis;
    private int nilai = 0;
    private int responIndex = 0;
    private int responLength = 0;
    List<Pertanyaan> petanyaans;

    public ResponKuis(String kodeKuis) {
        getData(kodeKuis);
        setTitle(kuis.judul);
        setSize(530, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel KodeLabel = new JLabel(kuis.kode, JLabel.CENTER);
        JLabel JudulLabel = new JLabel(kuis.judul, JLabel.CENTER);
        JudulLabel.setBounds(150, 10, 200, 30);
        JudulLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        KodeLabel.setBounds(150, 50, 200, 20);
        KodeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
      
        add(JudulLabel);
        add(KodeLabel);
        
        JButton nextButton = new JButton("Begin");
        nextButton.setBounds(150,100 , 200, 30);
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextRespon();

            }
        });

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(150, 150, 200, 30);
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

    //get Data
    // set class Kuis variable
    void getData(String kodeKuis){
        kuis = new Kuis("1u32");
        this.petanyaans = kuis.getPertanyaan();
        this.responLength = this.petanyaans.size();
    }

    // function to generate new respon dialog
    // generate Respon Class
    void nextRespon(){
        if(this.responIndex < this.responLength){
            new Respon(petanyaans.get(this.responIndex)).setVisible(true);
            this.responIndex++;
        }else{
            int idp = (Session.idPengguna != 0) ? Session.idPengguna : 1;
            model.Respon r = new model.Respon(idp ,kuis.idKuis);
            r.setNilai(this.nilai);
            r.save();
            new Hasil(this.nilai).setVisible(true);
            dispose();
        }
    }

    class Respon extends JDialog {
        private static final long serialVersionUID = 1L;
        private List<Jawaban> jawabans;
        private Pertanyaan pertanyaan;
        private List<JCheckBox> jawabanCheckboxs = new ArrayList<>();;
        
        public Respon(Pertanyaan pertanyaan){
            this.pertanyaan = pertanyaan;
            getJawabans();
            setSize(500,400);
            setResizable(false);
            setLocationRelativeTo(null);
            setLayout(null);
            JLabel tanyaLabel = new JLabel(pertanyaan.pertanyaan, JLabel.LEFT);
            tanyaLabel.setBounds(50, 10, 200, 30);
            tanyaLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            add(tanyaLabel);
    
            JLabel pilLabel = new JLabel("Pilih Jawaba :");
            pilLabel.setBounds(50, 60, 400, 30);
            pilLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
            add(pilLabel);
    
           
           for (int i = 0; i < jawabans.size(); i++) {
                Jawaban jawaban = jawabans.get(i);
                JCheckBox jawabCheck = new JCheckBox(jawaban.jawaban);
                jawabCheck.setBounds(50, (110+(i*50)), 20, 20);
                jawabanCheckboxs.add(jawabCheck);
                add(jawabanCheckboxs.get(i));
                JLabel jawabLabel = new JLabel(jawaban.jawaban);
                jawabLabel.setBounds(80, (110+(i*50)), 370, 20);
                add(jawabLabel);

            }
    
            
            JButton nextButton = new JButton("NEXT");
            nextButton.setBounds(250, 300, 200, 20);
            nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            add(nextButton);
            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getNilai();
                }
            });


        }

        //function to retrive jawabans
        //set Respon class variable
        void getJawabans(){
            this.jawabans =  pertanyaan.getJawaban();
        }

        //function to calculate nilai
        //set Responkuis.nilai 
        void getNilai(){

            
            for (int i = 0; i < jawabans.size(); i++) {
                Jawaban jawaban = jawabans.get(i);
                boolean isCheck = jawabanCheckboxs.get(i).isSelected();
                if(jawaban.isAnswer && isCheck){
                    ResponKuis.this.nilai++;
                }
            }
            ResponKuis.this.nextRespon();
            dispose();
        }
    }


   

}
