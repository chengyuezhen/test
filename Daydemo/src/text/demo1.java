package text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JOptionPane;

import cn.edu.jsu.cyz.dbc.DatabaseConnectionSql;
import cn.edu.jsu.cyz.frm.SelectPage;

public class demo1 {
   public static void main(String[] args) {
	   String username;
	   String password;
	   for(int i=1;i<=10000;i++) {
		 while(true) { 
			username=getUsername();
			password=getPassword();
			 String sql="select * from administrators1 where Username="+username;
			if(check(sql)) {
				break;
			}
		 }
		 String sql1="insert into administrators1(Username,Password) values('"+username+"','"+password+"')";
		 input(sql1);
	   }
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
   
   public  static String getPassword() {
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
   
   public static boolean check(String sql) {
	   DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			ResultSet rs=stm.executeQuery(sql); 
			if(!rs.next()) { 
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();  
		}   
		return false;
   }
   
   public static void input(String sql) {
		DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			stm.executeUpdate(sql);//执行数据库插入操作
		} catch (SQLException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
