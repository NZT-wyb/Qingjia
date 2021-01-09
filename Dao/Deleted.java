package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Deleted {
    public int Shanchu(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement presta = null;
        conn = Daotool.getconnection();
        String sql="delete  from qingjia where name=?";
//        System.out.println(sql);
        presta=conn.prepareStatement(sql);
        presta.setString(1,name);
        int res = presta.executeUpdate();
        return res;
    }
}
