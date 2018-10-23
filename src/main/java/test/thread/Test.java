package test.thread;

public class Test extends Thread{
    int ia = 1;

    @Override
    public void run() {

        for(int ib = 0;ib<10;ib++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---->"+ia++);
        }
    }
    public static void main(String[] args){
        Test t1 = new Test();
        Test t2 = new Test();
        t1.start();
        t2.start();
    }
}
