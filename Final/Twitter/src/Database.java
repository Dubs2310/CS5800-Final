import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users = new ArrayList<>();
    private List<HashTag> hashTags = new ArrayList<>();

    private static Database instance = null;
    private Database() {}
    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }
    public void addHashTag(HashTag hashTag) {
        hashTags.add(hashTag);
    }

    public User getUserByCredentials(Credentials credentials) {
        for (User user: users)
            if (user.matchCredentials(credentials))
                return user;
        System.out.println("Incorrect Username or Password!");
        return null;
    }

    public User getUserByUsername(String senderUsername) {
        for (User user: users)
            if (user.getUsername().equals(senderUsername))
                return user;
        return null;
    }

    public HashTag getOrCreateHashTagByName(String hashTagName) {
        for (HashTag hashTag: hashTags)
            if (hashTag.getName().equals(hashTagName))
                return hashTag;

        HashTag hashTag = new HashTag(hashTagName);
        addHashTag(hashTag);
        return hashTag;
    }
}