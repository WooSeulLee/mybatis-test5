package com.mybatis.test.service;

import java.util.List;

import com.mybatis.test.repository.CarRepository;
import com.mybatis.test.vo.CarVO;

public class CarService {
	private CarRepository cr = new CarRepository();
	
	public List<CarVO> getCars(CarVO car){
		return cr.selectCars(car);
	}
	
	public CarVO getCar(int ciNum) {
		return cr.selectCar(ciNum);
	}
	
	public int insertCar(CarVO Car) {
		return cr.insertCar(Car);
	}
	
	public int updateCar(CarVO Car) {
		return cr.updateCar(Car);
	}
	
	public int deleteCar(CarVO Car) {
		return cr.deleteCar(Car);
	}
}