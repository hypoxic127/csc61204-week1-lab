package Week_4.test;

import Week_4.task1.Circle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTest {

    @Test
    public void testCalculateArea() {
        Circle circle = new Circle("Red", 5.0);
        double expectedArea = Math.PI * 25;
        
        // verify calculateArea() returns Math.PI * 25 within delta 0.001
        assertEquals(expectedArea, circle.calculateArea(), 0.001);
    }
}
