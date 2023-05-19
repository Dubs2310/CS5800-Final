import java.util.ArrayList;
import java.util.List;

public class User extends TweetObservable {
    private String username;
    private String password;
    private List<AuthStrategy> enabledStrategies;
    private List<Tweet> posts = new ArrayList<>();
    private List<TweetObservable> observables = new ArrayList<>();
    private Feed feed = new Feed();

    public User(String username, String password, List<AuthStrategy> enabledStrategies) {
        this.username = username;
        this.password = password;
        this.enabledStrategies = enabledStrategies;
    }

    public String getUsername() { return username; }
    public List<Tweet> getPosts() { return posts; }
    public Feed getFeed() { return feed; }

    public boolean matchCredentials(Credentials credentials) {
        return credentials.getUsername().equals(username) && credentials.getPassword().equals(password);
    }
    
    public boolean authenticate(AuthStrategy strategy) {
        if (enabledStrategies.contains(strategy)) {
            strategy.authenticate(this);
            return true;
        }
        System.out.println("User \"" + username + "\" has not enabled the following strategy: " + strategy.getClass().getSimpleName());
        return false;
    }

    public void addPost(Tweet post) {
        posts.add(post);
    }

//    public void followUser(User user) {
//        if (observables.contains(user)) return;
//        super.addPropertyChangeListener(feed);
//        observables.add(user);
//    }
//
//    public void followHashTag(HashTag hashTag) {
//        if (observables.contains(hashTag)) return;
//        super.addPropertyChangeListener(feed);
//        observables.add(hashTag);
//    }

    public void follow(TweetObservable observable) {
        if (observables.contains(observable)) return;
        observable.addPropertyChangeListener(feed);
        observables.add(observable);
    }
}