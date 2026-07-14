import java.util.Scanner;

class RocketLaunchCountdownFor {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the countdown value: ");
        int counter = input.nextInt();

        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println("Rocket Launched!");

        input.close();
    }
}