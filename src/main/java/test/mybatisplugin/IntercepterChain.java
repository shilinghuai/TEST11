package test.mybatisplugin;

import java.util.ArrayList;

public class IntercepterChain {
  private ArrayList<Intercepter> intercepters = new ArrayList<>();
  public Object plugAll(Object object){
    PlugOne plugOne = new PlugOne();
    PlugTwo plugTwo = new PlugTwo();
    intercepters.add(plugOne);
    intercepters.add(plugTwo);
    for (Intercepter intercepter:intercepters
         ) {
      object = intercepter.plugin(object);
    }
    return object;
  }
}
