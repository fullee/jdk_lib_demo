package thread;

/**
 * 继承Thread实现多线程
 */
public class SimpleThread extends Thread{

    public static void main(String[] args) {
        new SimpleThread("A").start();
        new SimpleThread("B").start();
    }

    private String name;

    public SimpleThread() {
    }

    public SimpleThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println(name + "运行 "+i);
        }
    }
}
