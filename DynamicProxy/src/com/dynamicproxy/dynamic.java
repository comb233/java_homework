package com.dynamicproxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class dynamic  implements InvocationHandler {

	private Object proxied;
	public dynamic(Object proxied) {
		// TODO �Զ����ɵĹ��캯�����
		this.proxied=proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO �Զ����ɵķ������
		method.invoke(this.proxied, args);
		return null;
	}
	
	
}
