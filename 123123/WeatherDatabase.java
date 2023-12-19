import java.util.*;

public class WeatherDatabase {
    private Map<String, String> weatherData;

    public WeatherDatabase() {
        // Загрузка данных погоды из файла или другого источника
        weatherData = new HashMap<>();
        weatherData.put("2022-01-01", "{\"temperature\": 10, \"conditions\": \"sunny\"}");
        weatherData.put("2022-01-02", "{\"temperature\": 5, \"conditions\": \"cloudy\"}");
        weatherData.put("2022-01-03", "{\"temperature\": -5, \"conditions\": \"snowy\"}");
        weatherData.put("2022-01-04", "{\"temperature\": 12, \"conditions\": \"sunny\"}");
        weatherData.put("2022-01-05", "{\"temperature\": 7, \"conditions\": \"cloudy\"}");
        weatherData.put("2022-01-06", "{\"temperature\": -3, \"conditions\": \"snowy\"}");
        weatherData.put("2022-01-07", "{\"temperature\": 10, \"conditions\": \"rainy\"}");
        weatherData.put("2022-01-08", "{\"temperature\": 6, \"conditions\": \"cloudy\"}");
        weatherData.put("2022-01-09", "{\"temperature\": -2, \"conditions\": \"snowy\"}");
        weatherData.put("2022-01-10", "{\"temperature\": 8, \"conditions\": \"sunny\"}");
    }

    public String getWeather(String date) {
        return weatherData.get(date);
    }
}