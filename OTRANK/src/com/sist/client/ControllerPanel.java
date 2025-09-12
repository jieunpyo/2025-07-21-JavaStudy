package com.sist.client;

import javax.swing.*;
import java.awt.*;

public class ControllerPanel extends JPanel{

	HomeForm hf = new HomeForm();
	ChatForm cf = new ChatForm();
	BoardList bf = new BoardList();

	CardLayout card = new CardLayout(); 
	// CardLayout 객체 생성
	// CardLayout은 여러 컴포넌트를 겹쳐놓고 그 중 하나만 보이게 하는 레이아웃 매니저 카드를 넘기듯이 화면을 전환

	public ControllerPanel()
	{
		setLayout(card); //ControllerPanel의 레이아웃 매니저를 CardLayout으로 설정

		add("HF",hf);
		add("CF",cf);
		add("BF",bf);
		
	}
}
