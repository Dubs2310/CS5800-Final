public class DigitalAssistantApp {
    private RequestHandlerTemplate phoneCall = new PhoneCallRequestHandler();
    private RequestHandlerTemplate sendEmail = new SendEmailRequestHandler();
    private RequestHandlerTemplate playMusic = new PlayMusicRequestHandler();
    private RequestHandlerTemplate setReminder = new SetReminderRequestHandler();

    public void processPhoneCallRequest(String phoneNumber) {
        phoneCall.processRequest(phoneNumber);
        System.out.println();
    }

    public void processSendEmailRequest(String email) {
        sendEmail.processRequest(email);
        System.out.println();
    }

    public void processPlayMusicRequest(String music) {
        playMusic.processRequest("Jazz");
        System.out.println();
    }

    public void processSetReminderRequest(String time) {
        setReminder.processRequest("6:00 am");
        System.out.println();
    }
}