package com.mybatis.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.test.service.MovieService;
import com.mybatis.test.vo.MovieVO;

@WebServlet("/MovieSerVlet")
public class MovieSerVlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieService ms = new MovieService();
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		
		if("movie-list".equals(cmd)) {
			MovieVO movie = new MovieVO();
			String miNumStr = request.getParameter("miNum");
			if(miNumStr != null && !"".equals(miNumStr)) {
				movie.setMiNum(Integer.parseInt(miNumStr));
			}
			movie.setMiName(request.getParameter("miName"));
			movie.setMiDirector(request.getParameter("miDirector"));
			movie.setMiGenre(request.getParameter("miGenre"));
			movie.setMiYear(request.getParameter("miYear"));
			
			List<MovieVO> movies = ms.getMovies(movie);
			request.setAttribute("movis", movies);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/movie/movie-list.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
