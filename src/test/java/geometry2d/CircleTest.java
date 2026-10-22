package geometry2d;

import exceptions.InvalidParameterException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircleTest {
    private static final double EPSILON = 1e-9;

    @Test
    void testAreaAndPerimeter() {
        Circle circle = new Circle(1.0);
        assertEquals(Math.PI, circle.area(), EPSILON);
        assertEquals(2 * Math.PI, circle.perimeter(), EPSILON);
    }

    @Test
    void testInvalidRadius() {
        assertThrows(InvalidParameterException.class, () -> new Circle(-5.0));
        assertThrows(InvalidParameterException.class, () -> new Circle(Double.NaN));
        assertThrows(InvalidParameterException.class, () -> new Circle(Double.NEGATIVE_INFINITY));
    }
}