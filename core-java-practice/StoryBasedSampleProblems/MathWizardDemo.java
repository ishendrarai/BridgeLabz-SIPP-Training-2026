import java.util.Scanner;

class MathWizard {

    int instanceVariable = 100;

    boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    long factorial(int n) {
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    double factorial(double n) {
        double fact = 1;

        for (int i = 1; i <= (int) n; i++) {
            fact *= i;
        }

        return fact;
    }

    int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        int first = 0;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    long power(int base, int exp) {
        long result = 1;

        for (int i = 1; i <= exp; i++) {
            result *= base;
        }

        return result;
    }

    void displayScope() {
        int localVariable = 50;

        System.out.println("Instance Variable :- " + instanceVariable);
        System.out.println("Local Variable :- " + localVariable);
    }
}

public class MathWizardDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MathWizard obj = new MathWizard();

        System.out.print("Enter a number to check Prime :- ");
        int n = sc.nextInt();
        System.out.println("Prime :- " + obj.isPrime(n));

        System.out.print("Enter a number for Factorial :- ");
        int factNum = sc.nextInt();
        System.out.println("Factorial :- " + obj.factorial(factNum));

        System.out.print("Enter a double value for Factorial :- ");
        double d = sc.nextDouble();
        System.out.println("Factorial(Double) :- " + obj.factorial(d));

        System.out.print("Enter Fibonacci Position :- ");
        int fib = sc.nextInt();
        System.out.println("Fibonacci :- " + obj.fibonacci(fib));

        System.out.print("Enter two numbers for GCD and LCM :- ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("GCD :- " + obj.gcd(a, b));
        System.out.println("LCM :- " + obj.lcm(a, b));

        System.out.print("Enter Base and Exponent :- ");
        int base = sc.nextInt();
        int exp = sc.nextInt();

        System.out.println("Power :- " + obj.power(base, exp));

        obj.displayScope();

        sc.close();
    }
}