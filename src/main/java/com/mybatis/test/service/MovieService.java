package com.mybatis.test.service;

import java.util.List;

import com.mybatis.test.repository.MovieRepository;
import com.mybatis.test.vo.MovieVO;

public class MovieService {
	private MovieRepository mr = new MovieRepository();
	
	public List<MovieVO> getMovies(MovieVO movie){
		return mr.selectMovies(movie);
	}
}
