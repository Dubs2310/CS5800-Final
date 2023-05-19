import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class WeatherObservable {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private WeatherNotification latestNotification = null;
    private int notificationCounter = 1;

    public int getNotificationCounter() {
        return notificationCounter++;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setLatestNotification(WeatherNotification latestNotification) {
        support.firePropertyChange("latestNotification", this.latestNotification, latestNotification);
        this.latestNotification = latestNotification;
    }
}
