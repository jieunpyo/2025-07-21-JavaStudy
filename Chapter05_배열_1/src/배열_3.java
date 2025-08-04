// 100개의 난수 발생(0~9) => 빈도수 구하기 
public class 배열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bin=new int[10];// 0~9
		/*
		 * 	  rand=1 rand=9
		 * 	  0	  1  2  3  4  5  6  7  8  9
		 * 		 +1						 +1
		 */
		for(int i=1;i<=100;i++)
		{
			int rand=(int)(Math.random()*10);
			bin[rand]++;
		}
		System.out.println("===== 결과값 =====");
		for(int i=0;i<10;i++)
		{
			System.out.println(i+":"+bin[i]);
		}
		/*
		 * 		0:11
				1:6
				2:11
				3:8
				4:10
				5:12
				6:10
				7:9
				8:11
				9:12
				
		 */
	}

}
