package geometry3d;

import exceptions.InvalidParameterException;
import geometry2d.Figure;

public class Cylinder {
    private final Figure base;
    private final double height;

    public Cylinder(Figure base, double height) {
        if (base == null) {
            throw new InvalidParameterException("Основание цилиндра не может быть null");
        }
        if (!Double.isFinite(height) || height <= 0) {
            throw new InvalidParameterException("Некорректная высота: " + height);
        }
        this.base = base;
        this.height = height;
    }

    public Figure getBase() { return base; }
    public double getHeight() { return height; }
    public double volume() { return base.area() * height; }

    @Override
    public String toString() { return "Cylinder(base=" + base + ", height=" + height + ")"; }
}