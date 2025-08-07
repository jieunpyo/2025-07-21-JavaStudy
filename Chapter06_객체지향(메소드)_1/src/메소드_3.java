import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class 메소드_3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("멜론뮤직(1),지니뮤직(2):");
		int select=scan.nextInt();
		
		while(true)
		{
			System.out.println("===== Menu =====");
			System.out.println("1. 목록");
			System.out.println("2. 곡명 검색");
			System.out.println("3. 가수 검색");
			System.out.println("4. 종료");
			System.out.println("================");
			System.out.print("메뉴 선택:");
			int menu=scan.nextInt();
			if(menu==4)
			{
				System.out.println("프로그램 종료!!");
				break;
			}
			
			if(select==1)
			{
				Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
				   Elements title=doc.select("tr.lst50 div.rank01 a");
				   Elements singer=doc.select("tr.lst50 div.rank02 a");
				switch(menu)
				{
				   case 1 ->{
					   // 소스 읽기
					   
					   for(int i=0;i<title.size();i++)
					   {
						   
						   System.out.println((i+1)+"."
							 +title.get(i).text());
					   }
					   
				   }
				   case 2 ->{
					   	
				   }
				   case 3 ->{
					   
				   }
				}
			}
			else
			{
				switch(menu)
				{
				   case 1 ->{
					   
				   }
				   case 2 ->{
					   
				   }
				   case 3 ->{
					   
				   }
				}
			}
		}
		
	}

}
