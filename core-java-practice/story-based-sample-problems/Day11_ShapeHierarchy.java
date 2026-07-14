public class Day11_ShapeHierarchy {
    static abstract class Shape {
        public abstract double area();
        public abstract double perimeter();
    }
    
    static class Circle extends Shape {
        private double radius;
        public Circle(double radius) { this.radius = radius; }
        public double getRadius() { return radius; }
        @Override
        public double area() { return Math.PI * radius * radius; }
        @Override
        public double perimeter() { return 2 * Math.PI * radius; }
    }
    
    static class Rectangle extends Shape {
        private double length, width;
        public Rectangle(double l, double w) { this.length = l; this.width = w; }
        @Override
        public double area() { return length * width; }
        @Override
        public double perimeter() { return 2 * (length + width); }
    }
    
    static class Triangle extends Shape {
        private double a, b, c;
        public Triangle(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
        @Override
        public double area() {
            double s = perimeter() / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
        @Override
        public double perimeter() { return a + b + c; }
    }
    
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 4, 5)
        };
        
        System.out.println("--- Area Report ---");
        for (Shape s : shapes) {
            System.out.println(s.getClass().getSimpleName() + " -> Area: " + String.format("%.2f", s.area()) + " | Perimeter: " + String.format("%.2f", s.perimeter()));
        }
    }
}
