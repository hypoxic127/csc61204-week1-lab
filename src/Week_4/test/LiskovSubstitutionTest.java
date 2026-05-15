package Week_4.test;

import Week_4.task1.Rectangle;
import Week_4.task1.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LiskovSubstitutionTest {

    public void resizeRectangle(Rectangle r) {
        // A standard valid assumption for a Rectangle:
        // Setting width to 5 and height to 10 should give area = 50.
        r.setWidth(5);
        r.setHeight(10);
    }

    @Test
    public void testRectangleArea() {
        Rectangle rect = new Rectangle("Blue", 2, 2);
        resizeRectangle(rect);
        // This passes for Rectangle
        assertEquals(50.0, rect.calculateArea(), 0.001);
    }

    @Test
    public void testSquareAreaFails() {
        Rectangle square = new Square("Red", 2);
        resizeRectangle(square);
        // This fails Liskov Substitution Principle because when treating Square as a Rectangle, 
        // the assumption about independent width/height is broken.
        // It gives area 100 instead of 50. We assert what actually happens to make the test pass.
        assertEquals(100.0, square.calculateArea(), 0.001);
        
        // Alternatively, we can explicitly verify the violation
        assertNotEquals(50.0, square.calculateArea(), 0.001);
    }
}
