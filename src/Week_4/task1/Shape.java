package Week_4.task1;

public abstract class Shape {

    protected String colour;

    public Shape(String colour) {
        this.colour = colour;
    }

    // Abstract methods — every Shape MUST implement these
    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    // Concrete method — shared by all shapes
    public void printInfo() {
        System.out.printf("[%s] Area=%.2f, Perimeter=%.2f%n",
            this.colour, calculateArea(), calculatePerimeter());
    }
}
