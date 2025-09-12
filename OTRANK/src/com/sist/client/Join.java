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
/*
import com.sist.dao.MemberVO;
import com.sist.dao.ZipcodeVO;
*/
import java.awt.*;
import java.awt.event.*;
/*
	JLabel jointext;		 // 회원가입 문구
	JTextField id;			 // id 텍스트
	JPasswordField pwd;		 // 비밀번호 텍스트
	JPasswordField pwdCheck; // 비밀번호 확인
	JTextField nickName;	 // 닉네임 텍스트
	JTextField name;		 // 이름 텍스트
	JRadioButton man,wo;	 // 성별 / 남자 , 여자 라디오 버튼
	JTextField post;		 // 우편번호
	JTextField addr1;		 // 주소 텍스트
	JTextField addr2;		 // 상세주소 텍스트
	JTextField phone;		 // 전화번호 텍스트
	
	JButton idCheck;		 // ID 중복체크 버튼
	JButton nickCheck;		 // 닉네임 중복체크 버튼
	JButton phoneCheck;		 // 전화 중복체크 버튼
	JButton postFind;		 // 우편번호 검색
	JButton join;			 // 회원가입 버튼
	JButton cn;				 // 취소 버튼
 */
public class Join
implements ActionListener,MouseListener
{
   CardLayout card=new CardLayout();
   JoinForm join;
   Login login;
   PostFindForm post;
   public Join (JoinForm join)
   {
	   this.join=join;
	   this.login=login;
	   this.post=new PostFindForm();
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==join.join) // 회원가입
		{
			// 우편번호 검색
		if(e.getSource()==join.post)
			{
				post.find.setText("");
				for(int i=post.model.getRowCount()-1;i>=0;i--)
				{
					post.model.removeRow(i);
				}
				post.setVisible(true);
			}
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
						"🎉🎉회원가입을 축합니다!!\n"
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

		
	}
	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
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
