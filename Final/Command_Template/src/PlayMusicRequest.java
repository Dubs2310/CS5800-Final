public class PlayMusicRequest implements Request {
    private MusicPlayerReceiver receiver;

    public PlayMusicRequest(MusicPlayerReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String input) {
        receiver.playMusic(input);
    }
}
