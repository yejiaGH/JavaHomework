package com.yejia.planegenerator.test;

import com.yejia.planegenerator.airplane.AirPlane;
import com.yejia.planegenerator.simplefactory.AirPlaneFactory;

// 测试代码类
public class TestCases {

	public static void main(String[] args) {

		AirPlaneFactory factory = AirPlaneFactory.getInstance();
		//		生产飞机的类型
		String types[] = {"74E","77B","M11","M82","M90"};
		for(int i=0; i<types.length;i++){
			AirPlane plane = factory.build(types[i]);
			plane.printAirPlaneType();
		}
	}

}
