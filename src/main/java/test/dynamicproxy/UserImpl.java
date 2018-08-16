package test.dynamicproxy;

public class UserImpl implements UserI{
  @Override
  public void add() {
    System.out.println("-------------"+"add"+"-------------------");
  }
}
