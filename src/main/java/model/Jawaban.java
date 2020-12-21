package model;

import org.sql2o.Connection;

import java.util.List;

public class Jawaban {
    public int idJawaban;
    public String jawaban;
    public boolean isAnswer;
    public int idPertanyaan;
    Connection conn;

    // empty constructor for sql outside model
    public Jawaban(){
        try {
            this.conn = DBconnect.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // constuctor when you have the data
    public Jawaban(int idJawaban, String jawaban, boolean isAnswer, int idPertanyaan) {
        try {
            this.conn = DBconnect.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.idJawaban = idJawaban;
        this.jawaban = jawaban;
        this.isAnswer = isAnswer;
        this.idPertanyaan = idPertanyaan;
    }

    // get jawaban from databases by id pertanyaan
    // Parameter : int idpertanyaan;
    // output : List<Jawaban>->query results;
    public List<Jawaban> getByIdPertanyaan(int idPertanyaan){
        String q = "SELECT * FROM `Jawaban` WHERE idPertanyaan=:idPertanyaan";
        return (
            this.conn.createQuery(q)
            .addParameter("idPertanyaan", idPertanyaan)
            .executeAndFetch(Jawaban.class)
            );
    }

    // save jawaban to databases
    // then store in in class variable idJawaban
    // Parameter : 
    // Output : 
    public int save(){
        //query
        String q = "INSERT INTO `Jawaban` (`jawaban`, `isAnswer`, `idPertanyaan`) VALUES (:jawaban,:isAnswer,:idPertanyaan);";
        int k = this.conn.createQuery(q,true)
        .addParameter("jawaban", this.jawaban)
        .addParameter("isAnswer", this.isAnswer)
                .addParameter("idPertanyaan", this.idPertanyaan)
        .executeUpdate()
        .getKey(int.class);

        //set class idJawaban to database primary ket
        this.idJawaban = k;

        //return primary ket
        return k;
    }

    // delete jawaban from databases
    // Parameter : 
    // Output : 
    public void delete(){
        String q = "DELETE FROM `Jawaban` WHERE `idJawaban`=:idJawaban";
        this.conn.createQuery(q)
        .addParameter("idJawaban", this.idJawaban)
        .executeUpdate();
        
    }

    // set jawaban to isAnswer
    // Parameter :
    // Output :
    public void setAnswer(){
        String q = "UPDATE `Jawaban` SET `isAnswer`=true WHERE `idJawaban`=:idJawaban";
        this.conn.createQuery(q)
        .addParameter("idJawaban", this.idJawaban)
        .executeUpdate();
    }

}
