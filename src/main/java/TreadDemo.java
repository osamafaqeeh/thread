import java.util.Map;

public class TreadDemo implements Runnable {
    private int num;


    public TreadDemo(int num){
        this.num=num;
    }

    public void run(){
        while (true){
            this.num++;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( getNum());


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public int getNum() {

        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public void dec(){
        num++;
        notify();
    }
}
class main{
    public static void main(String[] args) throws InterruptedException {
        TreadDemo treadDemo=new TreadDemo(1);
        Thread t=new Thread(treadDemo);
        t.start();
        while (true){
            treadDemo.dec();

            Thread.sleep(1000);
        }
    }
}
