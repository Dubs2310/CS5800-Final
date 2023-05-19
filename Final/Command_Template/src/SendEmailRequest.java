public class SendEmailRequest implements Request {
    private EmailSenderReceiver receiver;

    public SendEmailRequest(EmailSenderReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String input) {
        receiver.sendEmail(input);
    }
}
