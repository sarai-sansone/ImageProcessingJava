import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class Greyscale
{
  public static void GreyImage(String filename) throws IOException
  {
    String strNew = filename.replace(".jpeg", "");
    BufferedImage image = null;
    File file = null;
    try
    {
      file = new File(filename);
      image = ImageIO.read(file);
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
    int width = image.getWidth();
    int height = image.getHeight();
    for (int y = 0; y < height; y++) //Repeat for each pixel of the image
    {
      for (int x = 0; x < width; x++)
      {
        int p = image.getRGB(x,y); //Get the RGB value of the pixel using the getRGB() method.
        int a = (p>>24) & 0xff;
        int r = (p>>16) & 0xff;
        int g = (p>>8) & 0xff;
        int b = p & 0xff;
        int avg = (r+g+b)/3;
        p = (a<<24) | (avg<<16) | (avg<<8) | avg; //Find the average of RGB with formula, average = (R + G + B) / 3
        image.setRGB(x, y, p); //Replace the R, G and B values of the pixel with the average calculated in the previous step.
      }
    }
    try
    {
      String greyName = strNew + "greyscale.png";
      file = new File(greyName);
      ImageIO.write(image, "png", file);
      System.out.println("Successfully converted a color image into a grayscale image");
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
  }
}