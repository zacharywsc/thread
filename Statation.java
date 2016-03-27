package test;

import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Zachary on 2016/3/26.
 */
public class Statation {
    AtomicInteger locker;
    final int count;
    ConcurrentHashMap<Worker, Integer> workers = new ConcurrentHashMap<Worker, Integer>();

    public Statation(int count) {
        this.count = count;
        locker = new AtomicInteger(count);
    }

    public void waitWorker(Worker worker) throws InterruptedException {
        int left = locker.decrementAndGet();
        workers.putIfAbsent(worker,1);
        if (left > 0) {
            wait();
        } else {
            for (Worker exist : workers.keySet()) {
                notify();
            }
            locker.set(count);
        }

    }

}
