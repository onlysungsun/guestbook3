package com.bit2015.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2015.guestbook.vo.GuestBookVo;

public class GuestBookDao {
	private static GuestBookDao instance;
	
	private GuestBookDao(){
		
	}
	public static GuestBookDao getInstance(){
		if(instance == null){
			instance = new GuestBookDao();
		}
		
		return instance;
	}

	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bitdb","bitdb");		
	
		
	}catch(ClassNotFoundException ex){
		System.out.println("???" + ex);
	}
		return conn;
	}
	
	//insert
	public void insert(GuestBookVo vo)throws SQLException{
		Connection conn = getConnection();
		
		String sql="insert into guestbook values (guestbook_seq.nextval, ?,?,?,sysdate)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getMessage());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	

	//delete
	public void delete(long no, String password) throws SQLException{
		
		Connection conn = getConnection();

		
		String sql = "delete from guestbook where no=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setLong(1,no);
		
		pstmt.executeUpdate();

		
		pstmt.close();
		conn.close();		
		
	}
	
	
	//getList
	public List<GuestBookVo> getList() throws SQLException{
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();
		
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "select no,name,password,message,to_char(reg_date, 'YYYY-MM-DD HH:MM:SS') from guestbook order by reg_date desc";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			long no = rs.getLong(1);
			String name = rs.getString(2);
		//	String password = rs.getString(3);
			String message = rs.getString(4);
			String regDate = rs.getString(5);
			
			GuestBookVo vo = new GuestBookVo();
			
			vo.setNo(no);
			vo.setName(name);
			vo.setMessage(message);
			vo.setRegDate(regDate);
			
			list.add(vo);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return list;
		
	}
}
