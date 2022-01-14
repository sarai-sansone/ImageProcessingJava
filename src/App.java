public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Greyscale.GreyImage("dragon.jpeg");
        Negative.NegativeImage("dragon.jpeg");
        Mirror.MirrorImage("dragon.jpeg");
        Exposure.LowExposureImage("dragon.jpeg");
        Saturation.SaturateImage("dragon.jpeg");
    }
}
