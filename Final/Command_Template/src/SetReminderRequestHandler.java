public class SetReminderRequestHandler extends RequestHandlerTemplate {
    private ReminderSetterReceiver receiver;

    public SetReminderRequestHandler() {
        this.receiver = new ReminderSetterReceiver();
    }

    @Override
    public boolean validateInput(String input) {
        System.out.println("Validating the reminder set for: " + input);
        return true;
    }

    @Override
    public void logRequest(String input) {
        System.out.println("Logging the reminder set at: " + input);
    }

    @Override
    public void notifyUser(String input) {
        System.out.println("Notifying the user that a reminder was set for: " + input);
    }

    @Override
    public void processRequest(String input) {
        super.processRequest(new SetReminderRequest(receiver), input);
    }
}
