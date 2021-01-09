package VO;

import Dao.PageController;
import Dao.Search;
import Qingjia.Set;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Collections;

import javax.swing.*;
import javax.swing.table.*;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;

/**
 *辅导员管理请假信息系统
 */
public class CounsellorLookRecord extends JFrame implements ActionListener{

    private TableRowSorter sorter;//定义排序器
    private Vector<String> titles;
    private DefaultTableModel model;// 定义表格数据模型

    JButton jb1=new JButton("审核请假信息");
    JButton jb2=new JButton("审核销假信息");
    JButton jb3=new JButton("学生请假记录");
    JButton jb4=new JButton("退出");
    JButton jb5=new JButton("查询");
    JTextField jt=new JTextField();
    JLabel jl=new JLabel("姓名");
    String[] columnNames={"姓名","学号","班级","联系","开始日期","结束日期","请假事由","请假状态"};//定义表格列名数
    String[][] tableValues=null;//{{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
            //{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
            //{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
            //{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""}};//定义表格数据数组

    JTable table=new JTable(tableValues,columnNames);//创建指定列名和数据的表格

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CounsellorLookRecord clr=new CounsellorLookRecord();
    }
    public CounsellorLookRecord(){
        this.setTitle("辅导员查看请假信息系统");
        this.setLocation(550,200);
        this.setSize(700,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        // 设置滚动面板
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


        //jb1.setBorder(null);
        jb1.setOpaque(false);
        jb1.setFont(new Font("微软雅黑",Font.PLAIN,18));
        //jb2.setBorder(null);
        jb2.setOpaque(false);
        jb2.setFont(new Font("微软雅黑",Font.PLAIN,18));
        //jb3.setBorder(null);
        jb3.setOpaque(false);
        jb3.setFont(new Font("微软雅黑",Font.PLAIN,18));
        //jb4.setBorder(null);
        jb4.setOpaque(false);
        jb4.setFont(new Font("微软雅黑",Font.PLAIN,18));
        //jb5.setBorder(null);
        jb5.setOpaque(false);
        jb5.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jl.setFont(new Font("微软雅黑",Font.PLAIN,18));
        //jl.setBorder(null);
        jl.setOpaque(false);
        scrollPane.setOpaque(false);

        jl.setFont(new Font("微软雅黑",Font.PLAIN,18));
        jb1.setBackground(new Color(233,240,247));
        jb2.setBackground(new Color(233,240,247));
        jb3.setBackground(new Color(233,240,247));
        jb4.setBackground(new Color(233,240,247));
        jb5.setBackground(new Color(233,240,247));
        jl.setBackground(new Color(233,240,247));
        scrollPane.setBackground(new Color(233,240,247));


        jb1.setBounds(5, 0, 233, 50);
        jb2.setBounds(236, 0, 223, 50);
        jb3.setBounds(457, 0, 223, 50);
        jb4.setBounds(457, 400, 223, 50);
        jb5.setBounds(5, 55, 123, 25);
        jl.setBounds(150, 55, 123, 25);
        jt.setBounds(220, 55, 123, 25);
        scrollPane.setBounds(5, 92, 675, 300);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);

        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jb5);
        this.add(jl);
        this.add(jt);
        this.add(scrollPane);
        this.setVisible(true);

    }

    public boolean isCellEditable(int rowlndex ,int columlndex){
        return false;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jb5)){
            Search s1=new Search();
            try {
//                s1.Find(jt.getText());
                Iterator<Vector> iter=s1.Find(jt.getText()).iterator();
                if(iter.hasNext()){
                    JOptionPane.showMessageDialog(null,"查询成功");
                    System.out.println(" 姓名 "+"    学号   "+"    班级   "+" 联系 "+"   开始日期 "+"  结束日期 "+"    请假事由 "+"  请假状态 ");
                    while (iter.hasNext()){
                        System.out.print(iter.next());
                        System.out.print("  ");
                    }
                    System.out.println();
                }
                else{
                    JOptionPane.showMessageDialog(null,"查无此人");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        // TODO Auto-generated method stub
        if(e.getSource().equals(jb4)){
            this.dispose();
        }

        if(e.getSource().equals(jb3)){
            JOptionPane.showMessageDialog(null, "你已处于当前界面");
        }
        if(e.getSource().equals(jb2)){
            JOptionPane.showMessageDialog(null, "对不起，该功能未开通");
        }
        if(e.getSource().equals(jb1)){
            //JOptionPane.showMessageDialog(null, "你已处于当前界面");
            try {
                Set s1=new Set();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            this.dispose();
        }

    }
}




