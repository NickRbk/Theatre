package cursor.rybak;

import cursor.rybak.util.TimeOut;

import java.util.concurrent.CountDownLatch;

public class Ring implements Runnable {
    private final static int RING_COUNT = 3;
    private final static int DELAY = 3000;

    private CountDownLatch ring;

    Ring(CountDownLatch ring) {
        this.ring = ring;
    }

    @Override
    public void run() {
        for (int i = 0; i < RING_COUNT; i++) {
            TimeOut.set(
                    String.format("Ring #%d", (RING_COUNT + 1) - (int) ring.getCount()),
                    DELAY
            );
            ring.countDown();
        }
    }
}
