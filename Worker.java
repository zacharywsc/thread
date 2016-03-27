package test;

import java.util.List;

/**
 * Created by Zachary on 2016/3/26.
 */
public class Worker extends Thread {
    Statation statation;
    final int waitSecondes;

    public Worker(Statation statation, int waitSecondes) {
        this.statation = statation;
        this.waitSecondes = waitSecondes;
    }

    public void run() {

        try {
            synchronized (this){
                statation.waitWorker(this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void process() throws InterruptedException {
        for(int i=0;i<waitSecondes;++i ){
            Thread.sleep(500);
            System.out.print(this.toString()+"："+String.valueOf(i));
        }
    }


}
