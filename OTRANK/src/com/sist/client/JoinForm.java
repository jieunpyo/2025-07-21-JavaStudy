package com.sist.client;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JoinForm extends JFrame{
	
	JLabel[] las=new JLabel[11];
	String[] title={"ID","비밀번호","비밀번호 확인","이름","닉네임","성별","우편번호","주소",
					"상세주소","전화","소개"};
	JLabel jointext;		 // 회원가입 문구
	JTextField id;			 // id 텍스트
	JPasswordField pwd;		 // 비밀번호 텍스트
	JPasswordField pwdCheck; // 비밀번호 확인
	JTextField nickName;	 // 닉네임 텍스트
	JTextField name;		 // 이름 텍스트
	JRadioButton man,wo;	 // 성별 / 남자 , 여자 라디오 버튼
	JTextField post;		 // 우편번호
	JTextField addr1;		 // 주소 텍스트
	JTextField addr2;		 // 상세주소 텍스트
	JTextField phone;		 // 전화번호 텍스트
	JTextArea content;		 // 소개 텍스트
	
	JButton idCheck;		 // ID 중복체크 버튼
	JButton nickCheck;		 // 닉네임 중복체크 버튼
	JButton phoneCheck;		 // 전화 중복체크 버튼
	JButton postFind;		 // 우편번호 검색
	JButton join;			 // 회원가입 버튼
	JButton cn;				 // 취소 버튼
	
	public JoinForm()
	{
		for(int i=0;i<las.length;i++)
		{
			las[i]=new JLabel(title[i]);
			las[i].setBounds(30, 115+(i*35), 100, 30);
			add(las[i]);
		}
		
		// 회원가입 문구
		setLayout(null);
		jointext=new JLabel("회원 가입",JLabel.CENTER);
		jointext.setFont(new Font("맑은 고딕",Font.BOLD,35));
		jointext.setBounds(10, 30, 440, 50);
		add(jointext);
		
		// ID
		id=new JTextField();
		id.setBounds(120, 115, 150, 30);
		add(id);
		
		// ID 중복체크
		idCheck=new JButton("중복체크");
		idCheck.setBounds(280, 115, 100, 30);
		add(idCheck);
		
		// 비밀번호
		pwd=new JPasswordField();
		pwd.setBounds(120, 150, 150, 30);
		add(pwd);
		
		// 비밀번호 확인
		pwdCheck=new JPasswordField();
		pwdCheck.setBounds(120, 185, 150, 30);
		add(pwdCheck);
		
		// 이름
		name=new JTextField();
		name.setBounds(120, 220, 150, 30);
		add(name);
		
		// 닉네임
		nickName=new JTextField();
		nickName.setBounds(120, 255, 150, 30);
		add(nickName);
		
		// 닉네임 중복체크
		nickCheck=new JButton("중복체크");
		nickCheck.setBounds(280, 255, 100, 30);
		add(nickCheck);
		
		// 성별 라디오 버튼
		man=new JRadioButton("남자");
		wo=new JRadioButton("여자");
		man.setBounds(120, 290, 70, 30);
		wo.setBounds(195, 290, 70, 30);
		add(man);
		add(wo);
		
		ButtonGroup sex=new ButtonGroup();
		sex.add(man);
		sex.add(wo);
		
		// 우편번호
		post=new JTextField();
		post.setBounds(120, 325, 150, 30);
		add(post);
		
		// 우편번호 검색
		postFind=new JButton("우편번호 검색");
		postFind.setBounds(280, 325, 100, 30);
		add(postFind);
		
		// 주소
		addr1=new JTextField();
		addr1.setBounds(120, 360, 300, 30);
		add(addr1);
		
		// 상세주소
		addr2=new JTextField();
		addr2.setBounds(120, 395, 300, 30);
		add(addr2);
		
		// 전화
		phone=new JTextField();
		phone.setBounds(120, 430, 150, 30);
		add(phone);
		
		// 전화 중복체크
		phoneCheck=new JButton("중복체크");
		phoneCheck.setBounds(280, 430, 100, 30);
		add(phoneCheck);

		// 소개
		content=new JTextArea();
		JScrollPane js=new JScrollPane(content);
		js.setBounds(120, 465, 300, 100);
		add(js);

		// 하단 회원가입 / 취소 버튼
		join=new JButton("회원가입");
		cn=new JButton("취소");
		
		JPanel p=new JPanel();
		p.add(join); 
		p.add(cn);
		
		p.setBounds(40, 580, 370, 35); // 회원가입, 취소 버튼 크기 및 위치
		add(p);
		
		id.setEnabled(false);
		nickName.setEnabled(false);
		phone.setEnabled(false);
		post.setEnabled(false);
		addr1.setEnabled(false);
		man.setSelected(true); // 성별 라디오버튼 남자로 세팅

		setSize(480, 670); // 회원가입 창 크기
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 닫기 누르면 창만 닫히게
	    setLocationRelativeTo(null); // 화면 가운데 표시
		//setVisible(true);
	}
}