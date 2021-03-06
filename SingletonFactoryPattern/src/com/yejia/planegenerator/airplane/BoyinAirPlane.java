package com.yejia.planegenerator.airplane;

//波音飞机
public class BoyinAirPlane extends AirPlane implements IAirPlane{
	//	类成员：型号
	private String AirPlaneType;

	//	构造函数继承父类的构造函数
	public BoyinAirPlane(String AirPlaneType){
		super();
		this.AirPlaneType = AirPlaneType;
	}

	@Override
	public String getAirPlaneType() {
		return "波音"+AirPlaneType;
	}
	
	@Override
	public void printAirPlaneType() {
		System.out.println("波音公司生产的飞机型号："+this.getAirPlaneType());		
	}
}
