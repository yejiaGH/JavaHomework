package com.yejia.haitao.testcases;
import com.yejia.haitao.buyer.IBuyer;
import com.yejia.haitao.buyer.ProxyBuyer;
import com.yejia.haitao.buyer.RealBuyer;

public class MainTest {
//	客户端调用
	public static void main(String[] args) {
		
//		真实买家：小明
		RealBuyer xiaoming = new RealBuyer("小明");
//		代理买家：小红
		IBuyer xiaohong = new ProxyBuyer("小红", xiaoming);
//		代理提交购物信息
		xiaohong.request();
	}
}
