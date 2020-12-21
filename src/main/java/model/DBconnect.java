package model;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DBconnect {
    private static Sql2o sql2o;
    //make connection public so it will be easeir to modify db
    private static Connection conn = null;

    // making connection
    public static Connection connect() throws Exception{       
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        if(conn == null || conn.getJdbcConnection().isClosed()){
            sql2o = new Sql2o("jdbc:mysql://62.171.164.73:3306/kuisis", "vera", "imamvera");
            conn = sql2o.open();
        }
                
        return conn;
    }

    // get sql2o connection object
    public Connection getConn(){
        return conn;
    }
}
