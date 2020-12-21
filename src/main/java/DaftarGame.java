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
        setBorder(new EmptyBorder(10,10,0,12));

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
        kuis.idPengguna = String.valueOf(1);
        List<Kuis> kuiss = kuis.getByIdPengguna();
        for(Kuis k: kuiss) {

            tblmodel.addRow(new Object[]{k.idKuis, k.judul, k.kode});
        }

        tbl.setModel(tblmodel);
    }

}