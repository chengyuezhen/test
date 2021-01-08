package cn.edu.jsu.cyz.frm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.edu.jsu.cyz.dbc.DatabaseConnectionSql;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class WagePage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WagePage window = new WagePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WagePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(14, 112, 253, 18);
		lblNewLabel_7.setFont(new Font("楷体", Font.BOLD, 18));
		lblNewLabel_7.setForeground(Color.RED);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("  修  改  员  工  工  资");
		lblNewLabel.setBounds(129, 13, 345, 27);
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.RED);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("工资编号");
		lblNewLabel_1.setBounds(32, 75, 72, 18);
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(103, 72, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("查询"); 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select *from Wage where WageId="+textField.getText();
				if(find(sql)) {
					DatabaseConnectionSql db=new DatabaseConnectionSql();
					try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
						ResultSet rs=stm.executeQuery(sql); 
						if(rs.next()) {
						textField.setText(rs.getString(1));
						textField_1.setText(rs.getString(2));
						textField_2.setText(""+rs.getInt(3));
						textField_3.setText(""+rs.getInt(4));
						textField_4.setText(""+rs.getInt(5));
						textField_5.setText(""+rs.getInt(6));
						lblNewLabel_7.setText("");
					}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block 
						e1.printStackTrace(); 
					}   
				}else {
					 lblNewLabel_7.setText("该编号不存在，请重新输入");
				}
			}
		});
		btnNewButton.setBounds(195, 71, 72, 27);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("姓名");
		lblNewLabel_2.setBounds(319, 75, 72, 18);
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(369, 74, 105, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("基础工资");
		lblNewLabel_3.setBounds(32, 160, 72, 18);
		lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(103, 157, 86, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("出勤");
		lblNewLabel_4.setBounds(319, 160, 72, 18);
		lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(369, 157, 105, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("   加班");
		lblNewLabel_5.setBounds(32, 244, 72, 18);
		lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(103, 241, 86, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("五险一金");
		lblNewLabel_6.setBounds(305, 244, 72, 18);
		lblNewLabel_6.setFont(new Font("楷体", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(369, 241, 105, 24);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("确定");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans=Integer.parseInt(textField_2.getText())+Integer.parseInt(textField_3.getText())+Integer.parseInt(textField_4.getText())-Integer.parseInt(textField_5.getText());
				String sql="update Wage set Name='"+textField_1.getText()+"',BasicWage='"+textField_2.getText()+"',Attendance='"+textField_3.getText()+"',WorkOvertime='"+textField_4.getText()+"',FIAOF='"+textField_5.getText()+"',Total="+ans+" where WageId='"+textField.getText()+"'";
			   modify(sql);
			   textField.setText("");
			   textField_1.setText("");
			   textField_2.setText("");
			   textField_3.setText("");
			   textField_4.setText("");
			   textField_5.setText("");
			}
		});														
		btnNewButton_1.setBounds(76, 350, 113, 27);
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 18));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectPage().main(null);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(319, 350, 113, 27);
		btnNewButton_2.setFont(new Font("楷体", Font.BOLD, 18));
		frame.getContentPane().add(btnNewButton_2);
		
		
	}
	
	public static boolean find(String sql) {
		DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			ResultSet rs=stm.executeQuery(sql); 
			if(rs.next()) { 
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}   
		return false;
	}
	
	public void modify(String sql) {
		DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();)  {
			stm.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "修改成功");
			new SelectPage().main(null);
			frame.dispose();
		} catch (SQLException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
