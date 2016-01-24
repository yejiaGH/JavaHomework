package com.yejia.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Method method = this.getClass().getDeclaredMethod("getModel", null);
			Object ob = method.invoke(this, null);
			Class cl = ob.getClass();
			Field[] fi = cl.getDeclaredFields();
			Enumeration em = req.getParameterNames();
			
			while(em.hasMoreElements()){
			
				String fieldName = em.nextElement().toString();
				System.out.println("fieldName: "+fieldName);
		
				for(int i =0;i<fi.length;i++){
					System.out.println("getName: "+fi[i].getName());
					
					if(fieldName.equals(fi[i].getName())){
						fi[i].setAccessible(true);
				
						fi[i].set(ob, req.getParameter(fieldName));
						
					}
				}
			}
			Method me1 = this.getClass().getDeclaredMethod("execute", null);
			Object url = me1.invoke(this, null);
			req.getRequestDispatcher(String.valueOf(url)).forward(req, resp);
		} catch  (Exception e) {
			e.printStackTrace();
		}
	}
}
