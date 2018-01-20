package thread;

public class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<3;i++) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + " 售票：" + count--);
            }
        }
    }

    private int count= 10;
}

class Test{
    public static void main(String[] args) {
        SimpleRunnable sr = new SimpleRunnable();
        new Thread(sr, "窗口1").start();
        new Thread(sr, "窗口2").start();
        new Thread(sr, "窗口3").start();


        Thread t1 = new Thread(sr, "窗口4");
        System.out.println(t1.isAlive());
        t1.start();
        try {
            //https://www.cnblogs.com/techyc/p/3286678.html
            t1.join(); // 主线程阻塞，执行完t1线程后再回到主线程，因此t1.isAlive()显示false


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.isAlive());
    }

    public void w() throws InterruptedException {
        wait(); // t1.join();最终通过调用主线程wait();
    }
}
