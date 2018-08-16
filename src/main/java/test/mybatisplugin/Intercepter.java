package test.mybatisplugin;

import java.lang.reflect.InvocationTargetException;

public interface Intercepter {
  Object  intercepte(Invocation invocation) throws InvocationTargetException, IllegalAccessException;
  Object plugin(Object target);
  void setProperties();
}
