public class PhoneCallRequest implements Request {
    private PhoneDialerReceiver receiver;

    public PhoneCallRequest(PhoneDialerReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String input) {
        receiver.makePhoneCall(input);
    }
}

