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
import com.mybatis.test.util.CMDUtil;
import com.mybatis.test.vo.UserVO;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = CMDUtil.getCmd(uri);
		
		if("user-list".equals(cmd)) {
		UserVO user = new UserVO();
		String uiNumStr = request.getParameter("uiNum");
		if(uiNumStr !=null && !"".equals(uiNumStr)) {
			user.setUiNum(Integer.parseInt(uiNumStr));
		}
		user.setUiId(request.getParameter("uiId"));
		user.setUiName(request.getParameter("uiName"));
		
		List<UserVO> users = us.getUsers(user);
		request.setAttribute("users", users);
		
		}else if("user-view".equals(cmd) || "user-update".equals(cmd)) {
			String uiNumStr = request.getParameter("uiNum");
			int uiNum = Integer.parseInt(uiNumStr);
			UserVO user = us.getUser(uiNum);
			request.setAttribute("user", user);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri+ ".jsp");
		rd.forward(request, response);
	}
		
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CMDUtil.getCmd(request.getRequestURI());
		UserVO user = new UserVO();
		String uiNumStr = request.getParameter("uiNum");
		if(uiNumStr != null && !"".equals(uiNumStr)) {
			user.setUiNum(Integer.parseInt(uiNumStr));
		}
		user.setUiName(request.getParameter("uiName"));
		user.setUiId(request.getParameter("uiId"));
		user.setUiPwd(request.getParameter("uiPwd"));
		user.setUiGender(request.getParameter("uiGender"));
		user.setUiBirth(request.getParameter("uiBirth"));
		user.setUiHobby(request.getParameter("uiHooby"));
		user.setUiDesc(request.getParameter("uiDesc"));
		String msg="";
		String uri="";
		if("user-insert".equals(cmd)) {
			msg="등록에 실패하였습니다";
			uri="/view/user/user-insert";
			int result = us.insertUser(user);
			if(result == 1) {
				msg = "등록에 성공했습니다.";
				uri="/user/user-list";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("uri", uri);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
		}else if("user-update".equals(cmd)) {
			msg = "유저 정보 수정이 실패 하였습니다.";
			uri = "/views/user/user-update?uiNum=" + uiNumStr;
			
			int result = us.updateUser(user);
			if(result==1) {
				msg = "유저 정보 수정이 성공 하였습니다.";
				uri = "/user/user-view?uiNum=" + uiNumStr;
			}
		
		}else if("user-delete".equals(cmd)) {
			msg = "유저 정보 삭제가 실패 하였습니다.";
			uri = "/views/user/user-update?uiNum=" + uiNumStr;
			
			int result = us.deleteUser(user);
			if(result==1) {
				msg = "유저 정보가 삭제되었습니다.";
				uri = "/user/user-list";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("uri", uri);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		rd.forward(request, response);

	}
}
