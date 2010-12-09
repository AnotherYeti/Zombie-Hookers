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

	File filename = new File("mood_overlay.jpg");
	private BufferedImage image;
	private double array[][];
	private Color clear = new Color(0,0,0,0);
	private List<Emoxel> emoxels;
	private int w = 250;
	private int h = 600;
	
	public void set(int i, int j, Color c)
	{
		image.setRGB(i, j, c.getRGB());
	}
	
	public void Process()
	{
        	image = new BufferedImage(250, 600, BufferedImage.TYPE_INT_ARGB);
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
			int temp_X = (int)(10*(X-25));
			int temp_Y = (int)(10*(Y+125));
			if (mood == 0){set(temp_X, temp_Y, Color.blue);}
			else{set(temp_X, temp_Y, Color.red);}
		}
		try {
			ImageIO.write(image,"jpg",filename);
		} catch ( IOException e) {
		}
	}

	public void Creator()
	{
		Twitter2Image tweet = new Twitter2Image();
		emoxels = tweet.getTweets();
		Process();
	}
	//public static void main(String[] args)
	//{
	//	Picture pic = new Picture(250, 600);
	//	ImageIO.write(image,"jpg",filename);
	//}
}
