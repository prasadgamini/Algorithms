package edu.message.broker;

public interface ConsumerCallback {
    void processMessage(Message message);
}
