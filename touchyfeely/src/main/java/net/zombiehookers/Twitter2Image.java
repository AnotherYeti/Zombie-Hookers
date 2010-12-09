package net.zombiehookers;

import twitter4j.*;
import twitter4j.api.*;
import java.util.List;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Emoxel {
	public double lat,lng,e;
}

public class Twitter2Image {
	
	private List<Emoxel> emoxels;
	private TwitterFactory tf;
	private Twitter t;

	public Twitter2Image() {
		tf = new TwitterFactory();
		t = tf.getInstance();
	}

	public List<Emoxel> getTweets() {
		return emoxels;
	}

	public void updateTweets(double lat, double lng, double radius) {
		GeoLocation g = new GeoLocation(lat, lng);
		Query query = new Query();
		query.setGeoCode(g, radius, Query.MILES);
		List<Tweet> tweets;
	
		try {	
			tweets = t.search(query).getTweets();
		} catch (TwitterException e) {
		}

		for(i = 0; i < tweets.size(); i++)
		{
			Emoxel e = new Emoxel();
			e.lat = tweets.get(i).getGeolocation().getLatitude();
			e.lng = tweets.get(i).getGeolocation().getLongitude();
			e.e = 1.0f;
		}
	}
}
