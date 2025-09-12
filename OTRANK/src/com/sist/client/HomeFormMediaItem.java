package com.sist.client;

// 크롤링 할 데이터의 컬럼들 설정
// DTO역할
public class HomeFormMediaItem {
    public final String title;
    public final String subtitle;
    public final String desc;

    public HomeFormMediaItem(String title, String subtitle, String desc) {
        this.title = title;
        this.subtitle = subtitle;
        this.desc = desc;
    }
    
}
