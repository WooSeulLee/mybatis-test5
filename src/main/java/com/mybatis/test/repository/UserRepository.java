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
	
	public UserVO selectUser(int uiNum){
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()){
			return session.selectOne("UserMapper.selectUser",uiNum);
		}
	}
	
	public int insertUser(UserVO user) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.insert("UserMapper.insertUser",user);
		}
	}
	
	public int updateUser(UserVO user) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.update("UserMapper.updateUser",user);
		}
	}
	public int deleteUser(UserVO user) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.delete("UserMapper.deleteUser",user);
		}
	}
	
	public static void main(String[] args) {
		UserRepository ur = new UserRepository();
		System.out.println(ur.selectUsers(null));
		
		UserVO user = new UserVO();
		user.setUiName("으아아");
		user.setUiId("이우슬");
		user.setUiPwd("234");
		user.setUiGender("2");
		user.setUiBirth("19980430");
		user.setUiHobby("자전거");
		user.setUiDesc("안녕");
		
		int result = ur.insertUser(user);
		System.out.println(result);
		
		user.setUiNum(2);
		result = ur.updateUser(user);
		System.out.println(result);
		
		result = ur.deleteUser(user);
		System.out.println(result);
	}
	
	
}
