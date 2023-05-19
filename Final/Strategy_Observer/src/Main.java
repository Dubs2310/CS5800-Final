import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        WeatherService api = new WeatherApi();
        WeatherService gov = new WeatherGov();
        WeatherService openMeteo = new OpenMeteo();

        User user1 = new User(Arrays.asList(api, gov, openMeteo));
        User user2 = new User(Arrays.asList(api, gov));
        User user3 = new User(Arrays.asList(openMeteo));

        api.sendWeatherNotification();
        api.sendWeatherNotification();
        gov.sendWeatherNotification();
        openMeteo.sendWeatherNotification();
        openMeteo.sendWeatherNotification();

        System.out.println("User 1's Feed:");
        user1.getFeed().getNotifications().forEach(System.out::println);

        System.out.println("\nUser 2's Feed:");
        user2.getFeed().getNotifications().forEach(System.out::println);

        System.out.println("\nUser 3's Feed:");
        user3.getFeed().getNotifications().forEach(System.out::println);
    }
}