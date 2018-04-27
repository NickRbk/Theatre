package cursor.rybak;

import java.util.concurrent.CountDownLatch;

public class Actor implements Runnable {

    private CountDownLatch ring;

    Actor(CountDownLatch ring) {
        this.ring = ring;
    }

    @Override
    public void run() {
        System.out.println("Actor behind the scene, is preparing to spectacle!");

        try {
            ring.await();
            System.out.println("Actor appears on scene...");
        } catch (InterruptedException e) {e.printStackTrace();}
    }
}
