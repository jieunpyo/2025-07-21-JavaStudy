package com.sist.manager;
import com.sist.music.*;
/*
 * 	 자바 소스 
 * 	 package => 클래스가 있는 폴더명 지정 => 한번만 사용이 가능 
 * 	 import => 다른 패키지 있는 클래스나 라이브러리 클래스 로드 
 * 			   여러번 사용이 가능 
 * 	 class Classname
 * 	 {
 * 		------------
 * 		 사용할 변수 => 여러개 사용 
 * 		   => 기본형 , 클래스 , 배열 , 클래스배열 
 * 			  MusicVO vo;
 * 			  MusicVO[] musics=new MusicVO[50]
 * 			  => 사용자 정의 데이터형
 * 			  => 일반 데이터형과 동일시 한다 
 * 			  => 배열 , 형변환 
 * 		------------
 * 		 생성자 => 여러개 사용이 가능 => 오버로딩 
 * 			  => 초기값을 다르게 지정한다면 매개변수가 있는 생성자 이용
 * 		------------
 * 		 메소드 => 기능별로 메소드 제작 ...
 * 		------------
 * 	 }
 * 
 * 	 메소드
 * 	 1. 메뉴  
 * 	 2. 목록
 * 	 3. 검색(곡명)
 * 	 4. 검색(가수명)
 * 	 5. 등폭이 가장 많은 곡 
 * 		=> 상승
 * 		=> 하강
 * 
 * 	 1) 기능 설정 => 자바에서는 메소드 
 * 	 2) 메소드의 기능 
 * 		=> 반복제거 
 * 		=> 기능별 코드를 분리 : 가독성
 * 		   --------------- 에러 처리 편리 
 * 		=> 다른 클래스에서 사용이 가능 : public 
 * 		=> 재사용 / 수정해서 사용이 가능 (오버라이딩)
 * 	 3) 메소드 구조 
 * 		[접근지정어] 리턴형 메소드명(매개변수...)
 *		{		 -----
 *					| 동일하거나 리턴형이 크다 (가급적이면 동일하게 만든다)
 *				  ---
 *			return 값;
 *		}
 *
 *		1. 접근지정어 : 메소드는 다른 클래스와 통신 : public 
 *		2. 리턴형 
 *		   => 기본형 : 값이 한개인 경우 
 *			  -----
 *				int / double / boolean / String 
 *				---			   -------	 ------
 *		   => 배열 / 클래스 : 값이 여러개인 경우 
 *					----- 상세보기 
 *			  ---- 정렬
 *		3. 메소드명 : 자바에서 메소드명은 주소값 
 *					MethodArea => Call Stack
 *					
 *					void main()
 *					{
 *					   a();
 *					}
 *					void a(){b();}
 *					void b(){c();}
 *					void c(){d();}
 *					void d(){}
 *
 *					------------
 *						d()	   ---->
 *					------------
 *						c()	 		c() --->
 *					------------
 *						b()			b()
 *					------------
 *						a()			a()
 *					------------
 *					   main()	   main()
 *					------------	
 *			=> 식별자 (변수,메소드,클래스,인터페이스)
 *			=> 변수/메소드 => 소문자로 시작 
 *			=> 인터페이스 / 클래스 => 대문자로 시작 
 *			   *** 두개의 단어가 있는 경우 
 *			   헝거리언식 표현법을 사용한다 
 *			   --------
 *				 MusicManager
 *				 Music_Manager	=> 약자 => 대문자 사용 
 *				 MusicVO , MusicDAO , MusicDTO
 *				 MusicEntity
 *		 4. 매개변수
 *			: 사용자의 요청값을 받아서 처리 
 *			매개변수 (X , 여러개인 경우도 있다)
 *						---------- 3개 이상 : 배열/클래스
 *			=> 갯수를 알 수 없는 경우도 있다 
 *			   ----------------- 가변매개변수 이용 
 *								 데이터형... 변수
 *
 *		 5. 호출 => 메소드를 부를 경우
 *			---
 *			 => 메소드 시작부터 return이 있는 곳 까지 수행
 *
 *			 => 데이터 
 *				정형화 => 데이터베이스 (검증)
 *				반정형화 => 구분만 된 데이터
 *						  JSON / XML / HTML
 *				비정형화 => 트위터,facebook 
 *						  --------------> 정형화 
 *		 6. 호출
 *			void일 경우 
 *			메소드명(값...)
 *
 *			=> static
 *			   클래스명.메소드()
 *			=> instance 
 *			   객체명.메소드()
 *
 *			class A
 *			{
 *			   public void display(){
 *				   this.insert() => this.은 생략이 가능
 *				   -------------
 *				   insert()
 *				   temp()
 *			   }
 *			   public static temp(){
 *			   	  A a=new A();
 *				   a.display()
 *				   a.insert()
 *				   => 오류
 *			   }
 *			   public void insert(){
 *
 *			   }
 *			}
 *
 *			class B
 *			{
 *			   public void display()
 *			   {
 *				  A a=new A();
 *				  a.display();
 *				  a.insert();
 *				  A.temp()
 *			   }
 *			   public static void temp() 
 *			   {
 *				  A a=new A();
 *				  a.display();
 *				  a.insert();
 *				  A.temp()
 *			   }
 *			}
 *
 *
 *			public int display()
 *			{
 *				 1
 *				 2
 *				 3
 *				 4
 *				 5
 *				 return 10; => int a전송하고 종료
 *			}
 *
 *			=> int a=display();
 *				6
 *				7
 *				8
 *			  메소드는 결과값을 전송하고 소멸 => 다음 문장 수행 
 *
 *		=> 메소드 :  어떤 값을 받을 지 => 매개변수
 *				   결과값 설정 => 리턴형 
 *	
 *		1. 메뉴
 *		   menu() => 리턴형 / 매개변수 
 *					  int	   X
 * 	 	2. 목록	  => 리턴형 / 매개변수 
 * 					  	   	   X
 * 					 void / MusicVO[]
 * 	 	3. 검색(곡명)  => 리턴형 / 매개변수 
 * 					 MusicVO[] / String fd
 * 		4. 검색(가수명)
 * 		5. 등폭이 가장 많은 곡 
 * 		   => 상승
 * 		   => 하강
 *
 */
public class MusicManager {
	public static void main(String[] args) {
		MusicManager m=new MusicManager();
		m.sum(10,20);
		m.sum(10,20,30,40,50);
		m.sum(10,20,30,40,50,60,70);
	}
	public void sum(int... arg)
	{
		int s=0;
		for(int i:arg)
		{
			s+=i;
		}
		System.out.println("sum="+s);
		
	}
	public void display(int a)
	{
		if(a==10)
			return; // 유효성 검사 
		System.out.println("메소드 종료");
	}
	
}
