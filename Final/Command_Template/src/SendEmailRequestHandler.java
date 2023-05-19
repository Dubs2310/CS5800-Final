public class SendEmailRequestHandler extends RequestHandlerTemplate {
    private EmailSenderReceiver receiver;

    public SendEmailRequestHandler() {
        this.receiver = new EmailSenderReceiver();
    }

    @Override
    public boolean validateInput(String input) {
        System.out.println("Validating the email sent to: " + input);
        return true;
    }

    @Override
    public void logRequest(String input) {
        System.out.println("Logging the email sent to: " + input);
    }

    @Override
    public void notifyUser(String input) {
        System.out.println("Notifying the user that an email was sent to: " + input);
    }

    @Override
    public void processRequest(String input) {
        super.processRequest(new SendEmailRequest(receiver), input);
    }
}
