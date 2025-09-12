package com.sist.client;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class PostFindForm extends JFrame{
    JTextField find; // 검색 창
    JButton search;  // 검색 버튼
    JButton cn;		 // 취소 버튼
    JTable table;	 // 우편번호 검색 자체 창
    DefaultTableModel model;
    JScrollPane js;	 // 스크롤 바
    
    public PostFindForm()
    {
    	setLocationRelativeTo(null);
    	find=new JTextField(13);
    	search=new JButton("검색");
    	cn=new JButton("취소");
    	String[] col={"우편번호","주소"};
    	String[][] row=new String[0][2];
    	model=new DefaultTableModel(row,col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
    		
    	};
    	table=new JTable(model);
    	js=new JScrollPane(table);
    	
    	JPanel p=new JPanel();
    	p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0)); 
    	p.add(find);p.add(search);p.add(cn);
    	
    	add("North",p);
    	add("Center",js);
    	setSize(450, 350);
    }
}