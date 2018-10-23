package test.thread;

public class TestTread {
    int ib = 1;
    public static void main(String[] args){
        TestTread t = new TestTread();
        for(int ia = 1;ia<1000;ia++){
            t.beganThread();
        }
        System.out.println(t.ib);
    }
    public  void beganThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ib++;
            }
        }).start();
    }

}
