package geometry3d;

import geometry2d.Circle;
import exceptions.InvalidParameterException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CylinderTest {
    private static final double EPSILON = 1e-9;

    @Test
    void testVolume() {
        Circle base = new Circle(2.0);
        Cylinder cylinder = new Cylinder(base, 5.0);
        assertEquals(20.0 * Math.PI, cylinder.volume(), EPSILON);
    }

    @Test
    void testGetters() {
        Circle base = new Circle(3.0);
        Cylinder cylinder = new Cylinder(base, 10.0);
        assertTrue(cylinder.getBase() == base);
        assertEquals(10.0, cylinder.getHeight(), EPSILON);
    }

    @Test
    void testInvalidParameters() {
        Circle base = new Circle(1.0);
        assertThrows(InvalidParameterException.class, () -> new Cylinder(null, 5.0));
        assertThrows(InvalidParameterException.class, () -> new Cylinder(base, -1.0));
        assertThrows(InvalidParameterException.class, () -> new Cylinder(base, Double.NaN));
    }

    @Test
    void testToString() {
        Circle base = new Circle(1.0);
        Cylinder cylinder = new Cylinder(base, 2.0);
        String str = cylinder.toString();
        assertTrue(str.contains("Cylinder"));
        assertTrue(str.contains("height=2.0"));
    }
}
