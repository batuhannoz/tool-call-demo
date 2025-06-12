package com.batuhan.toolcall.tools;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public class WeatherTools {

    private static final List<String> CONDITIONS = Arrays.asList(
        "Sunny", "Partly Cloudy", "Cloudy", "Showers", "Rainy"
    );

    private static final Random RANDOM = new Random();

    @Tool(description = "Get today's weather for a given city")
    public String getTodaysWeather(@ToolParam(description = "Name of the city") String city) {
        if (city == null || city.trim().isEmpty()) {
            return "Please provide a valid city name.";
        }

        String condition = CONDITIONS.get(RANDOM.nextInt(CONDITIONS.size()));
        int temp = RANDOM.nextInt(30);

        return String.format(
            "Today %s: Weather in %s, temperature %d°C",
            city, condition, temp
        );
    }

}
