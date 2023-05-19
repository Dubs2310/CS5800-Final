public class PhoneCallRequestHandler extends RequestHandlerTemplate {
    private PhoneDialerReceiver receiver;

    public PhoneCallRequestHandler() {
        this.receiver = new PhoneDialerReceiver();
    }

    @Override
    public boolean validateInput(String input) {
        System.out.println("Validating the following phone number: " + input);
        return true;
    }

    @Override
    public void logRequest(String input) {
        System.out.println("Logging the phone call to: " + input);
    }

    @Override
    public void notifyUser(String input) {
        System.out.println("Notifying the user that a phone call was made to: " + input);
    }

    @Override
    public void processRequest(String input) {
        super.processRequest(new PhoneCallRequest(receiver), input);
    }
}