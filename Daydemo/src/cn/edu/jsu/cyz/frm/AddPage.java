package cn.edu.jsu.cyz.frm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import cn.edu.jsu.cyz.dbc.DatabaseConnectionSql;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPage window = new AddPage();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) { 
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddPage() {
		initialize();
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 534, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  增加职员信息");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(151, 13, 268, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("职员编号");
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_1.setBounds(14, 83, 72, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(86, 84, 107, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("职员姓名");
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_2.setBounds(285, 87, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(358, 84, 107, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("   性别");
		lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_3.setBounds(14, 168, 72, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 165, 107, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("   年龄");
		lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_4.setBounds(285, 168, 72, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(358, 165, 107, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("部门编号");
		lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_5.setBounds(14, 249, 72, 18);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(86, 246, 107, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("部门名称");
		lblNewLabel_6.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_6.setBounds(285, 249, 72, 18);
		frame.getContentPane().add(lblNewLabel_6); 
		
		textField_5 = new JTextField();
		textField_5.setBounds(358, 246, 107, 24);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("工资编号");
		lblNewLabel_7.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_7.setBounds(14, 328, 72, 18);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(86, 325, 107, 24);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		 
		JLabel lblNewLabel_8 = new JLabel("工资发放情况");
		lblNewLabel_8.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_8.setBounds(250, 328, 107, 18);
		frame.getContentPane().add(lblNewLabel_8); 
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(14, 121, 243, 18);
		lblNewLabel_9.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_9.setForeground(Color.RED);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(14, 359, 243, 18);
		lblNewLabel_10.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_10.setForeground(Color.RED);
		frame.getContentPane().add(lblNewLabel_10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(358, 325, 107, 24);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 15)); 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql="select * from staff where JobNumber="+textField.getText(); 
				String sql2="select * from Wage where WageId="+textField_6.getText();
				if(find(sql)&&find1(sql2)) {
	String sql1="INSERT INTO staff(JobNumber,Name,Sex,Age,DepartmentNumber,DepartmentName,WageId,Distribution) VALUES('" + textField.getText() + "','" + textField_1.getText() + "','" + textField_2.getText() + "','" + textField_3.getText() + "','" + textField_4.getText() + "','" + textField_5.getText() + "','" + textField_6.getText() + "','" + textField_7.getText() + "')";
	             input(sql1);
	             String str="INSERT INTO Wage (WageId,Name) VALUES('" + textField_6.getText() + "','" + textField_1.getText() + "')";
	             input1(str);
	             textField.setText("");
	             textField_1.setText("");
	             textField_2.setText("");
	             textField_3.setText("");
	             textField_4.setText("");
	             textField_5.setText("");
	             textField_6.setText("");
	             textField_7.setText("");
	             lblNewLabel_9.setText("");
	             lblNewLabel_10.setText("");
	             new SelectPage().main(null);
	             frame.dispose();
			}else {
				if(!find(sql)) {
				lblNewLabel_9.setText("该职员编号已经存在，请重新输入");
				textField.requestFocus();
				textField.selectAll();
			  }
		   if(!find1(sql2)) {
			   lblNewLabel_10.setText("该工资编号已经存在，请重新输入");
			   textField_6.requestFocus();
			   textField_6.selectAll();
			   lblNewLabel_9.setText("");
		   }
			} 
		}
		});
		btnNewButton.setBounds(62, 401, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 15)); 
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectPage().main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 15)); 
		btnNewButton_1.setBounds(326, 401, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		 
		
	}
	
	public static boolean find(String sql) {
		DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();)  {
			ResultSet rs=stm.executeQuery(sql);
               if(!rs.next()) {
            	   return true;
               }
		} catch (SQLException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	
	public static boolean find1(String sql) {
		DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();)  {
			ResultSet rs=stm.executeQuery(sql);
               if(!rs.next()) {
            	   return true;
               }
		} catch (SQLException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	} 
	
	public static void input(String sql) {
		DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			stm.executeUpdate(sql);//执行数据库插入操作
			JOptionPane.showMessageDialog(null, "添加成功");
			
		} catch (SQLException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void input1(String sql) {
		DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			stm.executeUpdate(sql);//执行数据库插入操作
		} catch (SQLException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
