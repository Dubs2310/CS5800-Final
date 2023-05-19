import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class WeatherNotificationFeed implements PropertyChangeListener {
    private List<WeatherNotification> notifications = new ArrayList<>();

    public List<WeatherNotification> getNotifications() {
        return notifications;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        notifications.add((WeatherNotification) evt.getNewValue());
    }
}
