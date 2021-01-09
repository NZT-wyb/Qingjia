package Qingjia;

import Dao.Deleted;
import Dao.Search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

/**
 * 学生销假模块
 */



public class StudentDelete extends JFrame implements ActionListener {
    JButton jb1=new JButton("销假");
    JButton jb2=new JButton("返回");
    JTextField jt=new JTextField();
    JLabel jl=new JLabel("姓名");

    public StudentDelete(){
        this.setTitle("学生销假系统");
        this.setLocation(550,200);
        this.setSize(700,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        //this.setVisible(true);
        jb1.setOpaque(true);
        jb2.setOpaque(true);

        jb1.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb2.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb1.setBackground(new Color(233,240,247));
        jb2.setBounds(300,55,123,25);
        jb1.setBounds(5, 55, 123, 25);
        jt.setBounds(150, 55, 123, 25);
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        this.add(jb1);
        this.add(jb2);
        this.add(jt);
        this.setVisible(true);

    }
    public static void main(String[]args){
        StudentDelete std=new StudentDelete();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jb2)){
            System01 s2=new System01();
            this.dispose();
        }
        if(e.getSource().equals(jb1)){
            Deleted del=new Deleted();
            try {
                if(del.Shanchu(jt.getText())>0){
                    JOptionPane.showMessageDialog(null, "删除成功");
                }
                else{
                    JOptionPane.showMessageDialog(null, "查无此人，无法删除");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }



    }

}
