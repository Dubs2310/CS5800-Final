import java.beans.PropertyChangeListener;

public interface WeatherService {
    void addPropertyChangeListener(PropertyChangeListener listener);
    void sendWeatherNotification();
}