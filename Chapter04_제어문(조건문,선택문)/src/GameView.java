import javax.swing.*;// 경량 
import java.awt.*; // Image 
public class GameView extends JPanel{
	Image cat,cat2;
	// 초기화
	int x=150;
	int y=100;
	public GameView()
	{
		// 생성자 => 변수에 대한 초기화
		cat2=Toolkit.getDefaultToolkit().
				getImage("c:\\javaDev\\cat2.gif");
		cat=Toolkit.getDefaultToolkit().
				getImage("c:\\javaDev\\cat.jpg");
	}
	public void paint(Graphics g)
	{
		g.drawImage(cat2,0,0,getWidth(),getHeight(),this);
		g.drawImage(cat,x,y,150,100,this);
	}
}