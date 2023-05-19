public class Main {
    public static void main(String[] args) {
        DigitalAssistantApp assistant = new DigitalAssistantApp();
        assistant.processPhoneCallRequest("943-324-6456");
        assistant.processSendEmailRequest("johndoe@gmail.com");
        assistant.processPlayMusicRequest("Jazz");
        assistant.processSetReminderRequest("6:00 am");
    }
}