package com.sist.controll;
import java.awt.event.ActionListener;
import java.util.List;

import com.sist.client.MemberManagerForm;
import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;
public class MemberManagerControll {
	MemberManagerForm mmf;
	MemberDAO dao;
	public MemberManagerControll(MemberManagerForm mmf)
	{
		this.mmf=mmf;
		dao=MemberDAO.newInstance();
		List<MemberVO> list=dao.memberAlldata();
		System.out.println("가져온 회원 수: " + list.size());
		setTable(list);
	}
	public void setTable(List<MemberVO> members)
	{
		for(int i=mmf.getMembermodel().getRowCount() -1 ; i >=0 ;i--)
		{
			mmf.getMembermodel().removeRow(i);
		}
		for(int i=0; i<members.size();i++)
		{
			MemberVO vo=new MemberVO();
			vo=members.get(i);
			Object[] data= {vo.getId_num(),vo.getLogin_id(),vo.getLogin_pwd(),vo.getName(),vo.getNickname(),vo.getSex(),vo.getPost(),vo.getAddr1(),vo.getAddr2(),vo.getPhone(),vo.getBandate(),false};
			mmf.getMembermodel().addRow(data);
		}
	}
	public void checkListener (ActionListener e)
	{
		mmf.getCheck().addActionListener(e);
	}
	public void exitListener (ActionListener e)
	{
		mmf.getExit().addActionListener(e);
	}
	public void insertListener (ActionListener e)
	{
		mmf.getInsert().addActionListener(e);
	}
	public void deleteListener (ActionListener e)
	{
		mmf.getDelete().addActionListener(e);
	}
	
	public int getId() {
        int row = mmf.getMembertable().getSelectedRow();
        return (int) mmf.getMembertable().getValueAt(row, 0); // 0번 id_num을 return
    }
	

	
}
