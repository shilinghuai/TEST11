package test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy implements InvocationHandler {
  private Object target;

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("before-----------------add");
    Object result = method.invoke(target,args);
    System.out.println("after-----------------add");
    return result;
  }

  public UserProxy(Object target) {
    this.target = target;
  }
  public Object getProxyInstance(){
    return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
  }
}
