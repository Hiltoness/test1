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
import javax.swing.JTextField;

public class mainframe extends JFrame implements ActionListener{
	private JPanel jp=new JPanel();   //母面板，容器面板
	
	private JPanel coursejp=new JPanel();
	private JButton[] btnarray = new JButton[] {
			new JButton("学生信息管理"),new JButton("教师信息管理"),
			new JButton("课程信息管理"),new JButton("退出系统")
	};
	public mainframe() {
		//////////
		//母面板
		this.setLayout(null);
		for(int i=0;i<btnarray.length;i++) {
			btnarray[i].setBounds(30, 30+40*i, 100, 30);
			this.add(btnarray[i]);
			btnarray[i].addActionListener(this);
		}
		jp.setBounds(10,10,240,240);
//		jp.add(jp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("学生选课管理系统--管理员");
		this.setBounds(100,100,400,300);
		this.setVisible(true);
		}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnarray[0]) {
			mainframe.this.dispose();
            new stu_frame();
		}else if(e.getSource()==btnarray[1]) {
			mainframe.this.dispose();
			new tea_frame();
		}else if(e.getSource()==btnarray[2]) {
			mainframe.this.dispose();
			new cou_frame();
		}else if(e.getSource()==btnarray[3]) {
			mainframe.this.dispose();
			System.exit(0);
		}
		
		}
}
