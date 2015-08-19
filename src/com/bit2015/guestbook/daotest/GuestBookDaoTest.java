package com.bit2015.guestbook.daotest;

import java.sql.SQLException;
import java.util.List;

import com.bit2015.guestbook.dao.GuestBookDao;
import com.bit2015.guestbook.vo.GuestBookVo;


public class GuestBookDaoTest {

	public static void main(String[] args) {
		
		try{
		
		
		testGetList();
		
		}catch(SQLException ex){
			System.out.println("DB 에러: "+ex);
		}
	}
	public static void testGetList() throws SQLException{
		GuestBookDao dao = GuestBookDao.getInstance();
		List<GuestBookVo> list = dao.getList();
		
		for(GuestBookVo vo : list){
			System.out.println(vo);
		}
	}
}
