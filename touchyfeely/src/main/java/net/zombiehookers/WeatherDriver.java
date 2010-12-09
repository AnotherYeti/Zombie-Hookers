package net.zombiehookers;

import java.util.ArrayList;
import java.util.List;

public class WeatherDriver {
	private static List<WeatherPoint> input = new ArrayList<WeatherPoint>();

	public static void main() {
		addWeatherPoint(105.9,222.4);
		WeatherPoint current = getWeatherPoint(0);
		System.out.println(current.getID());
		System.out.println(current.getLat());
		System.out.println(current.getLon());
		System.out.println(current.getImage());
	}
		
	public static List<WeatherPoint> getWeather() {
		return input;
	}

	public static WeatherPoint getWeatherPoint(int id) {
		for(WeatherPoint point : input) {
			if(point.getID() == id) {
				return point;
			}
		}
		return null;
	}

	public static void addWeatherPoint(double lat, double lon) {
		
		WeatherPoint point = new WeatherPoint(lat,lon,"http://www.google.com/ig/images/weather/cloudy.gif");
		input.add(point);
	}
}
