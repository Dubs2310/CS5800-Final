import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tweet {
    private String senderUsername;
    private String timestamp;
    private String content;
    private List<Media> attachments;

    public Tweet(String senderUsername, String content, List<Media> attachments) {
        this.senderUsername = senderUsername;
        this.timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.content = content;
        this.attachments = attachments;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public List<String> getHashTagNames() {
        Pattern pattern = Pattern.compile("(?:\\s|^)(?:#(?!(?:\\d+|\\w+?_|_\\w*?)(?:\\s|$)))(\\w+)(?=\\s|$)");
        Matcher matcher = pattern.matcher(content);
        List<String> hashTagNames = new ArrayList<>();
        while (matcher.find())
            hashTagNames.add(matcher.group().trim());
        return hashTagNames;
    }

    @Override
    public String toString() {
        return "Tweet by \"" + senderUsername + "\":\n" +
                    "\tPosted at " + timestamp + '\n' +
                    "\tContent: " + content + '\n';
//                    "\tMedia Attachments:\n" +
//
//                    attachments.forEach(Object::toString);
    }
}