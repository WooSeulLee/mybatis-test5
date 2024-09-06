package com.mybatis.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.test.service.UserService;
import com.mybatis.test.vo.UserVO;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO user = new UserVO();
		String uiNumStr = request.getParameter("uiNum");
		if(uiNumStr !=null && !"".equals(uiNumStr)) {
			user.setUiNum(Integer.parseInt(uiNumStr));
		}
		user.setUiId(request.getParameter("uiId"));
		user.setUiName(request.getParameter("uiName"));
		
		List<UserVO> users = us.getUsers(user);
		request.setAttribute("users", users);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/user-list.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
