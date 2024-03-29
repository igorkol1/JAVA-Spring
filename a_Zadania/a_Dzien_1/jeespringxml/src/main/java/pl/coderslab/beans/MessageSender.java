package pl.coderslab.beans;

public class MessageSender {

    MessageService messageService;
    String message;

    public MessageSender(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendMessage() {
        messageService.send();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendMessageFromProperty(){
        messageService.send(message);
    }
}
