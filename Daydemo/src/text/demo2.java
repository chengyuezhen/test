package text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.jsu.cyz.dbc.DatabaseConnectionSql;

public class demo2 {
  public static void main(String[] agrs) {
	  DatabaseConnectionSql db=new DatabaseConnectionSql();
	  String sql="insert into administrators1(Username,Password) values('1234','1234')";
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
            stm.executeUpdate(sql); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();  
		}   
  }
}
