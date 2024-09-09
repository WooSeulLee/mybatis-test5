package com.mybatis.test.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.test.config.SqlMybatisConfig;
import com.mybatis.test.vo.MovieVO;

public class MovieRepository {

	public List<MovieVO> selectMovies(MovieVO movies){
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()){
			return session.selectList("MovieMapper.selectMovies", movies);
		}
	}
}
