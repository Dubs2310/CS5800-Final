public class PlayMusicRequestHandler extends RequestHandlerTemplate {
    private MusicPlayerReceiver receiver;

    public PlayMusicRequestHandler() {
        this.receiver = new MusicPlayerReceiver();
    }

    @Override
    public boolean validateInput(String input) {
        System.out.println("Validating the following music selection: " + input);
        return true;
    }

    @Override
    public void logRequest(String input) {
        System.out.println("Logging the request to play the following music: " + input);
    }

    @Override
    public void notifyUser(String input) {
        System.out.println("Notifying the user that following music was played: " + input);
    }

    @Override
    public void processRequest(String input) {
        super.processRequest(new PlayMusicRequest(receiver), input);
    }
}
