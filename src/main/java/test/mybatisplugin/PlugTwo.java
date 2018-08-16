package test.mybatisplugin;

import java.lang.reflect.InvocationTargetException;

public class PlugTwo implements Intercepter{
  @Override
  public Object intercepte(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
    System.out.println("PlugTwo==============>");
    return invocation.process();
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.swarp(target,this);
  }

  @Override
  public void setProperties() {

  }
}
