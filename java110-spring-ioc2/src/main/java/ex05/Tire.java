package ex05;

public class Tire {
    private String maker;
    private int width;
    private int height;
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Tire [maker=" + maker + ", width=" + width + ", height=" + height + "]";
    }
    
    
}
