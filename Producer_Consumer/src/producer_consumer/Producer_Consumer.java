
package producer_consumer;

import com.xtel.Producer.Producer;
import com.xtel.consumer.Consummer;
import com.xtel.logger.LoggerClass;
import com.xtel.msQueue.MsQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Tran ngoc Hoi
 * 13/1/2020
 */
public class Producer_Consumer {

    public static void main(String[] args) {
        LoggerClass log = new LoggerClass();
        MsQueue queue = new MsQueue();
        Producer producer = new Producer(log, queue);
        Consummer consummer = new Consummer(log, queue);       
        producer.start();
        consummer.start();
    }
    
}
