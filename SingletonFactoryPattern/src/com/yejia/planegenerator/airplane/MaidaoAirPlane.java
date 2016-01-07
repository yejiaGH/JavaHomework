package com.yejia.planegenerator.airplane;

//麦道飞机
public class MaidaoAirPlane  extends AirPlane implements IAirPlane{
//	类成员：型号
	private String AirPlaneType;

	//	构造函数继承父类的构造函数
	public MaidaoAirPlane(String AirPlaneType){
		super();
		this.AirPlaneType = AirPlaneType;
	}

	@Override
	public String getAirPlaneType() {
		return "麦道"+this.AirPlaneType;
	}

	@Override
	public void printAirPlaneType() {
		System.out.println("麦道公司生产的飞机型号："+this.getAirPlaneType());		
	}
}
