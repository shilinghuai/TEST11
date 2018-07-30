package test.mybatisplugin;

import jdk.internal.dynalink.beans.StaticClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Plugin implements InvocationHandler{
  private Object target;
  private Intercepter intercepter;
  public Plugin(Object target,Intercepter intercepter){
    this.target = target;
    this.intercepter = intercepter;
  }
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    return intercepter.intercepte(new Invocation(target,method,args));
  }
  public static Object swarp(Object target, Intercepter intercepter){
    return  Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new Plugin(target,intercepter));
  }

}
