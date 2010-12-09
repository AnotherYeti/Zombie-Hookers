package net.zombiehookers;

import twitter4j.*;
import twitter4j.api.*;
import java.util.List;
import twitter4j.GeoLocation;


public class Twitter2Image {
	
	private List<Tweet> tweets;
	private TwitterFactory tf;
	private Twitter t;

	public Twitter2Image() {
		tf = new TwitterFactory();
		t = tf.getInstance();
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void updateTweets(double lat, double lng, double radius) {
		GeoLocation g = new GeoLocation(lat, lng);
		Query query = new Query();
		query.setGeoCode(g, radius, Query.MILES);
	
		try {	
			tweets = t.search(query).getTweets();
		} catch (TwitterException e) {
		}
	}
}
