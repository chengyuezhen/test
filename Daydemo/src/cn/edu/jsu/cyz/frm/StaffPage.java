package cn.edu.jsu.cyz.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.cyz.dbc.DatabaseConnectionSql;
import cn.edu.jsu.cyz.vo.PageController1;

public class StaffPage  extends JFrame{

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;// �������
	private JTextField txtKey;//������ҹؼ����ı���
	private DefaultTableModel model;// �����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������   
	private Vector<String> titles;
	private Vector<Vector> stuInfo;
	private JPanel panel;
	private JLabel label;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_4;
	private JButton btnNewButton_3;
	private JButton btnNewButton_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffPage window = new StaffPage();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
	}

	/**
	 * Create the frame.
	 */
	
	public StaffPage() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
        table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ��������
		sorter = new TableRowSorter<DefaultTableModel>(model);//����������
		table.setAutoCreateRowSorter(true);;//���ñ����Զ�����
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		label = new JLabel("������ؼ���");
		label.setFont(new Font("����", Font.BOLD, 15));
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10); 
		
		btnNewButton = new JButton("����");
		btnNewButton.setFont(new Font("����", Font.BOLD, 15)); 
		String sql1="select * from staff";
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=textField .getText().trim();//��ȡ����ؼ����ı����ֵ
				if(key.length()!=0) {
					String sql="select * from staff where JobNumber="+key;
					model=new DefaultTableModel(new PageController1().Find(sql),titles);//��������ģ��
					table.setModel(model);
				//sorter.setRowFilter(RowFilter.regexFilter(key));//�Ƿ����������ֵ		 											
				}else {
					model=new DefaultTableModel(new PageController1().getSelectAll(sql1),titles);//��������ģ��
					table.setModel(model);
				}
			}
		});
		panel.add(btnNewButton);
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER); 
		scrollPane.setViewportView(table); 
		
		// ʹ�ö�̬�������ݣ��б����������ݣ�
		titles = new Vector<String>();// ���嶯̬�����ʾ�������
		Collections.addAll(titles, "Ա�����", "����","�Ա�", "����","���ű��","��������","���ʱ��","���ʷ������");
		 stuInfo = new PageController1().getPaegData();//��ȡ��һҳ������
		 
//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(stuInfo, titles) {// ʹ��Vectorװ�ر�������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {//��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass(); 
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};

		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("��һҳ"); 
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 15)); 
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController1().prePage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ��������ģ��
				
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("��һҳ");
		btnNewButton_2.setFont(new Font("����", Font.BOLD, 15)); 
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController1().nextPage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ��������ģ��
				
			}
		});
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("ÿҳ��ʾ��");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 15)); 
		panel_1.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20});
		comboBox.addItemListener(new ItemListener() {//ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//��ȡ��������ѡ��ֵ
				PageController1 pcl=new PageController1();
				pcl.setCountPerpage(pageSize);//����ÿҳ��ʾ��¼���� 
				model=new DefaultTableModel(pcl.getPaegData(),titles);//��������ģ�� 
				table.setModel(model);//���ñ�������ģ��
			}
		}); 
		comboBox.setSelectedIndex(1);//����������Ĭ��ֵ
		panel_1.add(comboBox);
		
		btnNewButton_4 = new JButton("���ز˵�");
		btnNewButton_4.setFont(new Font("����", Font.BOLD, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectPage().main(null);
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton_4);
		
		btnNewButton_3 = new JButton("ɾ��");
		btnNewButton_3.setFont(new Font("����", Font.BOLD, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=textField.getText();
				String sql="select * from staff where JobNumber= "+str;
				String str1="select * from staff ";
				if(find(sql)) {
					DatabaseConnectionSql db=new DatabaseConnectionSql();
					try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
						ResultSet rs=stm.executeQuery(sql); 
						if(rs.next()) {
						int wageid=rs.getInt(7);
						String sql1="delete from staff where JobNumber="+str;
						String sql2="delete from Wage where WageId="+wageid;
						modify1(sql1);
						modify2(sql2);
						model=new DefaultTableModel(new PageController1().getSelectAll(str1),titles);
						table.setModel(model);
					}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block 
						e1.printStackTrace(); 
					}   
				}else {
					
				}
			}
		});
		panel.add(btnNewButton_3);
		
		btnNewButton_5 = new JButton("�޸�");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyPage().main(null);
				setVisible(false);
			}
		});
		btnNewButton_5.setFont(new Font("����", Font.BOLD, 15));
		panel.add(btnNewButton_5);
		
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
	
	public static void modify1(String sql) {
		DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();)  {
			stm.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Ա����ɾ���ɹ�");
		} catch (SQLException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void modify2(String sql) {
		DatabaseConnectionSql db=new DatabaseConnectionSql();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();)  {
			stm.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "���ʱ�ɾ���ɹ�");
		} catch (SQLException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

