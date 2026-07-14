public class Day05_MathWizard {
    private int instanceCount = 0; // Instance variable
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
    
    public double factorial(double n) {
        // Simple overloading example
        return (double) factorial((int) n);
    }
    
    public int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    public double power(double base, int exp) {
        double res = 1;
        for (int i = 0; i < exp; i++) res *= base;
        return res;
    }
    
    public void demonstrateScope() {
        int localCount = 0; // Local variable
        localCount++;
        this.instanceCount++;
        System.out.println("Local: " + localCount + ", Instance: " + this.instanceCount);
    }
    
    public static void main(String[] args) {
        Day05_MathWizard wizard = new Day05_MathWizard();
        System.out.println("Is 7 prime? " + wizard.isPrime(7));
        System.out.println("Factorial of 5: " + wizard.factorial(5));
        System.out.println("Factorial of 5.0: " + wizard.factorial(5.0));
        System.out.println("10th Fibonacci: " + wizard.fibonacci(10));
        System.out.println("GCD(12, 18): " + wizard.gcd(12, 18));
        System.out.println("LCM(12, 18): " + wizard.lcm(12, 18));
        System.out.println("Power(2.5, 3): " + wizard.power(2.5, 3));
        
        wizard.demonstrateScope();
        wizard.demonstrateScope();
    }
}
