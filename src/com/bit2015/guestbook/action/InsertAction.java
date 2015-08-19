package com.bit2015.guestbook.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.guestbook.dao.GuestBookDao;
import com.bit2015.guestbook.vo.GuestBookVo;
import com.bit2015.web.action.Action;
import com.bit2015.web.util.WebUtil;

public class InsertAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		try{
		
		String action = request.getParameter("a");
		
		if("insert".equals(action)){
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			
			GuestBookVo vo = new GuestBookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			GuestBookDao dao = GuestBookDao.getInstance();
			dao.insert(vo);
			
			WebUtil.redirect(request, response, "/guestbook2/gb");

	}
		}catch(SQLException ex){
			System.out.println("DB 에러 : "+ ex);
		}
	}
}
