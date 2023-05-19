public class Client {
    private String loggedInUsername = null;
    private Server server = Server.getInstance();
    private TweetBuilder builder = null;
    
    public void authenticate(Credentials credentials, AuthStrategy strategy) {
        loggedInUsername = server.authenticate(credentials, strategy);
    }

    public void signOut() {
        loggedInUsername = null;
        builder = null;
    }

    public void startNewTweet() {
        if (loggedInUsername == null) return;
        builder = new TweetBuilder(loggedInUsername);
    }

    public void setContent(String content) {
        if (loggedInUsername == null) return;
        if (builder == null) return;
        builder.setContent(content);
    }

    public void attachImage(String imageName) {
        if (loggedInUsername == null) return;
        if (builder == null) return;
        builder.attachImage(imageName);
    }

    public void attachVideo(String videoName) {
        if (loggedInUsername == null) return;
        if (builder == null) return;
        builder.attachVideo(videoName);
    }

    public void attachAudio(String audioName) {
        if (loggedInUsername == null) return;
        if (builder == null) return;
        builder.attachAudio(audioName);
    }

    public void attachFile(String fileName) {
        if (loggedInUsername == null) return;
        if (builder == null) return;
        builder.attachFile(fileName);
    }

    public void postTweet() {
        if (loggedInUsername == null) return;
        if (builder == null) return;
        Tweet tweetToPost = builder.build();
        server.postTweet(tweetToPost);
        builder = null;
    }

    public void followUserByUsername(String username) {
        if (loggedInUsername == null) return;
        server.followUserByUsername(loggedInUsername, username);
    }

    public void followHashTagByName(String hashTagName) {
        if (loggedInUsername == null) return;
        server.followHashTagByName(loggedInUsername, hashTagName);
    }
}