package dataexp;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;


public class tea_frame extends JFrame{

//	private JPanel jp1=new JPanel();  //子面板1，学生信息管理
	private JButton[] btoparray = new JButton[] {
			new JButton("查询"),new JButton("添加"),
			new JButton("删除"),new JButton("修改"),new JButton("返回")
	};
	private JLabel tfn1 = new JLabel("请输入教师教工号：");
	private JTextField tfid = new JTextField(10);
	
	public void init() {

	    /*setLayout(new FlowLayout());*/
	    setTitle("教师信息管理");
	    setSize(400, 180);
	    setLocationRelativeTo(null);

	}
	public void add1() {
		JPanel jp=new JPanel();
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		btoparray[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new tea_search(tfid.getText());
					tea_frame.this.dispose();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btoparray[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new tea_add(); 
					tea_frame.this.dispose();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btoparray[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new tea_del(); 
					tea_frame.this.dispose();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btoparray[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new tea_modi(); 
					tea_frame.this.dispose();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btoparray[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tea_frame.this.dispose();
		            new mainframe();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.setContentPane(jp);
		jp.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(2,2));
		jp2.setLayout(new FlowLayout());
		for(int i=0;i<btoparray.length;i++) {
			btoparray[i].setBounds(30, 30+40*i, 100, 30);
			jp1.add(btoparray[i]);
		}
		jp2.add(tfn1);jp2.add(tfid);
		jp.add(jp1,BorderLayout.CENTER);
		jp.add(jp2,BorderLayout.NORTH);
	}
	
	public tea_frame() {
		JPanel cp=(JPanel) getContentPane();
	    cp.setLayout(new FlowLayout());

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    init();
	    add1();
	    setVisible(true);
//		jp1.setBounds(10,10,240,240);
		
//		.setVisible(true);
	}
}


	
