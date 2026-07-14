class NullPointerExceptionDemo {

    public static void generateException() {

        String text = null;

        System.out.println(text.length());
    }

    public static void handleException() {

        String text = null;

        try {

            System.out.println(text.length());

        } catch (NullPointerException exception) {

            System.out.println("NullPointerException Handled");

        }
    }

    public static void main(String[] args) {

        try {
            generateException();
        } catch (Exception exception) {
            System.out.println("Exception Generated");
        }

        handleException();
    }
}