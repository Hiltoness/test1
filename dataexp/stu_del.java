package dataexp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class stu_del extends JFrame{
	private JButton[] btn = new JButton[] {
			new JButton("确认删除"),new JButton("返回")
	};
	private JLabel tfn1 = new JLabel("请输入学生学号：");
	private JTextField tfid = new JTextField(10);
	
	public void init() {

	    /*setLayout(new FlowLayout());*/
	    setTitle("学生信息删除");
	    setSize(400, 180);
	    setLocationRelativeTo(null);

	}
	public void add1() {
		JPanel jp=new JPanel();
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		btn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					del_info(tfid.getText());
				    int x=JOptionPane.showConfirmDialog(stu_del.this, "删除成功","系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
				    if(x==JOptionPane.OK_OPTION){
				    	fh();

	                }
				}catch(Exception e1) {
	                // TODO Auto-generated catch block
	                e1.printStackTrace();
					JOptionPane.showConfirmDialog(stu_del.this, "删除失败，请重新操作", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		            stu_del.this.dispose();
		            new stu_del();
				}
			}
		});
		btn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fh();
			}
			
		});
		
		this.setContentPane(jp);
		jp.setLayout(new BorderLayout());
		jp1.setLayout(new FlowLayout());
		jp2.setLayout(new GridLayout(2,2));
		for(int i=0;i<btn.length;i++) {
			btn[i].setBounds(30, 30+40*i, 100, 30);
			jp2.add(btn[i]);
		}
		jp1.add(tfn1);jp1.add(tfid);
		jp.add(jp1,BorderLayout.CENTER);
		jp.add(jp2,BorderLayout.SOUTH);
	}
	
	public stu_del() {
		JPanel cp=(JPanel) getContentPane();
	    cp.setLayout(new FlowLayout());

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    init();
	    add1();
	    setVisible(true);
	}

	public void del_info(String id) {
		Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=dbconn.getConn();
            String sql="delete from s where sno=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, id);
            int a = ps.executeUpdate();
            if(a>0) {
            	String sql2="delete from sc where sno=?";
            	ps=con.prepareStatement(sql2);
                ps.setString(1, id);
                int b=ps.executeUpdate();
            }
            else {
            	
            }
        } catch (Exception e) {
        	// TODO Auto-generated catch block
            e.printStackTrace();
	}
	
	}
public void fh(){
	stu_del.this.dispose();
	new stu_frame();
}
}
