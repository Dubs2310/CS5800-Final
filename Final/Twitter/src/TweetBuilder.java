import java.util.ArrayList;
import java.util.List;

public class TweetBuilder {
    private String senderUsername;
    private String content = "";
    private List<Media> attachments = new ArrayList<>();

    public TweetBuilder(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public TweetBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public TweetBuilder attachImage(String imageName) {
        attachments.add(new Media(imageName, MediaType.IMAGE));
        return this;
    }

    public TweetBuilder attachVideo(String videoName) {
        attachments.add(new Media(videoName, MediaType.VIDEO));
        return this;
    }

    public TweetBuilder attachAudio(String audioName) {
        attachments.add(new Media(audioName, MediaType.AUDIO));
        return this;
    }

    public TweetBuilder attachFile(String fileName) {
        attachments.add(new Media(fileName, MediaType.FILE));
        return this;
    }

    public Tweet build() {
        return new Tweet(
                senderUsername,
                content,
                attachments
        );
    }
}
