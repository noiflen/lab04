package geometry2d;

import exceptions.InvalidParameterException;
import java.io.Serializable;

public class Rectangle implements Figure, Serializable {
    private static final long serialVersionUID = 1L;
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (!Double.isFinite(width) || width <= 0) {
            throw new InvalidParameterException("Некорректная ширина: " + width);
        }
        if (!Double.isFinite(height) || height <= 0) {
            throw new InvalidParameterException("Некорректная высота: " + height);
        }
        this.width = width;
        this.height = height;
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public double area() { return width * height; }
    public double perimeter() { return 2 * (width + height); }

    @Override
    public String toString() { return "Rectangle(width=" + width + ", height=" + height + ")"; }
}