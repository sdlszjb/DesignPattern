package cn.kisslinux.soft;

import kisslinux.singletonPattern.NotThreadSafeSingleton;
import kisslinux.singletonPattern.ThreadSafeSingleton;
import org.junit.Test;

public class SingletonTests {

    @Test
    public void testThreadSafeSingleton() throws InterruptedException {
        new Thread(new ThreadSafeRunnable()).start();
        new Thread(new ThreadSafeRunnable()).start();
        new Thread(new ThreadSafeRunnable()).start();
        new Thread(new ThreadSafeRunnable()).start();
        new Thread(new ThreadSafeRunnable()).start();
        
        Thread.sleep(10000);
    }

    @Test
    public void testNotThreadSafeSingleton() throws InterruptedException {
        new Thread(new NotThreadSafeRunnable()).start();
        new Thread(new NotThreadSafeRunnable()).start();
        new Thread(new NotThreadSafeRunnable()).start();
        new Thread(new NotThreadSafeRunnable()).start();
        new Thread(new NotThreadSafeRunnable()).start();

        Thread.sleep(5000);
    }

    @Test
    public void testSyncThreadSafeSingleton() throws InterruptedException {
        new Thread(new SyncThreadSafeRunnable()).start();
        new Thread(new SyncThreadSafeRunnable()).start();
        new Thread(new SyncThreadSafeRunnable()).start();
        new Thread(new SyncThreadSafeRunnable()).start();
        new Thread(new SyncThreadSafeRunnable()).start();
        new Thread(new SyncThreadSafeRunnable()).start();

        Thread.sleep(5000);
    }

    class ThreadSafeRunnable implements Runnable {

        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + ThreadSafeSingleton.getSingleton());
            }
        }
    }

    class NotThreadSafeRunnable implements Runnable {
        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + NotThreadSafeSingleton.getSingleton());
            }
        }
    }

    class SyncThreadSafeRunnable implements Runnable {
        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + NotThreadSafeSingleton.getThreadSafeSingleton());
            }
        }
    }
}
