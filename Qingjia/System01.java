package Qingjia;

import Dao.Daotool;
import VO.StudentLeaveRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 学生请假系统模块
 */



public class System01 extends JFrame implements ActionListener{


    JFrame frame;
    JButton jb1=new JButton("学生申请请假");
    JButton jb2=new JButton("学生申请销假");
    JButton jb3=new JButton("查询请假记录");
    JButton jb4=new JButton("提交");
    JButton jb5=new JButton("退出");

    static JTextArea jt;
    static  JTextField xmg;
    static  JTextField bjg;
    static JTextField xhg;
    static JTextField lxg;
    static JTextField ksrqg;
    static JTextField jsrqg;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System01 a=new System01();	}
    public System01(){
        this.setTitle("学生请假系统");
        this.setLocation(550,200);
        this.setSize(700,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        jb1.setOpaque(false);
        jb1.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb2.setOpaque(false);
        jb2.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb3.setOpaque(false);
        jb3.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb4.setOpaque(false);
        jb4.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb5.setOpaque(false);
        jb5.setFont(new Font("微软雅黑",Font.PLAIN,18));

        jb1.setBackground(new Color(233,240,247));
        jb2.setBackground(new Color(233,240,247));
        jb3.setBackground(new Color(233,240,247));
        jb4.setBackground(new Color(233,240,247));
        jb5.setBackground(new Color(233,240,247));


        JLabel jl=new JLabel("请假申请");
        JLabel xm=new  JLabel("姓名");
        JLabel bj=new JLabel("班级");
        JLabel xh=new JLabel("学号");
        JLabel lx=new JLabel("联系");
        JLabel ksrq=new JLabel("开始日期");
        JLabel jsrq=new JLabel("结束日期");
        JLabel qjsy=new JLabel("请假事由");



        jl.setFont(new Font("微软雅黑",Font.PLAIN,18));
        xm.setFont(new Font("微软雅黑",Font.PLAIN,18));
        bj.setFont(new Font("微软雅黑",Font.PLAIN,18));
        xh.setFont(new Font("微软雅黑",Font.PLAIN,18));
        lx.setFont(new Font("微软雅黑",Font.PLAIN,18));
        ksrq.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jsrq.setFont(new Font("微软雅黑",Font.PLAIN,18));
        qjsy.setFont(new Font("微软雅黑",Font.PLAIN,18));

        xmg=new JTextField();
        bjg=new JTextField();
        xhg=new JTextField();
        lxg=new JTextField();
        ksrqg=new JTextField();
        jsrqg=new JTextField();

        jt=new JTextArea();

        xmg.setFont(new Font("微软雅黑",Font.PLAIN,18));
        bjg.setFont(new Font("微软雅黑",Font.PLAIN,18));
        xhg.setFont(new Font("微软雅黑",Font.PLAIN,18));
        lxg.setFont(new Font("微软雅黑",Font.PLAIN,18));
        ksrqg.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jsrqg.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jt.setFont(new Font("微软雅黑",Font.PLAIN,18));

        xmg.setBorder(null);
        bjg.setBorder(null);
        xhg.setBorder(null);
        lxg.setBorder(null);
        ksrqg.setBorder(null);
        jsrqg.setBorder(null);


        jb1.setBounds(5, 0, 233, 50);
        jb2.setBounds(236, 0, 223, 50);
        jb3.setBounds(457, 0, 223, 50);

        jl.setBounds(300,51,620,50);

        xm.setBounds(30,90,60,50);
        xmg.setBounds(68,102,110,30);


        xh.setBounds(190,90,50,50);
        xhg.setBounds(227,102,110,30);

        bj.setBounds(350,90,50,50);
        bjg.setBounds(389,102,110,30);

        lx.setBounds(517,90,50,50);
        lxg.setBounds(556,102,110,30);

        ksrq.setBounds(30,135,90,50);
        ksrqg.setBounds(105,145,170,30);

        jsrq.setBounds(300,135,90,50);
        jsrqg.setBounds(375,145,170,30);

        qjsy.setBounds(30,210,90,100);
        //jt.setBounds(30,210,90,100);
        jt.setBounds(105,200,555,130);


        jb4.setBounds(30,380,100,50);
        jb5.setBounds(140,380,100,50);
        //this.add(upper);

        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jl);
        this.add(xm);
        this.add(xmg);
        this.add(bj);
        this.add(bjg);
        this.add(xh);
        this.add(xhg);
        this.add(lx);
        this.add(lxg);
        this.add(ksrq);
        this.add(ksrqg);
        this.add(jsrq);
        this.add(jsrqg);
        this.add(qjsy);
        //this.add(qjsyg);
        this.add(jt);
        this.add(jb4);
        this.add(jb5);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // String input = e.getActionCommand();
        if( e.getSource().equals(jb5))//按钮事件
        {
            this.dispose();//关闭当前实例
            // System.exit( 0 );
        }
//		  if(input.equals("退出")){
//			  this.dispose();
//		  }
        if(e.getSource().equals(jb4)){

            File f = new File("d:\\student1.txt");
            //字节输出流
            FileOutputStream fos=null;
            try {
                fos = new FileOutputStream(f);
                String s="姓名:"+"  "+xmg.getText()+"\r\n";
                String s1="学号:"+"  "+xhg.getText()+"\r\n";
                String s2="班级:"+"  "+bjg.getText()+"\r\n";
                String s3="联系:"+"  "+lxg.getText()+"\r\n";
                String s4="开始:"+"  "+ksrqg.getText()+"\r\n";
                String s5="结束:"+"  "+jsrqg.getText()+"\r\n";
                String s6 = "请假事由:"+"  "+jt.getText()+"\r\n";//换行：/r/n
                String s7="请假信息已提交,等待审核通过";
                //定义字节数组
                byte []btyes = new byte[10024];

                fos.write(s.getBytes());
                fos.write(s1.getBytes());
                fos.write(s2.getBytes());
                fos.write(s3.getBytes());
                fos.write(s4.getBytes());
                fos.write(s5.getBytes());
                fos.write(s6.getBytes());
                fos.write(s7.getBytes());



            } catch (Exception e1) {
                e1.printStackTrace();
                // TODO: handle exception
            }finally{
                try {
                    fos.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "提交成功");
            Connection conn = null;
            PreparedStatement presta = null;
            ResultSet res= null;

            conn = Daotool.getconnection();
            String sql = "insert into  qingjia values(?,?,?,?,?,?,?,?)";
            try {
                presta = conn.prepareStatement(sql);
                presta.setString(1,xmg.getText());
                presta.setString(2,xhg.getText());
                presta.setString(3,bjg.getText());
                presta.setString(4,lxg.getText());
                presta.setString(5,ksrqg.getText());
                presta.setString(6,jsrqg.getText());
                presta.setString(7,jt.getText());
                presta.setString(8,"待审核");
                presta.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            xmg.setText("");//清空
            bjg.setText("");
            xhg.setText("");
            lxg.setText("");
            ksrqg.setText("");
            jsrqg.setText("");
            jt.setText("");
            }
        if(e.getSource().equals(jb3)){
            StudentLeaveRecord SLR=new StudentLeaveRecord();
            this.dispose();
        }
        if(e.getSource().equals(jb2)){
            StudentDelete stl=new StudentDelete();
            this.dispose();

            //JOptionPane.showMessageDialog(null, "对不起，该功能未开通");
        }
        if(e.getSource().equals(jb1)){
            JOptionPane.showMessageDialog(null, "你已处于当前界面");
        }  }

}




