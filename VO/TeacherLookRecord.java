package VO;
import Dao.PageController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.Collections;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TeacherLookRecord extends JFrame implements ActionListener{

    /**
     * 教师查看学生请假信息系统模块
     */
    private DefaultTableModel model;// 定义表格数据模型
    private TableRowSorter sorter;
    private Vector<String> titles;
    JButton jb1=new JButton("学生请假信息");
    JButton jb2=new JButton("学生销假信息");
    JButton jb3=new JButton("退出");
    JTextArea jt=new JTextArea();
    JTextField jf=new JTextField();
    JLabel jl=new JLabel("学号");
    String[] columnNames={"姓名","学号","班级","联系","开始日期","结束日期","请假事由","请假状态"};//定义表格列名数
    String[][] tableValues={{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
            {"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
            {"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
            {"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""}};//定义表格数据数组

    JTable table=new JTable(tableValues,columnNames);//创建指定列名和数据的表格

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        CounsellorLookRecord clr=new CounsellorLookRecord();
//    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TeacherLookRecord TLR=new TeacherLookRecord();
    }

    public TeacherLookRecord(){

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
        jt.setBounds(30,80,620,300);
        jt.setEditable(false);//设计文本框不能外部输入
        jt.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
        scrollPane.setBounds(44, 82, 646, 110);// 设置大小与位置
        this.add(scrollPane);// 将滚动面板加入到内容面板中

        // 使用动态数组数据（列标题与行数据）
        titles = new Vector<String>();// 定义动态数组表示表格标题
        Collections.addAll(titles, "姓名","学号","班级","联系","开始日期","结束日期","请假事由","请假状态");
        Vector<Vector> stuInfo = new PageController().getPaegData();//获取第一页的数据

//		使用静态数据创建DefaultTableModel数据模型
        model = new DefaultTableModel(stuInfo, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
            public Class getColumnClass(int column) {//获取列的类型
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };
        table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
        sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
        table.setAutoCreateRowSorter(true);;//设置表格自动排序

        scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示

        JButton btnPre = new JButton("上一页");
        btnPre.addActionListener(new ActionListener() {//上一页单击事件
            @Override
            public void actionPerformed(ActionEvent e) {
                model=new DefaultTableModel(new PageController().prePage(),titles);//设置数据模型中的数据为上一页内容
                table.setModel(model);//设置表格的数据模型

            }
        });
        btnPre.setBounds(44, 302, 95, 25);
        this.add(btnPre);

        JButton btnNext = new JButton("下一页");
        btnNext.addActionListener(new ActionListener() {//下一页单击事件
            @Override
            public void actionPerformed(ActionEvent e) {
                model=new DefaultTableModel(new PageController().nextPage(),titles);//设置数据模型中的数据为下一页内容
                table.setModel(model);//设置表格的数据模型
            }
        });
        btnNext.setBounds(149, 302, 95, 25);
        this.add(btnNext);

        JLabel lblMsg = new JLabel("每页显示：");
        lblMsg.setBounds(254, 307, 87, 15);
        this.add(lblMsg);

        JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20});
        comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
            public void itemStateChanged(ItemEvent e) {
                int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//获取下拉框所选的值
                PageController pcl=new PageController();
                pcl.setCountPerpage(pageSize);//设置每页显示记录条数
                model=new DefaultTableModel(pcl.getPaegData(),titles);//设置数据模型
                table.setModel(model);//设置表格数据模型
            }
        });
        comboBox.setSelectedIndex(1);//设置下拉框默认值
        comboBox.setBounds(318, 303, 55, 23);
        this.add(comboBox);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jt);
        this.setVisible(true);

        FileReader fr=null;
        //写入文件（输出流）
        //FileWriter fw=null;

        try {
//            //创建fir对象
//            fr = new FileReader("d:\\student1.txt");
//
//
//            int n=0;//实际读取的字符数
//            //读入到内存
//            char c[]=new char[10024];
//            while((n=fr.read(c))!=-1){
//                //System.out.println(c);
//                String s= new String(c,0,n);
//
//                jt.setText(s);
//            }


        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

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
            JOptionPane.showMessageDialog(null, "你已处于当前界面");
        }
    }
}



