package model;

import org.sql2o.Connection;

public class Pengguna {
    int idPengguna;
    String nama;
    String email;
    String password;
    boolean isTemp;
    Connection conn;

    // empty constructor for sql outside model
    public Pengguna() {
        try {
            this.conn = DBconnect.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Login Constructor
    public Pengguna(String email, String pass) {
        try {
            this.conn = DBconnect.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.email = email;
        this.password = pass;

        // try to login
        this.Login();

    }

    // Full Constructor for user registration
    public Pengguna(String nama, String email, String pass,boolean isTemp){
        this.conn = new DBconnect().getConn();
        // creating temp user
        if(isTemp){
            this.password = null;
        }
        else{
            this.password = pass;
        }
        // store data to variable
        this.nama = nama;
        this.email = email;
        this.isTemp = isTemp;        
    }

    // get set function
    public int getIdPengguna() {
        return this.idPengguna;
    }


    public String getNama() {
        return this.nama;
    }

    // Login Function
    // Parameter :
    // output : boolean -> status if login is success
    public boolean Login(){
        String q = "SELECT COUNT(*) FROM `Pengguna` WHERE `email`=:email and `password`=:pass";
        int r = this.conn.createQuery(q)
                .addParameter("email", this.email)
                .addParameter("pass", this.password)
                .executeScalar(Integer.class);
        if(r == 1){
            // get account info
            q = "SELECT * FROM `Pengguna` WHERE `email`=:email and `password`=:pass";
            Pengguna p = this.conn.createQuery(q)
                        .addParameter("email", this.email)
                        .addParameter("pass", this.password)
                        .executeAndFetchFirst(Pengguna.class);
            this.idPengguna = p.getIdPengguna();
            Session.idPengguna = p.getIdPengguna();
            this.nama = p.getNama();

            return true;
        }
        return false;
    }

    // Register Function
    // use in class variable
    // then store primary key in variable idPengguna
    // Parameter : 
    // Output : int -> primary key of user or -1 when fail
    public int Register(){
        try{
            String q = "INSERT INTO `Pengguna`(`nama`, `email`, `password`) VALUES (:nama, :email, :pass)";
        
            int k = this.conn.createQuery(q,true)
            .addParameter("nama", this.nama)
            .addParameter("email", this.email)
            .addParameter("pass", this.password)
            .executeUpdate()
            .getKey(int.class);
            this.idPengguna = k;
            return this.idPengguna;
        }
        catch(Exception e) {
            //what to do when register fail
            return -1;
        }

    }

    
}
