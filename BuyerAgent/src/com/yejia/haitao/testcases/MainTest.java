package com.yejia.haitao.testcases;
import com.yejia.haitao.buyer.ProxyBuyer;
import com.yejia.haitao.buyer.RealBuyer;
import com.yejia.haitao.goods.Goods;

public class MainTest {
//	客户端调用
	public static void main(String[] args) {
		
//		iPhone商品
		Goods iPhone = new Goods("iPhone6s",5400.0f);
//		channel包包
		Goods channel = new Goods("channel",12000.0f);
//		购物清单
		Goods[] shoppingList = new Goods[]{iPhone,channel};
		
//		真实买家：小明
		RealBuyer xiaoming = new RealBuyer("小明", shoppingList);
//		代理买家：小红
		ProxyBuyer xiaohong = new ProxyBuyer("小红", xiaoming);
//		代理提交购物信息
		xiaohong.request();
	}
}
