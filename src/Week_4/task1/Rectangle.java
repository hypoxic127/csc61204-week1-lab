package Week_4.task1;

public class Rectangle extends Shape implements Drawable {
    private double width, height;

    public Rectangle(String colour, double width, double height) {
        super(colour);
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        System.out.printf("[Drawing Rectangle in %s]%n", this.colour);
    }
}
