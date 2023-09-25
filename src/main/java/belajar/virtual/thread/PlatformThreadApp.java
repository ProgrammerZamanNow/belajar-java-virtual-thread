package belajar.virtual.thread;

import java.time.Duration;

public class PlatformThreadApp {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Thread thread = Thread.ofPlatform().name("eko-" + i).daemon(false).unstarted(() -> {
        try {
          Thread.sleep(Duration.ofSeconds(2));
          System.out.println("Hello " + Thread.currentThread() + "!");
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      });

      thread.start();
    }

  }
}
