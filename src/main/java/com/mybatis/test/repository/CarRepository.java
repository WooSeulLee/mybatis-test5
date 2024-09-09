package com.mybatis.test.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.test.config.SqlMybatisConfig;
import com.mybatis.test.vo.CarVO;

public class CarRepository {
	
	public List<CarVO> selectCars(CarVO car){
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()){
			return session.selectList("CarMapper.selectCars",car);
		}
	}
	
	public CarVO selectCar(int ciNum) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()){
			return session.selectOne("CarMapper.selectCar",ciNum);
		}
	}
	
	public int insertCar(CarVO car) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.insert("CarMapper.insertCar",car);
		}
	}
	public int updateCar(CarVO car) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.update("CarMapper.updateCar",car);
		}
	}
	public int deleteCar(CarVO car) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.delete("CarMapper.deleteCar",car);
		}
	}
	
	public static void main(String[] args) {
		CarRepository cr = new CarRepository();
		System.out.println(cr.selectCars(new CarVO()));
		System.out.println(cr.selectCar(3));
		
		CarVO car = new CarVO();
		car.setCiName("테라컨");
		car.setCiYear("2222");
		int result = cr.insertCar(car);
		System.out.println(result);
		
		car.setCiNum(10);
		result = cr.updateCar(car);
		System.out.println(result);
		
		result = cr.deleteCar(car);
		System.out.println(result);
	}
}
