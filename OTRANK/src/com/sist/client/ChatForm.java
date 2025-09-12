package com.sist.client;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

public class ChatForm extends JPanel {
	JButton info,post;
	JTextArea textArea;
	JTextField chatField;
	JTable userList, roomList;
	DefaultTableModel ULmodel,RLModel;
	JTextPane pane;
	
	public ChatForm()
	{
		info=new JButton();
		post=new JButton();
		textArea=new JTextArea();
		chatField=new JTextField();
		
		String[] ulmd= {"아이디","이름","성별"};
		String[][] rlmd= new String[0][3];
		
		ULmodel=new DefaultTableModel(rlmd,ulmd) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		userList=new JTable(ULmodel);
		JScrollPane js1=new JScrollPane(userList);
		setLayout(null);
		textArea.setBounds(30, 140, 600, 400);
		add(textArea);
		js1.setBounds(650, 150, 570, 400);
		add(js1);
//		post.setBounds(770, 560, 150, 30);
//		info.setBounds(960, 560, 150, 30);

		chatField.setBounds(30, 560, 600, 30);
		chatField.setBounds(30, 660, 600, 30);
		chatField.setBounds(30, 660, 600, 30);
		add(chatField);
//		add(post);
//		add(info);

		JPanel p=new JPanel();
		p.setLayout(new FlowLayout());
		info.setPreferredSize(new java.awt.Dimension(150, 30));
		post.setPreferredSize(new java.awt.Dimension(150, 30));
		p.add(post);p.add(info);
		p.setBounds(650, 555, 585, 40);
		
		add(p);
		setSize(1280,800);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new ChatForm();
		
	}
}
