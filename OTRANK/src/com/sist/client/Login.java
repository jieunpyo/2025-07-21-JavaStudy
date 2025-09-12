package com.sist.client;
import javax.swing.*;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

import java.awt.event.*;

import com.sist.dao.DAOdefault;
import com.sist.dao.JoinDAO;
import com.sist.vo.MemberVO;
import com.sist.vo.ZipcodeVO;

import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame 
implements ActionListener,MouseListener
{	
	JoinDAO dao=JoinDAO.newInstance();
	private static Map<String, String> checkmap = new HashMap<String, String>();
	static {
		checkmap.put("아이디 중복체크", "Login_Id");
		checkmap.put("닉네임 중복체크", "nickname");
		checkmap.put("전화번호 중복체크", "Login_Id");
	}
    JLabel la1, la2;
    JTextField tf;
    JPasswordField pf;
    JButton b1, b2, b3;

    CardLayout card=new CardLayout();
    JoinForm join=new JoinForm();
    PostFindForm post=new PostFindForm();
    CheckForm check=new CheckForm();
    
    public Login() {
       
        setTitle("Login");
        setSize(253, 175); 
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // EXIT_ON_CLOSE면 로그인 창 닫았을 시 메인창도 같이 꺼짐
        setLocationRelativeTo(null); 

        la1 = new JLabel("ID", JLabel.CENTER);
        la2 = new JLabel("PW", JLabel.CENTER);
        tf = new JTextField();
        pf = new JPasswordField();
        b1 = new JButton("로그인");
        b2 = new JButton("가입");
        b3 = new JButton("취소");

       
        la1.setBounds(10, 18, 40, 25);
        tf.setBounds(57, 18, 118, 28);

        la2.setBounds(14, 51, 40, 25);
        pf.setBounds(57, 51, 118, 28);

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0)); 
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.setBounds(15, 93, 205, 30);

        
        add(la1);
        add(tf);
        add(la2);
        add(pf);
        add(p);
       
       // 로그인 버튼
       b1.addActionListener(this); // 로그인
       b2.addActionListener(this); // 회원가입 
       b3.addActionListener(this); // 취소
       
       // 테이블 버튼
       post.search.addActionListener(this); // 검색 버튼
   	   post.cn.addActionListener(this);		// 취소 버튼
   	   post.find.addActionListener(this);	// 검색 창
   	   post.table.addMouseListener(this);	// 우편번호 검색 자체 창
   	   check.table.addMouseListener(this);  // 아이디 중복체크 테이블
   	   check.search.addActionListener(this);
   	   
       //회원가입 버튼
       join.idCheck.addActionListener(this); // ID 중복체크 버튼
       join.nickCheck.addActionListener(this); // 닉네임 중복체크 버튼
       join.phoneCheck.addActionListener(this); // 전화 중복체크 버튼
       join.postFind.addActionListener(this); // 우편번호 검색
       join.join.addActionListener(this); // 회원가입 버튼
       join.cn.addActionListener(this); // 취소 버튼
       
       
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==b1)
      {
         dispose();
      }
      else if(e.getSource()==b2)
      {
    	  this.setVisible(false);
          join.setVisible(true);
      }
  	  // 우편번호 검색
      else if(e.getSource()==join.postFind)
  		{
			post.find.setText("");
			for(int i=post.model.getRowCount()-1;i>=0;i--)
			{
				post.model.removeRow(i);
			}
			post.setVisible(true);
			
  		}
      // 로그인 중복체크
      else if(e.getSource()==join.idCheck)
  		{
    	    check.find.setText("");
			for(int i=post.model.getRowCount()-1;i>=0;i--)
			{
				check.model.removeRow(i);
			}
			check.search.setText("아이디 중복체크");
			check.setVisible(true);
			
//			memberPhoneCheck(checkmap.get(join.idCheck.getText()),)
  		}
      
      	else if(e.getSource()==join.join)
      	{
  			// 유효성 검사 
  			String id=join.id.getText();
  			if(id.length()<1)
  			{
  				JOptionPane.showMessageDialog(this.join, "ID 중복체크를 클릭하세요");
  				join.id.requestFocus();
  				return;
  			}
  			
  			String pwd=String.valueOf(join.pwd.getPassword());
  			if(pwd.length()<1)
  			{
  				JOptionPane.showMessageDialog(this.join, "비밀번호를 입력하세요");
  				join.pwd.requestFocus();
  				return;
  			}
  			
  			String pwdCheck=String.valueOf(join.pwdCheck.getPassword());
  			if (pwdCheck.isEmpty()) {
  			    JOptionPane.showMessageDialog(this.join, "비밀번호 확인을 입력하세요");
  			    join.pwdCheck.requestFocus();
  			    return;
  			}
  			if (!pwd.equals(pwdCheck)) {
  			    JOptionPane.showMessageDialog(this.join, "비밀번호와 비밀번호 확인 값이 틀립니다!!");
  			    join.pwdCheck.requestFocus();
  			    return;
  			}
  			
  			String name=join.name.getText();
  			if(name.length()<1)
  			{
  				JOptionPane.showMessageDialog(this.join, "이름을 입력하세요");
  				join.name.requestFocus();
  				return;
  			}
  			String nickName=join.nickName.getText();
  			if(nickName.length()<1)
  			{
  				JOptionPane.showMessageDialog(this.join, "닉네임 중복체크를 클릭하세요");
  				join.nickName.requestFocus();
  				return;
  			}
  			
  			
  			String post1=join.post.getText();
  			if(post1.length()<1)
  			{
  				JOptionPane.showMessageDialog(this.join, "우편번호 검색을 클릭하세요");
  				join.post.requestFocus();
  				return;
  			}
  			if(e.getSource()==join.cn)
  			{
  				new Login().setVisible(true);
  				join.setVisible(false);
  			}

  			String addr1=join.addr1.getText();
  			String addr2=join.addr2.getText();
  			String post=join.post.getText();
  			String phone=join.phone.getText();
  			String sex = join.man.isSelected() ? "남자" : "여자";
  			
  			MemberVO vo=new MemberVO();
  			vo.setNickname(nickName);
  			vo.setLogin_id(id);
  			vo.setLogin_pwd(pwd);
  			vo.setSex(sex);
  			vo.setPost(post);
  			vo.setAddr1(addr1);
  			vo.setAddr2(addr2);
  			vo.setPhone(phone);
  			vo.setName(name);
  			
  			JoinDAO dao=JoinDAO.newInstance();
  			int res=dao.memberJoin(vo);
  			
  			if(res==0)
  			{
  				JOptionPane.showMessageDialog(join, this, 
  						"회원 가입 실패하셨습니다\n"
  						+"다시 회원가입을 하세요", res);
  			}
  			else
  			{
  				JOptionPane.showMessageDialog(join, this, 
  						"🎉🎉회원가입을 축하합니다!!\n"
  						+"로그인창으로 이동합니다", res);
  				card.show(getContentPane(), "login");
  			}
  		}
  		else if(e.getSource()==join.join)
  		{
  			new Login().setVisible(true);
  			join.setVisible(false);
  		}
  		else if(e.getSource()==post.search || e.getSource()==post.find)
  		{
  			String dong=post.find.getText();
  			if(dong.length()<1)
  			{
  				//post.js.setVisible(false);
  				JOptionPane.showMessageDialog(post, "동/읍/면을 입력하세요");
  				post.find.requestFocus();
  				return;
  			}
  			// 입력시 

  			JoinDAO dao=JoinDAO.newInstance();
  			java.util.List<ZipcodeVO> list=dao.postFind(dong);
  			if(list.size()>0)
  			{
  				//post.js.setVisible(true);
  				for(int i=post.model.getRowCount()-1;i>=0;i--)
  				{
  					post.model.removeRow(i);
  				}
  				
  				for(ZipcodeVO vo:list)
  				{
  					String[] data= {
  						vo.getZipcode(),
  						vo.getAddress()
  					};
  					post.model.addRow(data);
  				}
  			}
  			else
  			{
  				//post.js.setVisible(false);
  				JOptionPane.showMessageDialog(post, "검색 결과가 없습니다");
  				post.find.setText("");
  				post.find.requestFocus();
  			}
  		}
  		else if(e.getSource()==post.cn)
  		{
  			post.setVisible(false);
  		}
		  else if(e.getSource()==b3)
		  {
		     dispose();
		     System.exit(0);
		  }
		  else if (e.getSource()==check.search)
		  {
			  System.out.println(dao.memberPhoneCheck(checkmap.get(check.search.getText().toString()),check.find.getText().toString()));
		  }
}

   @Override
   public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	   if(e.getClickCount()==2)
		{
			int row=post.table.getSelectedRow();
			String zip=post.model.getValueAt(row, 0).toString();
			String addr=post.model.getValueAt(row, 1).toString();
			join.post.setText(zip);
			join.addr1.setText(addr);
			post.setVisible(false);
		}
   }

   @Override
   public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
   }

   @Override
   public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
   }

   @Override
   public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
   }

   @Override
   public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
   }
}
