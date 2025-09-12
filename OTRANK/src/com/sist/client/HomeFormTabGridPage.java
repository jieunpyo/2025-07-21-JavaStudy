package com.sist.client;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;

// HomeFormCardPanel을 어떻게 배치할지 정하는 곳
public class HomeFormTabGridPage extends JPanel {

    // 생성자
    public HomeFormTabGridPage(String ott) {
    	
    	setLayout(new BorderLayout());

        // WrapLayout 사용 (왼쪽 정렬, 간격 15px)
        JPanel gridPanel = new JPanel(new WrapLayout(FlowLayout.LEFT, 15, 15));

        
        // 더미 데이터
        List<HomeFormMediaItem> items = Arrays.asList(
            new HomeFormMediaItem(ott + " 영화 1", "감독 A", "설명 A"),
            new HomeFormMediaItem(ott + " 영화 2", "감독 B", "설명 B"),
            new HomeFormMediaItem(ott + " 영화 3", "감독 C", "설명 C"),
            new HomeFormMediaItem(ott + " 영화 4", "감독 D", "설명 D"),
            new HomeFormMediaItem(ott + " 영화 5", "감독 E", "설명 E"),
            new HomeFormMediaItem(ott + " 영화 6", "감독 F", "설명 F"),
            new HomeFormMediaItem(ott + " 영화 7", "감독 G", "설명 G"),
            new HomeFormMediaItem(ott + " 영화 8", "감독 H", "설명 H")
        );

        // 카드 추가
        for (HomeFormMediaItem item : items) {
            HomeFormCardPanel card = new HomeFormCardPanel(item);
            card.setPreferredSize(new Dimension(200, 250)); // 원하는 카드 크기
            gridPanel.add(card);
        }

        // 세로 스크롤 가능하게
        JScrollPane scrollPane = new JScrollPane(gridPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);
    }
    

    // 데이터 리스트를 카드로 렌더링
    public void render(List<HomeFormMediaItem> items) {
        // 구현예정
    }

    // 로딩 상태 표시
    public void showLoading() {
        // 구현예정
    }

    // 표시할 데이터가 없을 때 어떻게 표시할지
    public void showEmptyState(String message) {
        // 구현예정
    }
}
