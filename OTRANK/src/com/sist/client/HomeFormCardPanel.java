package com.sist.client;

import javax.swing.*;
import java.awt.*;

// MediaItem의 데이터들을 어떻게 배치하고 카드 형태로 만들지
public class HomeFormCardPanel extends JPanel {

//	CardLayout MovieCard = new CardLayout();
//	
//  
//
    // 생성자
	 public HomeFormCardPanel(HomeFormMediaItem item) {
	        setLayout(new BorderLayout());
	        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
	        setPreferredSize(new Dimension(200, 200));

	        // 제목
	        JLabel titleLabel = new JLabel(item.title, SwingConstants.CENTER);
	        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));

	        // 부제목
	        JLabel subtitleLabel = new JLabel(item.subtitle, SwingConstants.CENTER);
	        subtitleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	        subtitleLabel.setForeground(Color.DARK_GRAY);

	        
	        // 설명
	        JTextArea descArea = new JTextArea(item.desc);
	        descArea.setLineWrap(true);
	        descArea.setWrapStyleWord(true);
	        descArea.setEditable(false);
	        descArea.setBackground(getBackground());

	        // 중앙 영역 패널 (제목+부제목)
	        JPanel textPanel = new JPanel(new GridLayout(2, 1));
	        textPanel.add(titleLabel);
	        textPanel.add(subtitleLabel);

	        add(textPanel, BorderLayout.NORTH);
	        add(new JScrollPane(descArea), BorderLayout.CENTER);
	    }
//
//    // 썸네일 설정 메서드
//    public void setThumbnail(Icon icon) {
//    	
//        // 구현 예정
//    }
//
//    // 선택/호버 상태 등 스타일 변경 메서드
//    public void setSelected(boolean selected) {
//    	
//        // 구현 예정
//    }
	
}
