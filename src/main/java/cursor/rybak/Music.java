package cursor.rybak;

import java.util.concurrent.CountDownLatch;

public class Music implements Runnable {

    private CountDownLatch ring;

    Music(CountDownLatch ring) {
        this.ring = ring;
    }

    @Override
    public void run() {
        System.out.println("Music OFF");

        try {
            ring.await();
            System.out.println("Music on...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
