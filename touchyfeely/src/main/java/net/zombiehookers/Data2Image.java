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
	private Color clear = new Color(0,0,0,0);
	private List<Emoxel> emoxels;
	private int h = 1440;
	private int w = 600;
	
	public void set(int i, int j, Color c)
	{
		image.setRGB(i, j, c.getRGB());
	}
	
	public void Process()
	{
        	image = new BufferedImage(1440, 600, BufferedImage.TYPE_INT_ARGB);
		for (int a = 0; a < 100; a ++)
//		for (int a = 0; a < emoxels.size(); a ++)
		{
//			double mood = emoxels.get(a).e;
//			double X = emoxels.get(a).lat;
//			double Y = emoxels.get(a).lng;
			
//			int temp_X = (int)(24.0*(X-25.0));
//			int temp_Y = 25-(int)(24.0*(Y+125.0));
//			set(temp_X, temp_Y, Color.blue);
			set(a, a, Color.black);
			set(1439-a, a, Color.black);
			set(1439-a, 599-a, Color.black);
			set(a, 599-a, Color.black);

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
