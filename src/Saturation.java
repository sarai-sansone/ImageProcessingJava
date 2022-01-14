import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class Saturation {
    public static void SaturateImage(String filename) throws IOException
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
    for (int y = 0; y < height; y++)
    {
      for (int x = 0; x < width; x++)
      {
        int p = image.getRGB(x,y);
        int a = (p>>24) & 0xff;
        int r = (p>>16) & 0xff;
        int g = (p>>8) & 0xff;
        int b = p & 0xff;
        r = r *2;
        g = g *2;
        b = b *2;
        p = (a<<24) | (r<<16) | (g<<8) | b;
        image.setRGB(x, y, p);
      }
    }
    try
    {
      String saturateName = strNew + "saturate.jpeg";
      file = new File(saturateName);
      ImageIO.write(image, "jpg", file);
      System.out.println("Successfully converted a color image into a saturated image");
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
  }
}
