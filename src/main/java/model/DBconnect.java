package model;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DBconnect {
    private Sql2o sql2o;
    //make connection public so it will be easeir to modify db
    public Connection conn;

    // making connection
    public DBconnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            sql2o = new Sql2o("jdbc:mysql://62.171.164.73:3306/kuisis", "vera", "imamvera");
            this.conn = sql2o.open();

        }catch (Exception e) {
            System.out.println(e);

        }
    }

    // get sql2o connection object
    public Connection getConn(){
        return this.conn;
    }
}
