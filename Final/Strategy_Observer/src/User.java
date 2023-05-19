import java.util.List;

public class User {
    private WeatherNotificationFeed feed = new WeatherNotificationFeed();
    private List<WeatherService> services;

    public User(List<WeatherService> services) {
        this.services = services;
        services.forEach(service -> service.addPropertyChangeListener(feed));
    }

    public WeatherNotificationFeed getFeed() {
        return feed;
    }

    public void addWeatherService(WeatherService service) {
        services.add(service);
    }
}
