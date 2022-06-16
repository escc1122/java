package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                e1.func2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                e2.func2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
class SynchronizedExample {

    public void func2() throws InterruptedException {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 10; i++) {
                Thread.sleep((int)(Math.random()*1000));
                System.out.print(i + " ");
            }
        }
    }
}
