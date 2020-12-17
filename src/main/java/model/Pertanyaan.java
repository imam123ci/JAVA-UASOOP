package model;

import org.sql2o.Connection;

import java.util.List;

public class Pertanyaan {
    public int idPertanyaan;
    public String pertanyaan;
    public int idKuis;
    public List<Jawaban> jawabans;
    Connection con;

    // empty constructor for sql outside model
    public Pertanyaan(){
        this.con = new DBconnect().getConn();
    }

    // constructor where you have bunch of data. LOL
    public Pertanyaan(int idPertanyaan, String pertanyaan, int idKuis){
        this.con = new DBconnect().getConn();
        this.idPertanyaan = idPertanyaan;
        this.pertanyaan = pertanyaan;
        this.idKuis = idKuis;
    }

    // get pertanyaan by Id Kuis
    // Parameter : int idKuis
    // Output : List<Pertanyaan> -> results list
    public List<Pertanyaan> getByIdKuis(int idKuis){
        String q = "SELECT * FROM `Pertanyaan` WHERE `idKuis`=:idKuis";
        return(
            this.con.createQuery(q)
            .addParameter("idKuis", idKuis)
            .executeAndFetch(Pertanyaan.class)
        );
    }

    // get right jawaban (isAnswer = true)
    // Parameter :
    // Output : Jawaban -> result 
    public Jawaban getRightJawaban(){
        String q = "SELECT * FROM `Jawaban` WHERE `isAnswer`=true AND `idPertanyaan`=:idPertanyaan";
        Jawaban j = this.con.createQuery(q)
                    .addParameter("idPertanyaan", this.idPertanyaan)
                    .executeAndFetchFirst(Jawaban.class);
        
        return j;
    }

    // get Jawaban of this Pertanyaan from databases
    // then store in in class variable jawabans
    // Parameter :
    // Output : List<Jawaban> 
    public List<Jawaban> getJawaban(){
        return new Jawaban().getByIdPertanyaan(this.idPertanyaan);
        
    }



    // save pertanyaan to databases
    // then store in in class variable idPetanyaan
    // Parameter : 
    // Output : int->primary key
    public int save(){
        String q = "INSERT INTO `Pertanyaan`( `pertanyaan`, `idKuis`) VALUES (:pertanyaan, :idkuis)";

        int k = this.con.createQuery(q, true)
        .addParameter("pertanyaan", this.pertanyaan)
        .addParameter("idKuis", this.idKuis)
        .executeUpdate()
        .getKey(int.class);

        return k;
    }

    // update pertanyaan to databases
    // Parameter : 
    // Output : 
    public void update(){
        String q = "UPDATE `Pertanyaan` SET `pertanyaan`=:pertanyaan,`idKuis`=:idkuis WHERE `idPertanyaan`=:idpertanyaan";

        this.con.createQuery(q)
        .addParameter("pertanyaan", this.pertanyaan)
        .addParameter("idKuis", this.idKuis)
        .addParameter("idpertanyaan", this.idPertanyaan)
        .executeUpdate();
        
    }

    // delete pertanyaan from databases
    // Parameter : 
    // Output : 
    public void delete(){
        String q = "DELETE FROM `Pertanyaan` WHERE `idPertanyaan`=:idpertanyaan";
        this.con.createQuery(q)
        .addParameter("idpertanyaan", this.idPertanyaan)
        .executeUpdate();        
    }

    
}