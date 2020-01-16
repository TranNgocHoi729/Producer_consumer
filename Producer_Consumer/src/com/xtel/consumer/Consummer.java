package com.xtel.consumer;

import com.xtel.logger.LoggerClass;
import com.xtel.msQueue.MsQueue;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Ngoc Hoi
 * 13/1/2020
 */
public class Consummer extends Thread {

    private LoggerClass log;
    MsQueue queue;

    public Consummer(LoggerClass log, MsQueue queue) {
        this.log = log;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String mess;
            try {
                mess = queue.get();
                System.out.println("receive : "+ mess);
            } catch (InterruptedException ex) {
                log.getLogger().error(ex);
            }

            sleeps();
        }
    }

    public void sleeps() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            log.getLogger().error(ex);
        }
    }
}
