package com.xtel.Producer;

import com.xtel.logger.LoggerClass;
import com.xtel.msQueue.MsQueue;
import java.nio.charset.Charset;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Ngoc Hoi
 * 13/1/2020
 */
public class Producer extends Thread{

    
     private LoggerClass log;
    MsQueue queue;

    public Producer(LoggerClass log, MsQueue queue) {
        this.log = log;
        this.queue = queue;
    }
    

    @Override
    public void run() {
        while (true) {            
            try {
                String mess = getRandomString();
                queue.put(mess);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
            sleeps();
        }
    }

    /*
        this mehod creates a random String with maximum legth is 15
    */
    public static String getRandomString() {
        byte[] array = new byte[15]; 
        Random r = new Random();
        r.nextBytes(array);
        String generatedString = new String(array, Charset.forName("ASCII"));
        return generatedString;
    }

    public void sleeps() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            log.getLogger().error(ex);
        }
    }

}
