package edu.message.broker;

import org.junit.Test;

import static org.junit.Assert.*;


public class MessageBrokerImplTest {

    @Test
    public void testMessageBrokerImpl() {
        IMessageBroker broker = new MessageBrokerImpl();
        ConsumerCallback consumer1 = message -> {

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1 - " + message.getTopic() + " - " + message.getContent());
        };
        ConsumerCallback consumer2 = message -> {
            System.out.println("2 - " + message.getTopic() + " - " + message.getContent());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ConsumerCallback consumer3 = message -> {
            System.out.println("3 - " + message.getTopic() + " - " + message.getContent());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        };

        broker.register("A", consumer1);

        broker.register("B", consumer2);
        broker.register("B", consumer3);

        broker.register("A", consumer3);
        broker.register("B", consumer3);
        broker.register("C", consumer3);

        // A -> 1,3 ;;  B -> 2,3 ;; C -> 3

        broker.send(new Message("A", "HI - A"));
        broker.send(new Message("B", "HI - B"));
        broker.send(new Message("C", "HI - C"));



    }
}