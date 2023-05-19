import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AuthStrategy basic = new BasicAuth();
        AuthStrategy oauth = new OAuth();
        AuthStrategy _2FA = new TwoFactorAuth();

        Database database = Database.getInstance();
        database.addUser(new User("abdullahi", "passwordOne", Arrays.asList(basic, oauth, _2FA)));
        database.addUser(new User("amirm", "passwordTwo", List.of(basic)));
        database.addUser(new User("jahinm", "passwordThree", List.of(oauth)));
        database.addUser(new User("yousufm", "passwordFour", List.of(_2FA)));

        Client client = new Client();
        client.authenticate(new Credentials("amirm", "passwordTwo"), oauth);
        client.authenticate(new Credentials("abdullahi", ""), basic);
        client.authenticate(new Credentials("abdullahi", "passwordOne"), _2FA);

        Client client2 = new Client();
        client2.authenticate(new Credentials("amirm", "passwordTwo"), basic);
        client2.followUserByUsername("abdullahi");

        Client client3 = new Client();
        client3.authenticate(new Credentials("jahinm", "passwordThree"), oauth);
        client3.followHashTagByName("#CSE");

        client.startNewTweet();
        client.setContent("Testing... #CSE #SWE #DESIGN_PATTERNS");
        client.attachImage("image.png");
        client.attachVideo("video.mp4");
        client.attachAudio("audio.mp3");
        client.attachFile("file.txt");
        client.postTweet();

        client.startNewTweet();
        client.setContent("Testing2... #SWE #DESIGN_PATTERNS");
        client.attachImage("image.png");
        client.attachVideo("video.mp4");
        client.attachAudio("audio.mp3");
        client.attachFile("file.txt");
        client.postTweet();

        System.out.println();

        System.out.println("\"abdullahi\" Posts:");
        database.getUserByUsername("abdullahi").getPosts().forEach(System.out::println);

        System.out.println("\"abdullahi\" Feed:");
        database.getUserByUsername("abdullahi").getFeed().getTweets().forEach(System.out::println);
        
        System.out.println("\"amirm\" Posts:");
        database.getUserByUsername("amirm").getPosts().forEach(System.out::println);

        System.out.println("\"amirm\" Feed:");
        database.getUserByUsername("amirm").getFeed().getTweets().forEach(System.out::println);
        
        System.out.println("\"jahinm\" Posts:");
        database.getUserByUsername("jahinm").getPosts().forEach(System.out::println);
        
        System.out.println("\"jahinm\" Feed:");
        database.getUserByUsername("jahinm").getFeed().getTweets().forEach(System.out::println);
    }
}