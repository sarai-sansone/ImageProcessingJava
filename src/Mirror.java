import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class Mirror{
    public static void MirrorImage(String filename)throws IOException{
        //BufferedImage for source image
        String strNew = filename.replace(".jpeg", "");
        BufferedImage simg = null;
        //File object
        File f = null;
        //read source image file
        try{
            f = new File(filename);
            simg = ImageIO.read(f);
        }
        catch(IOException e){
            System.out.println("Error: " + e);
        }
        //get source image dimensionint width = simg.getWidth();
        int width = simg.getWidth();
        int height = simg.getHeight();
        //BufferedImage for mirror image
        BufferedImage mimg = new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
        //create mirror image pixel by pixel
        for(int y = 0; y < height; y++){
            for(int lx = 0, rx = width*2 - 1; lx < width; lx++, rx--){
                //lx starts from the left side of the image
                //rx starts from the right side of the image
                //get source pixel value
                int p = simg.getRGB(lx, y);
                //set mirror image pixel value - both left and right
                mimg.setRGB(lx, y, p);
                mimg.setRGB(rx, y, p);
            }
        }
        //save mirror image
        try{
            String mirroredName = strNew + "mirror.png";
            f = new File(mirroredName);
            ImageIO.write(mimg, "png", f);
            System.out.println("Successfully converted a color image into a mirrored image");
        }
        catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
}
