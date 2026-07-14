import java.util.Scanner;

class FriendDetails {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int amarAge = input.nextInt();

        System.out.print("Enter Amar's height: ");
        double amarHeight = input.nextDouble();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = input.nextInt();

        System.out.print("Enter Akbar's height: ");
        double akbarHeight = input.nextDouble();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = input.nextInt();

        System.out.print("Enter Anthony's height: ");
        double anthonyHeight = input.nextDouble();

        String youngestFriend;
        String tallestFriend;

        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            youngestFriend = "Amar";
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            youngestFriend = "Akbar";
        } else {
            youngestFriend = "Anthony";
        }

        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            tallestFriend = "Amar";
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            tallestFriend = "Akbar";
        } else {
            tallestFriend = "Anthony";
        }

        System.out.println("The youngest friend is " + youngestFriend);
        System.out.println("The tallest friend is " + tallestFriend);

        input.close();
    }
}