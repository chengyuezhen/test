package cn.edu.jsu.cyz.vo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class Test extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;// 定义表格
	private JTextField txtKey;//定义查找关键字文本框
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则   
	private Vector<String> titles;
	private Vector<Vector> stuInfo;
	private JPanel panel;
	private JLabel label;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
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
	
	public Test() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
        table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
		table.setAutoCreateRowSorter(true);;//设置表格自动排序
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		label = new JLabel("\u8BF7\u8F93\u5165\u5173\u952E\u5B57");
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("查找");
		String sql1="select * from Wage";
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=textField .getText().trim();//获取输入关键字文本框的值
				System.out.println(key);
				if(key.length()!=0) {
					String sql="select * from Wage where WageId="+key;
					model=new DefaultTableModel(new PageController().Find(sql),titles);//设置数据模型
					table.setModel(model);
				//sorter.setRowFilter(RowFilter.regexFilter(key));//是否包含输入框的值													
				}else {
					model=new DefaultTableModel(new PageController().getSelectAll(sql1),titles);//设置数据模型
					table.setModel(model);
				}
			} 
		});
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		
		// 使用动态数组数据（列标题与行数据）
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "工资编号", "姓名", "基础工资","出勤","加班","五险一金","总额"); 
		 stuInfo = new PageController().getPaegData();//获取第一页的数据
		
//		使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(stuInfo, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {//获取列的类型
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
		
		JButton btnNewButton_1 = new JButton("上一页");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().prePage(),titles);//设置数据模型中的数据为上一页内容
				table.setModel(model);//设置表格的数据模型
				
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("下一页");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().nextPage(),titles);//设置数据模型中的数据为下一页内容
				table.setModel(model);//设置表格的数据模型
				
			}
		});
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("每页显示：");
		panel_1.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20});
		comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//获取下拉框所选的值
				PageController pcl=new PageController();
				pcl.setCountPerpage(pageSize);//设置每页显示记录条数
				model=new DefaultTableModel(pcl.getPaegData(),titles);//设置数据模型 
				table.setModel(model);//设置表格数据模型
			}
		}); 
		comboBox.setSelectedIndex(1);//设置下拉框默认值
		panel_1.add(comboBox);
		
		btnNewButton_3 = new JButton("删除");
		panel_1.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("返回菜单");
		panel_1.add(btnNewButton_4);
	}
}
