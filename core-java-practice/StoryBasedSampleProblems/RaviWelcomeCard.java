public class RaviWelcomeCard {

    public static void main(String[] args) {

        
        String name = "Ravi";
        int age = 20;
        int rank = 5;
        double salary = 500000.0;
        float membershipFee = 999.50f;

        
        double bonus = salary * 0.12;

        
        int annualBonus = (int) bonus;

        
        System.out.println("=================================");
        System.out.println("       WELCOME TO CODING GUILD");
        System.out.println("=================================");
        System.out.println("Name           : " + name);
        System.out.println("Age            : " + age);
        System.out.println("Rank           : " + rank);
        System.out.println("Salary         : " + salary);
        System.out.println("Membership Fee : " + membershipFee);
        System.out.println("Annual Bonus   : " + annualBonus);
        System.out.println("=================================");
        System.out.println("Welcome, " + name + "! Happy Coding!");
    }
}