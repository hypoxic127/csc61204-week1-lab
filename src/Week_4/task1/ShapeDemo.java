package Week_4.task1;

import java.util.ArrayList;
import java.util.List;

public class ShapeDemo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("Red", 5.0));
        shapes.add(new Rectangle("Blue", 4.0, 6.0));
        shapes.add(new Triangle("Green", 3.0, 4.0, 5.0));

        // Polymorphism: same method call, different behaviour
        for (Shape s : shapes) {
            s.printInfo();
            if (s instanceof Drawable) {
                ((Drawable) s).draw();
            }
        }

        // Find total area
        double totalArea = 0;
        for (Shape s : shapes) totalArea += s.calculateArea();
        System.out.printf("Total area: %.2f%n", totalArea);
    }
}
