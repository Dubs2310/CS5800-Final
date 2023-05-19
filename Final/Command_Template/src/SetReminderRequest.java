public class SetReminderRequest implements Request {
    private ReminderSetterReceiver receiver;

    public SetReminderRequest(ReminderSetterReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String input) {
        receiver.setReminder(input);
    }
}
