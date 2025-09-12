package com.sist.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sist.vo.MemberVO;
import com.sist.vo.ZipcodeVO;
/*
 *   이름        널?       유형            
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
 */
public class JoinDAO {
	private static JoinDAO dao;
	Connection conn;
	PreparedStatement ps;
	DAOdefault db=new DAOdefault();
	public static JoinDAO newInstance()
	{
		if(dao==null)
			dao=new JoinDAO();
		return dao;
	}

	   // 1. 아이디 중복 체크 
	   public int memberIdCheck(String id)
	   {
		   int count=0;
		   try
		   {
			   String sql="SELECT COUNT(*) "
					     +"FROM project_member "
					     +"WHERE id=?";
			   ps=conn.prepareStatement(sql);
			   // ?에 값을 채운다 
			   ps.setString(1, id);
			   // 결과값 받기 
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   count=rs.getInt(1);
			   rs.close();
			}catch(Exception ex)
			{
				
			}
			finally
			{
				db.disConnection(conn,ps);
			}
		   return count;
	   }
	// 2. 닉네임 중복 체크 
	   public int memberNicknameCheck(String nickname)
	   {
		   int count=0;
		   try
		   {
			   String sql="SELECT COUNT(*) "
					     +"FROM project_member "
					     +"WHERE nickname=?";
			   ps=conn.prepareStatement(sql);
			   // ?에 값을 채운다 
			   ps.setString(1, nickname);
			   // 결과값 받기 
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   count=rs.getInt(1);
			   rs.close();
			}catch(Exception ex)
			{
				
			}
			finally
			{
				db.disConnection(conn,ps);
			}
		   return count;
	   }
	   // 3. 우편번호 검색 
	   public List<ZipcodeVO> postFind(String dong)
	   {
		   List<ZipcodeVO> list=
				   new ArrayList<ZipcodeVO>();
		   try
		   {
			   String sql="SELECT zipcode,sido,gugun,dong,"
					     +"NVL(bunji,' ') "
					     +"FROM zipcode "
					     +"WHERE dong LIKE '%'||?||'%'";
			   // 오라클SQL != 자바SQL => LIKE
			   ps=conn.prepareStatement(sql);
			   // ?에 값을 채운다 
			   ps.setString(1, dong);
			   // 결과값 받기 
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   ZipcodeVO vo=new ZipcodeVO();
				   vo.setZipcode(rs.getString(1));
				   vo.setSido(rs.getString(2));
				   vo.setGugun(rs.getString(3));
				   vo.setDong(rs.getString(4));
				   vo.setBunji(rs.getString(5));
				   list.add(vo);
			   }
			   rs.close();
			}catch(Exception ex)
			{
				
			}
			finally
			{
				db.disConnection(conn,ps);
			}
		   return list;
	   }
	   public int postFindCount(String dong)
	   {
		   // count=0 => 검색 결과가 없다 
		   int count=0;
		   try
		   {
			   String sql="SELECT COUNT(*) "
					     +"FROM zipcode "
					     +"WHERE dong LIKE '%'||?||'%'";
			   // 오라클SQL != 자바SQL => LIKE
			   ps=conn.prepareStatement(sql);
			   // ?에 값을 채운다 
			   ps.setString(1, dong);
			   // 결과값 받기 
			   ResultSet rs=ps.executeQuery();
			   count=rs.getInt(1);
			   rs.close();
			}catch(Exception ex)
			{
				
			}
			finally
			{
				db.disConnection(conn,ps);
			}
		   return count;
	   }
	   // 4. 전화번호 검색 => PRIMARY KEY , UNIQUE (NULL 허용) 
	   // ID를 모를 경우 => 전화번호로 찾는다 
	   public int memberPhoneCheck(String value, String tag)
	   {
		   int count=0;
		   try
		   {
			   String sql="SELECT COUNT(*) "
					     +"FROM 회원목록 "
					     +"WHERE "+tag+"=?";
			   ps=conn.prepareStatement(sql);
			   // ?에 값을 채운다 
			   ps.setString(1, value);
			   // 결과값 받기 
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   count=rs.getInt(1);
			   rs.close();
			}catch(Exception ex)
			{
				
			}
			finally
			{
				db.disConnection(conn,ps);
			}
		   return count;
	   }
	   // 5. 회원가입 => 회원 수정 => 회원 정보 출력 => 회원 탈퇴
	   /*
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
	    */
	   public int memberJoin(MemberVO vo)
	   {
		   int result=0;
		   try
		   {
			   String sql="INSERT INTO project_member "
					     +"VALUES(회원목록_id_num_seq.nextval,?,?,?,?,?,?,?,?,?)";
			   ps=conn.prepareStatement(sql);
			   //?에 값을 채운다 
			   ps.setString(1, vo.getNickname());
			   ps.setString(2, vo.getLogin_id());
			   ps.setString(3, vo.getLogin_pwd());
			   ps.setString(4, vo.getSex());
			   ps.setString(5, vo.getPost());
			   
			   ps.setString(6, vo.getAddr1());
			   ps.setString(7, vo.getAddr2());
			   ps.setString(8, vo.getPhone());
			   ps.setString(9, vo.getName());
			   ps.executeUpdate();
			}catch(Exception ex)
			{
				
			}
			finally
			{
				db.disConnection(conn,ps);
			}
		   return result;
	   }
	}
