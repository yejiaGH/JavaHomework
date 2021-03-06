package com.yejia.haitao.buyer;
import com.yejia.haitao.goods.Channel;
import com.yejia.haitao.goods.IGoods;
import com.yejia.haitao.goods.IPhone;

public class RealBuyer implements IBuyer {
//	真实客户的姓名
	private String buyerName;
	
	public RealBuyer(String buyerName) {
		this.buyerName = buyerName;
	}	
	
	public String getBuyerName() {
		return buyerName;
	}
	
//	真实用户请求购买
	@Override
	public void request() {
		System.out.println("我是实真客户:"+buyerName+"，我要海淘！我买了那么多商品，不要羡慕我！\n===============================\n");
//		小明买IPhone
		IGoods iPhone = new IPhone("iPhone6s", 5400.0f);
//		小明买Channel
		IGoods channel = new Channel("Channel", 12000.0f);
//		打印订单
		System.out.println("商品订单信息\n===============================\n"+printOrder(iPhone)+"===============================\n"+printOrder(channel));
	}
	
//	获取商品信息
	private String printOrder(IGoods goods){
		String goodsInfo="";
		goodsInfo += ("商品名称："+ getName(goods)+"\n");
		goodsInfo += ("商品价格："+ getPrice(goods)+"\n");
		return goodsInfo;
	}
	
//	真实用户实现获取海淘商品名称的功能
	private String getName(IGoods goods) {		
		return goods.getName();
	}
	
//	真实用户实现获取海淘商品价格的功能
	private float getPrice(IGoods goods) {		
		return goods.getPrice();
	}
}
