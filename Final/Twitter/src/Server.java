import java.util.HashMap;
import java.util.List;

public class Server {
    private Database database = Database.getInstance();

    private static Server instance = null;
    private Server() {}
    public static Server getInstance() {
        if (instance == null)
            instance = new Server();
        return instance;
    }

    public String authenticate(Credentials credentials, AuthStrategy strategy) {
        User user = database.getUserByCredentials(credentials);
        if (user == null || !user.authenticate(strategy)) return null;
        return user.getUsername();
    }

    public void postTweet(Tweet tweetToPost) {
        String senderUsername = tweetToPost.getSenderUsername();
        User user = database.getUserByUsername(senderUsername);
        user.setLatestTweet(tweetToPost);
        user.addPost(tweetToPost);

        List<String> hashTagNames = tweetToPost.getHashTagNames();
        for (String hashTagName: hashTagNames) {
            HashTag hashTag = database.getOrCreateHashTagByName(hashTagName);
            hashTag.setLatestTweet(tweetToPost);
        }
    }

    public void followUserByUsername(String loggedInUsername, String username) {
        if (loggedInUsername.equals(username)) return;
        User loggedInUser = database.getUserByUsername(loggedInUsername);
        User userToFollow = database.getUserByUsername(username);
        loggedInUser.follow(userToFollow);
    }

    public void followHashTagByName(String loggedInUsername, String hashTagName) {
        User loggedInUser = database.getUserByUsername(loggedInUsername);
        HashTag hashTag = database.getOrCreateHashTagByName(hashTagName);
        loggedInUser.follow(hashTag);
    }
}