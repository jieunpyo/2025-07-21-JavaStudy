/*
 * 	 문제1. 정수 한 개를 입력받아서, 그 수가 50 이상의 수인지 50미만의 수인지 판단해보자.
 * 	 if(num>=50)
 * 	 else
 */
import java.util.Scanner;

public class 문제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scan=new Scanner(System.in);
//		System.out.print("정수 한 개 입력:");
//		int a=scan.nextInt();
//		if (a >= 50) {
//			System.out.println("50이상의 수 입니다.");
//		} else {
//			System.out.println("50미만의 수 입니다");
//		}
		
		int num=(int)(Math.random()*100)+1;
		// 1~100 사이 정수
		System.out.println("num="+num);
		if(num>=50)
			System.out.println(num+"는(은) 50이상인 수");
		else
			System.out.println(num+"는(은) 50미만인 수");
	}

}
