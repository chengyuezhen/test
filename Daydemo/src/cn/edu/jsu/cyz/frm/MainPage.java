package cn.edu.jsu.cyz.frm;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.cyz.dbc.DatabaseConnectionSql;

import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;

public class MainPage{
	private static JTextField textField;
	private static JPasswordField passwordField;
	private JPanel contentPane;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JFrame frame;
	public static void main(String[] ages) {
//		MainPage a=new MainPage();
//		a.setLocationRelativeTo(null);// 窗体居中
//		a.setVisible(true);// 窗体可见 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage(); 
					window.frame.setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainPage() {
		initialize();
	}
	
	private void initialize() {
		// TODO Auto-generated constructor stub\
		frame=new JFrame("主界面");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭按钮
		frame.setBounds(100, 100, 550, 403);// 设置窗体位置与大小
		frame.getContentPane().setLayout(null);
		
//		Icon img=new ImageIcon("/image/background.jpg");
//		JLabel jp=new JLabel(img);
//		jp.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
//		contentPane.add(jp);
		
		JLabel lblNewLabel = new JLabel("\u8D26   \u53F7"); 
		lblNewLabel.setBounds(71, 100, 72, 25);
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6   \u7801");
		lblNewLabel_1.setBounds(71, 191, 72, 18);
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(176, 100, 154, 24); 
		frame.getContentPane().add(textField);
		textField.setColumns(10); 
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 188, 154, 24);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("登录"); 
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
				String username=textField.getText();
				String password=passwordField.getText();
				login(username,password);
				textField.setText(null);        
				passwordField.setText(null);
				new SelectPage().main(null);
				frame.dispose();
				}
  		  }
		});
		btnNewButton.setBounds(60, 258, 113, 27); 
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new RegisterPage().main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(333, 258, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("欢  迎  使 用  员  工 工  资  管  理  系  统");
		lblNewLabel_2.setBounds(47, 13, 467, 51);
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_2);
		
		 lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(360, 100, 118, 25);
		lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.RED);
		frame.getContentPane().add(lblNewLabel_3);
		
		 lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(360, 188, 118, 24);
		lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_4.setForeground(Color.RED);
		frame.getContentPane().add(lblNewLabel_4); 
		  
	}
	
        public static void login(String username,String password) {
		DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			String sql="select * from administrators where Username="+username+"and Password="+password;
			ResultSet rs=stm.executeQuery(sql); 
			if(rs.next()) { 
				JOptionPane.showMessageDialog(null, "欢迎回来，管理员"+rs.getInt(1));
				String str="管理员"+rs.getInt(1);
				In(str);
			}else {
				JOptionPane.showMessageDialog(null, "账号或密码错误");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	  
	public boolean checkInput() {
		  if(textField.getText().length()==0) {//获取成绩输入框的内容长度
			  lblNewLabel_3.setText("账号不能为空");//设置警告信息
			  textField.requestFocus();//成绩输入框获取焦点 
		    return false;
		  }else if(!textField.getText().matches("\\d+")) {//正则匹配整数
			  lblNewLabel_3.setText("账号必须是整数"); 
			  textField.requestFocus();//成绩输入框获取焦点
			  textField.selectAll();//全选当中的内容
		    return false;
		  } lblNewLabel_3.setText(""); 
		  
		  if(passwordField.getText().length()==0) { 
			  lblNewLabel_4.setText("密码不能为空"); 
			  passwordField.requestFocus();
			  return false; 
		  }lblNewLabel_4.setText("");
		  return true;  
     }
    
	public static void In(String str) throws IOException {
		File file =new File("D:"+File.separator+"passage"+File.separator+"a.txt");
		FileOutputStream fo =new FileOutputStream(file,true);
		SimpleDateFormat ds= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ans=str+"于"+ds.format(new Date())+"成功登陆\r\n";
		fo.write(ans.getBytes());
		fo.close();
	}
}
