package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadAwaitSignal {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalExample exam = new AwaitSignalExample();
        executorService.execute(() -> exam.after(1));
        executorService.execute(() -> exam.after(2));
        executorService.execute(() -> exam.after(3));
        executorService.execute(() -> exam.after(4));
        executorService.execute(() -> exam.before());
    }
}
// java.util.concurrent类库中提供了Condition类来实现线程之间的协调，可以在Condition上调用await()方法使线程挂起。
// 其他线程可以调用signal()或signalAll()来唤醒等待的线程.
// 使用Lock来获取一个Condition对象
class AwaitSignalExample{

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("before func");
            condition.signalAll();
            // 唤醒挂起的其他线程
        } finally {
            lock.unlock();
        }
    }

    public void after(int num) {
        lock.lock();
        try {
            condition.await();
            System.out.println("after func " + num);
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}