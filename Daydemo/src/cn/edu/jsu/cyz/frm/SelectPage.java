package cn.edu.jsu.cyz.frm;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectPage window = new SelectPage();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectPage() { 
		initialize();
	}

	/** 
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 524, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("��  ӭ  ʹ  ��  ");
		lblNewLabel.setBounds(159, 28, 205, 64);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("ְԱ��Ϣ����");
		mnNewMenu.setFont(new Font("����", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("����ְԱ��Ϣ");
		mntmNewMenuItem.setFont(new Font("����", Font.BOLD, 18));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddPage().main(null);
				frame.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("�޸�ְԱ��Ϣ");
		mntmNewMenuItem_1.setFont(new Font("����", Font.BOLD, 18));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyPage().main(null);
				frame.dispose();
			}
		}); 
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("ɾ��ְԱ��Ϣ");
		mntmNewMenuItem_2.setFont(new Font("����", Font.BOLD, 18));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StaffPage().main(null);
				frame.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("��ѯְԱ��Ϣ");
		mntmNewMenuItem_3.setFont(new Font("����", Font.BOLD, 18)); 
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StaffPage().main(null);
				frame.dispose();
			} 
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("ְԱ���ʹ���");
		mnNewMenu_1.setFont(new Font("����", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("��ѯְԱ����");
		mntmNewMenuItem_4.setFont(new Font("����", Font.BOLD, 18)); 
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListPage().main(null);
				frame.dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("�޸�Ա������");
		mntmNewMenuItem_5.setFont(new Font("����", Font.BOLD, 18));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WagePage().main(null);
				frame.dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
	}
}