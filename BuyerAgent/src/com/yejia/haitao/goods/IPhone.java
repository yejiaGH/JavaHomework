package com.yejia.haitao.goods;

public class IPhone implements IGoods{

//	商品名称
	private String name;
//	商品价格
	private float price;

	public IPhone(String name, float price){
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public float getPrice(){
		return price;
	}
}
