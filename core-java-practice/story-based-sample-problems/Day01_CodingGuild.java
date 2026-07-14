public class Day01_CodingGuild {
    public static void main(String[] args) {
        String name = "Ravi";
        byte age = 25;
        char rank = 'A';
        double salary = 85000.50;
        float membershipFee = 1500.75f;
        
        double annualBonusDouble = salary * 0.12;
        int annualBonus = (int) annualBonusDouble;
        
        System.out.println("--- Coding Guild Welcome Card ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Rank: " + rank);
        System.out.println("Salary: $" + salary);
        System.out.println("Membership Fee: $" + membershipFee);
        System.out.println("Annual Bonus (Computed): $" + annualBonus);
        System.out.println("---------------------------------");
    }
}
