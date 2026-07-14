import java.util.Scanner;

class ArrayIndexOutOfBoundsDemo {

    public static void generateException(String[] names) {

        System.out.println(names[names.length]);
    }

    public static void handleException(String[] names) {

        try {

            System.out.println(names[names.length]);

        } catch (ArrayIndexOutOfBoundsException exception) {

            System.out.println("ArrayIndexOutOfBoundsException Handled");

        } catch (RuntimeException exception) {

            System.out.println("Runtime Exception Handled");

        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] names = new String[3];

        for (int i = 0; i < names.length; i++) {

            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = input.next();
        }

        try {
            generateException(names);
        } catch (Exception exception) {
            System.out.println("Exception Generated");
        }

        handleException(names);

        input.close();
    }
}