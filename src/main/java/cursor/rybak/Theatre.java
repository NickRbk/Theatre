package cursor.rybak;

import java.util.concurrent.CountDownLatch;

public class Theatre {
    private Thread ring;
    private Thread music;
    private Thread light;
    private Thread actor;

    private CountDownLatch ringCount = new CountDownLatch(3);

    Theatre() {
        setThreads();
    }

    public void startSpectacle() {
        light.start();
        ring.start();
        music.start();
        actor.start();

        try {
            actor.join();
        } catch (InterruptedException e) {e.printStackTrace();};
    }

    private void setThreads() {
        this.ring = new Thread(new Ring(ringCount));
        this.music = new Thread(new Music(ringCount));
        this.light = new Thread(new Light(ringCount));
        this.actor = new Thread(new Actor(ringCount));
    }
}
