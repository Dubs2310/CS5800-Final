import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class TweetObservable {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Tweet latestTweet = null;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setLatestTweet(Tweet latestTweet) {
        support.firePropertyChange("latestTweet", this.latestTweet, latestTweet);
        this.latestTweet = latestTweet;
    }
}
