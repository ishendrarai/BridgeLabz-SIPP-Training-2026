public class MethodPropagation {
    public static void method1() {
        int result = 10 / 0; // Throws ArithmeticException
        System.out.println(result);
    }

    public static void method2() {
        method1(); // Calls method1
    }

    public static void main(String[] args) {
        try {
            method2(); // Calls method2
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
