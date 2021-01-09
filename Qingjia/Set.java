package Qingjia;

import Dao.Daotool;
import VO.CounsellorLookRecord;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class Set extends JFrame implements ActionListener{

    /**
     * 辅导员查看学生请假信息模块
     */

    JButton jb1=new JButton("审核请假信息");
    JButton jb2=new JButton("审核销假信息");
    JButton jb3=new JButton("学生请假记录");

    JButton jb5=new JButton("退出");

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        Set s1=new Set();
    }



    JPanel panel;
    JScrollPane scrollPane;
    public Set() throws SQLException, ClassNotFoundException {
        this.setTitle("辅导员管理请假信息系统");
        this.setLocation(550,200);
        this.setSize(823,498);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);


        jb1.setOpaque(false);
        jb1.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb2.setOpaque(false);
        jb2.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb3.setOpaque(false);
        jb3.setFont(new Font("微软雅黑",Font.PLAIN,18));
//        jb4.setOpaque(false);
//        jb4.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb5.setOpaque(false);
        jb5.setFont(new Font("微软雅黑",Font.PLAIN,18));
//        jb6.setOpaque(false);
//        jb6.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb1.setBackground(new Color(233,240,247));
        jb2.setBackground(new Color(233,240,247));
        jb3.setBackground(new Color(233,240,247));
//        jb4.setBackground(new Color(233,240,247));
        jb5.setBackground(new Color(233,240,247));
        //jb6.setBackground(new Color(233,240,247));



        jb1.setBounds(5, 0, 250, 50);
        jb2.setBounds(253, 0, 233, 50);
        jb3.setBounds(485, 0, 300, 50);
        //jb4.setBounds(230, 400, 223, 50);
        jb5.setBounds(550, 400, 223, 50);
        //jb6.setBounds(10, 400, 223, 50);


//        jt.setBounds(30,80,620,300);
//        jt.setEditable(false);//设计文本框不能外部输入
//        jt.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        //jb4.addActionListener(this);
        jb5.addActionListener(this);
        //jb6.addActionListener(this);

        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        //this.add(jb4);
        this.add(jb5);
        //this.add(jb6);
//        this.add(jt);
        this.setVisible(true);

        //FileReader fr=null;
        //写入文件（输出流）
        //FileWriter fw=null;
//
//        try {
//            //创建fir对象
//            fr = new FileReader("d:\\student1.txt");
//
//
//            int n=0;//实际读取的字符数
//            //读入到内存
//            char c[]=new char[10024];
//
//            while((n=fr.read(c))!=-1){
//                //System.out.println(c);
//                String s= new String(c,0,n);
//
//                jt.setText(s);
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            // TODO: handle exception
//        }
        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 50, 800, 300);
        this.add(scrollPane);

        panel = new JPanel();
        panel.setLayout(new GridLayout(50, 1,4,4));
        scrollPane.setViewportView(panel);
        toadd();

    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource().equals(jb5)){
            this.dispose();
        }
        //Object[] options={"好啊","去一边"};
        if(e.getSource().equals(jb3)){
            CounsellorLookRecord clr=new CounsellorLookRecord();
            this.dispose();
        }
        if(e.getSource().equals(jb2)){

            JOptionPane.showMessageDialog(null, "对不起，该功能未开通");
        }
        if(e.getSource().equals(jb1)){
            JOptionPane.showMessageDialog(null, "你已处于当前界面");
        }


    }
    public void toadd() throws ClassNotFoundException, SQLException {
        Connection conn = null ;
        PreparedStatement presta  = null;
        ResultSet res  = null;
        panel.removeAll();
        JLabel jlabel11 = new JLabel("  姓名  "+"  学号  "+"   班级  "+"   联系  "+"  开始日期  "+" 结束日期  "+" 请假事由  "+"请假状态 ");
        jlabel11.setFont(new Font("宋体", Font.PLAIN, 20));
        panel.add(jlabel11);
        String sql="select * from qingjia" ;
        conn = Daotool.getconnection();
        presta= conn.prepareStatement(sql);
        res = presta.executeQuery();
        while(res.next()){//设置格式
            String ans =  res.getString("name");
            ans = ans +"  " + res.getString("number");
            ans = ans +"  " + res.getString("class");
            ans = ans +"  " + res.getString("tel");
            ans = ans +"  " + res.getString("date1");
            ans = ans +"  " + res.getString("date2");
            ans = ans +"  " + res.getString("reason");
            ans = ans +"   " + res.getString("status")+"\r\n";

            if(res.getString("status").equals("待审核")){
                shenhe(res.getString("name"),ans);
            }
        }
    }
    public void shenhe(String name,String ans) {
        JLabel jlabel11 = new JLabel(ans);
        jlabel11.setFont(new Font("宋体", Font.PLAIN, 20));
        JPopupMenu popuMenu = new JPopupMenu();
        JMenuItem ac = new JMenuItem("通过审核");
        ac.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Connection conn = null;
                PreparedStatement presta = null;
                ResultSet res= null;
                conn = Daotool.getconnection();
                String sql = "update qingjia set status =? where name = ?";
                try {
                    presta = conn.prepareStatement(sql);
                    presta.setString(1,"通过");
                    presta.setString(2,name);

                    presta.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                try {
                    toadd();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        popuMenu.add(ac);

        JMenuItem de = new JMenuItem("不通过");
        de.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                Connection conn = null;
                PreparedStatement presta = null;
                ResultSet res= null;

                conn = Daotool.getconnection();
                String sql = "update qingjia set status =? where name = ?";
                try {
                    presta = conn.prepareStatement(sql);
                    presta.setString(1,"不通过");
                    presta.setString(2,name);
                    presta.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                try {
                    toadd();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        popuMenu.add(de);

        jlabel11.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                popuMenu.show(jlabel11,e.getX(),e.getY());

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override//鼠标碰到变蓝
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                JLabel jl=(JLabel)e.getSource();
                jl.setForeground(Color.blue);
            }

            @Override//鼠标离开变黑
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                JLabel jl=(JLabel)e.getSource();
                jl.setForeground(Color.black);
            }
        });
        panel.add(jlabel11);

        panel.setVisible(false);
        scrollPane.setVisible(false);
        panel.repaint();
        panel.setVisible(true);
        scrollPane.setVisible(true);
    }
}


