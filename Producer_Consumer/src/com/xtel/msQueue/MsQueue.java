/*
 *This class is used to storage a message queue for program Producer - Consummer 
 * It provides 2 function : add to queue and poll from queue
 */
package com.xtel.msQueue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Tran Ngoc Hoi
 * 13/1/2020
 */
public class MsQueue {
    int capacity = 10;
    private Queue <String> msQueue;

    public MsQueue() {
        this.msQueue = new LinkedBlockingQueue<>(capacity); 
    }
    /*
        this function is used to add a message to queue
        thread waits if queue is full. 
        thread continue add element if queue has empty index (not full)
    */
    
    public synchronized void put(String mess) throws InterruptedException{
        while (msQueue.size() >= 10){
            wait();
        }
        if(msQueue.size() < 10){
            notifyAll();
        }
        msQueue.add(mess);
        System.out.println("Send : " + mess);     
    }
    
    /*
        Wait when ms queue is empty , thread must be wait. 
        when ms queue has message, thread is notified for read message in queue
    */
    public synchronized String get() throws InterruptedException{
        while(msQueue.isEmpty()){
            wait();
        }
        if(!msQueue.isEmpty()){
           notifyAll();
        }
        return msQueue.poll();
        
    }
}
