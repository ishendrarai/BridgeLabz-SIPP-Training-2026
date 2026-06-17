import java.util.Scanner;

class RocketLaunchCountdown {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the countdown value: ");
        int counter = input.nextInt();

        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        System.out.println("Rocket Launched!");

        input.close();
    }
}