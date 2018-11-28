package com.dragon.rabbitmq;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by huangzhibo on 22/03/2017.
 */
public class QueueConsumer extends EndPoint implements Runnable, Consumer {

    public QueueConsumer(String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }
    @Override
    public void run(){
        try {
            channel.basicConsume(endPointName, true, this);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer " + consumerTag + " registered");
    }
    @Override
    public void handleDelivery(String consumerTag, Envelope env, BasicProperties props, byte[] body) throws IOException {
        Map map = (HashMap) SerializationUtils.deserialize(body);
        System.out.println("Message Number "+ map.get("message number") + " received.");
    }
    @Override
    public void handleCancel(String consumerTag){}
    @Override
    public void handleCancelOk(String consumerTag) {}
    @Override
    public void handleRecoverOk(String consumerTag) {}
    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {}
}
