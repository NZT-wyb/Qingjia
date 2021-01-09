package Qingjia;
/**
 * 登陆主界面
 */


import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
//import java.io.File;
//import java.io.IOException;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    //private static final String JPanel = null;
    JPanel jp=new JPanel();
    JTextField fieldAccount = new JTextField(1000);
    JPasswordField fieldPassword = new JPasswordField(1000);
    JButton jb1 = new JButton("登 录");
    JButton jb2=new JButton("退出");
    JLabel label = new JLabel("  帐  号   ");
    JLabel label1 = new JLabel(" 密 码   ");
    JLabel label2=new JLabel("请假系统登录界面");
    JRadioButton jrb1=new JRadioButton("学生");
    JRadioButton jrb2=new JRadioButton("教师");
    JRadioButton jrb3=new JRadioButton("辅导员");
    ButtonGroup bg=new ButtonGroup();

//		  public void paint(Graphics g){
//				 super.paint(g);
//				 ImageIcon imge=new ImageIcon("C:\\Users\\王益斌\\Desktop.images.back.jpg");
//				 imge.setImage(imge.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_AREA_AVERAGING));
//			g.drawImage(imge.getImage(),100,100,this);
//      增加背景图片 back.jpg
//			}

    public Login(){
       // 设置背景图
        ImageIcon img = new ImageIcon("C:\\Users\\王益斌\\Desktop\\back1.jpeg");
        JLabel lable = new JLabel(img);
        this.getLayeredPane().setLayout(null);
        lable.setBounds(0, 0, 700, 500);
        this.getLayeredPane().add(lable, new Integer(Integer.MIN_VALUE));
        JPanel j = (JPanel) this.getContentPane();
        j.setOpaque(false);
        this.setTitle("用户登录界面");
        this.setBounds(550, 200, 700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        jrb1.setOpaque(false);
        jrb2.setOpaque(false);
        jrb3.setOpaque(false);

        jb2.addActionListener(this);

        jb1.setBackground(new Color(233,240,247));
        jb1.setForeground(new Color(30,57,91));
        jb2.setBackground(new Color(233,240,247));
        jb2.setForeground(new Color(30,57,91));


        JLabel label = new JLabel("账号");

        label.setOpaque(false);
        label.setBounds(150,140,100,50);
        //label.setForeground(Color.white);
        label.setFont(new Font("微软雅黑",Font.PLAIN,18));

        //jb1.setForeground(Color.white);
        jb1.setFont(new Font("微软雅黑",Font.PLAIN,18));
        //jb2.setForeground(Color.white);
        jb2.setFont(new Font("微软雅黑",Font.PLAIN,18));

        // fieldAccount.setOpaque(false);
        fieldAccount.setBorder(null);
        // fieldPassword.setOpaque(false);
        // fieldPassword.setBorder(null);
        jb1.setOpaque(false);
        jb2.setOpaque(false);
        jb1.setBorder(null);
        jb2.setBorder(null);
        //label.setBackground(Color.red);
        //label.setForeground(Color.red);

        this.add(label);
        fieldAccount.setBounds(250, 140, 300, 50);
        this.add(fieldAccount);

        label1 = new JLabel("  密 码   ");

        label1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        //label1.setForeground(Color.white);
        label1.setFont(new Font("微软雅黑",Font.PLAIN,18));

        //label1.setForeground(Color.red);
        label1.setBounds(145, 238, 100, 50);
        this.add(label1);
        fieldPassword.setBounds(250, 240, 300, 50);
        fieldPassword.setBorder(null);
        this.add(fieldPassword);


        this.add(jb1);
        this.add(jb2);



        jb1.setBounds(250,350,100,50);
        jb2.setBounds(450,350,100,50);
        jb1.addActionListener(this);

        label2.setBounds(300,50,200,50);
        label2.setFont(new Font("微软雅黑",Font.PLAIN,18));
        this.add(label2);

        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        jrb1.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jrb2.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jrb3.setFont(new Font("微软雅黑",Font.PLAIN,18));

        jrb1.setBounds(250,320,70,30);
        jrb2.setBounds(320,320,70,30);
        jrb3.setBounds(390,320,100,30);
        this.add(jrb1);
        this.add(jrb2);
        this.add(jrb3);
        // pwd 监听enter键
        fieldPassword.addActionListener(this);
        fieldAccount.addActionListener(this);


        jrb1.addActionListener(this);
        jrb2.addActionListener(this);
        jrb3.addActionListener(this);
        jb1.addActionListener(this);

        this.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        if( e.getSource().equals(jb2))
        {
            this.dispose();
            // System.exit( 0 );
        }

        if(e.getSource() == fieldPassword|| e.getSource() == jb1){
            // 获取帐号
            String account = fieldAccount.getText();
            // 获取密码
            String pwd = new String(fieldPassword.getPassword());

            if (account.compareTo("123") == 0 && pwd.compareTo("123")==0 ){
                if(jrb1.isSelected()){
                    JOptionPane.showMessageDialog(null, "登录成功");
                    this.dispose();
                    System01 s=new System01();

                }
                else if(!jrb1.isSelected( )){
                    JOptionPane.showMessageDialog(null, "对不起，你不是学生用户");
                }
            }
            else if (account.compareTo("1234") == 0 && pwd.compareTo("1234")==0 ){
                if(jrb2.isSelected()){
                    JOptionPane.showMessageDialog(null, "登录成功");
                    this.dispose();
                    TeacherSystem TS=new TeacherSystem();
                }
                else JOptionPane.showMessageDialog(null, "对不起，你不是教师用户");

            }
            else if(account.equals("12345")  && pwd.equals("12345")){
                if(jrb3.isSelected()){
                    JOptionPane.showMessageDialog(null, "登录成功");
                    this.dispose();
                    CounsellorSystem CS=new CounsellorSystem();

                }
                else  JOptionPane.showMessageDialog(null, "对不起，你不是辅导员用户");
            }
            if( e.getSource().equals(jb1))
            {
                fieldAccount.setText("账号或密码错误");
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Login();
    }
}
 
 
 