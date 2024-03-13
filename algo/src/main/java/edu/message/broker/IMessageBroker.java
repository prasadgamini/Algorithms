package edu.message.broker;

/**
 * Navan interview question
 * 03/11/2024 Oleg Koyfman (Staff Software Engineer)
 */
public interface IMessageBroker {
    void register(String topic, ConsumerCallback consumer);
    void send(Message message);
}
