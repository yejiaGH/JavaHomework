package com.yejia.planegenerator.airplane;

//各种类型的飞机要实现共同的接口IAirPlane
public interface IAirPlane {
	//	获取飞机型号的方法
	abstract String getAirPlaneType();
	//	输出飞机型号的方法
	abstract void printAirPlaneType();
}
