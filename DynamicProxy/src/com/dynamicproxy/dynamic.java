package com.dynamicproxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class dynamic  implements InvocationHandler {

	private Object proxied;
	public dynamic(Object proxied) {
		// TODO 自动生成的构造函数存根
		this.proxied=proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO 自动生成的方法存根
		method.invoke(this.proxied, args);
		return null;
	}
	
	
}
