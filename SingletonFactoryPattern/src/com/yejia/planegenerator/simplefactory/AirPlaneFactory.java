package com.yejia.planegenerator.simplefactory;

import com.yejia.planegenerator.airplane.AirPlane;
import com.yejia.planegenerator.airplane.BoyinAirPlane;
import com.yejia.planegenerator.airplane.MaidaoAirPlane;

// AirPlaneFactory是单例类
public class AirPlaneFactory {
	
//	用双重检查加锁法来控制多线程单例的访问
	private volatile static AirPlaneFactory uniqueInstance = null;
	
//	只能从内部调用构造方法
	private AirPlaneFactory(){
		
	}
	
//	调用构造函数
//	用双重检查加锁法来控制多线程单例的访问
	public static AirPlaneFactory getInstance(){
		
		if(uniqueInstance == null){
			synchronized (AirPlaneFactory.class) {
				if(uniqueInstance == null){
					uniqueInstance = new AirPlaneFactory();
				}
			}			
		}
		
		return uniqueInstance;
	}
	
	public AirPlane build(String airPlaneType){
		AirPlane plane = null;
		
		switch (airPlaneType) {
		case "74E":
			plane = new BoyinAirPlane("74E");
			break;
		case "77B":
			plane = new BoyinAirPlane("77B");
			break;
		case "M11":
			plane = new MaidaoAirPlane("M11");
			break;
		case "M82":
			plane = new MaidaoAirPlane("M82");
			break;
		case "M90":
			plane = new MaidaoAirPlane("M90");
			break;
		default:
			break;
		}
		
		return plane;
	}
}
