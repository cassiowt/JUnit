package br.com.exemplo;

public class ChatEngine {

    private MessageSender messageSender;


    public ChatEngine(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void say(String messageToSend) {
    }
}
