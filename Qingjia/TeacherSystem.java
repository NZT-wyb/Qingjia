package Qingjia;

import VO.TeacherLookRecord;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TeacherSystem  extends JFrame implements ActionListener{

    /**
     * 教师查看学生请假信息系统模块
     */

    JButton jb1=new JButton("学生请假信息");
    JButton jb2=new JButton("学生销假信息");
    JButton jb3=new JButton("退出");
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TeacherSystem TS=new TeacherSystem();
    }

    public TeacherSystem(){

        this.setTitle("教师查看学生请假信息系统");
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
        jb1.setBackground(new Color(233,240,247));
        jb2.setBackground(new Color(233,240,247));
        jb3.setBackground(new Color(233,240,247));

        jb1.setBounds(5, 0, 233, 50);
        jb2.setBounds(236, 0, 223, 50);
        jb3.setBounds(457, 0, 223, 50);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if(e.getSource().equals(jb3)){
            this.dispose();
        }
        if(e.getSource().equals(jb2)){
            JOptionPane.showMessageDialog(null, "对不起，该功能未开通");
        }
        if(e.getSource().equals(jb1)){
            TeacherLookRecord TLR=new TeacherLookRecord();
            this.dispose();
        }
    }
}

