package com.yejia.haitao.buyer;

//代理海淘买家
public class ProxyBuyer implements IBuyer{
	// 以真实角色作为代理角色的属性
	private RealBuyer realBuyer;
	private String proxyBuyerName; 

	public ProxyBuyer(String proxyBuyerName, RealBuyer realBuyer){
		this.proxyBuyerName = proxyBuyerName;
		this.realBuyer = realBuyer;
	}

	// 该方法封装了真实对象的request方法,请求购买行为
	@Override	
	public void request() {
		System.out.println("我是代购，我叫"+proxyBuyerName+"。我替"+realBuyer.getBuyerName()+"购买以下商品。");
		realBuyer.request();// 此处执行真实对象的request方法
	}
}
