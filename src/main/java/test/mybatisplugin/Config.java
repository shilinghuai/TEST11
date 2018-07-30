package test.mybatisplugin;

import java.util.ArrayList;

public class Config {
  public static void main(String[] args) {
    ExecutorImpl executor = new ExecutorImpl();
    IntercepterChain intercepterChain = new IntercepterChain();
    Executor e = (Executor) intercepterChain.plugAll(executor);
    e.add();
  }
}
