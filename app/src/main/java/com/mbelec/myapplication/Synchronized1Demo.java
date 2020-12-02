package com.mbelec.myapplication;

import android.util.Log;

public class Synchronized1Demo implements TestDemo  {
//  private AtomicBoolean running = new AtomicBoolean(true);
  private boolean running = true;

  private void stop() {
//    running.set(false);
    running = false;
  }

  @Override
  public void runTest() {
    new Thread() {
      @Override
      public void run() {
        while (running) {
          Log.e("test", "running");
        }
      }
    }.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    stop();
  }
}
