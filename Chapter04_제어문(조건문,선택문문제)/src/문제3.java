/*
 * 	 문제3. 1학년부터 4학년까지 중간고사 시험을 보았다.
 * 		   4학년은 70점 이상이면 합격, 그 외의 학년은 60점 이상이면 합격이다.
 *		   이를 판단하는 프로그램을 작성해보자.
 *		   점수가 0미만 100초과이면 경고문구 출력!
 *		   (학년을 먼저 입력, 그 다음 점수)
 *			1학년
 *			2학년
 *			3학년
 *			4학년 a >=70 '합격' 그 외 a >=60 '합격'
 */

import java.util.Scanner;

public class 문제3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scan=new Scanner(System.in);
//		System.out.print("학년 입력:");
//		int a=scan.nextInt();
//		
//		System.out.print("점수 입력:");
//		int b=scan.nextInt();
//		
//		if (score<0 || score>100) {
//			System.out.println("잘못된 점수 입력입니다.");
//		}
//		else (a <= 3) {
//			if (b >= 60) {
//				System.out.println("합격");
//			} else {
//				System.out.println("불합격");
//			}
//		} else {
//			if (b >= 70) {
//				System.out.println("합격");
//			} else {
//				System.out.println("불합격");
//			}
//		}
		
		Scanner scan=new Scanner(System.in);
		System.out.print("1~4 학년 입력:");
		int grade=scan.nextInt();
		
		System.out.print("0~100사이의 정수 입력:");
		int score=scan.nextInt();
		
		if(score<0 || score>100)
		{
			System.out.print("잘못된 점수 입력입니다.");
		}
		else
		{
			// if~else => 삼항연산자를 이용해서 처리 
			System.out.println(
				(grade!=4 && score>=60)||(grade==4 && score>=70)?
				"합격":"불합격"
			);
			/*if(grade==4)
			{
				if(score>=70)
					System.out.println("합격");
				else
					System.out.println("불합격");
			}
			중첩 => &&
			if(grade==4 && score>=70)
			{
				if(score>=70)
					System.out.println("합격");
			}
			else
				System.out.println("불합격");
			else // 1~3
			{
				if(score>=60)
					System.out.println("합격");
				else
					System.out.println("불합격");
			}*/
		}
	}

}
