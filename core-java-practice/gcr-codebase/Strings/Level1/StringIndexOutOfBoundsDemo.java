import java.util.Scanner;

class StringIndexOutOfBoundsDemo {

    public static void generateException(String text) {

        System.out.println(text.charAt(text.length()));
    }

    public static void handleException(String text) {

        try {

            System.out.println(text.charAt(text.length()));

        } catch (StringIndexOutOfBoundsException exception) {

            System.out.println("StringIndexOutOfBoundsException Handled");

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