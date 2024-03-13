package edu.message.broker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MessageBrokerImpl implements IMessageBroker {

    private ConcurrentMap<String, List<ConsumerCallback>> map;
    private ExecutorService pool;

    public MessageBrokerImpl() {
        map = new ConcurrentHashMap<>();
        pool = Executors.newCachedThreadPool();
    }

    @Override
    public void register(String topic, ConsumerCallback consumer) {
        if (map.containsKey(topic)) {
            map.get(topic).add(consumer);
        } else {
            List<ConsumerCallback> list = new ArrayList<>();
            list.add(consumer);
            map.put(topic, list);
        }
    }

    @Override
    public void send(Message message) {
        String topic = message.getTopic();
        if (map.containsKey(topic)) {
            List<ConsumerCallback> consumers = map.get(topic);
            List<Future<?>> futures = new ArrayList<>();
            consumers.forEach(consumerCallback -> futures.add(pool.submit(() -> consumerCallback.processMessage(message))));
            futures.forEach(future -> {
                try {
                    future.get(5, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
