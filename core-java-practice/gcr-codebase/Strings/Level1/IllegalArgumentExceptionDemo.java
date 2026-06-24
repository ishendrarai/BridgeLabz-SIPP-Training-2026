import java.util.Scanner;

class IllegalArgumentExceptionDemo {

    public static void generateException(String text) {

        System.out.println(text.substring(5, 2));
    }

    public static void handleException(String text) {

        try {

            System.out.println(text.substring(5, 2));

        } catch (IllegalArgumentException exception) {

            System.out.println("IllegalArgumentException Handled");

        } catch (Exception exception) {

            System.out.println("Runtime Exception Handled");

        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = input.next();

        try {
            generateException(text);
        } catch (Exception exception) {
            System.out.println("Exception Generated");
        }

        handleException(text);

        input.close();
    }
}