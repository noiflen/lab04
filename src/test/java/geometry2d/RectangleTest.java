package geometry2d;

import exceptions.InvalidParameterException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    private static final double EPSILON = 1e-9;

    @Test
    void testAreaAndPerimeter() {
        Rectangle rect = new Rectangle(3.0, 4.0);
        assertEquals(12.0, rect.area(), EPSILON);
        assertEquals(14.0, rect.perimeter(), EPSILON);
    }

    @Test
    void testInvalidParameters() {
        assertThrows(InvalidParameterException.class, () -> new Rectangle(-1.0, 4.0));
        assertThrows(InvalidParameterException.class, () -> new Rectangle(3.0, 0.0));
        assertThrows(InvalidParameterException.class, () -> new Rectangle(Double.NaN, 4.0));
        assertThrows(InvalidParameterException.class, () -> new Rectangle(3.0, Double.POSITIVE_INFINITY));
    }
}

