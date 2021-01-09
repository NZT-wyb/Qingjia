package Dao;

import Dao.Daotool;
import java.lang.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

public class Search {
    public Vector Find(String name) throws SQLException {
        //Vector<Vector> rows=new Vector<Vector>();
        Vector row=new Vector();
        Connection conn = null;
        PreparedStatement presta = null;
        ResultSet res = null;
        conn = Daotool.getconnection();
        String sql="select * from qingjia where name=?";
//        System.out.println(sql);
        presta=conn.prepareStatement(sql);
        presta.setString(1,name);
        res= presta.executeQuery();
//        System.out.println(res);
        while(res.next()) {//遍历数据集
            //Vector row=new Vector();//定义行数据
            row.add(res.getString(1));//获取第一个字段学号
            row.add(res.getString(2));//获取第二个字段姓名
            row.add(res.getString(3));
            row.add(res.getString(4));
            row.add(res.getString(5));
            row.add(res.getString(6));
            row.add(res.getString(7));
            row.add(res.getString(8));
            //rows.add(row);//将行数据添加到记录集合中
        }
                return row;
    }
//    public static void main(String[] args) throws SQLException {
//        Search s1=new Search();
//        //System.out.println(s1.Find("索春"));
//        Iterator<Vector> iter = s1.Find("索春").iterator();
//        while(iter.hasNext())
//        {
//            System.out.print(iter.next());
//            System.out.print("  ");
//        }
//    }
}
