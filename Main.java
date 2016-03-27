package test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zachary on 2016/3/26.
 */
public class Main {

    public static void main(String agrs[]) throws InterruptedException {
        List<Worker> workerList = new LinkedList<Worker>();
        Statation statation = new Statation(10);
        for (int i = 0; i < 10; ++i) {
            workerList.add(new Worker(statation,i));
        }
        for(Worker worker:workerList){
            worker.start();
        }

        for(Worker worker:workerList){
            worker.join();
        }

    }

}
