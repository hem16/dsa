/*
package org.example.concurrencyconcept.customexecutor;

public class Execution implements Runnable{

    public void myExecuteMethod(){
        if(MyThreadPoolExcecutor.capacity > MyThreadPoolExcecutor.currentCapacity) {
            MyThreadPoolExcecutor.currentCapacity++;
            Thread t = new Thread(new Execution());
            t.start();
        }
    }

    @Override
    public void run() {
        if(MyThreadPoolExcecutor.blockingQueue.size() != 0) {
            MyThreadPoolExcecutor.blockingQueue.poll().run();
        }
    }
}
*/
