package test.dynamicproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class ProxyGeneratorUtils {
  public static void writeProxyClassToHardDisk(String path) {
    // 第一种方法，这种方式在刚才分析ProxyGenerator时已经知道了
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
  }
  public static void main(String[] args){
    ProxyGeneratorUtils.writeProxyClassToHardDisk("D:/$Proxy11.class");
  }
}
