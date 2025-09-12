package com.sist.client;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import lombok.Getter;
@Getter
public class MemberManagerForm extends JPanel{
	
	DefaultTableModel membermodel; // 회원목록 테이블 
	JButton check,exit,delete,ban,insert; // 확인 , 취소버튼
	JScrollPane js;
	JTable membertable;
	JComboBox<String> tag=new JComboBox<String>();
	JTextField search;
	TableColumn column;
	public MemberManagerForm()
	{
		String[] col = {"회원번호","아이디","비밀번호","이름",
				"닉네임","성별","우편번호","주소",
				"상세주소","전화번호","정지기간","선택"};
		String[][] row = new String[0][col.length];
		membermodel=new DefaultTableModel(row,col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return column !=0 && column !=10;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				if(columnIndex == 11) return Boolean.class;
				return String.class;
			}
			
			
		};
		search = new JTextField();
		tag.addItem("아이디");
		tag.addItem("닉네임");
		tag.addItem("이름");
		tag.setBounds(920,20,100,35);
		search.setBounds(1020, 20, 200, 35);
		add(tag);
		add(search);
		membertable=new JTable(membermodel);	
		js=new JScrollPane(membertable);
		setLayout(null); 
		js.setBounds(20, 60, 1200, 480);
		add(js);
		ban=new JButton("정지");
		check=new JButton("저장");
		exit=new JButton("취소");
		delete=new JButton("삭제");
		insert=new JButton("추가");
		membertable.getTableHeader().setReorderingAllowed(false);
		membertable.setRowHeight(40);
		check.setBounds(780, 560, 80, 40);
		add(check);
		insert.setBounds(870, 560, 80, 40);
		add(insert);
		ban.setBounds(960, 560, 80, 40);
		add(ban);
		delete.setBounds(1050, 560, 80, 40);
		add(delete);
		exit.setBounds(1140, 560, 80, 40);
		add(exit);
		for(int i=0;i<col.length;i++)
		{
			DefaultTableCellRenderer rand=new DefaultTableCellRenderer();
			column=membertable.getColumnModel().getColumn(i);
			if(i==0) // 회원번호
			{ 
				column.setPreferredWidth(60);
				rand.setHorizontalAlignment(JLabel.CENTER);
				column.setCellRenderer(rand);
			}
			else if(i==1) // 아이디
			{
				column.setPreferredWidth(90);
				rand.setHorizontalAlignment(JLabel.CENTER);
				column.setCellRenderer(rand);
			}
			else if(i==2) // 비밀번호
			{
				column.setPreferredWidth(90);
				rand.setHorizontalAlignment(JLabel.CENTER);
				column.setCellRenderer(rand);
			}
			else if(i==3) // 이름
			{
				column.setPreferredWidth(70);
				rand.setHorizontalAlignment(JLabel.CENTER);
				column.setCellRenderer(rand);
			}
			else if(i==4) // 닉네임
			{
				column.setPreferredWidth(90);
				rand.setHorizontalAlignment(JLabel.CENTER);
				column.setCellRenderer(rand);
			}
			else if(i==5) // 성별
			{
				column.setPreferredWidth(50);
				rand.setHorizontalAlignment(JLabel.CENTER);
				column.setCellRenderer(rand);
			}
			else if(i==6) // 우편번호
			{
				column.setPreferredWidth(100);
				rand.setHorizontalAlignment(JLabel.CENTER);
				column.setCellRenderer(rand);
			}
			else if(i==7) // 주소
			{
				column.setPreferredWidth(190);
				rand.setHorizontalAlignment(JLabel.CENTER);
				column.setCellRenderer(rand);
			}
			else if(i==8) // 상세주소
			{
				column.setPreferredWidth(230);
				rand.setHorizontalAlignment(JLabel.CENTER);
				column.setCellRenderer(rand);
			}
			else if(i==9) // 전화번호
			{
				column.setPreferredWidth(100);
				rand.setHorizontalAlignment(JLabel.CENTER);
				column.setCellRenderer(rand);
			}
			else if(i==10) // 밴기간
			{
				column.setPreferredWidth(100);
				rand.setHorizontalAlignment(JLabel.CENTER);
				column.setCellRenderer(rand);
			}
			else if(i==11) // 선택
			{
				column.setPreferredWidth(30);
				column.setCellRenderer(membertable.getDefaultRenderer(Boolean.class));
			}
			
			
			
		}
		
	}
	
}
