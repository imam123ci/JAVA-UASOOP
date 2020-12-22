import model.Kuis;
import model.Session;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import java.sql.SQLException;
import javax.swing.border.EmptyBorder;


public class DaftarGame extends JPanel {
    static DefaultTableModel tblmodel;
    static JTable tbl;
    DaftarGame(){
        tblmodel = new DefaultTableModel();
        tbl = new JTable(tblmodel);
        JScrollPane scrollPane = new JScrollPane(tbl);
        tbl.setFillsViewportHeight(true);
        tbl.setEnabled(false);
        this.selectId();
        setLayout(new GridLayout(1,1));
        setBorder(new EmptyBorder(10,10,10,12));

        add(scrollPane);
        setVisible(true);
    }
    static void selectId(){
        tblmodel = new DefaultTableModel();
        tblmodel.addColumn("ID Kuisis");
        tblmodel.addColumn("Judul");
        tblmodel.addColumn("Kode Kuisis");

        // get kuis
        Kuis kuis = new Kuis();
        kuis.idPengguna = String.valueOf(Session.idPengguna);
        List<Kuis> kuiss = kuis.getByIdPengguna();
        for(Kuis k: kuiss) {

            tblmodel.addRow(new Object[]{k.idKuis, k.judul, k.kode});
        }

        tbl.setModel(tblmodel);
    }

    void refeshData(){
        Kuis kuis = new Kuis();
        kuis.idPengguna = String.valueOf(Session.idPengguna);
        List<Kuis> kuiss = kuis.getByIdPengguna();
        Object[][] results = new String[kuiss.size()][5];
        for(int i = 0; i< kuiss.size(); i++){
            Kuis k = kuiss.get(i);
            results[i][0] = String.valueOf(k.idKuis);
            results[i][1] = k.judul;
            results[i][2] = k.kode;
        }
        Object columnNames[] = {"Id Kuisis","Jusul","kode kuisis"};
        tblmodel.setDataVector(results,columnNames);
        tblmodel.fireTableDataChanged();
        System.out.println("data changed");
    }

}