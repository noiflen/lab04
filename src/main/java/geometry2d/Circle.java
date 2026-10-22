package geometry2d;

import exceptions.InvalidParameterException;
import java.io.Serializable;

public class Circle implements Figure, Serializable {
    private static final long serialVersionUID = 1L;
    private final double radius;

    public Circle(double radius) {
        if (!Double.isFinite(radius) || radius <= 0) {
            throw new InvalidParameterException("Некорректный радиус: " + radius);
        }
        this.radius = radius;
    }

    public double getRadius() { return radius; }
    public double area() { return Math.PI * radius * radius; }
    public double perimeter() { return 2 * Math.PI * radius; }

    @Override
    public String toString() { return "Circle(radius=" + radius + ")"; }
}
