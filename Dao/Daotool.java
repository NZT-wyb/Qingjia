package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Daotool {

    public static Connection getconnection() {
        Connection conn = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立和数据库的连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stu?serverTimezone=GMT", "root", "root");
            //conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

//    public static void main(String[] args) {
//        System.out.println(Daotool.getconnection());
//    }

}
