package com.sist.client;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class HomeForm extends JPanel{ //1

       // 검색 입력하는 필드
	JTextField SearchFd;
       // 검색 버튼
	JButton SearchBtn;
       // 탭 기능
       JTabbedPane RankTab;

	public HomeForm(){ //2

              setLayout(null);// 좌표로 위치를 잡기 위해 null

              //------------------------ 검색 기능 ----------------------------

              SearchFd = new JTextField(); // 검색 입력 필드 생성
              SearchBtn = new JButton("검색"); // 검색 버튼에 '검색' 이라고 표시
              
              JPanel p = new JPanel(); // 검색 입력 필드와 검색 버튼을 담을 패널 생성

              p.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
              // p.setLayout은 
              // 패널의 배치를 FlowLayout로 설정 => 가로로 배치한다고 생각하면 됨 
              // FlowLayout.center은 가운데로 정렬
              
              SearchFd.setPreferredSize(new Dimension(800, 35)); //검색 입력 필드 크기 설정 800은 가로, 35는 세로
              SearchBtn.setPreferredSize(new Dimension(90, 35)); //검색 버튼 크기 설정 90은 가로, 35는 세로
              
              p.add(SearchFd); // 위에서 패널을 생성하고 패널들의 크기를 정했으면 이제 패널에 추가하기
              p.add(SearchBtn); // 이하 동문
              
              //----------------------- 탭 기능 ------------------------------
              RankTab = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
              // JTabbedPane.TOP => 탭이 위로 가게끔
              // JTabbedPane.WRAP_TAB_LAYOUT => 탭이 여러개이면 줄바꿈 기능

              RankTab.setBounds(20, 60, 1190, 680); // 탭의 위치
              

              // 반복문으로 탭들을 보여지게 출력
              String[] Titles = {"넷플릭스","웨이브","디즈니+","왓챠","쿠팡플레이"};
              for (String ott : Titles) { //3

//                     RankTab.addTab(ott, new JPanel(new BorderLayout())); 
                      RankTab.addTab(ott, new HomeFormTabGridPage(ott));  // 분리한 페이지 넣기

              } //3

              // 각 탭의 제목 컴포넌트를 커스텀
              for(int i = 0; i < Titles.length; i++){ //4
                     String title = RankTab.getTitleAt(i); // 탭의 제목 문자열을 가져옴

                     JLabel TabLabel = new JLabel(title); // 탭의 제목 문자열을 JLable에 넣어서 표시가 됨

                     TabLabel.setBorder(new EmptyBorder(6, 18, 6, 18)); // JLable의 상,좌,하,우 여백
                     RankTab.setTabComponentAt(i, TabLabel);
                     
              } //4
              

              


              p.setBounds(100, 0, 1020, 40); // 패널의 위치를 x : 100, y : 0, 가로 : 1020, 세로 : 40 설정
              
              add(p); // 검색 필드, 버튼 추가
              add(RankTab); // 탭 추가
	} //2
} //1
