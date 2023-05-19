import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Feed implements PropertyChangeListener {
    private List<Tweet> tweets = new ArrayList<>();

    public List<Tweet> getTweets() {
        return tweets;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        tweets.add((Tweet) evt.getNewValue());
    }
}
