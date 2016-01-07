package com.yejia.haitao.goods;

public class Channel implements IGoods{
//	商品名称
	private String name;
//	商品价格
	private float price;

	public Channel(String name, float price){
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
