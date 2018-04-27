package cursor.rybak.util;

public class TimeOut {
    public static void set(String msg, int timeOut) {
        try {
            Thread.sleep(timeOut);
            System.out.println(msg);
        }
        catch (InterruptedException e) { e.printStackTrace();}
    }
}
