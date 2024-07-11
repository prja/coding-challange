package prja.leetcode.challange.thread;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;

public class StartAllThreadAtSameTimewithCountDownLatch extends Thread {
    private CountDownLatch latch;

    public StartAllThreadAtSameTimewithCountDownLatch(String name, CountDownLatch latch) {
        this.latch = latch;
        setName(name);
    }

    
    @Override public void run() {
        try {
            System.out.println("created, blocked by the latch..."+getName());
            latch.await();
            System.out.println(getName()+" starts at: %sn"+ Instant.now());
            // do actual work here...
            for(int i=0;i<100;i++) {
            	Thread.sleep(1);
            }
            System.out.println("Thread"+getName()+" finishedd.."  );
           
        } catch (InterruptedException e) {
            // handle exception
        }
    }
    private static void usingCountDownLatch() throws InterruptedException {
	    System.out.println("===============================================");
	    System.out.println("        >>> Starting All Thread at  same time Using CountDownLatch <<<<");
	    System.out.println("===============================================");

	    CountDownLatch latch = new CountDownLatch(1);

	    StartAllThreadAtSameTimewithCountDownLatch worker1 = new StartAllThreadAtSameTimewithCountDownLatch("Worker Thread  1", latch);
	    StartAllThreadAtSameTimewithCountDownLatch worker2 = new StartAllThreadAtSameTimewithCountDownLatch("Worker Thread 2", latch);

	    worker1.start();
	    worker2.start();

	    //Thread.sleep(10);//simulation of some actual work

	    System.out.println("-----------------------------------------------");
	    System.out.println(" Rrelease the latch:");
	    System.out.println("-----------------------------------------------");
	    latch.countDown();
	}
    public static void main(String[] args) throws InterruptedException {
    	usingCountDownLatch();
	}
}