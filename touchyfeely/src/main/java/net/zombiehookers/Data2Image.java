package net.zombiehookers;

import java.util.List;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import net.zombiehookers.Twitter2Image;

public class Data2Image
{

	File filename = new File("src/main/webapp/mood_overlay.png");
	private BufferedImage image;
	private double array[][];
	private Color clear = new Color(0,0,0,0);
	private List<Emoxel> emoxels;
	private int h = 250;
	private int w = 600;
	
	public void set(int i, int j, Color c)
	{
		image.setRGB(i, j, c.getRGB());
	}
	
	public void Process()
	{
        	image = new BufferedImage(6000, 2500, BufferedImage.TYPE_INT_ARGB);
		for (int a = 0; a < w-1; a ++)
		{
			for (int b = 0; b < h-1; b ++)
			{
				image.setRGB(a, b, clear.getRGB());
			}
		}	
		for (int a = 0; a < emoxels.size(); a ++)
		{
			double mood = emoxels.get(a).e;
			double X = emoxels.get(a).lat;
			double Y = emoxels.get(a).lng;
			System.out.println("Mood: " + mood);
			System.out.println("X: " + X);
			System.out.println("Y: " + Y);
			int temp_X = (int)(100.0*(X-25.0));
			int temp_Y = (int)(100.0*(Y+125.0));
			if (mood == 0){set(temp_X, temp_Y, Color.blue);}
			else{set(temp_X, temp_Y, Color.red);}
		}
		try {
			ImageIO.write(image,"png",filename);
		} catch ( IOException e) {
		}
	}

	public void Creator(double lat, double lng, double radius)
	{
		Twitter2Image tweet = new Twitter2Image();
		tweet.updateTweets(lat, lng, radius);
		emoxels = tweet.getTweets();
		Process();
	}
	//public static void main(String[] args)
	//{
	//	Picture pic = new Picture(250, 600);
	//	ImageIO.write(image,"jpg",filename);
	//}
}
