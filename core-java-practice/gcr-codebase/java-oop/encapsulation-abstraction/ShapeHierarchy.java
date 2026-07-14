public class ShapeHierarchy {
    abstract static class Shape {
        public abstract double area();
        public abstract double perimeter();
    }

    static class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }
    }

    static class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }

        @Override
        public double perimeter() {
            return 2 * (width + height);
        }
    }

    static class Triangle extends Shape {
        private double sideA;
        private double sideB;
        private double sideC;

        public Triangle(double sideA, double sideB, double sideC) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }

        @Override
        public double area() {
            double s = perimeter() / 2;
            return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        }

        @Override
        public double perimeter() {
            return sideA + sideB + sideC;
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Triangle(3, 4, 5);

        for (Shape shape : shapes) {
            System.out.printf("Shape: %s | Area: %.2f | Perimeter: %.2f%n", 
                              shape.getClass().getSimpleName(), shape.area(), shape.perimeter());
        }
    }
}
