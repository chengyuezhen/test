package cn.edu.jsu.cyz.frm;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.cyz.dbc.DatabaseConnectionSql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RegisterPage extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private String str =null;
	private JFrame frame;
	private JButton btnNewButton_1;
	
	public static void main(String[] ages) {
//		MainPage a=new MainPage();
//		a.setLocationRelativeTo(null);// 窗体居中 
//		a.setVisible(true);// 窗体可见
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage window = new RegisterPage();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null); 
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}
		});
	}

	public RegisterPage() { 
		while(true) {  
			 str = getUsername();
			DatabaseConnectionSql db=new DatabaseConnectionSql();
			try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
				String sql="select * from administrators where Username="+str; 
				ResultSet rs=stm.executeQuery(sql);
				if(!rs.next()) {
					break;
				} 
			} catch (SQLException e1) { 
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		initialize();
	}
	
	private void initialize() {
		// TODO Auto-generated constructor stub 
		frame =new JFrame("注册");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭按钮
		frame.setBounds(100, 100, 550, 403);// 设置窗体位置与大小
	    frame.getContentPane().setLayout(null);
		 
		JLabel lblNewLabel = new JLabel("\u8D26  \u53F7");
		lblNewLabel.setBounds(57, 65, 88, 34); 
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField(); 
		textField.setBounds(139, 70, 142, 24);  
		frame.getContentPane().add(textField);
		textField.setText(str); 
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("    账号为主动生成，切勿修改");
		lblNewLabel_1.setBounds(282, 69, 250, 26);
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.RED);
		frame.getContentPane().add(lblNewLabel_1);
	
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801");
		lblNewLabel_2.setBounds(57, 148, 72, 18);
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u91CD\u65B0\u8F93\u5165\u5BC6\u7801");
		lblNewLabel_3.setBounds(41, 212, 98, 18);
		lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 145, 142, 24);
		frame.getContentPane().add(passwordField); 
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(139, 209, 142, 24);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_4 = new JLabel("        员  工  工  资  管  理  系  统");
		lblNewLabel_4.setBounds(28, 13, 490, 39);
		lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					DatabaseConnectionSql db=new DatabaseConnectionSql();
					try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
						String sql="INSERT INTO administrators(Username,Password) VALUES('" + textField.getText() + "','" + passwordField.getText()+"')";
						stm.executeUpdate(sql);
						JOptionPane.showMessageDialog(null,"注册成功");
						new MainPage().main(null);
						frame.dispose(); 
					} catch (SQLException e1) {
						// TODO Auto-generated catch block 
						e1.printStackTrace();
					}   
				}
			} 
		});
		btnNewButton.setBounds(57, 280, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		 lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(312, 148, 177, 18); 
		lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_5);
		
		 lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(323, 215, 166, 18);
		lblNewLabel_6.setFont(new Font("楷体", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_6);
		
		btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainPage().main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 15));
		btnNewButton_1.setBounds(313, 280, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	public boolean checkInput() {
		  if(passwordField.getText().length()==0) {//获取成绩输入框的内容长度
			  lblNewLabel_5.setText("密码不能为空");//设置警告信息
			  passwordField.requestFocus();//成绩输入框获取焦点
		    return false;
		  } lblNewLabel_5.setText("");
		  
		  if(!passwordField.getText().equals(passwordField_1.getText())) {
			  lblNewLabel_6.setText("两次密码不一致");
			  passwordField_1.requestFocus();
			  passwordField_1.selectAll();
			  return false; 
		  }lblNewLabel_6.setText("");
		  return true;  
   }
	public  static String getUsername() {
		String base = "0123456789"; 
		int size = base.length();
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=5;i++){
			//产生0到size-1的随机值
			int index = r.nextInt(size);
			//在base字符串中获取下标为index的字符
			if(i==1&&index==0) {
				continue;
			}
			char c = base.charAt(index);
			//将c放入到StringBuffer中去
			sb.append(c);
		}
		return sb.toString();
	}
	
}
