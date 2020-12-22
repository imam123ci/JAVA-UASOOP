package model;
import java.util.UUID;
import org.sql2o.Connection;

import java.util.List;

public class Kuis {
    public int idKuis;
    public String judul;
    public String idPengguna;
    public String kode;
    public List<Pertanyaan> pertanyaans;
    Connection con;
    public Kuis() {

        try {

            this.con = DBconnect.connect();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }
    // constuctor when select kuis from databases based on kode kuis
    // Parameter : String kode-> kode kuis
    // Output : None
    public Kuis(String kode) {
        // get Kuis from databases
        Kuis k = null;
        try {
            this.con = DBconnect.connect();
            String q = "SELECT `idKuis`,`judul`, `kode`, `idPengguna` FROM `Kuis` WHERE `kode`=:kkuis";
            k = this.con.createQuery(q)
            .addParameter("kkuis", kode)
            .executeAndFetchFirst(Kuis.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
        if(k != null){
            this.idKuis = k.idKuis;
            this.judul = k.judul;
            this.kode = k.kode;
            this.pertanyaans = k.pertanyaans;
            System.out.println(this.judul);    
        }else{
            System.out.println("data is empty");
        }
    }

    public Kuis(String judul , String kode, int idPengguna) {
        this.judul=judul;
        this.kode=kode;
        this.idPengguna=Integer.toString(idPengguna);
    }



    // get Pertanyaan of this kuis from databases
    // then store in in class variable pertanyaans
    // Parameter :
    // Output : List<Pertanyaan> 
    public List<Pertanyaan> getPertanyaan(){
        return new Pertanyaan().getByIdKuis(this.idKuis);
    }

    // save kuis to databases
    // Parameter : 
    // Output : int -> primary key
    public int save(){
        //write query to save kuis
        this.con = new DBconnect().getConn();
        String q = "INSERT INTO `Kuis`(`judul`, `kode`, `idpengguna`)"
                +"VALUES (:judul,:kode,:pengguna);";
        int k = this.con.createQuery(q, true)
        .addParameter("judul", this.judul)
        .addParameter("kode", this.kode)
        .addParameter("pengguna", this.idPengguna)
        .executeUpdate()
        .getKey(int.class);

        return k;
    }
// get All Kuis

    // parameter :

    // output : List<Kuis>
    public String generateKode(){

        String uuid = UUID.randomUUID().toString();

        this.kode = uuid.substring(0, 8);
        return this.kode;
    }


    public List<Kuis> getAll(){

        String q = "SELECT * FROM `Kuis`";

        return (

                this.con.createQuery(q)

                        .executeAndFetch(Kuis.class)

        );

    }



    // get All Kuis By Id

    // parameter :

    // output : List<Kuis>

    public List<Kuis> getByIdPengguna(){

        String q = "SELECT * FROM `Kuis` WHERE `idPengguna`=:idPengguna";

        return (

                this.con.createQuery(q)

                        .addParameter("idPengguna", this.idPengguna)

                        .executeAndFetch(Kuis.class)

        );

    }
    // update kuis to databases
    // Parameter : 
    // Output :
    public void update(){
        String q = "UPDATE `Kuis` SET `judul`=:judul,`kode`=:kode,`idPengguna`=:idpengguna"
        +" WHERE `idKuis` = :id";
        
        this.con.createQuery(q)
        .addParameter("judul", this.judul)
        .addParameter("kode", this.kode)
        .addParameter("idpengguna", this.idPengguna)
        .addParameter("id", this.idKuis)
        .executeUpdate();
    }

    // delete kuis from databases
    // Parameter : 
    // Output : row update
    public int delete(){
        String q = "DELETE FROM `Kuis` WHERE `idKuis` = :id";
        this.con.createQuery(q)
        .addParameter("id", this.idKuis)
        .executeUpdate();

        return this.con.getResult();
    }


}
