package com.yejia.haitao.buyer;
import com.yejia.haitao.goods.Goods;

public class RealBuyer implements IBuyer {
//	真实客户的姓名
	private String buyerName;
//	海淘购物清单
	private Goods[] shoppingList;
	
	public RealBuyer(String buyerName, Goods[] shoppingList) {
		this.buyerName = buyerName;
		this.shoppingList = shoppingList;
	}	
	
	public String getBuyerName() {
		return buyerName;
	}
	
//	真实用户请求购买
	@Override
	public void request() {
		System.out.println("我是实真客户:"+buyerName+"，我要海淘！\n===============================\n");
		System.out.println("商品订单信息\n===============================\n"+getInfo());
	}
	
//	获取商品信息
	private String getInfo(){
		String goodsInfo="";
		for(int i = 0; i<shoppingList.length; i++){
			goodsInfo += ("商品名称："+ getName(shoppingList[i])+"\n");
			goodsInfo += ("商品价格："+ getPrice(shoppingList[i])+"\n");
			goodsInfo += "===============================\n";
		}
		return goodsInfo;
	}
//	真实用户实现获取海淘商品名称的功能
	private String getName(Goods goods) {		
		return goods.getName();
	}
//	真实用户实现获取海淘商品价格的功能
	private float getPrice(Goods goods) {		
		return goods.getPrice();
	}
}
