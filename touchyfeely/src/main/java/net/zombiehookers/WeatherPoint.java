package net.zombiehookers;

public class WeatherPoint {
	private double lat;
	private double lon;
	private String image;
	private int id;
	public WeatherPoint(double lat, double lon, String image) {
		this.lat = lat;
		this.lon = lon;
		this.image = image;
	}
	public double getLat() {return lat;}
	public double getLon() {return lon;}
	public String getImage() {return image;}
	public int getID() {return id;}
}
