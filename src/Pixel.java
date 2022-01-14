import java.awt.Color;
public class Pixel {
    private int r,g,b,a;

    public Pixel() {
        setR(0);
        setG(0);
        setB(0);
        setA(0);
    }
    public Pixel(int r, int g, int b, int a) {
        this.setR(r);
        this.setG(g);
        this.setB(b);
        this.setA(a);
    }
    public Pixel(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        a = 255;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    public int getG() {
        return g;
    }
    public void setG(int g) {
        this.g = g;
    }
    public int getR() {
        return r;
    }
    public void setR(int r) {
        this.r = r;
    }
    public Color getColor() {
        return new Color(r,g,b);
    }
    public void setColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public void setColor(Color color) {
        r = color.getRed();
        g = color.getGreen();
        b = color.getBlue();
    }
    public void setGray() {
        int avg = (r + g + b) / 3;
        r = avg;
        g = avg;
        b = avg;
    }
    public void setNegative() {
        r = 255 - r;
        g = 255 - g;
        b = 255 - b;
    }
    public double colorDistance(Color otherColor) {
        double rDist = Math.pow(otherColor.getRed() - this.r , 2);
        double bDist = Math.pow(otherColor.getBlue() - this.b , 2);
        double gDist = Math.pow(otherColor.getGreen() - this.g , 2);
        return (double) (Math.sqrt(rDist+ gDist +bDist));
    }
    @Override
    public String toString() {
        return "Pixel [r = " + r + ", g = " + g + ", b = " + b + ", a = " + a + "]";
    }
}
