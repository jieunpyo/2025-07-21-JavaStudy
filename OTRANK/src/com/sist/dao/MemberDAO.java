package com.sist.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * 	desc 회원목록 결과
 * 이름        널?       유형            
 * --------- -------- ------------- 
 * ID_NUM    NOT NULL NUMBER  
 * NICKNAME  NOT NULL VARCHAR2(30)  
 * LOGIN_ID  NOT NULL VARCHAR2(20)   
 * LOGIN_PWD NOT NULL VARCHAR2(15)  
 * SEX                VARCHAR2(6)   
 * POST      NOT NULL VARCHAR2(15)  
 * ADDR1     NOT NULL VARCHAR2(300) 
 * ADDR2              VARCHAR2(200) 
 * PHONE              VARCHAR2(13)  
 * NAME 	 NOT NULL VARCHAR2(15)
 * 
 * 
 * 
 */
import com.sist.vo.MemberVO;
public class MemberDAO{
	private static MemberDAO dao;
	Connection conn;
	PreparedStatement ps;
	DAOdefault db=new DAOdefault();
	public static MemberDAO newInstance()
	{
		if(dao==null)
			dao=new MemberDAO();
		return dao;
	}
	public List<MemberVO> memberAlldata()
	{
		List<MemberVO> list=new ArrayList<MemberVO>();

		try
		{
			conn=db.getConnection(conn);
			String sql="SELECT 회원목록.Id_num,Login_id,Login_pwd,nickname,sex,post,addr1,NVL(addr2,' '),phone,name,NVL(TO_CHAR(enddate,'YYYY-MM-DD'),' ') as bandate FROM 회원목록,banlist WHERE 회원목록.id_num=banlist.id_num(+)";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				MemberVO vo=new MemberVO();
				vo.setId_num(rs.getInt(1));
				vo.setLogin_id(rs.getString(2));
				vo.setLogin_pwd(rs.getString(3));
				vo.setNickname(rs.getString(4));
				vo.setSex(rs.getString(5));
				vo.setPost(rs.getString(6));
				vo.setAddr1(rs.getString(7));
				vo.setAddr2(rs.getString(8));
				vo.setPhone(rs.getString(9));
				vo.setName(rs.getString(10));
				vo.setBandate(rs.getString(11));
				list.add(vo);
			}
		}catch(Exception ex)
		{
			
		}
		finally
		{
			db.disConnection(conn,ps);
		}
		return list;
	}
	
}
