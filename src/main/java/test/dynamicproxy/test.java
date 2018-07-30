package test.dynamicproxy;

public class test {
  public static void main(String[] args){
    UserImpl userImpl = new UserImpl();
    UserProxy userProxy = new UserProxy(userImpl);
    UserI user = (UserI) userProxy.getProxyInstance();
    user.add();
  }
}
