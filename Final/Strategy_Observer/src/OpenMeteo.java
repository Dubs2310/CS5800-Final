import java.beans.PropertyChangeListener;

public class OpenMeteo extends WeatherObservable implements WeatherService {
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
    }

    @Override
    public void sendWeatherNotification() {
        int counter = super.getNotificationCounter();
        super.setLatestNotification(new WeatherNotification("Notification (" + counter + ") received from OpenMeteo"));
    }
}
