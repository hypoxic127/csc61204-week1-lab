package Week_4.task1;

public class Triangle extends Shape {
    private double a, b, c; // three sides
    public Triangle(String colour, double a, double b, double c) {
        super(colour); this.a = a; this.b = b; this.c = c;
    }
    @Override public double calculateArea() {
        double s = (a + b + c) / 2; // Heron's formula
        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }
    @Override public double calculatePerimeter() { return a + b + c; }
}
