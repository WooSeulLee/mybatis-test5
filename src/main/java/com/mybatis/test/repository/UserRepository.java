package com.mybatis.test.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.test.config.SqlMybatisConfig;
import com.mybatis.test.vo.UserVO;

public class UserRepository {
	public List<UserVO> selectUsers(UserVO user){
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()){
			return session.selectList("UserMapper.selectUsers",user);
		}
	}
	public static void main(String[] args) {
		UserRepository ur = new UserRepository();
		System.out.println(ur.selectUsers(null));
	}
}
