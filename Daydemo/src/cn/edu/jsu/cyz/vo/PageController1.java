package cn.edu.jsu.cyz.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.jsu.cyz.dbc.DatabaseConnectionSql;

public class PageController1 {
	private static Vector<Vector> bigList ; // �󼯺ϣ�������ȡ����
	private Vector<Vector> smallList = new Vector<Vector>(); // С���ϣ����ظ�����������
	private static int curentPageIndex = 1; // ��ǰҳ��
	private static int  countPerpage = 5; // ÿҳ��ʾ���� 
	private int pageCount; // ��ҳ��
	private int recordCount; // �ܼ�¼����
	{// ��ʼ�������
		if(PageController1.bigList==null) {
			PageController1.bigList=getSelectAll("select * from staff");// ���ò�ѯ���ݿ�ķ������������е���
		}
		//��ȡ��ҳ��
		if(bigList.size()%countPerpage==0) {
			pageCount=bigList.size()/countPerpage;
		}else { 
			pageCount=bigList.size()/countPerpage+1;
		} 
	}
	public PageController1() {}//�޲ι��췽��

	public PageController1(int curentPageIndex) {//���췽�����õ�ǰҳ
		this.curentPageIndex = curentPageIndex;
	} 
	public void setCountPerpage(int countPerpage) {//����ÿҳ��ʾ�ļ�¼�� 
		this.countPerpage = countPerpage;
	}
	public Vector<Vector> getPaegData() {// ���ݵ�ǰҳ����ɸѡ��¼
		recordCount = bigList.size();//�����¼��Ϊ���ݿ��б�����������
		for (int i = (curentPageIndex - 1) * countPerpage; i < curentPageIndex * countPerpage && i < recordCount; i++) {//ȡ�õ�ǰҳ���ļ�¼��curentPageIndex��ǰҳ����countPerpageÿҳ��ʾ�ļ�¼��
			smallList.add(bigList.get(i));//����¼���뵽С������
		}
		return smallList;//����С���ϣ���ǰҳ�����ݣ�
	}
	public Vector<Vector> nextPage(){//��һҳ
		if(curentPageIndex<pageCount) { 
			curentPageIndex++;
		}else {  
			curentPageIndex=1;
		}
		return getPaegData();//������һҳ������
	}
	public Vector<Vector> prePage(){//��һҳ
		if(curentPageIndex>1) {
			curentPageIndex--;
		}else {
			curentPageIndex=pageCount; 
		}
		return getPaegData();//������һҳ������
	}
	
	
	public static Vector<Vector> Find(String sql){
		Vector<Vector> rows=new Vector<Vector>();
		DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			ResultSet rs=stm.executeQuery(sql); 
			while(rs.next()) { 
				Vector row=new Vector();//���������� 
    			row.add(rs.getString(1));//��ȡ��һ���ֶ�ѧ��
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ����� 
    			row.add(rs.getString(3));
    			row.add(rs.getInt(4)); 
    			row.add(rs.getString(5));
    			row.add(rs.getString(6));  
    			row.add(rs.getInt(7)); 
    			row.add(rs.getInt(8));
    			rows.add(row);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block 
			e1.printStackTrace();
		}  
		return rows;
	}
	
	
	 public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ���� 
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�� 
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
	    			Vector row=new Vector();//���������� 
	    			row.add(rs.getString(1));//��ȡ��һ���ֶ�ѧ��
	    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ����� 
	    			row.add(rs.getString(3));
	    			row.add(rs.getInt(4)); 
	    			row.add(rs.getString(5));//��ȡ�������ֶγɼ�
	    			row.add(rs.getString(6));
	    			row.add(rs.getInt(7));
	    			row.add(rs.getInt(8));
	    			rows.add(row);//�����������ӵ���¼������
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//��������������
	    }
	}