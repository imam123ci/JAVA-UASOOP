package model;

import org.sql2o.Connection;

import java.util.List;

public class Respon {
    int idPengguna;
    int idKuis;
    int nilai;
    Connection conn;

    
    // constructor
    // parameter : int idPengguna, int idKuis
    public Respon(int idPengguna, int idKuis){
        this.conn = new DBconnect().getConn();
        this.idPengguna = idPengguna;
        this.idKuis = idKuis;
        this.nilai = 0;
    }

    //get set function
    public int getNilai() {
        return this.nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }


    // add 1 poin to nilai
    public void addNilai(){
        this.nilai++;
    }

    // save respon to database
    // Parameter : 
    // Output : 
    public void save() {
        String q = "INSERT INTO `Respon`(`idPengguna`, `idKuis`, `nilai`) VALUES (:idPengguna,:idKuis,:nilai)";
        this.conn.createQuery(q)
            .addParameter("idPengguna", this.idPengguna)
            .addParameter("idKuis", this.idKuis)
            .addParameter("nilai", this.nilai)
            .executeUpdate();
    }

    // get Respon from databases by id kuis
    // Parameter : int idKuis;
    // output : List<Respon>->query results;
    public List<Respon> getByIdKuis(int idKuis){
        String q = "SELECT * FROM `Respon` WHERE `idKuis`=:idKuis";
        return(
            this.conn.createQuery(q)
            .addParameter("idKuis", idKuis)
            .executeAndFetch(Respon.class)
        );
    }

    // get Respon from databases by id pengguna
    // Parameter : int idPengguna;
    // output : List<Respon>->query results;
    public List<Respon> getByIdPengguna(int idPengguna){
        String q = "SELECT * FROM `Respon` WHERE `idPengguna`=:idPengguna";
        return(
            this.conn.createQuery(q)
            .addParameter("idPengguna", idPengguna)
            .executeAndFetch(Respon.class)
        );
    }
}
