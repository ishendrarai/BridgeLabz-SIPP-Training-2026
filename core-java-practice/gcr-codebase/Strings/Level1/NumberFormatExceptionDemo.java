import java.util.Scanner;

class NumberFormatExceptionDemo {

    public static void generateException(String text) {

        int number = Integer.parseInt(text);

        System.out.println(number);
    }

    public static void handleException(String text) {

        try {

            int number = Integer.parseInt(text);

            System.out.println(number);

        } catch (NumberFormatException exception) {

            System.out.println("NumberFormatException Handled");

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