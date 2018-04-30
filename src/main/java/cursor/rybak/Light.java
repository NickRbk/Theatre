package cursor.rybak;

import java.util.concurrent.CountDownLatch;

public class Light implements Runnable {
    private CountDownLatch ring;

    Light(CountDownLatch ring) {
        this.ring = ring;
    }

    @Override
    public void run() {
        System.out.println("Light ON");

        try {
            ring.await();
            System.out.println("Light off...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
