package com.sist.client;

import javax.swing.*;
import java.awt.*; // 배치 => 레이아웃
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map; // 이벤트 처리 

public class ClintMainFrame extends JFrame

implements ActionListener
{
	MenuForm menu1=new MenuForm(); // 하단 버튼들
	MenuForm2 menu2=new MenuForm2(); // 상단 버튼들

	ControllerPanel cp=new ControllerPanel(); // 내용물 
	

	
	// has-a => 포함 클래스 
	public ClintMainFrame()
	{
		setLayout(null); // 좌표로 위치를 잡기 위해 null

		menu1.setBounds(135, 80, 1000, 50); // 하단 버튼들 위치 및 크기
		menu2.setBounds(750, 15, 500, 30); // 상단 버튼들 위치 및 크기

		// cp.setBounds(20, 147, 1225, 595);		// 왜 두개인지 모르겠음 중복인 것 같은데?
		cp.setBounds(20, 150, 1230, 600);

		add(menu1); // 하단 버튼들 ClintMainFrame에 넣기 => 아직 보여지게 하는 부분은 아님
		add(menu2); // 상단 버튼들 ClintMainFrame에 넣기 => 아직 보여지게 하는 부분은 아님
		add(cp); // 내용물 ClintMainFrame에 넣기 => 아직 보여지게 하는 부분은 아님

		setSize(1280, 800); // ClintMainFrame의 크기 설정 => 내용물을 큰 틀인 ClintMainFrame에 넣고 이것에 대한 크기를 설정

		setVisible(true); // UI 보이기 
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 하단 버튼 클릭 이벤트 등록 => 누르면 actionPerformed의 내용이 실행됨 조건에 따라
		menu1.b1.addActionListener(this);
		menu1.b2.addActionListener(this);
		menu1.b3.addActionListener(this);
		menu1.b4.addActionListener(this);
		
		// 상단버튼 클릭 이벤트 등록 => 누르면 actionPerformed의 내용이 실행됨 조건에 따라
		menu2.b5.addActionListener(this);
	}

	// 파일에서 실행시키는 부분인 main
	public static void main(String[] args) {

		try{
			//											   hifi HiFiLook~
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel"); // JTATOO의 기본 디자인 설정

		}catch(Exception e) {}

		new ClintMainFrame();
		// 프레임을 메인에서 생성한다는 말 => setVisible(true) 호출됨
		// 생성자 호출
		// ClintMainFrame() c=new ClientMainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==menu1.b1)
		{
			cp.card.show(cp, "HF"); // 메인 홈
		}
		else if(e.getSource()==menu1.b2)
		{
			// cp.card.show(cp, "CF"); // 채팅
		}
		else if(e.getSource()==menu1.b3)
		{
			cp.card.show(cp, "BF");
		}
		else if (e.getSource()== menu1.b4)
		{
	        cp.card.show(cp, "CF"); // 채팅
	    }
		else if (e.getSource()== menu2.b5)
		{
			new Login().setVisible(true); //로그인은 JFrame라서 일단 이렇게 넣었음
		}
	}
}
